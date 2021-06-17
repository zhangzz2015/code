class Unique {
public:
	// non-optimized
	int uniquePaths(int m, int n) {
		vector<vector<int>> dp(m + 1, vector<int>(n + 1));
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) {
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m][n];
	}

	// space optimized
	int unique_paths_optimized(int m, int n) {
		vector<int> dp(n + 1);
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) {
                    dp[i] = 1;
                    continue;
                }
                dp[j] += dp[j - 1];
            }
        }
        return dp[n];
	}
};
