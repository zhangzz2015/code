class SmallestRange {
	static class Cell implements Comparable<Cell> {
		int row;
		int col;
		int val;
		Cell(int row, int col, int val) {
			this.row = row;
			this.col = col;
			this.val = val;
		}
		@Override
		public int compareTo(Cell other) {
			return Integer.compare(this.val, other.val);
		}
	}

	public int[] smallestRange(List<List<Integer>> nums) {
		if (nums == null || nums.isEmpty()) return new int[0];
		PriorityQueue<Cell> minHeap = new PriorityQueue<>();
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.size(); i++) {
			if (!nums.get(i).isEmpty()) {
				int cur = nums.get(i).get(0);
				minHeap.offer(new Cell(i, 0, cur));
				max = Math.max(max, cur);
			}
		}
		int[] res = new int[2];
		int minRange = Integer.MAX_VALUE;
		while (minHeap.size() == nums.size()) {
			Cell curMin = minHeap.poll();
			if (max - curMin.val < minRange) {
				minRange = max - curMin.val;
				res[0] = curMin.val;
				res[1] = max;
			}
			if (curMin.col + 1 < nums.get(curMin.row).size()) {
				int newVal = nums.get(curMin.row).get(curMin.col + 1);
				minHeap.offer(new Cell(curMin.row, curMin.col + 1, newVal));
				max = Math.max(max, newVal);
			}
		}
		return res;
	}
}
