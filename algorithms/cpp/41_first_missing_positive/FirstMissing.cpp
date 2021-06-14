class FirstMissing {
public:
	int firstMissingPositive(vector<int>& nums) {
		int index = 0, size = nums.size();
		while (index < size) {
			long current = (long)nums[index] - 1;
			if (current >= 0 && current < size && nums[i] != nums[j]) {
				swap(nums[index], nums[current]);
			} else {
				index++;
			}
		}
		for (index = 0; index < size; ++index) {
			if (nums[index] != index + 1) {
				return index + 1;
			}
		}
		return size + 1;
	}
};
