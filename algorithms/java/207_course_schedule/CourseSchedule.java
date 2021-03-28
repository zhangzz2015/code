class CourseSchedule {
	
	// dfs
	public boolean canFinish1(int numCourses, int[][] prerequisites) {
		if (numCourses == 0) return false;
		List<List<Integer>> graph = buildGraph1(numCourses, prerequisites);
		boolean[] visited = new boolean[numCourses];
		boolean[] visiting = new boolean[numCourses];
		for (int i = 0; i < numCourses; i++) {
			if (!dfs(i, graph, visited, visiting)) {
				return false;
			}
		}
		return true;
	}
	private boolean dfs(int node, List<List<Integer>> graph, boolean[] visited, boolean[] visiting) {
		if (visited[node]) return true;
		if (visiting[node]) return false;
		visiting[node] = true;
		for (int nei : graph.get(node)) {
			if (!dfs(nei, graph, visited, visiting)) {
				return false;
			}
		}
		visiting[node] = false;
		visited[node] = true;
		return true;
	}
	private List<List<Integer>> buildGraph1(int numCourses, int[][] edges) {
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < numCourses; i++) {
			graph.add(new ArrayList<>());
		}
		for (int[] edge : edges) {
			graph.get(edge[0]).add(edge[1]);
		}
		return graph;
	}
	

	// bfs
	public boolean canFinish2(int numCourses, int[][] prerequisites) {
		if (numCourses == 0) return false;
		int[] indegree = new int[numCourses];
		List<List<Integer>> graph = buildGraph2(numCourses, prerequisites, indegree);
		return bfs(numCourses, graph, indegree);
	}
	private boolean bfs(int nodes, List<List<Integer>> graph, int[] indegree) {
		List<Integer> res = new ArrayList<>();
		Queue<Integer> queue = new ArrayDeque<>();
		for (int i = 0; i < indegree.length; i++) {
			if (indegree[i] == 0) {
				queue.offer(i);
			}
		}
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			res.add(cur);
			for (int nei : graph.get(cur)) {
				indegree[nei]--;
				if (indegree[nei] == 0) {
					queue.offer(nei);
				}
			}
		}
		return res.size() == nodes;
	}
	private List<List<Integer>> buildGraph2(int nodes, int[][] edges, int[] indegree) {
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < nodes; i++) {
			graph.add(new ArrayList<>());
		}
		for (int[] edge : edges) {
			graph.get(edge[1]).add(edge[0]);
			indegree[edge[0]]++;
		}
		return graph;
	}
}
