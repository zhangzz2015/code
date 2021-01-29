class WordBreak {
	// 1. backtracking
	public List<String> wordBreak1(String s, List<String> wordDict) {
		List<String> res = new ArrayList<>();
		Set<String> set = new HashSet<>(wordDict);
		StrngBuilder sb = new StringBuilder();
		dfs(s, 0, sb, res, set);
		return res;
	}
	private void dfs(String s, int index, StringBuilder sb, List<String> res, Set<String> set) {
		if (index == s.length()) {
			sb.deleteCharAt(sb.length() - 1);
			res.add(sb.toString());
			return;
		}
		StringBuilder tmp = new StringBuilder();
		for (int i = index; i < s.length(); i++) {
			tmp.append(s.charAt(i));
			if (set.contains(tmp.toString()) {
				int len = sb.length();
				sb.append(tmp).append(' ');
				dfs(s, i + 1, sb, res, set);
				sb.setLength(len);
			}
		}
	}
	// 2. recursion memoization
	public List<String> wordBreak2(String s, List<String> wordDict) {
		List<String> res = new ArrayList<>();
		Set<String> set = new HashSet<>(wordDict);
		Map<Integer, List<String>> memo = new HashMap<>();
		return recursion(s, s.length(), set, memo);
	}
	private List<String> rescursion(String s, int index, Set<String> set, Map<Integer, List<String>> memo) {
		if (memo.containsKey(index)) {
			return memo.get(index);
		}
		List<String> allPaths = new ArrayList<>();
		if (index == 0) {
			allPath.add("");
			return allPaths;
		}
		for (int i = index; i >= 0; i--) {
			String cur = s.substring(i, index);
			if (wordSet.contains(cur)) {
				List<String> prevPaths = recursion(s, i, set, memo);
				for (String path : prevPaths) {
					if (path.isEmpty()) {
						allPaths.add(path + cur);
					} else {
						allPaths.add(path + " " + cur);
					}
				}
			}
		}
		memo.put(index, allPaths);
		return allPath;
	}
}
