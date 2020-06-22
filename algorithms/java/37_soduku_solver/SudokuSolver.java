public class SudokuSolver {
    // board size
    static final int ROW_LEN = 9;
    static final int COL_LEN = 9;
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            throw new IllegalArgumentException("Input is empty");
        }
        boolean[][] rowVisited = new boolean[ROW_LEN][COL_LEN + 1];
        boolean[][] colVisited = new boolean[ROW_LEN][COL_LEN + 1];
        boolean[][] blockVisited = new boolean[ROW_LEN][COL_LEN + 1];
        initialize(board, rowVisited, colVisited, blockVisited);
        fillOutSudoku(board, 0, rowVisited, colVisited, blockVisited);
    }
  
    private boolean fillOutSudoku(char[][] board, int position, boolean[][] rowVisited, boolean[][] colVisited,
                                  boolean[][] blockVisited) {
        if (position == 81) return true;
        int row = position / COL_LEN;
        int col = position % COL_LEN;
        if (board[row][col] == '.') {
            for (int num = 1; num <= 9; num++) {
                if (canFill(row, col, num, rowVisited, colVisited, blockVisited)) {
                    System.out.println("[" + row + ", " + col + ", " + position + "]" + "num = " + (char) (num + '0'));
                    board[row][col] = (char) (num + '0');
                    updateVisitedStatus(num, row, col, rowVisited, colVisited, blockVisited, /* isMarkVisited= */true);
                    if (fillOutSudoku(board, position + 1, rowVisited, colVisited, blockVisited)) {
                        return true;
                    }
                    board[row][col] = '.';
                    updateVisitedStatus(num, row, col, rowVisited, colVisited, blockVisited, /* isMarkVisited= */false);
                }
            }
        } else if (fillOutSudoku(board, position + 1, rowVisited, colVisited, blockVisited)) {
            return true;
        }
        return false;
    }
  
    private void updateVisitedStatus(int num, int row, int col, boolean[][] rowVisited, boolean[][] colVisited, boolean[][] blockVisited, boolean isMarkVisited) {
        rowVisited[row][num] = isMarkVisited;
        colVisited[col][num] = isMarkVisited;
        // The block position is row / 3 + col.
        blockVisited[row / 3  * 3 + col / 3][num] = isMarkVisited;
    }
  
    private boolean canFill(int row, int col, int num, boolean[][] rowVisited, boolean[][] colVisited, boolean[][] blockVisited) {
        if (rowVisited[row][num]) {
            return false;
        }
        if (colVisited[col][num]) {
            return false;
        }
        // The block position is row / 3  * 3 + col / 3.
        if (blockVisited[row / 3  * 3 + col / 3][num]) {
            return false;
        }
        return true;
    }
  
    private void initialize(char[][] board, boolean[][] rowVisited, boolean[][] colVisited, boolean[][] blockVisited) {
        for (int row = 0; row < ROW_LEN; row++) {
            for (int col = 0; col < COL_LEN; col++) {
                if (board[row][col] != '.') {
                    if (!Character.isDigit(board[row][col])) {
                        throw new IllegalArgumentException("The character should be digit, but it is " + board[row][col]);
                    }
                    int num = board[row][col] - '0';
                    rowVisited[row][num] = true;
                    colVisited[col][num] = true;
                    // The block position is row / 3  * 3 + col / 3.
                    blockVisited[row / 3  * 3 + col / 3][num] = true;
                }
            }
        }
    }
  
    public static void main(String[] args) {
        SudokuSolver sudokuSolver = new SudokuSolver();
        char[][] board =
                {
                        {'5','3','.','.','7','.','.','.','.'},
                        {'6','.','.','1','9','5','.','.','.'},
                        {'.','9','8','.','.','.','.','6','.'},
                        {'8','.','.','.','6','.','.','.','3'},
                        {'4','.','.','8','.','3','.','.','1'},
                        {'7','.','.','.','2','.','.','.','6'},
                        {'.','6','.','.','.','.','2','8','.'},
                        {'.','.','.','4','1','9','.','.','5'},
                        {'.','.','.','.','8','.','.','7','9'}};
        sudokuSolver.solveSudoku(board);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
  }