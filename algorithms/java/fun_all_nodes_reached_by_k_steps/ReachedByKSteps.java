class ReachedByKSteps {
	class Node {
		List<Node> neighbors;
	}
	public List<Node> bfs(Node root, int k) {
		Queue<Node> queue = new ArrayDeque<>();
		queue.offer(root);
		Set<Node> visited = new HashSet<>();
		visited.add(root);
		int level = 0;
		while (level < k && !queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Node cur = queue.poll();
				for (Node nei : cur.neighbors) {
					if (visited.add(nei)) {
						queue.offer(nei);
					}
				}
			}
			level++;
		}
		return new ArrayList<>(visited);
	}
}
