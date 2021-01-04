class CourseSchedule {
	// 1. dfs
	public int[] findOrder1(int numCourses, int[][] prerequisites) {
		if (numCourses == 0) {
            return new int[0];
        }
        List<List<Integer>> graph = buildGraph(numCourses, prerequisites);
        boolean[] visited = new boolean[numCourses];
        boolean[] visiting = new boolean[numCourses];
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, visited, visiting, res, i)) {
                return new int[0];
            }
        }
        int[] courses = new int[res.size()];
        for (int i = 0; i < courses.length; i++) {
            courses[i] = res.get(i);
        }
        return courses;
	}

	private boolean dfs(List<List<Integer>> graph, boolean[] visited, boolean[] visiting, List<Integer> res, int node) {
        if (visited[node]) {
            return true;
        }
        if (visiting[node]) {
            return false;
        }
        visiting[node] = true;
        for (int nei : graph.get(node)) {
            if (!dfs(graph, visited, visiting, res, nei)) {
                return false;
            }
        }
        visited[node] = true;
        res.add(node);
        return true;
    }

	private List<List<Integer>> buildGraph1(int num, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
        }
        return graph;
    }

	// 2. bfs
	public int[] findOrder2(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
            return new int[0];
        }
        int[] indegree = new int[numCourses];
        List<List<Integer>> graph = buildGraph(numCourses, prerequisites, indegree);
        List<Integer> res = bfs(numCourses, graph, indegree);
        int[] courses = new int[res.size()];
        for (int i = 0; i < courses.length; i++) {
            courses[i] = res.get(i);
        }
        return courses;
    }
    
    private List<Integer> bfs(int nodes, List<List<Integer>> graph, int[] indegree) {
        List<Integer> res = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < nodes; i++) {
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
        return res.size() == nodes ? res : new ArrayList<>();
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
