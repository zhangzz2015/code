class WordSearch {
	private static final int[][] DIRS = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	public boolean exist(char[][] board, String word) {
		int m = board.length, n = board[0].length;
		boolean[][] visited = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (dfs(board, i, j, word, 0, visited)) {
					return true;
				}
			}
		}
		return false;
	}
	private boolean dfs(char[][] board, int i, int j, String word, int index, boolean[][] visited) {
		if (index == word.length()) {
			return true;
		}
		if (!isValid(board, i, j) || visited[i][j] || board[i][j] != word.charAt(index)) {
			return false;
		}
		visited[i][j] = true;
		for (int[] dir : DIRS) {
			int neiX = i + dir[0];
			int neiY = j + dir[1];
			if (dfs(board, neiX, neiY, word, index + 1, visited)) {
				return true;
			}
		}
		visited[i][j] = false;
		return false;
	}
	private boolean isValid(char[][] board, int i, int j) {
		return i >= 0 && i < board.length && j >= 0 && j < board[0].length;
	}
}
