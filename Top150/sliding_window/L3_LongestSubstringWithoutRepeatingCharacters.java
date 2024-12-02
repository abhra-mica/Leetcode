package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class L3_LongestSubstringWithoutRepeatingCharacters {
	public static void main(String[] args) {
		String s = "abcabcbb";
		int result = lengthOfLongestSubstring(s);
		System.out.println("Result= " + result);
	}

	public static int lengthOfLongestSubstring(String s) {
		int start = 0;
		int end = 0;
		int maxLength = 0;
		Map<Character, Integer> map = new HashMap<>();

		while (end < s.length()) {
			char c = s.charAt(end);

			/*
			 * If the string is "abba" after reaching 2nd index b we put start =
			 * 2 by map.get('b')+1, now when we move to 3rd index 'a'
			 * map.get('a') + 1 gives us 1 which is not need to take because we
			 * already check the more forward index for b so check max of
			 * map.get(s.charAt(end)) + 1, start
			 */
			if (map.containsKey(c)) {
				start = Math.max(start, map.get(c) + 1);
			}
			/*
			 * We need to calculate maxLength with every iteration, if we decide
			 * to calculate maxLength when duplicate character arrives then when
			 * no duplicates arise or a single character only present in the
			 * string we will get output 0, where as we should get 1.
			 */
			maxLength = Math.max(maxLength, end - start + 1);
			map.put(c, end);
			end++;
		}
		return maxLength;
	}
}
