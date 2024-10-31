package stack;
//This solution done without using stack
public class L20_ValidParentheses {
	public static void main(String[] args) {
		String s = "()[]{}";
		boolean result = isValid(s);
		System.out.println("Valid Parenthesis= " + result);
	}

	public static boolean isValid(String s) {
		while (true) {
			if (s.contains("()")) {
				s = s.replace("()", "");
			} else if (s.contains("{}")) {
				s = s.replace("{}", "");
			} else if (s.contains("[]")) {
				s = s.replace("[]", "");
			} else {
				return s.isEmpty();
			}
		}
	}
}
