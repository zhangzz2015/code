class WordPattern {
	public boolean wordPatternMatch(String pattern, String str) {
		Map<Character, String> map = new HashMap<>();
		Set<String> set = new HashSet<>();
		return isMatch(pattern, 0, str, 0, map, set);
	}
	private boolean isMatch(String pattern, int pIndex, String str, int sIndex, Map<Character, String> map, Set<String> set) {
		if (pIndex == pattern.length() && sIndex == str.length()) {
			return true;
		}
		if (pIndex == pattern.length() || sIndex == str.length()) {
			return false;
		}
		char c = patter.charAt(pIndex);
		String s = map.get(c);
		if (s != null) {
			if (!str.startsWith(s, sIndex)) {
				return false;
			}
			return isMatch(pattern, pIndex + 1, str, sIndex + s.length(), map, set);
		}
		for (int i = sIndex; i < str.length(); i++) {
			String cur = str.substring(sIndex, i + 1);
			if (!set.contains(cur)) {
				map.put(c, cur);
				set.add(cur);
				if (isMatch(pattern, pIndex + 1, str, sIndex + cur.length(), map, set) {
					return true;
				}
				map.remove(c);
				set.remove(cur);
			}
		}
		return false;
	} 
}
