class SpellCorrection {
	private TrieNode root;

	SpellCorrection(List<String> dictionary) {
		this.root = new TrieNode();
		for (String word : dictionary) {
			insert(word);
		}
	}

	private void insert(String word) {
		if (word == null) {
			return;
		}
		TrieNode cur = root;
		for (char c : word) {
			TrieNode next = cur.children.get(c);
			if (next == null) {
				next = new TrieNode();
				cur.children.put(c, next);
			}
			cur = next;
		}
		cur.isWord = true;
	}

	public List<String> findKClosest(String word, int k) {
		List<String> res = new ArrayList<>();
		int len = word.length();
		int[] dp = new int[len + 1];
		for (int i = 0; i <= len; i++) {
			dp[i] = i;
		}
		StringBuilder sb = new StringBuilder();
		traverse(sb, root, 1, word, k, res, dp);
		Collections.sort(res);
		return res;
	}

	private void traverse(StringBuilder sb, TrieNode current, int level, String word, int k, List<String> res, int[] dp) {
		int[] tmp = new int[dp.length];
		tmp[0] = level;
		for (Character c : current.children.keySet()) {
			for (int j = 1; j < tmp.length; j++) {
				if (c == word.charAt(j - 1)) {
					tmp[j] = dp[j - 1];
				} else {
					tmp[j] = Math.min(dp[j], tmp[j - 1]) + 1;
					tmp[j] = Math.min(tmp[j], dp[j - 1] + 1);
				}
			}
			sb.append(c);
			TrieNode next = current.children.get(c);
			if (next.isWord && dp[tmp.length - 1] <= k) {
				res.add(sb.toString());
			}
			traverse(sb, next, level + 1, word, k, res, tmp);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	class TrieNode {
		boolean isWord;
		Map<Character, TrieNode> children;
		TrieNode() {
			this.children = new HashMap<>();
		}
	}
}
