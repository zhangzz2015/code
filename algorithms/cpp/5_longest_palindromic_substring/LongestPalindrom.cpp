class LongestPalindrom {
public:
	// time: O(n^2) space: O(n^2)
	string longestPalindrome(string s) {
        int n = s.size();
        vector<vector<bool>> dp(n, vector<bool> (n, false));
        int start = 0;
        int longest = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = s[i] == s[j] && (i == j - 1 || dp[i + 1][j - 1]);
                }
                if (dp[i][j] && j - i + 1 > longest) {
                    longest = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substr(start, longest);
    }

	// time: O(n^2) space: O(n)
	string longest_palindrome(string s) {
        int n = s.size();
        vector<bool> dp(n, false);
        int start = 0;
        int longest = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j > 0; j--) {
                if (i == j) {
                    dp[j] = true;
                } else {
                    dp[j] = s[i] == s[j] && (i == j - 1 || dp[j - 1]);
                }
                if (dp[j] && j - i + 1 > longest) {
                    longest = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substr(start, longest);
    }
};
