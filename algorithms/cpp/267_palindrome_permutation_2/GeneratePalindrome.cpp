class GeneratePalindrome {
// 1. using array as map
public:
	vector<string> generatePalindromes(string s) {
		int count[256] = {0};
		int oddCount = 0;
		for (char c : s) {
			count[c]++;
		}
		for (int i = 0; i < 256; i++) {
			if (count[i] % 2 == 1) {
				oddCount++;
			}
			if (oddCount > 1) {
				return vector<string>();
			}
		}
		string res(s.size(), ' ');
		vector<string> ret;
		dfs(count, 0, s.size() - 1, res, ret);
		return ret;
	}
private:
	void dfs(int count[], int l, int r, string& res, vector<string>& ret) {
		if (l > r) {
			ret.push_back(res);
			return;
		}
		for (int i = 0; i < 256; i++) {
			if (l < r && count[i] < 2) continue;
			if (l == r && count[i] == 0) continue;
			res[l] = res[r] = i;
			count[i] -= 2;
			dfs(count, l + 1, r - 1, res, ret);
			count[i] += 2;
		}
	}

// 2. using map
public:
	vector<string> generatePalindromes1(string s) {
        unordered_map<char, int> count;
        int oddCount = 0;
        for (char c : s) {
            count[c]++;
        }
        for (auto it : count) {
            if (it.second % 2 == 1) {
                oddCount++;
            }
            if (oddCount > 1) {
                return vector<string>();
            }
        }
        string res(s.size(), ' ');
        vector<string> ret;
        dfs1(count, 0, s.size() - 1, res, ret);
        return ret;
    }

private:
    void dfs1(unordered_map<char, int> count, int l, int r, string& res, vector<string>& ret) {
        if (l > r) {
            ret.push_back(res);
            return;
        }
        for (auto it = count.begin(); it != count.end(); it++) {
            if (l < r && it->second < 2) continue;
            if (l == r && it->second == 0) continue;
            res[l] = res[r] = it->first;
            it->second -= 2;
            dfs1(count, l + 1, r - 1, res, ret);
            it->second += 2;
        }
    }
};
