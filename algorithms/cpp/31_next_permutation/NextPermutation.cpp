class NextPermutation {
public:
	void nextPermutation(vector<int>& nums) {
		if (nums.size() == 0) {
			return;
		}
		int i = nums.size() - 2;
		while (i >= 0 && nums[i] >= nums[i + 1]) {
			i--;
		}
		if (i >= 0) {
			int j = nums.size() - 1;
			while (nums[j] <= nums[i]) {
				j--;
			}
			swap(nums[i], nums[j]);
		}
		reverse(nums, i + 1, nums.size() - 1);
	}
private:
	void reverse(vector<int>& nums, int left, int right) {
		while (left < right) {
			swap(nums[left++], nums[right--]);
		}
	}

	// we can also use binary search to find the index j
	int search(vector<int>& nums, int left, int right, int target) {
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return nums[right] > target ? right : left;
    }
};
