class Decode {
	public String deCompress(String s) {
		if (s == null || s.length() == 0) return s;
		return deCompress(s.toCharArray(), new int[1]).toString();
	}

	private StringBuilder deCompress(char[] array, int[] index) {
		StringBuilder sb = new StringBuilder();
		int count = 0;
		while (index[0] < array.length) {
			if (Character.isDigit(array[index[0]])) {
				while (array[index[0]] != '|') {
					count = count * 10 + (array[index[0]] - '0');
					index[0]++;
				}
				// skip '|'
				index[0]++;
			} else if (Character.isLetter(array[index[0]])) {
				sb.append(array[index[0]++]);
			} else if (array[index[0]] == '[') {
				index[0]++;
				sb.append(deCompress(array, index));
			} else {
				// find ']'
				index[0]++;
				StringBuilder res = new StringBuilder();
				while (count > 0) {
					count--;
					res.append(sb);
				}
				return res;
			}
		}
		return sb;
	}

	public static void main(String[] args) {
		Decode solve = new Decode();
		String input = "HG[3|B[2|CA]]F";
		System.out.println(solve.deCompress(input));
	}
}
