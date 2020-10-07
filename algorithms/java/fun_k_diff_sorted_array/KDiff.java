class KDiff {
	public void sort(int[] array, int k) {
		if (k <= 0 || k > array.length - 1) {
			throw new IllegalArgumentException("Not valid input");
		}
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for (int i = 0; i <= k; i++) {
			minHeap.offer(array[i]);
		}
		for (int i = 0; i < array.length; i++) {
			array[i] = minHeap.poll();
			if (i + k + 1 < array.length) {
				minHeap.offer(array[i + k + 1]);
			} 
		}
	}
}
