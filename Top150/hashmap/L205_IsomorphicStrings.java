package hashmap;

import java.util.HashMap;
import java.util.Map;

public class L205_IsomorphicStrings {
	public static void main(String[] args) {
		String s = "egg";
		String t = "add";
		boolean result = isIsomorphic(s, t);
		System.out.println("Isomorphic== " + result);
	}

	public static boolean isIsomorphic(String s, String t) {
		Map<Character, Character> map = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			char replacement = s.charAt(i);
			char original = t.charAt(i);
			if (!map.containsKey(replacement)) {
				if (!map.containsValue(original)) {
					map.put(replacement, original);
				} else {
					return false;
				}
			} else {
				if (map.get(replacement) != original) {
					return false;
				}
			}
		}
		return true;
	}
}
