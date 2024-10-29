import java.util.HashMap;
import java.util.Map;

public class L13_RomanToInteger {
	public static void main(String[] args) {
		String roman = "III";
		System.out.println(romanToInt(roman));

	}

	public static int romanToInt(String roman) {
		Map<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);

		int result = map.get(roman.charAt(roman.length() - 1));

		for (int i = roman.length() - 2; i >= 0; i--) {
			if (map.get(roman.charAt(i)) >= map.get(roman.charAt(i + 1))) {
				result += map.get(roman.charAt(i));
			} else {
				result -= map.get(roman.charAt(i));
			}
		}
		return result;
	}
}
