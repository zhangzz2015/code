class ThreeSum {
public:
	vector<vector<int>> threeSum(vector<int>& nums) {
		vector<vector<int>> res;
		if (nums.size() == 0) 
			return res;
		sort(nums.begin(), nums.end());
		for (int k = 2; k < nums.size(); k++) {
			while (k + 1 < nums.size() && nums[k] == nums[k + 1]) {
				k++;
			}
			int i = 0;
			int j = k - 1;
			while (i < j) {
				int sum = nums[i] + nums[j] + nums[k];
				if (sum == 0) {
					res.push_back({nums[i], nums[j], nums[k]});
					while (j > i && nums[j] == nums[j - 1]) {
						j--;
					}
					j--;
				} else if (sum < 0) {
					i++;
				} else {
					j--;
				}
			}
		}
		return res;
	}
};
