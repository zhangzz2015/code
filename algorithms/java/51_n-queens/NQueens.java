class NQueen {
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> res = new ArrayList<>();
		if (n < 1) {
			return res;
		}
		int[] curRow = new int[n];
		boolean[] col = new boolean[n];
		boolean[] dia1 = new boolean[n * 2 - 1];
		boolean[] dia2 = new boolean[n * 2 - 1];
		dfs(n, 0, curRow, res, col, dia1, dia2);
		return res;
	}
	private void dfs(int n, int row, int[] curRow, List<List<String>> res, boolean[] col, boolean[] dia1, boolean[] dia2) {
		if (row == n) {
			res.add(parseString(curRow, n));
			return;
		}
		for (int i = 0; i < n; i++) {
			if (isValid(n, row, i, col, dia1, dia2)) {
				col[i] = true;
				dia1[i + row] = true;
				dia2[n - 1 + i - row] = true;
				curRow[row] = i;
				dfs(n, row + 1, curRow, res, col, dia1, dia2);
				col[i] = false;
				dia1[i + row] = false;
				dia2[n - 1 + i - row] = false;
			}
		}
	}
	private boolean isValid(int n, int row, int column, boolean[] col, boolean[] dia1, boolean[] dia2) {
		return !col[column] && !dia1[row + column] && !dia2[n - 1 + column -row];
	}
	private List<String> parseString(int[] curRow, int n) {
		List<String> res = new ArrayList<>();
		for (int col : curRow) {
			char[] array = new char[n];
			Arrays.fill(array, '.');
			array[col] = 'Q';		
			res.add(new String(array));
		}
		return res;
	}
}
