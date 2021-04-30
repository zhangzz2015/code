class ThreeSumClosest {
public:
	int threeSumClosest(vector<int>& nums, int target) {
		sort(nums.begin(), nums.end());
		int res = nums[0] + nums[1] + nums[nums.size() - 1];
		for (int k = 2; k < nums.size(); k++) {
			int i = 0, j = k - 1;
			while (i < j) {
				int sum = nums[i] + nums[j] + nums[k];
				if (sum == target) {
					return sum;
				}
				if (abs(sum - target) < abs(res - target)) {
					res = sum;
				}
				if (sum < target) {
					i++;
				} else {
					j--;
				}
			}
		}
		return res;
	}
};
