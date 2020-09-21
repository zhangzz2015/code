class TwoSum {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> map;
        vector<int> res;
        for (int i = 0; i < nums.size(); i++) {
            if (map.find(target - nums[i]) == map.end()) {
                map[nums[i]] = i;
            } else {
                res.push_back(map[target - nums[i]]);
                res.push_back(i);
                return res;
            }
        }
        return res;
    }
};
