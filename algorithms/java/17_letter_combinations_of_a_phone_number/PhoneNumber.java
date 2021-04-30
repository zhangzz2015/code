class PhoneNumber {
	public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        List<char[]> map = buildMap();
        dfs(digits, 0, res, map, new StringBuilder());
        return res;
    }
    
    private void dfs(String digits, int index, List<String> res, List<char[]> map, StringBuilder sb) {
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }
        int cur = digits.charAt(index) - '0';
        char[] candidates = map.get(cur);
        for (char c : candidates) {
            sb.append(c);
            dfs(digits, index + 1, res, map, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    
    private List<char[]> buildMap() {
        List<char[]> res = new ArrayList<>();
        res.add(new char[0]);
        res.add(new char[0]);
        res.add(new char[]{'a', 'b', 'c'});
        res.add(new char[]{'d', 'e', 'f'});
        res.add(new char[]{'g', 'h', 'i'});
        res.add(new char[]{'j', 'k', 'l'});
        res.add(new char[]{'m', 'n', 'o'});
        res.add(new char[]{'p', 'q', 'r', 's'});
        res.add(new char[]{'t', 'u', 'v'});
        res.add(new char[]{'w', 'x', 'y', 'z'});
        return res;
    }
}
