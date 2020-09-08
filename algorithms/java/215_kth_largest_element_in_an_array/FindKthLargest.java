public class FindKthLargest {
	
	// 1. use size k minHeap
	public int findKthLargest(int[] nums, int k) {
		if (nums == null || nums.length < k) {
			return Integer.MIN_VALUE;	
		}
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for (int i : nums) {
			minHeap.offer(i);
			if (minHeap.size() > k) {
				minHeap.poll();
			}
		}
		return minHeap.peek();
	}

	// 2. quickselect
	public int findKthLargest1(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return Integer.MIN_VALUE;
		}
		k = nums.length - k;
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int pivotIndex = partition(nums, left, right);
			if (pivotIndex == k) {
				return nums[pivotIndex];
			}
			if (pivotIndex < k) {
				left = pivotIndex + 1;
			} else {
				right = pivotIndex - 1;
			}
		}
		return Integer.MIN_VALUE;
	}
	
	private int partition(int[] nums, int left, int right) {
		int pivotIndex = left + (int)(Math.random() * (right - left + 1));
		int pivot = nums[pivotIndex];
		swap(nums, pivotIndex, right);
		int leftBound = left;
		int rightBound = right - 1;
		while (leftBound <= rightBound) {
			if (nums[leftBound] < pivot) {
				leftBound++;
			} else if (nums[rightBound] >= pivot) {
				rightBound--;
			} else {
				swap(nums, leftBound++, rightBound--);
			}
		}
		swap(nums, leftBound, right);
		return leftBound;
	}

	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
