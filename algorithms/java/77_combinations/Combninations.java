class Combninations {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		dfs(res, path, 1, n, k);
		return res;
	}
	private void dfs(List<List<Integer>> res, List<Integer> path, int cur, int n, int k) {
		if (path.size() == k) {
			res.add(new ArrayList<>(path));
			return;
		}
		for (int i = cur; i <= n; i++) {
			path.add(i);
			dfs(res, path, i + 1, n, k);
			path.remove(path.size() - 1);
		}
	}
}
