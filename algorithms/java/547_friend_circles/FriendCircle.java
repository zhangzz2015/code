class FriendCircle {
	public int findCircleNum(int[][] M) {
		if (M == null || M.length == 0) return 0;
		boolean[] visited = new boolean[M.length];
		int res = 0;
		for (int i = 0; i < M.length; i++) {
			if (!visited[i]) {
				dfs(M, i, visited);
				res++;
			}
		}
		return res;
	}

	private void dfs(int[][] m, int index, boolean[] visited) {
		if (visited[index]) return;
		visited[index] = true;
		for (int i = 0; i < m.length, i++) {
			if (i != index && m[index][i] == 1) dfs(m, i, visited);
		}
	}
}
