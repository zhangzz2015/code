class FloodFill {
	private static final int[][] DIRS = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	private boolean isValid(int[][] image, int i, int j) {
		return i >= 0 && i < image.length && j >= 0 && j < image[0].length;
	}

	// dfs
	public int[][] floodFill1(int[][] image, int sr, int sc, int newColor) {
		if (image == null || image.length == 0 || image[0].length == 0 || image[sr][sc] == newColor) return image;
		dfs(image, sr, sc, image[sr][sc], newColor);
		return image;
	}
	private void dfs(int[][] image, int i, int j, int oldColor, int newColor) {
		image[i][j] = newColor;
		for (int[] dir : DIRS) {
			int neiX = i + dir[0];
			int neiY = j + dir[1];
			if (isValid(image, neiX, neiY) && image[neiX][neiY] == oldColor) {
				dfs(image, neiX, neiY, oldColor, newColor);
			}
		}
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
	public int[][] floodFill2(int[][] image, int sr, int sc, int newColor) {
		if (image == null || image.length == 0 || image[0].length == 0 || image[sr][sc] == newColor) return image;
		Queue<Cell> queue = new ArrayDeque<>();
		int oldColor = image[sr][sc];
		queue.offer(new Cell(sr, sc));
		image[sr][sc] = newColor;
		while (!queue.isEmpty()) {
			Cell cur = queue.poll();
			for (int[] dir : DIRS) {
				int neiX = cur.row + dir[0];
				int neiY = cur.col + dir[1];
				if (isValid(image, neiX, neiY) && image[neiX][neiY] == oldColor) {
					queue.offer(new Cell(neiX, neiY);
					image[neiX][neiY] = newColor;
				}
			}
		}
		return image;
	}
}