public class MaxSubarray {
    public int maxSubarray(int[] array) {
        int res = array[0];
        int cur = array[0];
        for (int i = 1; i < array.length; i++) {
            cur =  Math.max(cur + array[i], array[i]);
            res = Math.max(res, cur);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] input = {-2, 1, -3, 4, -1, 2, 1, -5, 4}; // output 6 [4, -1, 2, 1]
        MaxSubarray solution = new MaxSubarray();
        System.out.println(solution.maxSubarray(input));
    }
}