class Longest {
public:
	int lengthOfLongestSubstring(string s) {
		unordered_set<char> set;
		int longest = 0;
		int slow = 0;
		for (int fast = 0; fast < s.size(); fast++) {
			if (set.find(s[fast]) != set.end()) {
				// found s[fast]
				while (slow < fast && s[slow] != s[fast]) {
					set.erase(s[slow++]);
				}
				slow++;
			} else {
				set.insert(s[fast]);
			}
			longest = max(longest, fast - slow + 1);
		}
		return longest;
	}

	// time: O(n) space: O(1)
	int length_of_longest_substring(string s) {
		const int ASCII_MAX = 255;
		int last[ASCII_MAX]; // index of the last character that appeared
		fill(last, last + ASCII_MAX, -1);
		int start = 0;
		int max_len = 0;
		for (int i = 0; i < s.size(); i++) {
			if (last[s[i]] >= start) {
				max_len = max(i - start, max_len);
				start = last[s[i]] + 1;
			}
			last[s[i]] = i;
		}
		return max((int)s.size() - start, max_len);
	}
};
