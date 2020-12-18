class RotateImage {
public:
	void rotate(vector<vector<int>>& matrix) {
		if (matrix.size() <= 1) {
			return;
		}
		int left = 0, right = matirx.size() - 1;
		while (left < right) {
			for (int i = 0; i < (right - left); i++) {
				swap(matrix[left][left + i], matrix[left + i][right]);
				swap(matrix[left][left + i], matirx[right][right - i]);
				swap(matrix[left][left + i], matrix[right - i][left]);
			}
			left++;
			right--;
		}
	}
};
