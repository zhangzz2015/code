class Longest {
	public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int longest = 0;
        int slow = 0;
        for (int fast = 0; fast < s.length(); ++fast) {
            if (!set.add(s.charAt(fast))) {
                while (slow < fast && s.charAt(slow) != s.charAt(fast)) {
                    set.remove(s.charAt(slow));
                    slow++;
                }
                slow++;
            }
            longest = Math.max(longest, fast - slow  + 1);
        }
        return longest;
    }
}
