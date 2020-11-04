class TopoOrder {
	enum State {
		UNVISITED, VISITING, VISITED
	}
	class Vertex {
		List<Vertex> dependencies;
		State state = State.UNVISITED;
	}

	// dfs
	public List<Vertex> topoOrderDFS(List<Vertex> graph) {
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
			dfs(d, topoOrder);
		}
		v.state = State.VISITED;
		topoOrder.add(v);
	}

	// bfs
	public List<Vertex> topoOrderBFS(List<Vertex> vertices) {
		if (vertices == null) {
			return null;
		}
		List<Vertex> topoOrder = new ArrayList<>();
		Map<Vertex. Lst<Vertex>> map = buildMap(vertices); // mapping from a node and all the nodes depending on this node
		Map<Vertex, Integer> indegree = getIndegree(vertices);
		Queue<Vertex> queue = new ArrayDeque<>();
		initializeQueue(queue, vertices);
		while (!queue.isEmpty()) {
			Vertex cur = queue.poll();
			for (Vertex depender : map.get(cur)) {
				int count = indegree.get(depender);
				if (count == 1) {
					queue.offer(depender);
				} else {
					indegree.put(depender, count - 1);
				}
			}
			topoOrder.add(file);
		}
		return topoOrder;
	}

	private void initializeQueue(Queue<Vertex> queue, List<Vertex> graph) {
		for (Vertex v : graph) {
			if (v.dependencies.size() == 0) {
				queue.offer(v);
			}
		}
	}

	private Map<Vertex, Integer> getIndegree(List<Vertex> graph) {
		Map<Vertex, Integer> indegree = new HashMap<>();
		for (Vertex v : graph) {
			indegree.put(v, v.dependencies.size());
		}
		return indegree;
	}

	private Map<Vertex, List<Vertex>> buildMap(List<Vertex> graph) {
		Map<Vertex, List<Vertex>> map = new HashMap<>();
		for (Vertex v : graph) {
			map.putIfAbsent(v, new ArrayList<>());
			for (Vertex dep : v.dependecies) {
				List<Vertex> dependencyList = map.getOrDefault(dependency, new ArrayList<>());
				dependencyList.add(file);
				map.put(dependency, dependencyList);
			}
		}
		return map;
	}
}
