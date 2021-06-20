class Combinations {
public:
	// 1.
	vector<vector<int>> combine1(int n, int k) {
        vector<vector<int>> res;
        vector<int> cur;
        dfs1(res, cur, n, k);
        return res;
    }
    void dfs1(vector<vector<int>>& res, vector<int>& cur, int n, int k) {
        if (cur.size() == k) {
            res.push_back(cur);
            return;
        }
        if (n == 0) {
            return;
        }
        dfs1(res, cur, n - 1, k);
        cur.push_back(n);
        dfs1(res, cur, n - 1, k);
        cur.pop_back();
    }

	// 2.
	vector<vector<int>> combine2(int n, int k) {
        vector<vector<int>> res;
        vector<int> cur;
        dfs2(res, cur, n, k, 1);
        return res;
    }
    void dfs2(vector<vector<int>>& res, vector<int>& cur, int n, int k, int index) {
        if (cur.size() == k) {
            res.push_back(cur);
            return;
        }
        for (int i = index; i <= n; ++i) {
            cur.push_back(i);
            dfs2(res, cur, n, k, i + 1);
            cur.pop_back();
        }
    }
};
