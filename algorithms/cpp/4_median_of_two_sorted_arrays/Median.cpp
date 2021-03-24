class Median {
public:
	double findMedianSortedArrays(vector<int>& nums1, vecotr<int>& nums2) {
		int m = nums1.size(), n = nums2.size();
		int left = (m + n + 1) / 2;
		int right = (m + n + 2) / 2;
		if (left == right) {
			return findKth(nums1, 0, nums2, 0, left);
		} else {
			return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2.0;
		}
	}
private:
	int findKth(vector<int>& a, int aLeft, vector<int>& b, int bLeft, int k) {
		if (aLeft >= a.size()) {
			return b[bLeft + k - 1];
		}
		if (bLeft >= b.size()) {
			return a[aLeft + k - 1];
		}
		if (k == 1) {
			return min(a[aLeft], b[bLeft]);
		}
		int aMid = aLeft + k / 2 - 1;
		int bMid = bLeft + k / 2 - 1;
		int aVal = aMid >= a.size() ? INT_MAX : a[aMid];
		int bVal = bMid >= b.size() ? INT_MAX : b[bMid];
		if (aVal <= bVal) {
			return findKth(a, aMid + 1, b, bLeft, k - k / 2);
		} else {
			return findKth(a, aLeft, b, bMid + 1, k - k / 2);
		}
	}
}
