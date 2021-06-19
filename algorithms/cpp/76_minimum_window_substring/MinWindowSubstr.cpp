class MinWindowSubstr {
public:
	string minWindow(string s, string t) {
        unordered_map<char, int> freq;
        for (int i = 0; i < t.size(); ++i) {
            freq[t[i]] += 1;
        }
        int slow = 0, start = -1, shortest = INT_MAX, match = 0;
        for (int fast = 0; fast < s.size(); ++fast) {
            char cur = s[fast];
            if (freq.find(cur) != freq.end()) {
                if (freq[cur] == 1) {
                    match++;
                }
                freq[cur]--;
            }
            while (match == freq.size()) {
                if (shortest > fast - slow + 1) {
                    shortest = fast - slow + 1;
                    start = slow;
                }
                cur = s[slow];
                if (freq.find(cur) != freq.end()) {
                    if (freq[cur] == 0) {
                        match--;
                    }
                    freq[cur]++;
                }
                slow++;
            }
        }
        return shortest == INT_MAX ? "" : s.substr(start, shortest);
};
