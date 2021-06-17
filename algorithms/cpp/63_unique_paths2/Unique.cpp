class Unique {
public:
	// un-optimized
	int uniquePathsWithObstacles(vector<vector<int>>& obstacle_grid) {
		if (obstacle_grid[0][0] == 1) {
			return 0;
		}
		int m = obstacle_grid.size(), n = obstacle_grid[0].size();
        vector<vector<int>> dp(m, vector<int>(n));
        dp[0][0] = 1;
        for (int i = 1; i < m; i++) {
            dp[i][0] = (dp[i - 1][0] == 1 && obstacle_grid[i][0] == 0) ? 1 : 0;    
        } 
        for (int j = 1; j < n; j++) {
            dp[0][j] = (dp[0][j - 1] == 1 && obstacle_grid[0][j] == 0) ? 1 : 0;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacle_grid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }
        return dp[m - 1][n - 1];
	}

	// optimized
	int unique_paths_with_obstacles(vector<vector<int>>& obstacle_grid) {
		if (obstacle_grid[0][0] == 1) {
            return 0;
        }
        int m = obstacle_grid.size(), n = obstacle_grid[0].size();
        vector<int> dp(n);
        dp[0] = 1;
        for (int j = 1; j < n; j++) {
            dp[j] = (dp[j - 1] == 1 && obstacle_grid[0][j] == 0) ? 1 : 0;
        }
        for (int i = 1; i < m; i++) {
            if (obstacle_grid[i][0] == 1) {
                dp[0] = 0;
            }
            for (int j = 1; j < n; j++) {
                if (obstacle_grid[i][j] == 1) {
                    dp[j] = 0;
                } else {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[n - 1];
	}
};
