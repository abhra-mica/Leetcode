package trie;

public class L211_WordDictionary {
	static TrieNode root;

	public L211_WordDictionary() {
		root = new TrieNode();
	}

	public static void main(String[] args) {
		L211_WordDictionary dic = new L211_WordDictionary();
		dic.addWord("bad");
		boolean result = search(".ad", 0, root);
		System.out.println("Result = " + result);
	}

	public void addWord(String word) {
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			int idx = word.charAt(i) - 'a';

			if (node.children[idx] == null) {
				node.children[idx] = new TrieNode();
			}

			if (i == word.length() - 1) {
				node.children[idx].eow = true;
			}

			node = node.children[idx];
		}
	}

	public boolean search(String word) {
		return search(word, 0, root);
	}

	public static boolean search(String word, int i, TrieNode node) {
		if (node == null) {
			return false;
		}

		if (i == word.length()) {
			return node.eow;
		}

		char c = word.charAt(i);
		if (c == '.') {
			for (int j = 0; j < 26; j++) {
				if (search(word, i + 1, node.children[j])) {
					return true;
				}
			}
		} else {
			// Without this if condition returning result for above will be lost
			if (search(word, i + 1, node.children[c - 'a'])) {
				return true;
			}
		}
		return false;
	}

	// Normal one word search recursively( for practice)
	public static boolean searchRecNormal(String word, int i, TrieNode node) {
		if (node == null) {
			return false;
		}

		if (i == word.length()) {
			return node.eow;
		}
		int idx = word.charAt(i) - 'a';
		// Without this if condition returning result for above will be lost
		if (searchRecNormal(word, i + 1, node.children[idx])) {
			return true;
		}

		return false;
	}
}

class TrieNode {
	TrieNode[] children;
	boolean eow;

	TrieNode() {
		children = new TrieNode[26];
		eow = false;
	}
}
