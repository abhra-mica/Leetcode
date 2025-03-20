package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L17_LetterCombinationsPhoneNumber {
	public static void main(String[] args) {
		List<String> result = letterCombinations("23");
		result.stream().forEach(i -> System.out.print(i + " "));
	}

	public static List<String> letterCombinations(String digits) {
		List<String> ans = new ArrayList<>();

		if (digits == null || digits.length() == 0) {
			return ans;
		}

		Map<Character, String> hm = new HashMap<>();
		hm.put('2', "abc");
		hm.put('3', "def");
		hm.put('4', "ghi");
		hm.put('5', "jkl");
		hm.put('6', "mno");
		hm.put('7', "pqrs");
		hm.put('8', "tuv");
		hm.put('9', "wxyz");
		backtrack(digits, 0, hm, new StringBuilder(), ans);
		return ans;
	}

	private static void backtrack(String digits, int i,
			Map<Character, String> hm, StringBuilder sb, List<String> ans) {

		if (i == digits.length()) {
			ans.add(sb.toString());
			return;
		}

		String curr = hm.get(digits.charAt(i));
		for (int k = 0; k < curr.length(); k++) {
			sb.append(curr.charAt(k));
			backtrack(digits, i + 1, hm, sb, ans);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
}
