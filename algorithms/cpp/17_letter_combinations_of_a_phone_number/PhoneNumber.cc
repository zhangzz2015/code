class PhoneNumber {
// 1. iterative
public:
	vector<string> letterCombinations(string digits) {
        if (digits.empty()) {
            return {};
        }
        vector<string> res;
        res.push_back("");
        
        for (char digit : digits) {
            vector<string> tmp;
            for (char c : book[digit - '0']) {
                for (string s : res) {
                    tmp.push_back(s + c);
                }
            }
            res.swap(tmp);
        }
        return res;
    }
private:
	const vector<string> book = {
        "", "", "abc", "def",
         "ghi", "jkl", "mno",
        "pqrs", "tuv", "wxyz"
    };

// 2. backtracking
public:
    vector<string> letterCombinations1(string digits) {
        if (digits.empty()) {
            return {};
        }
        vector<string> res;
        dfs(digits, "", res, 0);
        return res;
    }
private:
    void dfs(string& digits, string path, vector<string>& res, int index) {
        if (index == digits.size()) {
            res.push_back(path);
            return;
        }
        int cur = digits[index] - '0';
        for (char c : book[cur]) {
            dfs(digits, path + c, res, index + 1);
        }
    }
    const vector<string> book = {
        "", "", "abc", "def",
         "ghi", "jkl", "mno",
        "pqrs", "tuv", "wxyz"
    };
};
