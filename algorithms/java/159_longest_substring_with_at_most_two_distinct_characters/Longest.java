class Longest {
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int longest = 0;
		int i = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (int j = 0; j < s.length(); j++) {
			char cur = s.charAt(j);
			map.put(cur, map.getOrDefault(cur, 0) + 1);
			while (map.size() > 2) {
				cur = s.charAt(i);
				Integer count = map.get(cur);
				if (count == 1) {
					map.remove(cur);
				} else {
					map.put(cur, count - 1);
				}
				i++;
			}
			longest = Math.max(longest, j - i + 1);
		}
		return longest;
	}
}
