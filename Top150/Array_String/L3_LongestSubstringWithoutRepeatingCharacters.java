package array_string;

import java.util.HashMap;
import java.util.Map;

public class L3_LongestSubstringWithoutRepeatingCharacters {
	public static void main(String[] args) {
		String s = "abba";
		int result = lengthOfLongestSubstring(s);
		System.out.println("Max Length = " + result);

	}

	public static int lengthOfLongestSubstring(String s) {
		int start = 0;
		int end = 0;
		int maxLength = 0;

		Map<Character, Integer> map = new HashMap<>();
		while (end < s.length()) {
			if (map.containsKey(s.charAt(end))) {

				start = Math.max(map.get(s.charAt(end)) + 1, start);// If the string is "abba" after
																	// reaching 2nd index b we put
																	// start = 2 by map.get('b')+1,
																	// now when we move to 3rd index 'a'
																	// map.get('a') + 1 gives us 1
																	// which is not need to take
																	// because we already check the
																	// more forward index for b so check
																	//  max of map.get(s.charAt(end)) + 1, start
			}

			map.put(s.charAt(end), end);
			maxLength = Math.max(maxLength, end - start + 1);
			end++;

		}
		return maxLength;
	}
}
