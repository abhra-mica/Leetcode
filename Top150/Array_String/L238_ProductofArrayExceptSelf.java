package array_string;

import java.util.Arrays;

public class L238_ProductofArrayExceptSelf {
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4};
		int[] result = productExceptSelf(nums);
		Arrays.stream(result).forEach(i -> System.out.print(i + " "));
	}

	public static int[] productExceptSelf(int[] nums) {
		int[] leftProd = new int[nums.length];
		int[] rightProd = new int[nums.length];
		int[] result = new int[nums.length];

		leftProd[0] = 1;
		rightProd[rightProd.length - 1] = 1;

		for (int i = 1; i < nums.length; i++) {
			leftProd[i] = leftProd[i - 1] * nums[i - 1];
		}

		for (int i = nums.length - 2; i >= 0; i--) {
			rightProd[i] = rightProd[i + 1] * nums[i + 1];
		}

		for (int i = 0; i < nums.length; i++) {
			result[i] = leftProd[i] * rightProd[i];
		}

		return result;
	}
}
