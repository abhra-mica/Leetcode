package hashmap;

import java.util.HashMap;
import java.util.Map;

public class L290_WordPattern {
	public static void main(String[] args) {
		String pattern = "abba";
		// String s = "dog dog dog dog";
		String s = "dog cat cat dog";
		boolean result = wordPattern(pattern, s);
		System.out.println("Pattern matched = " + result);

	}
	public static boolean wordPattern(String pattern, String s) {
		Map<Character, String> map = new HashMap<>();
		String[] words = s.split(" ");

		if (words.length != pattern.length()) {
			return false;
		}

		for (int i = 0; i < pattern.length(); i++) {
			char curr = pattern.charAt(i);
			if (!map.containsKey(curr) && !map.containsValue(words[i])) {
				map.put(curr, words[i]);
			} else if (!words[i].equals(map.get(curr))) {
				return false;
			}
		}
		return true;
	}
}
