class MaxRectangle {
public:
	int maximalRectangle(vector<vector<char>>& matrix) {
        if (matrix.size() == 0) {
            return 0;
        }
        int n = matrix[0].size();
        vector<int> heights(n);
        int largest = 0;
        for (vector<char>& row : matrix) {
            for (int j = 0; j < n; ++j) {
                if (row[j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }
            largest = max(largest, get_max(heights));
        }
        return largest;
    }
private:
    int get_max(vector<int>& heights) {
        int res = 0;
        deque<int> stack;
        for (int right = 0; right <= heights.size(); ++right) {
            int cur = right == heights.size() ? 0 : heights[right];
            while (!stack.empty() && heights[stack.back()] >= cur) {
                int height = heights[stack.back()];
                stack.pop_back();
                int left = stack.empty() ? -1 : stack.back();
                res = max(res, height * (right - left - 1));
            }
            stack.push_back(right);
        }
        return res;
    }
};
