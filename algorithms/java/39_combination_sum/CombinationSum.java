class CombinationSum {
	// 1.
	public List<List<Integer>> combinationSum1(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		comb1(candidates, target, res, new ArrayList<>(), 0);
		return res;
	}

	private void comb1(int[] candidates, int target, List<List<Integer>> res, List<Integer> cur, int index) {
		if (target == 0) {
			res.add(new ArrayList<>(cur));
			return;
		}
		if (target < 0 || index == candidates.length) {
			return;
		}
		int max = target / candidates[index];
		for (int i = 0; i <= max; i++) {
			int tmp = i;
			while(tmp > 0) {
				cur.add(candidates[index]);
				tmp--;
			}
			comb1(candidates, target - i * candidates[index], res, cur, index + 1);
			while (tmp < i) {
				cur.remove(cur.size() - 1);
				tmp++;
			}
		}
	}

	// 2.
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        comb2(candidates, target, res, new ArrayList<>(), 0);
        return res;
    }
    private void comb2(int[] candidates, int target, List<List<Integer>> res, List<Integer> cur, int index) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            cur.add(candidates[i]);
            comb2(candidates, target - candidates[i], res, cur, i);
            cur.remove(cur.size() - 1);
        }
    }
}
