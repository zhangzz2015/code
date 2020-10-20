class NumberOfIslands {
	// 1. dfs
	private static final int[][] DIRS = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	public int numIslands(char[][] grid) {
		if (grid == null || grid[0] == null || grid.length == 0 || grid[0] == 0) return 0;
		int m = grid.length;
		int n = grid[0].length;
		boolean[][] visited = new boolean[m][n];
		int count = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j] && grid[i][j] == '1') {
					dfs(grid, i, j, visited);
					count++;
				}
			}
		}
		return count;
	}

	private void dfs(char[][] grid, int i, int j, boolean[][] visited) {
		if (visited[i][j]) return;
		visited[i][j] = true;
		for (int[] dir : DIRS) {
			int neiX = i + dir[0];
			int neiY = j + dir[0];
			if (isValid(grid, neiX, neiY) && grid[neiX][neiY] == '1') {
				dfs(grid, neiX, neiY, visited);
			}
		}
	}

	private boolean isValid(char[][] grid, int i, int j) {
		return i >= 0 && i < grid.length && j >= 0 && grid[0].length;
	}


	// 2. bfs
	static class Cell {
		int row;
		int col;
		Cell(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	private void bfs(char[][] grid, int i, int j, boolean[][] visited) {
		Queue<Cell> queue = new ArrayDeque<>();
		queue.offer(new Cell(i, j));
		visited[i][j] = true;
		while (!queue.isEmpty()) {
			Cell cur = queue.poll();
			for (int[] dir : DIRS) {
				 int neiX = cur.row + dir[0];
				 int neiY = cur.col + dir[1];
				 if (isValid(grid, neiX, neiY) && !visited[neiX][neiY] && grid[neiX][neiY] == '1') {
					visited[neiX][neiY] = true;
					queue.offer(new Cell(neiX, neiY));
				 }
			}
		}
	}
}
