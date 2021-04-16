class WordLadder {
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		List<List<Stirng>> res = new ArrayList<>();
		Set<String> wordSet = new HashSet<>(wordList);
		if (!wordSet.contains(endWord)) {
			return res;
		}
		Map<String, List<String>> prevMap = new HashMap<>();
		int level = bfs(beginWord, endWord, wordSet, prevMap);
		if (level == 0) return res;
		List<String> path = new LinkedList<>();
		dfs(endWord, prevMap, path, res);
		return res;
	}

	private int bfs(String beginWord, String endWord, Set<String> wordSet, Map<String, List<String>> prevMap) {
		Queue<String> queue = new ArrayDeque<>();
		Map<String, Integer> levels =  new HashMap<>();
		queue.offer(beginWord);
		prevMap.put(beginWord, new ArrayList<>());
		levels.put(beginWord, 0);
		int level = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String cur = queue.poll();
				List<String> neighbors = findNeighbors(cur, wordSet);
				if (neighbors.isEmpty()) {
					return 0;
				}
				for (String nei : neighbors) {
					if (!levels.containsKey(nei)) {
						List<String> parent = new ArrayList<>();
						parent.add(cur);
						prevMap.put(nei, parent);
						levels.put(nei, level + 1);
						queue.offer(nei);
					} else if (levels.get(nei) == level + 1) {
						prevMap.get(nei).add(cur);
					}
				}
			}
			level++;
			if (levels.containsKey(endWord)) break;
		}
		return level;
	}

	private List<String> findNeighbors(String s, Set<String> wordSet) {
		List<String> res = new ArrayList<>();
		char[] array =  s.toCharArray();
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

	private void dfs(String cur, Map<String, List<String>> prevMap, List<String> path, List<List<String>> res) {
		path.add(0, cur);
		if (prevMap.get(cur).isEmpty()) {
			List<String> tmp = new ArrayList<>(path);
			Collections.reverse(tmp);
			res.add(tmp);
		} else {
			for (String s : prevMap.get(cur)) {
				dfs(s, prevMap, path, res);
			}
		}
		path.remove(0);
	}
}
