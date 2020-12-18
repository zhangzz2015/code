class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		if (strs == null || strs.length == 0) {
			return new ArrayList<>();
		}
		Map<String, List<String>> map = new HashMap<>();
		for (String s : strs) {
			String pattern = getPattern(s);
			map.putIfAbsent(pattern, new ArrayList<>());
			map.get(pattern).add(s);
		}
		return new ArrayList<>(map.values());
	}
	private String getPattern(String s) {
		int[] count = new int[26];
		for (char c : s.toCharArray()) {
			count[c - 'a']++;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < count.length; i++) {
			for (int j = 0; j < count[i]; j++) {
				sb.append((char)(i + 'a'));
			}
		}
		return sb.toString();
	}
}
