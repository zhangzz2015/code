class CloneGraph {
	class Node {
		 public int val;
		 public List<Node> neighbors;
		 public Node(int _val) {
			val = _val;
			neighbors = new ArrayList<Node>();
		 }
	}
	// dfs
	public Node cloneGraph(Node node) {
		if (node == null) return null;
		HashMap<Node, Node> map = new HashMap<>();
		map.put(node, new Node(node.val));
		dfs(node, map);
		return map.get(node);
	}
	private void dfs(Node node, HashMap<Node, Node> map) {
		Node copy = map.get(node);
		for (Node nei : node.neighbors) {
			if (!map.containsKey(nei)) {
				map.put(nei, new Node(nei.val));
				dfs(nei, map);
			}
			copy.neighbors.add(map.get(nei));
		}
	}

	// bfs
	public Node cloneGraph1(Node node) {
		if (node == null) return null;
		Map<Node, Node> map = new HashMap<>();
		Queue<Node> queue = new ArrayDeque<>();
		queue.offer(node);
		map.put(node, new Node(node.val));
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			for (Node nei : cur.neighbors) {
				if (!map.containsKey(nei)) {
					Node copy = new Node(nei.val);
					map.put(nei, copy);
					queue.offer(nei);
				}
				map.get(cur).neighbors.add(map.get(nei));
			}
		}
		return map.get(node);
	}
}
