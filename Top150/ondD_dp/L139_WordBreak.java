package oneD_dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L139_WordBreak {
	private static Boolean[] t;
	public static void main(String[] args) {
		/*
		 * String s = "leetcode"; List<String> wordDict = Arrays.asList("leet",
		 * "code"); boolean result = wordBreak(s, wordDict);
		 * System.out.println("Word Contains: " + result);
		 */
		// =======================

		/*
		 * String s1 =
		 * "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
		 * List<String> wordDict1 = Arrays.asList("a", "aa", "aaa", "aaaa",
		 * "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa");
		 * 
		 * t = new Boolean[s1.length()]; boolean result1 = wordBreak(s1,
		 * wordDict1); System.out.println("Word Contains memoize: " + result1);
		 */

		// ===================================

		String s = "catsandog";
		List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
		boolean result = wordBreakDP(s, wordDict);
		System.out.println("Word Contain DP: " + result);
	}

	public static boolean wordBreak(String s, List<String> wordDict) {
		// return solve(s, 0, wordDict);
		return solveMemoize(s, 0, wordDict);
	}

	/*
	 * Get time limit exceeded for
	 * "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
	 * aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"
	 * wordDict
	 * =["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa"
	 * ,"aaaaaaaaaa"]
	 */
	private static boolean solve(String s, int idx, List<String> wordDict) {
		if (idx == s.length()) {
			return true;
		}

		for (int endIdx = idx + 1; endIdx <= s.length(); endIdx++) {
			String split = s.substring(idx, endIdx);

			if (wordDict.contains(split) && solve(s, endIdx, wordDict)) {
				return true;
			}
		}
		return false;
	}

	// Memoize to overcome time limit exceeded problem
	private static boolean solveMemoize(String s, int idx,
			List<String> wordDict) {
		if (idx == s.length()) {
			return true;
		}

		if (t[idx] != null) {
			return t[idx];
		}
		for (int endIdx = idx + 1; endIdx <= s.length(); endIdx++) {
			String split = s.substring(idx, endIdx);

			if (wordDict.contains(split) && solveMemoize(s, endIdx, wordDict)) {
				return t[idx] = true;
			}
		}
		return t[idx] = false;
	}

	public static boolean wordBreakDP(String s, List<String> wordDict) {
		// For O(1) lookups
		Set<String> wordSet = new HashSet<>(wordDict);

		int maxLength = 0;
		for (String word : wordSet) {
			maxLength = Math.max(maxLength, word.length());
		}

		int n = s.length();

		// dp[i] states if the substring s[0...i] can be segmented
		boolean[] dp = new boolean[n + 1];

		dp[0] = true;
		for (int i = 1; i <= n; i++) {
			// check prefixes of lengthup to maxlength
			for (int j = i - 1; j >= Math.max(0, i - maxLength); j--) {
				if (dp[j] && wordSet.contains(s.subSequence(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[n];
	}
}
