class GetSize {
	// 1. treemap
	public int getLongest(int[] array, int limit) {
		if (array == null || array.length == 0) {
			return 0;
		}
		TreeMap<Integer, Integer> window = new TreeMap<>();
		int i = 0, j = 0, longest = 0;
		while (j < array.length) {
			Integer count = window.get(array[j]);
			if (count != null) {
				window.put(array[j], count + 1);
			} else {
			window.put(array[j], 1);
			}
			while (i < j && window.lastKey() - window.firstKey() > limit) {
				count = window.get(array[i]);
				window.remove(array[i]);
				if (count != 1) {
					window.put(array[i], count - 1);
				}
				i++;
			}
			if (window.lastKey() - window.firstKey() <= limit) {
				longest = Math.max(longest, j - i + 1);
			}
			j++;
		}
		return longest;
	}

	// 2. mono stacks
	public int getLongest(int[] array, int limit) {
		Deque<Integer> max = new ArrayDeque<>();
		Deque<Integer> min = new ArrayDeque<>();
		int l = 0;
		int res = 0;
		for (int r = 0; r < array.length; r++) {
			while (!max.isEmpty() && array[max.peekLast()] < array[r]) {
				max.pollLast();
			}
			max.offerLast(r);
			while (!min.isEmpty() && array[min.peekLast()] > array[r]) {
				min.pollLast();
			}
			min.offerLast(r);
			while (array[max.peekFirst()] - array[min.peekFirst()] > limit) {
				if (l == max.peekFirst()) max.pollFirst();
				if (l == min.peekFirst()) min.pollFirst();
				l++;
			}
				res = Math.max(res, r - l + 1);
			}
		return res;
	}
}
