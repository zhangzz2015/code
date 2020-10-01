class Combinations {
    
    // easier to understand way
    public List<List<Integer>> combinations1(int[] array, int target, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (array == null || array.length == 0 || k <= 0) return res;
        Arrays.sort(array);
        List<Integer> cur = new ArrayList<>();
        dfs1(array, target, k, res, cur, 0);
        return res;
    }

    private void dfs1(int[] array, int target, int k, List<List<Integer>> res, List<Integer> cur, int index) {
        if (index == array.length || target < 0 || cur.size() > k) return;
        if (target == 0 && cur.size() == k) {
            res.add(new ArrayList<>(cur));
            return;
        }
        cur.add(array[index]);
        dfs(array, target - array[index], k, cur, index + 1);
        cur.remove(cur.size() - 1);
        while (index < array.length - 1 && array[index] == array[index + 1]) {
            index++;
        }
        dfs(array, target, k, res, cur, index + 1);
    }

    // a better way: call less using iteration to avoid using recursion to go to the next level
    public List<List<Integer>> combinations2(int[] array, int target, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (array == null || array.length == 0 || k <= 0) return res;
        Arrays.sort(array);
        List<Integer> cur = new ArrayList<>();
        dfs(array, target, k, res, cur, 0);
        return res;
    }

    public void dfs1(int[] array, int target, int k, List<List<Integer>> res, List<Integer> cur, int index) {
        if (index == array.length || target < 0 || cur.size() > k) return;
        if (target == 0 && cur.size() == k) {
            res.add(new ArrayList<>());
            return;
        }
        for (int i = index, i < array.length; i++) {
            if (i == index || array[i] != array[i - 1]) {
                cur.add(array[i]);
                dfs(array, target - array[i], k, res, cur, i + 1);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
