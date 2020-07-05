public class Larger {

    // solution 1
    public boolean find1(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int i = 0;
        int j = matrix[0].length - 1;
        int count = 0;
        while (i < matrix.length && j >= 0) { // i,j must be in the matrix
            if (matrix[i][j] > target) {
                j--;
            } else { // 走到了该走的位置了， rightmost j for current i
                i++; // 换行的时候
                count += matrix[i].length - (j + 1);
            }
        }
        // !!! important implementation detail: terminate condition?
        // i == matrix.length || j == -1
        count += matrix[0].length * (matrix.length - i);
        return count;
        }
    
    // solution 2
    public boolean find2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
	    int i = 0;
	    int j = matrix[0].length - 1;
	    int count = 0;
	    while (i < matrix.length && j >= 0) { // i,j must be in the matrix
	        if (matrix[i][j] > target) {
	            j--;
	            count += matrix.length - i;
            } else {
	            i++;
            }
        }
        // !!! important implementation detail: terminate condition?
        // i == matrix.length || j == -1
        return count;
        }
}