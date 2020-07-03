public class LargestSquareSum {
    public int findMaxSum(int[][] matrix) {
        int result = Integer.MIN_VALUE;
        int n = matrix.length;
        for (int i = 0; i < n; i++) { // upper row
            int[] prefixSum = new int[n];
            for (int j = i; j < n; j++) { // lower row
                for (int index = 0; index < n; index++) {
                    prefixSum[index] += matrix[j][index];
                }
                int fixedSize = j - i + 1;
                int maxSum = findMax(prefixSum, fixedSize);
                result = Math.max(result, maxSum);
            }
        }
        return result;
    }

    private int findMax(int[] array, int size) {
        int result = Integer.MIN_VALUE;
        int curSum = 0;
        for (int i = 0; i < array.length; i++) {
            curSum += array[i];
            if (i >= size) {
                curSum -= array[i - size];
                result = Math.max(result, curSum);
            }
        }
        return Math.max(result, curSum);
    }

    public static void main(String[] args) {
        LargestSquareSum largestSquareSum = new LargestSquareSum();
        int[][] m1 = {{1}}; // expect 1
        System.out.println(largestSquareSum.findMaxSum(m1));
        int[][] m2 = {{1, 1}, {1, 1}}; // expect 4
        System.out.println(largestSquareSum.findMaxSum(m2));
        int[][] m3 = {{1, 2}, {-2, 1}}; // expect 2
        System.out.println(largestSquareSum.findMaxSum(m3));
        int[][] m4 = {{2,3,-4,1}, {-5,1,2,-2}, {3,2,0,-3}, {-1,5,2,1}}; // expect 9
        System.out.println(largestSquareSum.findMaxSum(m4));
    }
}