package oneD_dp;

import java.util.Arrays;

public class L198_HouseRobber {
	static Integer[] aux = null;
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 1};
		int robAmount = rob(nums);
		System.out.println("Robbed Amount= " + robAmount);
	}

	public static int rob(int[] nums) {
		int totalHouses = nums.length;
		// aux = new Integer[totalHouses];
		return solveDP(nums);

	}

	private static int solve(int[] nums, int houseNo, int totalHouses) {
		if (houseNo >= totalHouses) {
			return 0;
		}

		int steal = nums[houseNo] + solve(nums, houseNo + 2, totalHouses);
		int skip = solve(nums, houseNo + 1, totalHouses);

		return Math.max(steal, skip);
	}

	private static int solveMemoize(int[] nums, int houseNo, int totalHouses) {
		if (houseNo >= totalHouses) {
			return 0;
		}

		if (aux[houseNo] != null) {
			return aux[houseNo];
		}

		int steal = nums[houseNo] + solve(nums, houseNo + 2, totalHouses);
		int skip = solve(nums, houseNo + 1, totalHouses);
		return aux[houseNo] = Math.max(steal, skip);
	}

	private static int solveDP(int[] nums) {
		int n = nums.length;
		Integer[] aux = new Integer[n];
		aux[0] = nums[0];
		aux[1] = Math.max(aux[0], nums[0]);

		for (int i = 2; i < n; i++) {
			aux[i] = Math.max(nums[i] + aux[i - 2], aux[i - 1]);
		}

		return aux[n - 1];
	}
}
