class GetNumber {
	// 1. find all the substrings with no repeating characters check if there is length k substring
	public int getNumber1(String s, int k) {
		int i = 0, j = 0, res = 0;
		Set<Character> set = new HashSet<>();
		while (j < s.length()) {
			char cur = s.charAt(j);
			while (i < j && set.contains(cur)) {
				set.remove(s.charAt(i++));
			}
			set.add(cur);
			if (set.size() >= k) {
				res++;
			}
			j++;
		}
		return res;
	}
	
	// 2. find all the substrings with length k check if there is repeating character
	public int getNumber2(String s, int k) {
        if (s == null || s.length() < k) {
		    return 0;
        }
        Map<Character, Integer> occurrence = new HashMap<>();
        int j = 0, res = 0;
        while (j < s.length()) {
	        char cur = s.charAt(j);
	        occurrence.put(cur, occurrence.getOrDefault(cur, 0)  + 1);
            if (j >= k) {
	            cur = s.charAt(j - k);
	            int count = occurrence.get(cur);
	            if (count == 1) {
	                occurrence.remove(cur);
                } else {
	                occurrence.put(cur, count - 1);
                }
            }
            if (j >= k - 1 && occurrence.size() == k) {
	            res++;
            }
            j++;
        }
        return res;
    }
}
