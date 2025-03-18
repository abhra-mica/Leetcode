package trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L212_WordSearchII {
	TrieNode root = new TrieNode();
	boolean[][] visited = null;

	public List<String> findWords(char[][] board, String[] words) {
		Set<String> result = new HashSet<>();
		visited = new boolean[board.length][board[0].length];

		for (String word : words) {
			addToTrie(word);
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (root.children[board[i][j] - 'a'] != null) {
					search(board, i, j, root, "", result);
				}
			}
		}

		return new ArrayList<>(result);
	}

	private void addToTrie(String word) {
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

	private void search(char[][] board, int i, int j, TrieNode node,
			String word, Set<String> result) {

		if (i >= board.length || i < 0 || j >= board[0].length || j < 0
				|| visited[i][j] || node.children[board[i][j] - 'a'] == null) {
			return;
		}

		visited[i][j] = true;
		node = node.children[board[i][j] - 'a'];
		if (node.eow) {
			result.add(word + board[i][j]);
		}

		search(board, i - 1, j, node, word + board[i][j], result);
		search(board, i + 1, j, node, word + board[i][j], result);
		search(board, i, j - 1, node, word + board[i][j], result);
		search(board, i, j + 1, node, word + board[i][j], result);
		visited[i][j] = false;
	}
}
