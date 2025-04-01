package math;

public class L50_Pow_x_n {
	public static void main(String[] args) {
		double x = 2.00000;
		int n = -2;

		double result = myPow(x, n);
		System.out.println("Result == " + result);
	}
	public static double myPow(double x, int n) {
		return solve(x, (long) n);
	}

	private static double solve(double x, long n) {
		if (n == 0) {
			return 1;
		}

		if (n < 0) {
			return solve(1 / x, -n);
		}

		if (n % 2 == 0) {
			return solve(x * x, n / 2);
		}

		return x * solve(x * x, (n - 1) / 2);
	}
}
