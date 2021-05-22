class MaxSubarray {
public:
	int maxSubArray(vector<int>& nums) {
		int sum = nums[0], res = nums[0];
		for (int i = 1; i < nums.size(); ++i) {
			sum = max(nums[i], sum + nums[i]);
			res = max(res, sum);
		}
		return res;
	}
};
