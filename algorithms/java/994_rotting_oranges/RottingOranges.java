class RottingOranges {
	private static final int[][] DIRS = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int orangesRotting(int[][] grid) {
        Queue<Cell> queue = new ArrayDeque<>();
        int m = grid.length, n = grid[0].length;
        int fresh = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new Cell(i, j));
                }
                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        if (fresh == 0) {
            return 0;
        }
        int time = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Cell cur = queue.poll();
                for (int[] dir : DIRS) {
                    int neiX = cur.row + dir[0];
                    int neiY = cur.col + dir[1];
                    if (isValid(grid, neiX, neiY) && grid[neiX][neiY] == 1) {
                        fresh--;
                        grid[neiX][neiY] = 2;
                        queue.offer(new Cell(neiX, neiY));
                    }
                }
            }
            time++;
        }
        if (fresh != 0) {
            return -1;
        }
        return time - 1;
    }
    
    private boolean isValid(int[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }
    static class Cell {
        int row, col;
        Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
