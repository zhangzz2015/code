class Zigzag {
	public String convert(String s, int numRows) {
		if (numRows == 1) {
			return s;
		}
		int n = s.length();
		int cycle = numRows * 2 - 2;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j + i < n; j += cycle) {
				sb.append(s.charAt(j + i));
				if (i != 0 && i != numRows - 1 && j + cycle - i < n) {
					sb.append(s.charAt(j + cycle - i));
				}
			}
		}
		return sb.toString();
	}
}
