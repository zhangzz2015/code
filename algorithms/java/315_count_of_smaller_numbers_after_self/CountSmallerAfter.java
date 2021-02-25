public class CountSmallerAfter {
	public List<Integer> countSmaller(int[] nums) {
		if (nums == null || nums.length == 0) {
			return new ArrayList<>();
		}
		int[] index = new int[nums.length];
		for (int i = 0; i < index.length; i++) {
			index[i] = i;
		}
		int[] count = new int[nums.length];
		int[] helper = new int[nums.length];
		mergeSort(nums, index, count, helper, 0, nums.length - 1);
		List<Integer> res = new ArrayList<>();
		for (int c : count) {
			res.add(c);
		}
		return res;
	}
	private void mergeSort(int[] nums, int[] index, int[] count, int[] helper, int left, int right) {
		if (left >= right) {
			return;
		}
		int mid = left + (right - left) / 2;
		mergeSort(nums, index, count, helper, left, mid);
		mergeSort(nums, index, count, helper, mid + 1, right);
		merge(nums, index, count, helper, left, mid, right);
	}
	private void merge(int[] nums, int[] index, int[] count, int[] helper, int left, int mid, int right) {
		for (int i = left; i <= right; i++) {
			helper[i] = index[i];
		}
		int l = left;
		int r = mid + 1;
		int cur = left;
		while (l <= mid) {
			if (r > right || nums[helper[l]] <= nums[helper[r]]) {
				count[helper[l]] += r - mid - 1;
				index[cur++] = helper[l++];
			} else {
				index[cur++] = helper[r++];
			}
		}
	}
}
