package hashmap;
import java.util.HashMap;
import java.util.Map;

public class L242_ValidAnagram {
	public static void main(String[] args) {
		String s = "anagram";
		String t = "nagaram";
		boolean result = isAnagram(s, t);
		System.out.println("Is Aanagram= " + result);
	}

	public static boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}

		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
			map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
		}

		for (char c : map.keySet()) {
			if (map.get(c) != 0) {
				return false;
			}
		}
		return true;
	}
}
