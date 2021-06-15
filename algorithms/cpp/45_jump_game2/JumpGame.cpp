class JumpGame {
public:
	// 1. dp
	int jump_dp(vector<int>& nums) {
		vector<int> dp(nums.size());
		dp[dp.size() - 1] = 0;
		for (int i = num.size() - 2; i >= 0; --i) {
			int maxStep = min(i + nums[i], (int)nums.size() - 1);
			dp[i] = INT_MAX;
			for (int j = i + 1; j <= maxStep; ++j) {
				if (dp[i] != INT_MAX) {
					dp[i] = min(dp[i], dp[j] + 1);
				}
			}
		}
		return dp[0];
	}

	// 2. bfs
	int jump_bfs(vector<int>& nums) {
		if (nums.size() == 0)
            return INT_MAX;
        if (nums.size() == 1)
            return 0;
        queue<int> queue;
        vector<bool> visited(nums.size());
        queue.push(0);
        visited[0] = true;
        int steps = 0;
        while (!queue.empty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                int cur_index = queue.front();
                queue.pop();
                for (int j = min(cur_index + nums[cur_index], (int)nums.size() - 1); j >= cur_index; --j) {
                    if (j == nums.size() - 1)
                        return steps + 1;
                    if (!visited[j]) {
                        queue.push(j);
                        visited[j] = true;
                    }
                }
            }
            ++steps;
        }
        return INT_MAX;
	}
};
