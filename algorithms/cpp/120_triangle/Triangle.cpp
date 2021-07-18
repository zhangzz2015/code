class Triangle {
public:
	int minimumTotal(vector<vector<int>>& triangle) {
        if (triangle.size() == 1) {
            return triangle[0][0];
        }
        int m = triangle.size();
        vector<vector<int>> dp(m, vector<int>(m, 0));
        for (int i = 0; i < m; ++i) {
            dp[m - 1][i] = triangle[m - 1][i];
        }
        for (int i = m - 2; i >= 0; --i) {
            for (int j = 0; j <= i; ++j) {
                dp[i][j] = min(dp[i + 1][j + 1], dp[i + 1][j]) + triangle[i][j];
            }
        }
        return dp[0][0];
    }

	// optimized
	int minimumTotal_optimized(vector<vector<int>>& triangle) {
        if (triangle.size() == 1) {
            return triangle[0][0];
        }
        int m = triangle.size();
        vector<int> dp(m, 0);
        for (int i = 0; i < m; ++i) {
            dp[i] = triangle[m - 1][i];
        }
        for (int i = m - 2; i >= 0; --i) {
            for (int j = 0; j <= i; ++j) {
                dp[j] = min(dp[j + 1], dp[j]) + triangle[i][j];
            }
        }
        return dp[0];
    }
};
