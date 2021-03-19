class EncodeDecode {
	// 1. chunked transfer encoding
	private static final String DELIMITER = "#";
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if (strs == null || strs.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append(DELIMITER).append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        int i = 0;
        while (i < s.length()) {
            int index = s.indexOf(DELIMITER, i);
            int len = Integer.valueOf(s.substring(i, index));
            res.add(s.substring(index + 1, index + 1 + len));
            i = index + 1 + len;
        }
        return res;
    }

	// 2. escape character
	private static final char SPLITTER = ',';
    private static final char ESCAPE = '/';

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c == ESCAPE || c == SPLITTER) {
                    sb.append(ESCAPE).append(c);
                } else {
                    sb.append(c);
                }
            }
            sb.append(SPLITTER);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        int index = 0;
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        while (index < s.length()) {
            char c = s.charAt(index);
            if (c == SPLITTER) {
                res.add(sb.toString());
                sb.setLength(0);
            } else if (c == ESCAPE) {
                sb.append(s.charAt(++index)); // require ESCAPE != SPLITTER
            } else {
                sb.append(c);
            }
            index++;
        }
        return res;
    }
}
