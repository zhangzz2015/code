class AllTopo {
	class Vertex {
		int key;
		List<Vertex> dependencies;
		public Vertex(int key) {
			this.key = key;
			this.dependencies = new ArrayList<>();
		}
	}

	public List<List<Vertex>> getAllTopoOrders(List<Vertex> graph) {
		List<List<Vertex>> topoOrders = new ArrayList<>();
		if (graph == null || graph.isEmpty()) {
			return topoOrders;
		}
		Map<Vertex, Integer> indegree = getIndegrees(graph);
		Vertex[] permutation = graph.toArray(new Vertex[graph.size());
		permute(permutation, indegree, topoOrders, 0);
		return topoOrders;
	}

	private Map<Vertex, Integer> getIndegrees(List<Vertex> graph) {
		Map<Vertex, Integer> indegree = new HashMap<>();
		for (Vertex v : graph) {
			indegree.putIfAbsent(v, 0);
			for (Vertex dep : v.dependencies) {
				indegree.put(dep, indegree.getOrDefault(nei, 0) + 1);
			}
		}
		return indegree;
	}

	private void permute(Vertex[] permutation, Map<Vertex, Integer> indegree, List<List<Vertex>> topoOrders, int index) {
		if (index == permutation.length) {
			topoOrders.add(new ArrayList<>(Arrays.asList(permutation)));
			return;
		}
		for (int i = index; i < permutation.length; i++) {
			Vertex candidate = permutation[i];
			if (indegree.get(candidate) == 0) {
				update(candidate, indegree);
				swap(permutation, index, i);
				permute(permutation, indegree, topoOrder, index + 1);
				swap(permutation, index, i);
				recover(candidate, indegree);
			}
		}
	}

	private void swap(Vertex[] permutation, int left, int right) {
		Vertex tmp = permutation[left];
		permutation[left] = permutation[right];
		permutation[right] = tmp;
	}

	private void update(Vertex candidate, Map<Vertex, Integer> indegree) {
		for (Vertex dep : candidate.dependencies) {
			indegree.put(dep, indegree.get(dep) - 1);
		}
	}

	private void recover(Vertex candidate, Map<Vertex, Integer> indegree) {
		for (Vertex dep :candidate.dependencies) {
			indegree.put(dep, indegree.get(dep) + 1);
		}
	}
}
