class Solution {
public:
	int largestSubmatrix(vector<vector<int>>& matrix) {
		int m = matrix.size(), n = matrix[0].size();
		int res = 0;
		vector<int> height(n, 0);
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) height[j] = 0;
				else height[j] += 1;
			}
			vector<int> rearranged = height;
			sort(rearranged.rbegin(), rearranged.rend());
			for (int j = 0; j < n; j++) {
				res = max(res, rearranged[j] * (j + 1));
			}
		}
		return res;
	}
};
