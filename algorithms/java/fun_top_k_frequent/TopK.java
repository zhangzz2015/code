class TopK {
	// 1. offline
	public List<String> topKFrequent(String[] url, int k) {
		List<String> res = new ArrayList<>();
		if (url == null || url.length == 0 || k <= 0) {
			return res;
		}
		Map<String, Integer> freqMap = getFreqMap(url);
		PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(new MyComparator());
		for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
			if (minHeap.size() > k) {
				minHeap.offer(entry);
			} else if (entry.getValue() > minHeap.peek().getValue()) {
				minHeap.poll();
				minHeap.offer(entry);
			}
		}
		while (!minHeap.isEmpty()) {
			res.add(minHeap.poll().getKey());
		}
		Collections.reverse(res);
		return res;
	}
	private Map<String, Integer> getFreqMap(String[] urls) {
		Map<String, Integer> freqMap = new HashMap<>();
		for (String url : urls) {
			freqMap.put(url, freqMap.getOrDefault(url, 0) + 1);
		}
		return freqMap;
	}
	static class MyComparator implements Comparator<Map.Entry<String, Integer>> {
		@Override
		public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
			int res = Integer.compare(e1.getValue(), e2.getValue());
			return res == 0 ? e1.getKey().compareTo(e2.getKey()) : res;
		}
	}


	// 2. online hashmap + treeset
	private final int k;
	private Map<String, Element> freqMap;
	private TreeSet<Element> treeSet;

	TopK(int k) {
		this.k = k;
		this.freqMap = new HashMap<>();
		this.treeSet = new TreeSet<>();
	}

	public void record(String url) {
		Element element = freqMap.getOrDefault(url, new Element(url, 0));
		if (treeSet.contains(element)) {
			treeSet.remove(element);
			updateFreq(element);
		} else if (treeSet.size() > k) {
			updateFreq(element);
		} else if (treeSet.first().freq < element.freq + 1) {
			treeSet.pollFirst();
			updateFreq(element);
		} else {
			element.freq++;
		}
		freqMap.put(url, element);
	}
	private void updateFreq(Element element) {
		element.freq++;
		treeSet.add(element);
	}

	public List<String> topK() {
		Iterator<Element> iterator = treeSet.iterator();
		List<String> res = new ArrayList<>();
		while (iterator.hasNext() && k > 0) {
			res.add(iterator.next().toString());
			k--;
		}
		return res;
	}

	static class Element implements Comparable<Element> {
		String url;
		int freq;

		Element(String url, int freq) {
			this.url = url;
			this.freq = freq;
		}

		@Override
		public int compareTo(Element other) {
			int res = Integer.compare(this.freq, other.freq);
			return res == 0 ? this.url.compareTo(other.url) : res;
		}

		@Override
		public String toString() {
			return "<url: " + url + ", frequency: " + freq + ">";
		}
	}


	// 3. online hashmap + dll
	private Map<String, Node> urlMap;
	private int k;
	private Node head;
	private Node tail;

	TopK(int k) {
		this.urlMap = new HashMap<>();
		this.k = k;
		this.head = new Node(0);
		this.tail = new Node(0);
		head.next = tail;
		tail.prev = head;
	}

	public void record(String url) {
		Node oldNode = urlMap.getOrDefault(url, head);
		int oldFreq = oldNode.freq;
		Node prev = head;
		Node next = oldNode.next;
		if (oldFreq != 0) {
			if (oldNode.urls.size() == 1) {
				prev = oldNode.prev;
				remove(oldeNode);
			} else {
				oldNode.urls.remove(url);
				prev = oldNode;
			}
		}
		int newFreq = oldFreq + 1;
		Node newNode = next.freq == newFreq ? : next : new Node(newFreq);
		newNode.urls.add(url);
		if (next.freq != newFreq) {
			insert(newNode, prev, next);
		}
		urlMap.put(url, newNode);
	}
	private void insert(Node node, Node prev, Node next) {
		node.next = next;
		next.prev = node;
		node.prev = prev;
		prev.next = node;
	}
	private void remove(Node node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}

	public List<String> topK() {
		List<String> res = new ArrayList<>();
		Node cur = tail.prev;
		Iterator<String> curIterator = cur.urls.iterator();
		while (k > 0 && cur.freq > 0) {
			if (curIterator.hasNext()) {
				res.add(curIterator.next());
				k--;
			} else if (cur.prev != null) {
				curIterator = cur.prev.urls.iterator();
				cur = cur.prev;
			}
		}
		return res;
	}

	static class Node {
		int freq;
		Set<String> urls;
		Node prev;
		Node next;

		Node(int freq) {
			this.freq = freq;
			this.urls = new HashSet<>();
		}
	}
}
