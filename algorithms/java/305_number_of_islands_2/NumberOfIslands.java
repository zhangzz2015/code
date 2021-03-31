class NumberOfIslands {
	public List<Integer> numIslands2(int m, int n, int[][] positions) {
		List<Integer> res = new ArrayList<>();
		UnionFind uf = new UnionFind(m * n);
		boolean[][] island = new boolean[m][n];
		for (int[] pos : positions) {
			int i = p[0];
			int j = p[1];
			if (island[i][j]) {
				res.add(uf.count());
				continue;
			}
			uf.count++;
			island[i][j] = true;
			int id = i * n + j;
			if (i - 1 >= 0 && island[i - 1][j]) {
				uf.union(id, id - n);
			}
			if (j - 1 >= 0 && island[i][j - 1]) {
				uf.union(id, id - 1);
			}
			if (i + 1 < m && island[i + 1][j]) {
				uf.union(id, id + n);
			}
			if (j + 1 < n && island[i][j + 1]) {
				uf.union(id, id + 1);
			}
			res.add(uf.count);
		}
		return res;
	}

	private class UnionFind {
		private int[] ids;
		private int[] sizes;
		public int count;

		UnionFind(int n) {
			this.ids = new int[n];
			this.sizes = new int[n];
			for (int i = 0; i < n; i++) {
				ids[i] = i;
				sizes = 1;
			}
		}

		private int getRoot(int a) {
			int root = a;
			while (root != ids[root]) {
				root = ids[root];
			}
			while (a != root) {
				int next = ids[a];
				ids[a] = root;
				a = next;
			}
			return root;
		}

		public void union(int a, int b) {
			int roota = getRoot(a);
			int rootb = getRoot(b);
			if (roota == rootb) {
				return;
			}
			count--;
			if (sizes[roota] >= sizes[rootb]) {
				ids[rootb] = roota;
				sizes[roota] += sizes[rootb];
			} else {
				ids[roota] = rootb;
				sizes[rootb] += sizes[roota];
			}
		}
	}
}
