class RestoreIP {
	public List<String> restorIpAddresses(String s) {
		List<String> res = new ArrayList<>();
		dfs(res, new StringBuilder(), s, 0, 0);
		return res;
	}
	private void dfs(List<String> res, StringBuilder sb, String s, int index, int part) {
		if (index == s.length()) {
			if (part == 4) {
				sb.deleteCharAt(sb.length() - 1);
				res.add(sb.toString());
			}
			return;
		}
		if (part == 4) {
			return;
		}
		int count = 0;
		for (int i = index; i < Math.min(index + 3, s.length()); i++) {
			count = count * 10 + s.charAt(i) - '0';
			if (count >= 0 && count <= 255) {
				int len = sb.length();
				sb.append(count).append(".");
				dfs(res, sb, s, i + 1, part + 1);
				sb.setLength(len);
			}
			if (count == 9 && i == index) break;
		}
	}
}
