import.java.util.*;

class KeepDistance {
	public List<int[]> getAll(int k) {
		int[] array = new int[k * 2];
		List<int[]> res = new ArrayList<>();
		dfs(res, array, k);
		return res;
	}
	private void dfs(List<int[]> res, int[] array, int k) {
		if (k == 0) {
			res.add(array.clone());
			return;
		}
		for (int i = 0; i + k + 1 < array.length; i++) {
			if (array[i] == 0 && array[i + k + 1] == 0) {
				array[i] = k;
				array[i + k + 1] = k;
				dfs(res, array, k - 1);
				array[i] = 0;
				array[i + k + 1] = 0;
			}
		}
	}
	public static void main(String[] args) {
        KeepDistance solve = new KeepDistance();
        List<int[]> res = solve.getAll(3);
        for (int[] r : res) {
            System.out.println(Arrays.toString(r));
        }
    }
}
