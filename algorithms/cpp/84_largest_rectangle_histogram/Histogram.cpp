class Histogram {
public:
	int largestRectangleArea(vector<int>& heihgts) {
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
