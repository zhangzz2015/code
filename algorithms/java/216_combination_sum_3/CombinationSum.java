class CombinationSum {
	// 1.
	public List<List<Integer>> combinationSum1(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        comb1(k, n, 1, res, new ArrayList<>());
        return res;
    }
    private void comb1(int k, int n, int element, List<List<Integer>> res, List<Integer> cur) {
        if (cur.size() == k && n == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if (n < 0 || element > 9) {
            return;
        }
        cur.add(element);
        comb1(k, n - element, element + 1, res, cur);
        cur.remove(cur.size() - 1);
        comb1(k, n, element + 1, res, cur);
    }

	// 2.
	public List<List<Integer>> combinationSum2(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        comb2(k, n, 1, res, new ArrayList<>());
        return res;
    }
    private void comb2(int k, int n, int element, List<List<Integer>> res, List<Integer> cur) {
        if (cur.size() == k && n == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if (n < 0) {
            return;
        }
        for (int i = element; i < 10; i++) {
            cur.add(i);
            comb2(k, n - i, i + 1, res, cur);
            cur.remove(cur.size() - 1);
        }
    }
}
