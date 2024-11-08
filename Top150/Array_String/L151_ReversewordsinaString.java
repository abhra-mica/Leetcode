package array_string;

public class L151_ReversewordsinaString {
	public static void main(String[] args) {
		String s = "  hello world  ";
		String result = reverseWords(s);
		System.out.println(result);
	}

	public static String reverseWords(String s) {
		int i = 0;
		int j = 0;
		// StringBuilder sb = new StringBuilder();
		String word = null;
		String result = "";
		while (i < s.length()) {
			// Find the start of a word
			while (i < s.length() && s.charAt(i) == ' ') {
				i++;
			}
			// Find end of a word
			j = i;
			while (j < s.length() && s.charAt(j) != ' ') {
				j++;
			}

			word = s.substring(i, j);
			// sb.insert(0, word);
			result = word + " " + result;
			i = j + 1;
		}
		return result.trim();
	}
}
