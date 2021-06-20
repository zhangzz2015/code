class Subsets {
public:
	vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> res;
        vector<int> cur;
        dfs(res, cur, nums, 0);
        return res;
    }
private:
	void dfs(vector<vector<int>>& res, vector<int>& cur, vector<int>& nums, int index) {
        if (index == nums.size()) {
            res.push_back(cur);
            return;
        }
        dfs(res, cur, nums, index + 1);
        cur.push_back(nums[index]);
        dfs(res, cur, nums, index + 1);
        cur.pop_back();
    }
};
