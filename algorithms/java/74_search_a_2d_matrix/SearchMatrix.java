class SearchMatrix {

    // solution 1
    public boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        int right = rows * cols - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int x = mid / cols;
            int y = mid % cols;
            if (matrix[x][y] == target) return true;
            else if (matrix[x][y] < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }

    // solution 2
    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int i = 0;
        int j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) { // i, j must be in the matrix
            if (matrix[i][j] == target) return true;
            else if (matrix[i][j] < target) i++;
            else j--;
        }
        // !!! important implementation detail: terminate condition
        // i == matrix.length || j == -1
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        int target1 = 3; // true
        int target2 = 24; // false
        SearchMatrix searchMatrix = new SearchMatrix();
        System.out.println(searchMatrix.searchMatrix1(matrix, target1));
        System.out.println(searchMatrix.searchMatrix1(matrix, target2));
        System.out.println(searchMatrix.searchMatrix2(matrix, target1));
        System.out.println(searchMatrix.searchMatrix2(matrix, target2));
    }
}