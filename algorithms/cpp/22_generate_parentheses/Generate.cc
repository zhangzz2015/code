class Generate {
public:
	vector<string> generateParenthesis(int n) {
		vector<string> res;
		dfs(res, n, n, "");
		return res;
	}
private:
	void dfs(vector<string>& res, int left_remain, int right_remain, string current) {
		if (left == 0 && right == 0) {
			res.push_back(current);
			return;
		}
		if (left_remain > 0) {
			dfs(res, left_remain - 1, right_remain, current + "(");
		}
		if (right_remain > left_remain) {
			dfs(res, left_remain, right_remain - 1, current + ")");
		}
	}
};
