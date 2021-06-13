class RainWater {
public:
	// 1. stack
	int trap_stack(vector<int>& height) {
		int res = 0, current = 0;
		stack<int> stack;
		while (current < height.size()) {
			while (!stack.empty() && height[current] > height[stack.top()]) {
				int peek = stack.top();
				stack.pop();
				if (stack.empty()) {
					break;
				}
				int dis = current - stack.top() - 1;
				int tall = min(height[current], height[stack.top()]) - height[peek];
				res += dis * tall;
			}
			stack.push(current++);
		}
		return res;
	}

	// 2. greedy
	int trap_greedy(vector<int>& height) {
		if (height.size() == 0) {
			return 0;
		}
		int left = 0;
		int right = height.size() - 1;
		int left_max = height[left];
		int right_max = height[right];
		int res = 0;
		while (left <= right) {
			if (height[left] < height[right]) {
				res += max(left_max - height[left], 0);
				left_max = max(left_max, height[left++]);
			} else {
				res += max(right_max - height[right], 0);
				right_max = max(right_max, height[right++]);
			}
		}
		return res;
	}
};
