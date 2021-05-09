class FourSum {
public:
	vector<vector<int>> fourSum(vector<int>& nums, int target) {
		sort(nums.begin(), nums.end());
		vector<vector<int>> res;
		for (int l = 3; l < nums.size(); l++) {
			while (l + 1 < nums.size() && nums[l] == nums[l + 1]) {
				l++;
			}
			for (int k = 2; k < l; k++) {
				while (k + 1 < l && nums[k] == nums[k + 1]) {
					k++;
				}
				int i = 0;
				int j = k - 1;
				while (i < j) {
					int sum = nums[i] + nums[j] + nums[k] + nums[l];
					if (sum == target) {
						res.push_back({nums[i], nums[j], nums[k], nums[l]});
						while (j > i && nums[j] == nums[j - 1]) {
							j--;
						}
						j--;
					} else if (sum < target) {
						i++;
					} else {
						j--;
					}
				}
			}
		}
		return res;
	}
};
