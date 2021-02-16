class ValidTree {
	// count and cycle
	public boolean validTree(int n, int[][] edges) {
        if (edges == null) {
            return false;
        }
        int[] edgeCount = new int[1];
        List<List<Integer>> graph = buildGraph(n, edges, edgeCount);
        if (edgeCount[0] != n - 1) {
            return false;
        }
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i] && hasCycle(i, -1, graph, visited)) {
                return false;
            }
        }
        return true;
    }
    private List<List<Integer>> buildGraph(int n, int[][] edges, int[] edgeCount) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            edgeCount[0]++;
        }
        return graph;
    }
    private boolean hasCycle(int node, int prev, List<List<Integer>> graph, boolean[] visited) {
        if (visited[node]) {
            return true;
        }
        visited[node] = true;
        for (int nei : graph.get(node)) {
            if (nei != prev && hasCycle(nei, node, graph, visited)) {
                return true;
            }
        }
        return false;
    }


	// count and connected
	public boolean validTree1(int n, int[][] edges) {
        if (edges == null) {
            return false;
        }
        int[] edgeCount = new int[1];
        List<List<Integer>> graph = buildGraph1(n, edges, edgeCount);
        if (edgeCount[0] != n - 1) {
            return false;
        }
        Set<Integer> visited = new HashSet<>();
        dfs(0, graph, visited);
        return visited.size() == n;
    }
    private List<List<Integer>> buildGraph1(int n, int[][] edges, int[] edgeCount) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            edgeCount[0]++;
        }
        return graph;
    }
    private void dfs(int node, List<List<Integer>> graph, Set<Integer> visited) {
        if (!visited.add(node)) {
            return;
        }
        for (int nei : graph.get(node)) {
            dfs(nei, graph, visited);
        }
    }
}
