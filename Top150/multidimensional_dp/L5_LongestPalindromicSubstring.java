package multidimensional_dp;

//Recursive and Recursive with memoization is not tested in leetcode
public class L5_LongestPalindromicSubstring {
	static boolean[][] t = new boolean[101][101];
	public static void main(String[] args) {
		String s = "cabba";
		String result = longestPalindromeMemoization(s);
		System.out.println("Longest Palindrome Substring=" + result);

	}
	public static String longestPalindrome(String s) {
		if (s.length() <= 1) {
			return s;
		}

		String lpSub = s.charAt(0) + "";
		for (int i = 0; i < s.length(); i++) {
			// For odd palindrom

			int start = i;
			int end = i;
			while (s.charAt(start) == s.charAt(end)) {
				start--;
				end++;
				if (start == -1 || end == s.length()) {
					break;
				}
			}
			String temp = s.substring(start + 1, end);
			if (lpSub.length() < temp.length()) {
				lpSub = temp;
			}

			start = i;
			end = i + 1;
			while (end != s.length() && s.charAt(start) == s.charAt(end)) {
				start--;
				end++;
				if (start == -1 || end == s.length()) {
					break;
				}
			}
			temp = s.substring(start + 1, end);
			if (lpSub.length() < temp.length()) {
				lpSub = temp;
			}

		}
		return lpSub;
	}

	// Recursive process[WIthout memoization, in leetcode constraint is very
	// less, so it will not give TLE
	public static String longestPalindromeRec(String s) {
		int n = s.length();
		int maxLen = -1;
		int startPoint = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (solve(s, i, j) == true) {
					if (j - i + 1 > maxLen) {
						maxLen = j - i + 1;
						startPoint = i;
					}
				}
			}
		}
		return s.substring(startPoint, startPoint + maxLen);
	}

	public static boolean solve(String s, int i, int j) {
		if (i >= j) {
			return true;
		}

		if (s.charAt(i) == s.charAt(j)) {
			return solve(s, i + 1, j - 1);
		}

		return false;
	}

	public static String longestPalindromeMemoization(String s) {
		int n = s.length();
		int maxLen = -1;
		int startPoint = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (solveMemoize(s, i, j) == true) {
					if (j - i + 1 > maxLen) {
						maxLen = j - i + 1;
						startPoint = i;
					}
				}
			}
		}
		return s.substring(startPoint, startPoint + maxLen);
	}

	public static boolean solveMemoize(String s, int i, int j) {
		if (i >= j) {
			return true;
		}

		if (t[i][j] == true) {
			return t[i][j];
		}

		if (s.charAt(i) == s.charAt(j)) {
			return t[i][j] = solve(s, i + 1, j - 1);
		}

		return t[i][j] = false;
	}

}
