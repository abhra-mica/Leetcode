public class L58_LengthofLastWord {
	public static void main(String[] args) {
		String s = "Hello World";
		int result = lengthOfLastWord(s);
		System.out.println("Last word length= " + result);
	}

	public static int lengthOfLastWord(String s) {
		s = s.trim();
		int count = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == ' ') {
				break;
			}
			count++;
		}
		return count;
	}
}
