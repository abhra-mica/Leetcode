package two_pointers;

public class L125_ValidPalindrome {
	public static void main(String[] args) {
		String s = "A man, a plan, a canal: Panama";
		System.out.println(isPalindrome(s));
	}

	public static boolean isPalindrome(String s) {
		int start = 0;
		int end = s.length() - 1;

		while (start < end) {
			while (!Character.isLetterOrDigit(s.charAt(start)) && start < end) {
				start++;
			}
			while (!Character.isLetterOrDigit(s.charAt(end)) && start < end) {
				end--;
			}

			if (Character.toLowerCase(s.charAt(start)) != Character
					.toLowerCase(s.charAt(end))) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
}
