package math;

public class L9_PalindromeNumber {
	public static void main(String[] args) {
		int x = 10;
		boolean result = isPalindrome(x);
		System.out.println("Palindrome = " + result);

	}
	public static boolean isPalindrome(int x) {
		/*
		 * Suppose 1210, ending with zero can't be a palindrome. x!=0 ==> if the
		 * number is only zero then itself a palindrome number
		 */
		if (x < 0 || (x % 10 == 0 && x != 0)) {
			return false;
		}

		int reversedNo = 0;
		// Through below code we are checking half of the number.
		while (x > reversedNo) {
			reversedNo = reversedNo * 10 + x % 10;
			x = x / 10;
		}
		/*
		 * suppose 121, one point x=1 and reversedNo=12 then the second or
		 * condition will work
		 */
		return x == reversedNo || x == reversedNo / 10;
	}
									
   }
}
