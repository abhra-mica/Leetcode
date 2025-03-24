package kadane_algo;

public class L53_MaximumSubarray {
	public static void main(String[] args) {
		int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		System.out.println("Max Sum = " + maxSumArray(nums));
	}

	public static int maxSumArray(int[] nums) {
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
