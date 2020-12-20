class Trie {
    static class TrieNode {
        boolean isWord;
        Map<Character, TrieNode> children;
        TrieNode() {
            this.children = new HashMap<>();
        }
    }
    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        this.root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            TrieNode next = cur.children.get(c);
            if (next == null) {
                next = new TrieNode();
                cur.children.put(c, next);
            }
            cur = next;
        }
        cur.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            TrieNode next = cur.children.get(c);
            if (next == null) {
                return false;
            }
            cur = next;
        }
        return cur.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0) {
            return false;
        }
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            TrieNode next = cur.children.get(c);
            if (next == null) {
                return false;
            }
            cur = next;
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */





/**
* This class is a class of trie storing a set of the string
* which is the prefix using the prefix starting from the root
* ending at the current node before.
*/
class Trie {
	TrieNode root;

	public Trie() {
		this.root = new TrieNode();
	}

	public void insert(String word) {
		if (word == null || word.length() == 0) {
			return;
		}
		TrieNode cur = root;
		cur.startsWith.add(word);
		for(char c : word.toCharArray()) {
			TrieNode next = cur.children.get(c);
			if (next == null) {
				next = new TrieNode();
				cur.children.put(c, next);
			}
			cur = next;
			cur.startsWith.add(word);
		}
		cur.isWord = true;
	}

	/* return a list of the strings starting with the prefix */
	public List<String> startsWith(String prefix) {
		List<String> res = new ArrayList<>();
		TrieNode cur = root;
		for (char c : prefix.toCharArray()) {
			if (cur.children.get(c - 'a') == null) {
				return res;
			}
			cur = cur.get(c - 'a');
		}
		res.addAll(cur.startsWith);
		return res;
	}

	class TrieNode {
		boolean isWord;
		Set<String> startsWith;
		Map<Character, TrieNode> children;
		TrieNode() {
			this.isWord;
			this.startsWith = new HashSet<>();
			this.children = new HashMap<>();
		}
	}
}



