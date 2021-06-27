class Subset {
public:
	// 1. add or not add
	vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        vector<vector<int>> res;
        sort(nums.begin(), nums.end());
        vector<int> partial;
        dfs1(nums, res, partial, 0);
        return res;
    }
    void dfs1(vector<int>& nums, vector<vector<int>>& res, vector<int>& partial, int index) {
        if (index == nums.size()) {
            res.push_back(partial);
            return;
        }
        partial.push_back(nums[index]);
        dfs1(nums, res, partial, index + 1);
        partial.pop_back();
        while (index + 1 < nums.size() && nums[index] == nums[index + 1]) {
            index++;
        }
        dfs1(nums, res, partial, index + 1);
    }
	
	// 2. combination
	vector<vector<int>> subsetsWithDup2(vector<int>& nums) {
        vector<vector<int>> res;
        sort(nums.begin(), nums.end());
        vector<int> partial;
        dfs2(nums, res, partial, 0);
        return res;
	}
	void dfs2(vector<int>& nums, vector<vector<int>>& res, vector<int>& partial, int index) {
		res.push_back(partial);
		for (int i = index; i < nums.size(); ++i) {
			if (i == index || nums[i] != nums[i - 1]) {
				partial.push_back(nums[i]);
				dfs2(nums, res, partial, i + 1);
				partial.pop_back(nums[i]);
			}
		}
	}
};
