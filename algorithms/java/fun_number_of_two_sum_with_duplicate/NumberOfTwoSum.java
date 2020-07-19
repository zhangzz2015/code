public class NumberOfTwoSum {
    
    // there are duplicates elements but we don't count duplicate pairs.
    public int numberOfTwoSum1(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        int count = 0;
        while (left < right) {
            int sum = array[left] + array[right];
            if (sum == target) {
                count++;
                while (right - 1 >= 0 && array[right - 1] == array[right]) {
                    right--;
                }
                right--;
            } else if (sum < target) left++;
            else right--;
        }
        return count;
    }

    // there are duplicate numbers and count duplicate pairs
    public int numberOfTwoSum2(int[] array, int target) {
        int left = 0;
        int right = array.length;
        int count = 0;
        while (left < right) {
            int sum = array[left] + array[right];
            if (sum == target) {
                // case 1: [xx, 2, 2, 2, xx]
                if (array[left] == array[right]) {
                    count += (right - left + 1) * (right - left) / 2;
                    break;
                }
                // case 2: [1, 1, x,x,x, 3, 3]
                // step 1: move left, rightmost position of the duplicate group
                int leftCount = 1;
                while (array[left + 1] == array[left]) {
                    leftCount++;
                    left++;
                }
                // step 2: move right, leftmost position of the duplicate group
                int rightCount = 1;
                while (array[right - 1] == array[right]) {
                    rightCount++;
                    right--;
                }
                count += leftCount * rightCount;
                left++;
                right--;
            } else if (sum < target) left++;
            else right--;
        }
        return count;
    }
}