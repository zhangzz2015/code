class DeepCopy {
	class GraphNode {
		int val;
		List<GraphNode> neighbors;
		public GraphNode(int val) {
			this.val = val;
			this.neighbors = new ArrayList<GraphNode>();
		}
	}

	public List<GraphNode> copy(List<GraphNode> graph) {
		if (graph == null) {
			return null;
		}
		HashMap<GraphNode, GraphNode> map = new HashMap<>();
		for (GraphNode node : graph) {
			if (!map.containsKey(node)) {
				map.put(node, new GraphNode(node.val));
				dfs(node, map);
			}
		}
		return new ArrayList<GraphNode>(map.values());
	}

	private void dfs(GraphNode node, HashMap<GraphNode, GraphNode> map) {
		GraphNode copy = map.get(node);
		for (GraphNode nei : node.neighbors) {
			if (!map.containsKey(nei)) {
				map.put(nei, new GraphNode(nei.key));
				dfs(nei, map);
			}
			copy.neighbors.add(map.get(nei));
		}
	}

	// follow up
	public List<GraphNode> reverseCopy(List<GraphNode> graph) {
		if (graph == null) {
			return null;
		}
		HashMap<GraphNode, GraphNode> map = new HashMap<>();
		for (GraphNode node : graph) {
			if (!map.containsKey(node)) {
				map.put(node, new GraphNode(node.val));
				reverseCopyDfs(node, map);
			}
		}
		return new ArrayList<GraphNode>(map.values());
	}

	private void reverseCopyDfs(GraphNode node, HashMap<GraphNode, GraphNode> map) {
		GraphNode copy = map.get(node);
		if (copy != null) return; // already visited
		copy = new GraphNode(node.val);
		map.put(node, copy);
		for (GraphNode nei : node.neighbors) {
			reverseCopyDfs(nei, map);
			// copy edges to current vertex
			// must be after the dfs of neightbors, this can make sure that the copied node exists
			map.get(node).neighbors.add(copy);
		}
	}
}
