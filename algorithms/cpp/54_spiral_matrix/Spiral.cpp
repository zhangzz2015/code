class Spiral {
public:
	vector<int> spiralOrder(vector<vector<int>>& matrix) {
		vector<int> res;
		int left = 0, right = matrix[0].size() - 1;
		int up = 0, down = matrix.size() - 1;
		while (left < right && up < down) {
			for (int i = left; i <= right; ++i) {
				res.push_back(matrix[up][i]);
			}
			for (int i = up + 1; i <= down; ++i) {
				res.push_back(matrix[i][right]);
			}
			for (int i = right - 1; i >= left; --i) {
				res.push_back(matrix[down][i]);
			}
			for (int i = down - 1; i >= up + 1; --i) {
				res.push_back(matrix[i][left]);
			}
			++left;
			--right;
			++up;
			--down;
		}
		if (left > right || up > down) {
			return res;
		}
		if (left == right) {
			for (int i = up; i <= down; ++i) {
				res.push_back(matrix[i][left]);
			}
		} else {
			for (int i = left; i <= right; ++i) {
				res.push_back(matrix[up][i]);
			}
		}
		return res;
    }
};
