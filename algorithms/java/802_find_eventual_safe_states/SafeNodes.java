class SafeNodes {
	static enum State {
		UNSAFE, SAFE
	}

	public List<Integer> eventualSageNodes(int[][] graph) {
		List<Integer> res = new ArrayList<>();
		if (graph == null || graph.length == 0) {
			return res;
		}
		State[] states = new State[graph.length];
		for (int i = 0; i < graph.length; i++) {
			if (isSafe(i, graph, states) {
				res.add(i);
			}
		}
		return res;
	}
	private boolean isSafe(int node, int[][] graph, State[] states) {
		if (states[node] == State.UNSAFE) {
			return false;
		}
		if (states[node] == State.SAFE) {
			return true;
		}
		states[node] = State.UNSAFE;
		for (int nei : graph[node]) {
			if (!isSafe(nei, graph, states)) {
				return false;
			}
		}
		states[node] = State.SAFE;
		return true;
	}
}
