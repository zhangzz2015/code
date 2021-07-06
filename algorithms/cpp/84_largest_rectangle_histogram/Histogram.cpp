class Histogram {
public:
	int largestRectangleArea(vector<int>& heihgts) {
		int res = 0;
		stack<int> stack;
		for (int right = 0; right <= heights.size(); ++right) {
			int cur = right == heights.size() ? 0 : heights[right];
			while (!stack.empty() && heights[stack.top()] >= cur) {
				int height = heights[stack.top()];
				stack.pop();
				int left = stack.empty() ? -1 : stack.top();
				res = max(res, height * (right - left - 1));
			}
			stack.push(right);
		}
		return res;
	}
};
