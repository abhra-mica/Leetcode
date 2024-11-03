package math;
import java.util.Arrays;

public class L66_PlusOne {
	public static void main(String[] args) {
		int[] digits = {1, 2, 3};
		int[] result = plusOne(digits);
		Arrays.stream(result).forEach(x -> System.out.print(x + " "));
	}

	public static int[] plusOne(int[] digits) {
		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] < 9) {
				digits[i] = digits[i] + 1;
				return digits;
			}
			digits[i] = 0;
		}

		int[] arr = new int[digits.length + 1];
		arr[0] = 1;
		return arr;
	}
}
