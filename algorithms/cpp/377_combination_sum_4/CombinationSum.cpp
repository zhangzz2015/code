class CombinationSum {
	public:
		int combinationSum(vector<int>& nums, int target) {
			vector<unsigned int> dp(target + 1);
			dp[0] = 1;
			for (int i = 0; i <= target; ++i) {
				for (int n : nums) {
					if (i - n >= 0) {
						dp[i] += dp[i - n];
					}
				}
			}
			return dp[target];
		}
};

/*
We can use a unsigned int to pass the test case of:
[3,33,333]
10000
because in C++ if an unsigned int is overflow, it will round. But for int it will be an undefined behavior
*/
