class Generate {
	public List<String> generateParentheses(int n) {
		List<String> res = new ArrayList<>();
		if (n <= 0) {
			return res;
		}
		generate(n, n, new StringBuilder(), res);
		return res;
	}
	private void generate(int left, int right, StringBuilder sb, List<String> res) {
		if (left == 0 && right == 0) {
            res.add(sb.toString());
            return;
        }
        if (left > 0) {
            sb.append('(');
            generate(left - 1, right, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right > left) {
            sb.append(')');
            generate(left, right - 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
