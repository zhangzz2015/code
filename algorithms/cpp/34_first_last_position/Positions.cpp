class Positions {
public:
	// using the api
	vector<int> searchRangeAPI(vector<int>& nums, int target) {
		int first = lower_bound(nums.begin(), nums.end(), target) - nums.begin();
		int last = upper_bound(nums.begin(), nums.end(), target) - nums.begin() - 1;
		if (first < nums.size() && nums[first] == target) {
			return {first, last};
		}
		return {-1, -1};
	}

	// implementation
	vector<int> searchRange(vector<int>& nums, int target) {
		vector<int> res(2, -1);
		if (nums.size() == 0) {
			return res;
		}
		res[0] = first(nums, target);
		if (res[0] == -1) {
			return res;
		}
		res[1] = last(nums, target);
		return res;
	}
private:
	int first(vector<int>& nums, int target) {
		int left = 0, right = nums.size() - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] >= target) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return nums[left] == target ? left : -1;
	}
	int last(vector<int>& nums, int target) {
		int left = 0, right = nums.size() - 1;
		while (left < right - 1) {
			int mid = left + (right - left) / 2;
			if (nums[mid] <= target) {
				left = mid;
			} else {
				right = mid - 1;
			}
		}
		if (nums[right] == target) {
			return right;
		}
		if (nums[left] == target) {
			return left;
		}
		return -1;
	}
};
