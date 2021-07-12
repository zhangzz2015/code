class DisSubsequences {
public:
	// not optimized
	int numDistinct(string s, string t) {
        int m = s.size(), n = t.size();
        if (m < n)
            return 0;
        vector<vector<uint64_t>> dp(m + 1, vector<uint64_t>(n + 1, 0));
        for (int i = 0; i <= m; ++i) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                dp[i][j] = dp[i - 1][j];
                if (s[i - 1] == t[j - 1])
                    dp[i][j] += dp[i - 1][j - 1];
            }
        }
        return dp[m][n];
    }
	
	// optimized
	int numDistinct_optimize(string s, string t) {
        int m = s.size(), n = t.size();
        if (m < n)
            return 0;
        vector<uint64_t> dp(n + 1, 0);
        dp[0] = 1;
        for (int i = 1; i <= m; ++i) {
            for (int j = n; j >= 1; --j) {
                if (s[i - 1] == t[j - 1])
                    dp[j] += dp[j - 1];
            }
        }
        return dp[n];
    }
};
