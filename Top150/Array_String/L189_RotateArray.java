package array_string;

import java.util.Arrays;

public class L189_RotateArray {
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5, 6, 7};
		int k = 3;
		rotate(nums, k);
		Arrays.stream(nums).forEach((i) -> System.out.print(i + " "));
	}

	public static void rotate(int[] nums, int k) {
		k = k % nums.length;
		reverse(nums, 0, nums.length - k - 1);
		reverse(nums, nums.length - k, nums.length - 1);
		reverse(nums, 0, nums.length - 1);
	}

	public static void reverse(int[] nums, int start, int end) {
		while (start <= end) {
			int temp = nums[start];
			nums[start++] = nums[end];
			nums[end--] = temp;
		}
	}
}
