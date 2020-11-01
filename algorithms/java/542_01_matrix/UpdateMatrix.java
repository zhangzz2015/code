class UpdateMatrix {
	static class Cell {
		int x;
		int y;
		Cell(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	private static final int[][] DIRS = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	public int[][] updateMatrix(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return matrix;
		int m = matrix.length;
		int n = matrix[0].length;
		boolean[][] visited = new boolean[m][n];
		Queue<Cell> queue = new ArrayDeque<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					queue.offer(new Cell(i, j));
					visited[i][j] = true;
				}
			}
		}
		int level = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Cell cur = queue.poll();
				for (int[] dir : DIRS) {
					int neiX = cur.x + dir[0];
					int neiY = cur.y + dir[1];
					if (isValid(matrix, neiX, neiY) && !visited[neiX][neiY] && matrix[neiX][neiY] == 1) {
						matrix[neiX][neiY] = level + 1;
						visited[neiX][neiY] = true;
						queue.offer(new Cell(neiX, neiY));
					}
				}
			}
			level++;
		}
		return matrix;
	}
	private boolean isValid(int[][] matrix, int i, int j) {
		return i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length;
	}
}
