package oneD_dp;

public class L70_ClimbingStairs {
	static int[] t = new int[46];

	public static void main(String[] args) {
		int result = climbStairs(1);
		System.out.println(result);
	}

	// 1.Using simple recurssion
	public static int climbStairRecursion(int n) {
		if (n < 0) {
			return 0;
		}

		if (n == 0) {
			return 1;
		}

		int oneStep = climbStairRecursion(n - 1);
		int twoStep = climbStairRecursion(n - 2);
		return oneStep + twoStep;
	}

	// 2.Recursion using memoization
	public static int climbStairMemoization(int n) {
		if (n < 0) {
			return 0;
		}
		/*
		 * We can initialize the array with -1 and check instead we way because
		 * when n==0 the second if condition will handle that
		 */
		if (t[n] != 0) {
			return t[n];
		}
		if (n == 0) {
			return 1;
		}

		int oneStep = climbStairRecursion(n - 1);
		int twoStep = climbStairRecursion(n - 2);
		return t[n] = oneStep + twoStep;
	}

	// 3. Memoization bottom-up approach
	public static int climbStairs(int n) {
		if (n == 1 || n == 2 || n == 3) {
			return n;
		}

		int[] dp = new int[n + 1];
		dp[1] = 1;
		dp[2] = 2;

		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		return dp[n];
	}
}
