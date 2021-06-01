class CombinationSum {
	// 1. 
	public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
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
        cur.add(candidates[index]);
        comb1(candidates, target - candidates[index], res, cur, index + 1);
        cur.remove(cur.size() - 1);
        while (index < candidates.length - 1 && candidates[index] == candidates[index + 1]) {
            index++;
        }
        comb1(candidates, target, res, cur, index + 1);
    }

	// 2.
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
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
            comb2(candidates, target - candidates[i], res, cur, i + 1);
            cur.remove(cur.size() - 1);
            while (i < candidates.length - 1 && candidates[i] == candidates[i + 1]) {
                i++;
            }
        }
    }

	// 3.
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        comb3(candidates, target, res, new ArrayList<>(), 0);
        return res;
    }
    private void comb3(int[] candidates, int target, List<List<Integer>> res, List<Integer> cur, int index) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if (target < 0) {
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = index; i < candidates.length; i++) {
            if (set.add(candidates[i])) {
                cur.add(candidates[i]);
                comb3(candidates, target - candidates[i], res, cur, i + 1);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
