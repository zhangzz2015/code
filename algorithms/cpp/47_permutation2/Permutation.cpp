class Permutation {
public:
	vector<vector<int>> permuteUnique(vector<int>& nums) {
        vector<vector<int>> res;
        permute(res, nums, 0);
        return res;
    }
private:
	void permute(vector<vector<int>>& res, vector<int>& nums, int index) {
        if (index == nums.size()) {
            res.push_back(nums);
            return;
        }
        unordered_set<int> set;
        for (int i = index; i < nums.size(); ++i) {
            if (set.find(nums[i]) == set.end()) {
                set.insert(nums[i]);
                swap(nums[index], nums[i]);
                permute(res, nums, index + 1);
                swap(nums[index], nums[i]);
            }
        }
    } 
};
