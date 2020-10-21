class MaxArea {
	// dfs
	private static final int[][] DIRS = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	public int maxArea1(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;
		int m = grid.length;
		int n = grid[0].length;
		boolean[][] visited = new boolean[m][n];
		int max = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j] && grid[i][j] == 1) {
					max = Math.max(max, dfs(grid, i, j, visited));
				}
			}
		}
		return max;
	}
	private int dfs(int[][] grid, int i, int j, boolean[][] visited) {
		if (visited[i][j]) return 0;
		visited[i][j] = true;
		int count = 1;
		for (int[] dir : DIRS) {
			int neiX = i + dir[0];
			int neiY = j + dir[1];
			if (isValid(grid, neiX, neiY) && grid[neiX][neiY] == 1) {
				count += dfs(grid, neiX, neiY, visited);
			}
		}
		return count;
	}
	private boolean isValid(int[][] grid, int i, int j) {
		return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
	}


	// bfs
	static class Cell {
		int row;
		int col;
		Cell(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	private int bfs(int[][] grid, int i, int j, boolean[][] visited) {
		Queue<Cell> queue = new ArrayDeque<>();
		queue.offer(new Cell(i, j));
		visited[i][j] = true;
		int count = 1;
		while (!queue.isEmpty()) {
			Cell cur = queue.poll();
			for (int[] dir : DIRS) {
				int neiX = cur.row + dir[0];
				int neiY = cur.col + dir[1];
				if (isValid(grid, neiX, neiY) && !visited[neiX][neiY] && grid[neiX][neiY] == 1) {
					count++;
					visited[neiX][neiY] = true;
					queue.offer(new Cell(neiX, neiY));
				}
			}
		}
		return count;
	}
}
