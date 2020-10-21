class TopoOrder {
	enum State {
		UNVISITED, VISITING, VISITED
	}
	class Vertex {
		List<Vertex> dependencies;
		State state = State.UNVISITED;
	}

	// dfs
	public List<Vertex> topoOrder(List<Vertex> graph) {
		List<Vertex> topoOrder = new ArrayList<>();
		for (Vertex v : graph) {
			if (!dfs(v, topoOrder) {
				// throw new IllegalStateException("Cycle detected");
				return new ArrayList<>();
			}
		}
		return topoOrder;
	}
	private boolean dfs(Vertex v, List<Vertex> topoOrder) {
		if (v.state == State.VISITED) return true;
		if (v.state == State.VISITING) return false; // there is a cycle
		v.state = State.VISITING;
		for (Vertex d : v.dependencies) {
			execute(d, topoOrder);
		}
		v.state = State.VISITED;
		topoOrder.add(v);
	}
}
