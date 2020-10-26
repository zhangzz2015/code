class CountComponents {
	private List<List<Integer>> buildMap(int n, int[][] edges) {
		List<List<Integer>> map = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			map.add(new ArrayList<>());
		}
		for (int[] edge : edges) {
			map.get(edge[0]).add(edge[1]);
			map.get(edge[1]).add(edge[0]);
		}
		return graph;
	}

	// dfs
	public int countComponents1(int n, int[][] edges) {
		if (n == 0) return 0;
		List<List<Integer>> graph = buildMap(n, edges);
		boolean[] visited = new boolean[n];
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				dfs(graph, i, visited);
				count++;
			}
		}
		return count;
	}
	private void dfs(List<List<Integer>> graph, int node, boolean[] visited) {
		if (visited[node]) return;
		visited[node] = true;
		for (int nei : graph.get(node)) {
			dfs(graph, nei, visited);
		}
	}

	// bfs
	public int countComponents2(int n, int[][] edges) {
		if (n == 0) return 0;
		List<List<Integer>> graph = buildMap(n, edges);
		boolean[] visited = new boolean[n];
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				bfs(i, graph, visited);
				count++;
			}
		}
		return count;
	}
	private void bfs(int node, List<List<Integer>> graph, boolean[] visited) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(node);
		while (!queue.isEmpty()) {
			Integer cur = queue.poll();
			for (Integer nei : graph.get(cur)) {
				if (!visited[nei]) {
					visited[nei] = true;
					queue.offer(nei);
				}
			}
		}
	}
}
