class HasCycle {
	static class Vertex {
		List<Vertex> neighbors;
		State1 state = State.UNVISITED;
	}
	// for undirected graph
	// dfs with mark VISITED
	enum State1 {
		UNVISITED,
		VISITED
	}
	boolean hasCycle1(Vertex v, Vertex prev) {
		if (v.state == State1.VISITED) return true; // find cycle
		v.state = State1.VISITED;
		for (Vertex nei : v.neighbors) {
			if (prev != nei && hasCycle1(nei, v)) return true;
		}
	}

	// for directed graph
	// 1. dfs with mark VISITING
	enum State2 {
		UNVISITED,
		VISITING,
		VISITED
	}
	public boolean hasCycle2(List<Vertex> graph) {
		for (Vertex v : graph) {
			if (hasCycle2(v)) return true;
		}
		return false;
	}
	private boolean hasCycle2(Vertex v) {
		if (v.state == State2.VISITING) return true; // find cycle
		if (v.state == State2.VISITED) return false;
		v.state = State2.VISITING;
		for (Vertex nei : v.neighbors) {
			if (hasCycle2(nei)) return true;
		}
		v.state = State2.VISITED;
		return false;
	}

	// 2. dfs backtracking
	enum State3 {
		UNVISITED,
		VISITED
	}
	public boolean hasCycle3(List<Vertex> graph) {
		for (Vertex v : graph) {
			if (hasCycle3(v)) return true;
		}
		return false;
	}
	private boolean hasCycle3(Vertex v) {
		if (v.state == State3.VISITED) return true; // find cycle
		v.state = State3.VISITED;
		for (Vertex nei : v.neighbors) {
			if (hasCycle3(n)) return true;
		}
		v.state = State3.UNVISITED; // backtracking
		return false;
	}
}
