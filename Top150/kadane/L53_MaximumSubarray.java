package kadane_algo;

import java.util.Arrays;

public class L53_MaximumSubarray {
	public static void main(String[] args) {
		int[] nums = {3, -4, 5, 4, -1, 7, -8};
		System.out.println("Max Sum = " + maxSumArray(nums));
		Arrays.stream(maxSumSubArrayLength(nums))
				.forEach(i -> System.out.print(i + " "));
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

	// Below example to get the max sum subarray
	public static int[] maxSumSubArrayLength(int[] nums) {
		int maxSum = Integer.MIN_VALUE, currSum = 0;
		int start = 0, finalStart = 0;
		int end = 0;

		for (int i = 0; i < nums.length; i++) {
			currSum += nums[i];
			if (currSum > maxSum) {
				maxSum = currSum;
				end = i;
				finalStart = start;
			}

			if (currSum < 0) {
				currSum = 0;
				start = i + 1;
			}
		}
		return new int[]{finalStart, end};
	}
}
