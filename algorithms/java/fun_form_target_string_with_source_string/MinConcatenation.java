class MinConcatenation {
	public int findMinConcatenation(String target, String source) {
		Map<Character, List<Integer>> invertIndexMap = buildMap(source);
		char[] targetArray = target.toCharArray();
		int curIndex = -1;
		int count = 1;
		for (int i = 0; i < targetArray.length; i++) {
			char cur = targetArray[i];
			List<Integer> curPos = invertIndexMap.get(cur);
			if (curPos == null) {
				return -1;
			}
			curIndex = findSmallestLarger(curPos, curIndex);
			if (curIndex == -1) {
				count++;
				curIndex = curPos.get(0);
			}
		}
		return count;
	}

	private int findSmallestLarger(List<Integer> pos, int target) {
		int left = 0;
		int right = positions.size() - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (pos.get(mid) > target) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return pos.get(left) > target ? pos.get(left) : -1;
	}

	private Map<Character, List<Integer>> buildMap(String source) {
		Map<Character, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < source.length(); i++) {
			char cur = souce.charAt(i);
			map.putIfAbsent(cur, new ArrayList<>());
			map.get(cur).add(i);
		}
		return map;
	}
}
