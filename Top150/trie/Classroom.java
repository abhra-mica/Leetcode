package trie;

public class Classroom {
	static Node root = new Node();
	// Node class
	static class Node {
		Node[] children;
		boolean eow;

		Node() {
			children = new Node[26];
			eow = false;
		}
	}

	public static void main(String[] args) {
		/*
		 * String[] words = {"the", "a", "there", "their", "any"};
		 * 
		 * // insert for (int i = 0; i < words.length; i++) { insert(words[i]);
		 * }
		 */

		// System.out.println("There exists ? " + search("there"));
		// System.out.println("thor exists ? " + search("thor"));
		// System.out.println("an exists ? " + search("an"));

		// ====================
		/*
		 * String[] words = {"i", "like", "sam", "samsung", "mobile"};
		 * 
		 * for (int i = 0; i < words.length; i++) { insert(words[i]); }
		 * 
		 * String key = "ilikesam"; boolean result = wordBreak(key);
		 * System.out.println("Word availalbe == " + result);
		 */

		// ============
		// Question - Find count of unique substring.
		// System.out.println(
		// "No of unique substring: " + countUniqueStrings("ababa"));

		// Questions - Find longest word prefix

		/*
		 * String[] words = {"a", "banana", "app", "appl", "ap", "apple"};
		 * 
		 * for (int i = 0; i < words.length; i++) { insert(words[i]); }
		 * longestWord(root, new StringBuilder("")); System.out.println(ans);
		 */

		System.out.println(startsWith("a"));
	}

	// Insertion of a single word in trie or we can say populate trie
	public static void insert(String word) {
		Node node = root;
		for (int i = 0; i < word.length(); i++) {
			int idx = word.charAt(i) - 'a';
			if (node.children[idx] == null) {
				node.children[idx] = new Node();
			}

			if (i == word.length() - 1) {
				node.children[idx].eow = true;
			}
			node = node.children[idx];
		}
	}

	// Search a particular word in trie
	public static boolean search(String key) {
		Node node = root;
		for (int i = 0; i < key.length(); i++) {
			int idx = key.charAt(i) - 'a';

			if (node.children[idx] == null) {
				return false;
			}
			if (i == key.length() - 1 && node.children[idx].eow == false) {
				return false;
			}

			node = node.children[idx];
		}
		return true;
	}

	// 1. Find all the substring of a word is present in an array or not
	public static boolean wordBreak(String key) {
		if (key.length() == 0) {
			return true;
		}

		for (int i = 1; i < key.length(); i++) {
			String firstPart = key.substring(0, i);
			String secondPart = key.substring(i);

			if (search(firstPart) && wordBreak(secondPart)) {
				return true;
			}
		}
		return false;
	}

	// 2.Find a prefix of a word is availalbe in the trie
	public static boolean startsWith(String prefix) {
		Node node = root;
		for (int i = 0; i < prefix.length(); i++) {
			int idx = prefix.charAt(i) - 'a';

			if (node.children[idx] == null) {
				return false;
			}
			node = node.children[idx];
		}
		return true;
	}

	// 3. Count all unique substrings
	public static int countUniqueStrings(String str) {
		for (int i = 0; i < str.length(); i++) {
			String suffix = str.substring(i);// step-1: Create all suffix
			insert(suffix);// Step-2: Insert all suffixes to Trie

		}
		return countNode(root);// Step-3:Count all nodes for root
	}

	private static int countNode(Node root) {
		if (root == null) {
			return 0;
		}

		int count = 0;
		for (int i = 0; i < 26; i++) {
			if (root.children[i] != null) {
				count += countNode(root.children[i]);
			}
		}
		return count + 1; // Current node also need to be counted
	}

	// 4.Longest word prefix
	static String ans = "";
	public static void longestWord(Node node, StringBuilder temp) {
		if (node == null) {
			return;
		}

		for (int i = 0; i < 26; i++) {
			if (node.children[i] != null && node.children[i].eow == true) {
				temp.append((char) (i + 'a')); // as index signifies the
												// character, so add a with i so
												// it become that character

				if (temp.length() > ans.length()) {
					ans = temp.toString();
				}
				longestWord(node.children[i], temp);
				temp.deleteCharAt(temp.length() - 1);
			}
		}
	}
}
