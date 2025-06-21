package oneD_dp;

public class L213_HouseRobberII {
	public static void main(String[] args) {
		int[] nums = {2};
		int robAmount = rob(nums);
		System.out.println("Robbed Amount= " + robAmount);
	}

	public static int rob(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}
		int[] skipLastHouse = new int[nums.length - 1];
		int[] skipFirstHouse = new int[nums.length - 1];

		for (int i = 0; i < nums.length - 1; i++) {
			skipLastHouse[i] = nums[i];
			skipFirstHouse[i] = nums[i + 1];
		}

		return Math.max(solveDP(skipFirstHouse), solveDP(skipLastHouse));
	}

	private static int solveDP(int[] nums) {
		// Below two if blocks to check for [0] and [0,0] type houses
		if (nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		int n = nums.length;
		Integer[] aux = new Integer[n];
		aux[0] = nums[0];
		aux[1] = Math.max(aux[0], nums[1]);

		for (int i = 2; i < n; i++) {
			aux[i] = Math.max(nums[i] + aux[i - 2], aux[i - 1]);
		}

		return aux[n - 1];
	}
}
