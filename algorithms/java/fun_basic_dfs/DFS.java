class DFS {
	// mark visted 1
	enum State {
		UNVISITED, VISITED
	}
	class Vertex {
		State state = State.UNVISITED;
		List<Vertex> neighbors;
	}
	void dfs1(Vertex v) {
		// base case (actually pruning)
		if (v.state == State.VISITED) return; // not the first time
		v.state = State.VISITED; // first time
		for (Vertex n : v.neighbors) {
			dfs(n);
		}
	}

	// mark visited 2
	enum State {
		UNVISITED, VISITING, VISITED
	}
	class Vertex {
		State state = State.UNVISITED;
		List<Vertex> neighbors;
	}
	void dfs2(Vertex v) {
		if (v.state == State.VISITED) return; // already visited
		if (v.state == State.VISITING) return; // there is a cycle
		v.state = State.VISITING;
		for (Vertex n : v.neighbors) {
			dfs2(n);
		}
		v.state = State.VISITED; // mark visited after all descendents are visited
	}

	// mark visited 3
	enum State {
		UVISITED, VISITED
	}
	class Vertex {
		State state = State.UNVISITED;
		List<Vertex> neighbors;
	}
	void dfs3(Vertex v) {
		if (v.state == State.VISITED) return; // there is cycle on the current path
		v.state = State.VISITED;
		for (Vertex n : v.neighbors) {
			dfs3(n);
		}
		v.state = State.UNVISITED; // recover, remove current node from the current dfs path
	}
}
