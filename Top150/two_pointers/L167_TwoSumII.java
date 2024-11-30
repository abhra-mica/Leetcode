package two_pointer;

import java.util.Arrays;

public class L167_TwoSumII {
	public static void main(String[] args) {
		int[] numbers = {2, 7, 11, 15};
		int target = 9;
		int[] result = twoSum(numbers, target);
		Arrays.stream(result).forEach(System.out::println);
	}

	public static int[] twoSum(int[] numbers, int target) {
		int start = 0;
		int end = numbers.length - 1;
		int[] ans = new int[2];

		while (start < end) {
			if (numbers[start] + numbers[end] == target) {
				ans[0] = start + 1;
				ans[1] = end + 1;
				return ans;
			} else if (numbers[start] + numbers[end] < target) {
				start++;
			} else {
				end--;
			}
		}
		return ans;
	}
}
