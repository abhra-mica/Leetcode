import java.util.HashMap;
import java.util.Map;

public class L13_RomanToInteger {
	public static void main(String[] args) {
		String roman = "III";
		System.out.println(romanToInt(roman));
	}

 public static int romanToInt(String s) {
        Map<Character, Integer> intRomans = new HashMap<>();
        intRomans.put('I', 1);
        intRomans.put('V', 5);
        intRomans.put('X', 10);
        intRomans.put('L', 50);
        intRomans.put('C', 100);
        intRomans.put('D', 500);
        intRomans.put('M', 1000);

        int length = s.length() - 1;
        int number = intRomans.get(s.charAt(length--));

        while (length >= 0) {
            if (intRomans.get(s.charAt(length)) >= intRomans.get(s.charAt(length + 1))) {
                number += intRomans.get(s.charAt(length));
            } else {
                number -= intRomans.get(s.charAt(length));
            }
            length--;
        }
        return number;
    }
}
