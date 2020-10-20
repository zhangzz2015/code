class IsTree {
	static class Vertex {
		List<Vertex> neighbors;
	}
	
	// undirected graph
	public boolean isTree(List<Vertex> graph) {
		Set<Vertex> visited = new HashSet<>();
		int count = 0; // count connected areas
		for (Vertex v : graph) {
			if (!visited.contains(v)) {
				count++;
				if (hasCycle(v, null, visited)) return false;
			}
		}
		return count == 1;
	}
	private boolean hasCycle(Vertex cur, Vertex prev, Set<Vertex> visited) {
		if (visited.contains(cur)) return true;
		visited.add(cur);
		for (Vertex n : cur.neighbors) {
			if (prev != null && hasCycle(n, cur)) return true;
		}
		return false;
	}
}
