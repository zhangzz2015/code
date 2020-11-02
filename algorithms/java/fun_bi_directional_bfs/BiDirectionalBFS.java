class BiDirectionalBFS {
	static class OneDirection {
		private Queue<Node> queue;
		public Map<Node, Integer> visited; // visited nodes from init and its shortest path length from init
		public OneDirection(Node init) {
			queue = new ArrayDeque<>();
			visited = new HashMap<>();
			queue.offer(init);
			visited.put(init, 0);
		}

		public boolean hasNodesToExplore() {
			return !queue.isEmpty();
		}

		public int nextRound(OneDirection reverse) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Node cur = queue.poll();
				for (Node nei : cur.neigbors) {
					// check if overlap with reverse
					if (reverse.visited.containsKey(nei)) {
						return reverse.visited.get(nei) + visited.get(cur) + 1;
					}
					if (!visited.containsKey(nei)) {
						visited.put(nei, visited.get(cur) + 1);
						queue.offer(nei);
					}
				}
			}
			return -1;
		}
	}

	public int biDirectionalBFS(Node init, Node goal) {
		OneDirection start = new OneDirection(init);
		OneDirection end = new OneDirection(goal);
		while (start.hasNodesToExplore() && end.hasNodesToExplore()) {
			int shortest = start.nextRound(end);
			if (shortest != -1) {
				return shortest;
			}
			shortest = end.nextRound(start);
			if (shortest != -1) {
				return shortest;
			}
		}
		return -1; // cannot reach
	}
}
