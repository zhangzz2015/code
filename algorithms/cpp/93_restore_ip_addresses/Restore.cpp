class Restore {
public:
	vector<string> restoreIpAddresses(string s) {
        vector<string> res;
        string cur = string("");
        dfs(res, cur, s, 0, 0);
        return res;
    }
private:
	void dfs(vector<string>& res, string cur, string& s, int index, int parts) {
        if (index == s.size()) {
            if (parts == 4) {
                cur.pop_back();
                res.push_back(cur);
            }
            return;
        }
        if (parts == 4) {
            return;
        }
        int count = 0;
        for (int i = index; i < min(index + 3, (int)s.size()); ++i) {
            count = count * 10 + (s[i] - '0');
            if (count <= 255) {
                cur += s[i];
                dfs(res, cur + '.', s, i + 1, parts + 1);
            }
            if (count == 0 && i == index) break;
        }
    }
};
