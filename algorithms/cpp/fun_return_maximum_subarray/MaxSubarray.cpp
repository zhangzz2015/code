class MaxSubarray {
public:
	vector<int> maxSubArray(vector<int>& nums) {
		vector<int> dp(nums.size(), INT_MIN);
		int start = 0, start_res = 0, end_res = 0, max_sum = nums[0];
		dp[0] = nums[0];
		for (int i = 1; i < nums.size(); i++) {
			if (dp[i - 1] >= 0) {
				dp[i] = dp[i - 1] + nums[i];
			} else {
				dp[i] = nums[i];
				start = i;
			}
			if (dp[i] >= max_sum) {
				start_res = start;
				end_res = i;
				max_sum = dp[i];
			}
		}
		return {start_res, end_res};
	}

	// space optimize
	vector<int> maxSubArrayOptimize(vector<int>& nums) {
		int prev_sum = nums[0], start = 0, max_sum = nums[0];
		vector<int> res(2, 0);
		for (int i = 1; i < nums.size(); ++i) {
			if (prev_sum >= 0) {
				prev_sum += nums[i];
			} else {
				prev_sum = nums[i];
				start = i;
			}
			if (prev_sum >= max_sum) {
				res[0] = start;
				res[1] = i;
				max_sum = prev_sum;
			}
		}
		return res;
	}
};
