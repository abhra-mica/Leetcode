package math;

public class L172_FactorialTrailingZeroes {
	public static void main(String[] args) {
		int result = trailingZeroes(30);
		System.out.println("Number of trailing zeros= " + result);
	}

	public static int trailingZeroes(int n) {
		int result = 0;
		for (int i = 5; i <= n; i = i * 5) {
			result = result + n / i;
		}
		return result;
	}
}
