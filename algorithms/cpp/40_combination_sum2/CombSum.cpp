class CombSum {
public:
	// 1.
	vector<vector<int>> combinationSum1(vector<int>& candidates, int target) {
        vector<vector<int>> res;
        sort(candidates.begin(), candidates.end());
        vector<int> cur;
        comb1(candidates, target, res, cur, 0);
        return res;
    }
    void comb1(vector<int>& candidates, int target, vector<vector<int>>& res, vector<int> cur, int index) {
        if (target == 0) {
            res.push_back(cur);
            return;
        }
        if (target < 0 || index == candidates.size()) {
            return;
        }
        cur.push_back(candidates[index]);
        comb1(candidates, target - candidates[index], res, cur, index + 1);
        cur.pop_back();
        while (index < candidates.size() - 1 && candidates[index] == candidates[index + 1]) {
            index++;
        }
        comb1(candidates, target, res, cur, index + 1);
    }

	// 2.
	vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        vector<vector<int>> res;
        sort(candidates.begin(), candidates.end());
        vector<int> cur;
        comb2(candidates, target, res, cur, 0);
        return res;
    }
    void comb2(vector<int>& candidates, int target, vector<vector<int>>& res, vector<int> cur, int index) {
        if (target == 0) {
            res.push_back(cur);
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = index; i < candidates.size(); i++) {
            cur.push_back(candidates[i]);
            comb2(candidates, target - candidates[i], res, cur, i + 1);
            cur.pop_back();
            while (i < candidates.size() - 1 && candidates[i] == candidates[i + 1]) {
                i++;
            }
        }
    }
};
