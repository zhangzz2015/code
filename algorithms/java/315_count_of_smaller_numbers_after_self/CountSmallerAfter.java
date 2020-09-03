public class CountSmallerAfter {
    public List<Integer> countSmaller(int[] nums) {
        int[] index = new int[nums.length];
        for (int i = 0; i < index.length; i++) index[i] = i;
        int[] count = new int[nums.length];
        mergeSort(nums, index, count, 0, nums.length - 1);
        List<Integer> res = new ArrayList<>();
        for (int i : count) res.add(i);
        return res;
    }

    private void mergeSort(int[] nums, int[] index, int[] count, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(nums, index, count, left, mid);
        mergeSort(nums, index, count, mid + 1, right);
        merge(nums, index, count, left, mid, right);
    }

    private void merge(int[] nums, int[] index, int[] count, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int leftIndex = left;
        int rightIndex = mid + 1;
        int tmpIndex = 0;
        while (leftIndex <= mid) {
            if (rightIndex > right || nums[index[leftIndex]] <= nums[index[rightIndex]]) {
                count[index[leftIndex]] += rightIndex - mid - 1;
                tmp[tmpIndex++] = index[leftIndex++];
            } else {
                tmp[tmpIndex++] = index[rightIndex++];
            }
        }
        while (rightIndex <= right) {
            tmp[tmpIndex++] = index[rightIndex++];
        }
        for (int i = 0, z = left; z <= right; i++, z++) {
            index[z] = tmp[i];
        }
    }
}