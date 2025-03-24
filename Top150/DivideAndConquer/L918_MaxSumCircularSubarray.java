package kadane_algo;

public class L918_MaxSumCircularSubarray {
	public static void main(String[] args) {
		int[] nums = {1, -2, 3, -2};
		int result = maxSubarraySumCircular(nums);
		System.out.println("Result = " + result);

	}
	public static int maxSubarraySumCircular(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}

		int x = kaden(nums);
		int y = 0;

		for (int i = 0; i < nums.length; i++) {
			y += nums[i];
			nums[i] *= -1;
		}

		int z = kaden(nums);
		if (y + z == 0) {
			return x;
		}

		return Math.max(x, y + z);
	}

	private static int kaden(int[] nums) {
		int maxSum = Integer.MIN_VALUE, currSum = 0;

		for (int i = 0; i < nums.length; i++) {
			currSum += nums[i];
			maxSum = Math.max(maxSum, currSum);

			if (currSum < 0) {
				currSum = 0;
			}
		}
		return maxSum;
	}
}
