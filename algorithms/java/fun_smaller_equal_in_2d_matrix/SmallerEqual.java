class SmallerEqual {
    public boolean find(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int i = 0;
        int j = matrix[0].length - 1;
        int count = 0;
        while (i < matrix.length && j >= 0) { // i, j must be in the matrix
            if (matrix[i][j] > target) j--; // still on the current row finding the rightmost j
            else { // on the current row first time meet the rightmost j, matrix[i][j] <= target
                i++; // go to the next row
                count += j + 1; // count the numbers
            }
        }
        // !!! important implementation detail: terminate condition
        // i == matrix.length || j == -1
        return count;
    }
}