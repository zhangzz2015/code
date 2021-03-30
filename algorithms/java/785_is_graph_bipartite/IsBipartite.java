class IsBipartite {
	// 1. dfs
	public boolean isBipartite(int[][] graph) {
		if (graph == null || graph.length == 0) {
			return false;
		}
		int n = graph.length;
		int[] visited = new int[n]; // 0: not visited  1: color1 -1: color2
		for (int i = 0; i < n; i++) {
			if (visited[i] == 0 && !isValidDFS(i, 1, graph, visited)) {
				return false;
			}
		}
		return true;
	}
	private boolean isValidDFS(int node, int color, int[][] graph, int[] visited) {
		if (visited[node] != 0) {
			return visited[node] == color;
		}
		visited[node] = color;
		for (int nei : graph[node]) {
			if (!isValidDFS(nei, graph, -color, graph, visited)) {
				return false;
			}
		}
		return true;
	}

	// 2. bfs
	public boolean isBipartite1(int[][] graph) {
		if (graph == null || graph.length == 0) {
			return false;
		}
		int n = graph.length;
		int[] visited = new int[n];
		for (int i = 0; i < n; i++) {
			if (visited[i] == 0 && !isValidBFS(i, graph, visited)) {
				return false;
			}
		}
		return true;
	}
	private boolean isValidBFS(int node, int[][] graph, int[] visited) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(node);
		visited[node] = 1;
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			int color = visited[cur];
			for (int nei : graph[cur]) {
				if (visited[nei] == color) {
					return false;
				}
				if (visited[nei] == 0) {
					queue.offer(nei);
					visited[nei] = -color;
				}
			}
		}
		return true;
	}
}
