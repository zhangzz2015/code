class WordSearch {
	private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

	public List<String> findWords(char[][] board, String[] words) {
		List<String> res = new ArrayList<>();
		Trie trie = new Trie();
		for (String word : words) {
			trie.insert(word);
		}
		StringBuilder sb = new StringBuilder();
		int m = board.length, n = board[0].length;
		boolean[][] visited = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				dfs(trie.root, board, i, j, visited, sb, res);
			}
		}
		return res;
	}

	private void dfs(TrieNode cur, char[][] board, int i, int j, boolean[][] visited, StringBuilder sb, List<String> res) {
		if (!isValid(board, i, j) || visited[i][j]) {
			return;
		}
		char c = board[i][j];
		TrieNode next = cur.children.get(c);
		if (next == null) {
			return;
		}
		cur = next;
		sb.append(c);
		if (cur.isWord) {
			res.add(sb.toString());
			cur.isWord.false;
		}
		visited[i][j] = true;
		for (int[] dir : DIRS) {
			int neiX = i + dir[0];
			int neiY = j + dir[1];
			dfs(cur, board, neiX, neiY, sb, res);
		}
		sb.deleteCharAt(sb.length() - 1);
		visited[i][j] = false;
	}

	private boolean isValid(char[][] board, int i, int j) {
		return i >= 0 && i < board.length && j >= 0 && j < board[0].length;
	}

	static class TrieNode {
		boolean isWord;
		Map<Character, TrieNode> children;
		TrieNode() {
			this.children = new HashMap<>();
		}
	}
	static class Trie {
		TrieNode root;
		Trie() {
			this.root = new TrieNode();
		}
		private void insert(String word) {
			TrieNode cur = root;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				TrieNode next = cur.children.get(c);
				if (next == null) {
					next = new TrieNode();
					cur.children.put(c, next);
				}
				cur = next;
			}
			cur.isWord = true;
		}
	}
}
