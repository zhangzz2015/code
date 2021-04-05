class CrossBridge {
public:
	int findShortestTime(vector<int> time) {
		sort(time.begin(), time.end());
		vector<int> dp(time.size());
		for (int i = 0; i < dp.size(); i++) {
			if (i <= 1) {
				dp[i] = time[i];
			} else {
				dp[i] = min(dp[i - 1] + time[0] + time[i], dp[i - 2] + time[0] + time[i] + 2 * time[1]);
			}
		}
		return dp[dp.size() - 1];
	}
};
