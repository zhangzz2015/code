class ClosedIsland {
public:
	int closedIsland(vector<vector<int>>& grid) {
		int m = grid.size();
		int n = grid[0].size();
		int count = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 0) {
					bool closed = true;
					isClosed(grid, i, j, closed);
					if (closed) {
						count++;
					}
				}
			}
		}
		return count;
	}
private:
	void isClosed(vector<vector<int>>& grid, int i, int j, bool& closed) {
		if ((i == 0 || j == 0 || i == grid.size() - 1 || j == grid[0].size() - 1) && grid[i][j] == 0) {
			closed = false;
		}
		if (i == 0 || j == 0 || i == grid.size() - 1 || j == grid[0].size() - 1 || grid[i][j] == 1) {
			return;
		}
		grid[i][j] = 1;
		isClosed(grid, i + 1, j, closed);
		isClosed(grid, i - 1, j, closed);
		isClosed(grid, i, j + 1, closed);
		isClosed(grid, i, j - 1, closed);
	}
};
