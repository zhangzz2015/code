class CombSum {
// 1.
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<vector<int>> res;
        vector<int> combination;
        findComb(res, candidates, 0, target, combination);
        return res;
    }
private:
    void findComb(vector<vector<int>>& res, vector<int>& candidates, int index, int target, vector<int>& combination) {
        if (target == 0) {
            res.push_back(combination);
            return;
        }
        if (target < 0 || index == candidates.size()) {
            return;
        }
        int max = target / candidates[index];
        for (int i = 0; i <= max; ++i) {
            int tmp = i;
            while (tmp > 0) {
                combination.push_back(candidates[index]);
                tmp--;
            }
            findComb(res, candidates, index + 1, target - i * candidates[index], combination);
            while (tmp < i) {
                combination.pop_back();
                tmp++;
            }
        }

// 2. 
public:
	vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        vector<vector<int>> res;
        vector<int> combination;
        findComb2(res, candidates, 0, target, combination);
        return res;
    }
private:
    void findComb2(vector<vector<int>>& res, vector<int>& candidates, int index, int target, vector<int>& combination) {
        if (target == 0) {
            res.push_back(combination);
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = index; i < candidates.size(); ++i) {
            combination.push_back(candidates[i]);
            findComb2(res, candidates, i, target - candidates[i], combination);
            combination.pop_back();
        }
    }
};
