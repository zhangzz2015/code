class AlienDic {
	// dfs
	public String alienOrder(String[] words) {
		if (words == null || words.length == 0) return "";
		Map<Character, Set<Character>> graph = buildGraph(words);
		boolean[] visited = new boolean[26];
		boolean[] visiting = new boolean[26];
		StringBuilder sb = new StringBuilder();
		for (char c : graph.keySet()) {
			if (!dfs(c, graph, visited, visiting, sb)) {
				return "";
			}
		}
		return sb.toString();
	}

	private boolean dfs(char node, Map<Character, Set<Character>> graph, boolean[] visited, boolean[] visiting, StringBuilder sb) {
		int index = node - 'a';
		if (visited[index]) return true;
		if (visiting[index]) return false; // find cycle
		visiting[index] = true;
		for (char nei : graph.get(node)) {
			if (!dfs(nei, graph, visited, visiting, sb)) {
				return false;
			}
		}
		visited[index] = true;
		visiting[index] = false;
		sb.append(node);
		return true;
	}

	private Map<Character, Set<Character>> buildGraph(String[] words) {
		Map<Character, Set<Character>> graph = new HashMap<>();
		for (String[] s : words) {
			for (char c : s.toCharArray()) {
				graph.putIfAbsent(c, new HashSet<>());
			}
		}
		for (int i = 0; i < words.length - 1; i++) {
			String cur = words[i];
			String next = words[i - 1];
			if (cur.length() > next.length() && cur.startsWith(next)) return new HashMap<>(); // deal with case of "abc" "ab"
			int len = Math.min(cur.length(), next.length());
			for (int j = 0; j < len; j++) {
				char c1 = cur.charAt(j);
				char c2 = next.charAt(j);
				if (c1 != c2) {
					graph.get(c2).add(c1);
					break;
				}
			}
		}
		return graph;
	}

	
	// bfs
	public String alienOrder1(String[] words) {
		if (words == null || words.length == 0) return "";
		int[] indegree = new int[26];
        Map<Character, Set<Character>> graph = buildMap(words, indegree);
        return bfs(graph, indegree);
    }
    
    private String bfs(Map<Character, Set<Character>> graph, int[] indegree) {
        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new ArrayDeque<>();
        for (char c : graph.keySet()) {
            if (indegree[c - 'a'] == 0) {
                queue.offer(c);
            }
        }
        while (!queue.isEmpty()) {
            char c = queue.poll();
            sb.append(c);
            for (char nei : graph.get(c)) {
                indegree[nei - 'a']--;
                if (indegree[nei - 'a'] == 0) {
                     queue.offer(nei);
                }
            }
        }
        return sb.length() == graph.size() ? sb.toString() : "";
    }
    
    private Map<Character, Set<Character>> buildMap(String[] words, int[] indegree) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        for (String s : words) {
            for (char c : s.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            String cur  = words[i];
            String next = words[i + 1];
            if (cur.length() > next.length() && cur.startsWith(next)) return new HashMap<>();
            int len = Math.min(cur.length(), next.length());
            for (int j = 0; j < len; j++) {
                char c1 = cur.charAt(j);
                char c2 = next.charAt(j);
                if (c1 != c2) {
                    if (graph.get(c1).add(c2)) {
                        indegree[c2 - 'a']++;
                    }
                    break;
                }
            }
        }
        return graph;
    }
}
