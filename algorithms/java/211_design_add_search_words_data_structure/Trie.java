class Trie {
	class TrieNode {
		boolean isEnd = false;
		TrieNode[] children = new TrieNode[26];
	}

	TrieNode root;
	public Trie() {
		root = new TrieNode();
	}

	public void addWord(String word) {
		TrieNode tmp = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (tmp.children[ch - 'a'] == null) {
				tmp.children[ch - 'a'] = new TrieNode();
				tmp = tmp.children[ch - 'a'];
			}
		}
		tmp.isEnd = true;
	}

	public boolean search(String word) {
		TrieNode tmp = root;
		return search(word, 0, tmp);
	}
	private boolean search(String word, int i, TrieNode node) {
		if (node == null) {
			return false;
		}
		if (i == word.length()) {
			return node.isEnd;
		}
		char ch = word.charAt(i);
		// . can match any character
		if (ch == '.') {
			for (int k = 0; k < 26; k++) {
				if (search(word, i + 1, node.children[k])) {
					return true;
				}
			}
		} else {
			if (search(word, i + 1, node.children[k])) {
				return true;
			}
		}
		return false;
	}
}
