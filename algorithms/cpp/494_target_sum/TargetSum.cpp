class TargetSum {
public:
	// 1. dp
	int findTargetSumWays1(vector<int>& nums, int S) {
		int n = nums.size();
        int sum = accumulate(nums.begin(), nums.end(), 0);
        if (sum < S) return 0;
        vector<vector<int>> dp(n + 1, vector<int>(2 * sum + 1, 0));
        dp[0][sum] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = nums[i]; j < 2 * sum + 1 - nums[i]; j++) {
                if (dp[i][j] != 0) {
                    dp[i + 1][j + nums[i]] += dp[i][j];
                    dp[i + 1][j - nums[i]] += dp[i][j];
                }
            }
        }
        return dp[n][S + sum];
	}

	// 2. knapsack
	int findTargetSumWays2(vector<int>& nums, int S) {
		int sum = accumulate(nums.begin(), nums.end(), 0);
		if (sum < S || (S + sum) % 2 == 1) {
			return 0;
		}
		int target = (S + sum) / 2;
		vector<int> dp(target + 1, 0);
		dp[0] = 1;
		for (int i = 0; i < nums.size(); i++) {
			for (int j = target; j >= nums[i]; j--) {
				dp[j] += dp[j - nums[i]];
			}
		}
		return dp[target];
	} 
};
