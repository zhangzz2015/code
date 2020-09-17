public class NumberOfPairSmallerOrEqualToTarget {
    public int  numberOfPairSmallerOrEqualToTarget(int[] arr, int target) {
        if (arr == null) return 0;
        int left = 0;
        int right = arr.length - 1;
        int res = 0;
        while (left < right) {
            while (arr[left] + arr[right] <= target) {
                left++;
            }
            res += left;
            right--;
        }
        // sum of any pair from index [0, index] <= target.
        // c(n, 2) = n *  (n - 1) / 2
        res += (right + 1) * right / 2;
        return res;
    }
}
