
public class L670_MaximumSwap {
	public static void main(String[] args) {
		int num = 2736;
		// int result = maximumSwap(num);
		int result = maximumSwapGreedyApproach(num);
		System.out.println("Max value after swap = " + result);
	}

	// Using 2-Parse Solution
	public static int maximumSwap(int num) {
		if (num <= 10) {// if single digit or 10 we can't do anything
			return num;
		}

		// Convert the given number to string and then in integer array and fill
		// up the array with the given number's digits to make seemless process
		String digits = Integer.toString(num);
		int[] nums = new int[digits.length()];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(digits.charAt(i) + "");
		}

		// rightMax hold the max elements at right for every element. Assign
		// last index with it's own index as there is no right element
		int[] rightMax = new int[digits.length()];
		rightMax[rightMax.length - 1] = rightMax.length - 1;

		/*
		 * An element can itself be the max element for right side if it is
		 * greater than the next element, else next element's right max element
		 * is it's right most max element too.
		 */
		for (int i = rightMax.length - 2; i >= 0; i--) {
			rightMax[i] = nums[i] > nums[i + 1] ? i : i + 1;
		}

		// Traverse from left to right to find the swap pair, and swap the
		// numbers

		for (int i = 0; i < rightMax.length - 1; i++) {
			if (rightMax[i] != i) {
				int temp = nums[rightMax[i]];
				nums[rightMax[i]] = nums[i];
				nums[i] = temp;
				break;
			}
		}

		// Form the number again from nums
		int result = 0;
		for (int i : nums) {
			result = result * 10 + i;
		}
		return result;
	}

	// 1-pass(Greedy) approach
	public static int maximumSwapGreedyApproach(int num) {
		String digits = Integer.toString(num);
		int[] nums = new int[digits.length()];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(digits.charAt(i) + "");
		}

		int max_val_idx = nums.length - 1;
		int swapRight = nums.length - 1;
		int swapLeft = -1;

		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] > nums[max_val_idx]) {
				max_val_idx = i;
			} else {
				swapLeft = i;
				swapRight = max_val_idx;
			}
		}

		// swapping the value
		int temp = nums[swapLeft];
		nums[swapLeft] = nums[swapRight];
		nums[swapRight] = temp;

		// Form the number again from nums
		int result = 0;
		for (int i : nums) {
			result = result * 10 + i;
		}

		return result;
	}
}
