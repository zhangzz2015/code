class WordLadder {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> wordSet = new HashSet<>(wordList);
		if (!wordSet.contains(endWord)) return 0;
		return bfs(beginWord, endWord, wordSet);
	}

	private int bfs(String beginWord, String endWord, Set<String> wordSet) {
		Queue<String> queue = new ArrayDeque<>();
		Set<String> visited = new HashSet<>();
		queue.offer(beginWord);
		visited.add(beginWord);
		int level = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String cur = queue.poll();
				List<String> neighbors = getNeighbors(cur, wordSet);
				for (String nei : neighbors) {
					if (nei.equals(endWord)) {
						return level + 1;
					}
					if (visited.add(nei)) {
						queue.offer(nei);
					}
				}
			}
			level++;
		}
		return 0;
	}

	private List<String> getNeighbors(String s, Set<String> wordSet) {
		List<String> res = new ArrayList<>();
		char[] array = s.toCharArray();
		for (int i = 0; i < array.length; i++) {
			char tmp = array[i];
			for (char c = 'a'; c <= 'z'; c++) {
				if (c != tmp) {
					array[i] = c;
					String cur = new String(array);
					if (wordSet.contains(cur)) {
						res.add(cur);
					}
					array[i] = tmp;
				}
			}
		}
		return res;
	}
}
