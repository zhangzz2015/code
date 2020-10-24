class BFS {
	// mark visited expansion
	void bfs1(Node root) {
		Queue<Node> queue = new ArrayDeque<>();
		queue.offer(root);
		Set<Node> visited = new HashSet<>();
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Node cur = queue.poll(); // expansion
				if (!visited.add(cur)) continue; // mark visited
				for (Node nei : cur.children) {
					queue.offer(nei);
				}
			}
			level++;
		}
	}

	// mark visited at being generated
	void bfs2(Node root) {
		Queue<Node> queue = new ArrayDeque<>();
		queue.offer(root); // generate root
		int level = 0;
		Set<Node> visited = new HashSet<>();
		visited.add(root); // mark at generated
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Node cur = queue.poll(); // expansion
				for (Node nei : cur.children) {
					if (visited.add(nei)) {
						queue.offer(nei); // generate
					}
				}
			}
			level++;
		}
	}
}
