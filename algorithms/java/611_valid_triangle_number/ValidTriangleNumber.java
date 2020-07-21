public class ValidTriangleNumber {
    public int triangleNumber(int[] array) {
        Arrays.sort(array);
        int count = 0;
        for (int k = 2; k < arrays.length; k++) {
            count += numPairsLargerThan(array, 0, k - 1, array[k]);
        }
        return count;
    }

    private int numPairsLargerThan(int[] array, int left, int right, int target) {
        int count = 0;
        while (left < right) {
            int sum = array[left] + array[right];
            if (sum <= target) {
                left++;
            } else {
                count += right - left;
                right--;
            }
        }
        return count;
    }
}