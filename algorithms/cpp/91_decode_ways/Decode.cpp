class Decode {
public:
	int numDecodings(string s) {
		vector<int> dp(s.size() + 1);
		dp[0] = 1;
		dp[1] = s[0] == '0' ? 0 : 1;
		for (int i = 2; i < dp.size(); ++i) {
			if (s[i - 1] >= '1') {
				dp[i] = dp[i - 1];
			}
			if (s[i - 2] == '1' || (s[i - 2] == '2' && s[i - 1] < '7')) {
				dp[i] += dp[i - 2];
			}
		}
		return dp[dp.size() - 1];
	}

	int num_decodings_optimized(string s) {
		int two_before = 1, one_before = s[0] == '0' ? 0 : 1;
		for (int i = 2; i <= s.size(); ++i) {
			int cur = 0;
			if (s[i - 1] >= '1') {
				cur = one_before;
			}
			if (s[i - 2] == '1' || (s[i - 2] == '2' && s[i - 1] < '7')) {
				cur += two_before;
			}
			two_before = one_before, one_before = cur;
		}
		return one_before;
	}
};
