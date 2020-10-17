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
}
