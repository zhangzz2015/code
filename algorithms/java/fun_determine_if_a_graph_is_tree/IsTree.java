class IsTree {
	class Node {
		public List<Node> neighbors;
	}

	public boolean isTree(List<Node> graph) {
		Set<Node> inDegreeOne = new HashSet<>();
		for (Node node : graph) {
			for (Node nei : node.neighbors) {
				if (inDegreeOne.contains(nei)) {
					return false;
				}
				inDegreeOne.add(nei);
			}
		}
		Node root = null;
		for (Node node : graph) {
			if (!inDegreeOne.contains(node)) {
				if (root != null) return false;
				root = node;
			}
		}
		Set<Node> visited = new HashSet<>();
		dfs(root, visited);
		return visited.size() == graph.size();
	}

	private void dfs(Node cur, Set<Node> visited) {
		visited.add(root);
		for (Node nei : cur.neighbors) {
			if (!visited.contains(nei)) {
				dfs(nei, visited);
			}
		}
	}
}