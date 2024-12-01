package sliding_window;

public class L209_MinimumSizeSubarraySum {
	public static void main(String[] args) {
		int[] nums = {2, 0, 0, 0, 3};
		int target = 3;
		int result = minSubArrayLen(target, nums);
		System.out.println("Result= " + result);
	}

	public static int minSubArrayLen(int target, int[] nums) {
		int sum = 0;
		int minLength = Integer.MAX_VALUE;
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			sum = sum + nums[i];
			// This while loop will work because when sum is greater than target
			// then it's length is obviously greater when sum == target
			while (sum >= target) {
				minLength = Math.min(minLength, i - index + 1);
				sum = sum - nums[index++];
			}
		}
		return minLength == Integer.MAX_VALUE ? 0 : minLength;
	}
}
