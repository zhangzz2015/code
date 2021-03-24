class Median {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length, n = nums2.length;
		int left = (m + n + 1) / 2;
		int right = (m + n + 2) / 2;
		if (left == right) {
			return findKth(nums1, 0, nums2, 0, left);
		} else {
			return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2.0;
		}
	}
	private int findKth(int[] a, int aLeft, int[] b, bLeft, int k) {
		if (aLeft >= a.length) {
			return b[bLeft + k - 1];
		}
		if (bLeft >= b.length) {
			return a[aLeft + k - 1];
		}
		if (k == 1) {
			return Math.min(a[aLeft], b[bLeft]);
		}
		int aMid = aLeft + k / 2 - 1;
		int bMid = bLeft + k / 2 - 1;
		int aVal = aMid >= a.length ? Integer.MAX_VALUE : a[aMid];
		int bVal = bMid >= b.length ? Integer.MAX_VALUE : b[bMid];
		if (aVal <= bVal) {
			return findKth(a, aMid + 1, b, bLeft, k - k / 2);
		} else {
			return findKth(a, aLeft, b, bMid + 1, k - k / 2);
		}
	}
}
