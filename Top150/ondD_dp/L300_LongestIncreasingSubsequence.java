package oneD_dp;

import java.util.Arrays;

public class L300_LongestIncreasingSubsequence {
	public static void main(String[] args) {
		int[] nums = {0, 1, 0, 3, 2, 3};
		int result = lengthOfLIS(nums);
		System.out.println("Maximum Longest Increasing Subsequence= " + result);
	}

	public static int lengthOfLIS(int[] nums) {
		int[] dp = new int[nums.length];
		Arrays.fill(dp, 1);

		for (int i = 1; i < nums.length; i++) {
			int j = i - 1;
			while (j >= 0) {
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
				j--;
			}
		}

		int maxLength = 0;
		for (int i : dp) {
			maxLength = Math.max(maxLength, i);
		}

		return maxLength;
	}
}
