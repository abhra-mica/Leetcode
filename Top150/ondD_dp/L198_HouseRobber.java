package oneD_dp;

import java.util.Arrays;

public class L198_HouseRobber {
	static int[] t = new int[101];
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 1};
		int robAmount = rob_bottom_up(nums);
		System.out.println("Robbed Amount= " + robAmount);
	}

	public static int rob(int[] nums) {
		int n = nums.length;
		Arrays.fill(t, -1);

		return solveMemoization(nums, 0, n);
	}

	public static int solve(int[] nums, int i, int n) {
		if (i >= n) {
			return 0;
		}

		int steal = nums[i] + solve(nums, i + 2, n);
		int skip = solve(nums, i + 1, n);
		return Math.max(steal, skip);
	}

	public static int solveMemoization(int[] nums, int i, int n) {
		if (i >= n) {
			return 0;
		}

		if (t[i] != -1) {
			return t[i];
		}

		int steal = nums[i] + solve(nums, i + 2, n);
		int skip = solve(nums, i + 1, n);
		return t[i] = Math.max(steal, skip);
	}

	public static int rob_bottom_up(int[] nums) {
		int n = nums.length;

		if (n == 1) {
			return nums[0];
		}

		int[] t = new int[n + 1];

		// No house
		t[0] = 0;

		// One house
		t[1] = nums[0];

		for (int i = 2; i <= n; i++) {
			int steal = nums[i - 1] + t[i - 2];
			int skip = t[i - 1];
			t[i] = Math.max(steal, skip);
		}
		return t[n];
	}
}
