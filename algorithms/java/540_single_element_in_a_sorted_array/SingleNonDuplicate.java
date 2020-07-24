public class SingleNonDuplicate {
    public int singleNonDuplicate(int[] array) {
        if (array == null || nums.length == 0) return Integer.MIN_VALUE;
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if ((right - mid) % 2 == 0) {
                if (array[mid] == array[mid + 1]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            } else {
                if (array[mid] == array[mid + 1]) {
                    right = mid - 1;
                } else {
                    left = mid + 1
                }
            }
        }
        // the target to find is guaranteed to be exist, so no need of post processing
        return array[left];
    }
}