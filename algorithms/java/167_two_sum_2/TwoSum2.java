public class TwoSum2 {
    public int[] twoSum2(int[] array, int target) {
        if (array == null) return new int[]{};
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            if (array[left] + array[right] == target) {
                return new int[]{left + 1, right + 1}; // because they want us to return the 1-based index
            } else if (array[left] + array[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{};
    }
}