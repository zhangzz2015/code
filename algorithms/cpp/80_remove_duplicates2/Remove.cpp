class Remove {
public:
	int removeDuplicates(vector<int>& nums) {
		if (nums.size() <= 2) {
			return nums.size();
		}
		for (int fast = 2; fast < nums.size(); ++fast) {
			if (nums[fast] != nums[slow - 2]) {
				nums[slow++] = nums[fast];
			}
		}
		return slow;
	}
};
