class Valid {
public:
	// use a stack
	int longestValidParentheses(string s) {
		stack<int> stack;
		int start = 0, longest = 0;
		for (int end = 0; end < s.size(); end++) {
			if (s[end] == '(') {
				stack.push(end);
			} else {
				// s[end] == ')'
				if (stack.empty()) {
					start = end + 1;
				} else {
					stack.pop();
					longest = stack.empty() ? max(longest, end - start + 1) : max(longest, end - stack.top());
				}
			}
		}
		return longest;
	}

	// dp
	int longestValidParenthesesDP(string s) {
		if (size() == 0) {
			return 0;
		}
		vector<int> dp(s.size() + 1, 0);
		int count = 0, longest = 0;
		for (int i = 1; i <= s.size(); i++) {
			if (s[i - 1] == '(') {
				count++;
			} else {
				// s[i - 1] == ')'
				count--;
				dp[i] = 2;
				if (s[i - 1] == ')') {
					// add former closed ')'
					dp[i] += dp[i - 1];
				}
				// add previous valid substring
				dp[i] += dp[i - dp[i]];
				longest = max(longest, dp[i]);
			}
		}
		return longest;
	}
};
