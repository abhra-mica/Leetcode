package binary_search;

import java.util.Arrays;

public class L34_FirstandLastPosofEleinSortedArray {
	public static void main(String[] args) {
		// int[] nums = {5, 7, 7, 8, 8, 10};
		// int target = 8;
		// int[] nums = {5, 7, 7, 8, 8, 10};
		// int target = 6;

		int[] nums = {2, 2};
		int target = 2;

		int[] result = searchRange(nums, target);
		Arrays.stream(result).forEach(i -> System.out.print(i + " "));
	}

	public static int[] searchRange(int[] nums, int target) {
		// int firstPos = firstPosition(nums, target);
		// int lastPos = lastPosition(nums, target);

		int firstPos = binarySearch(nums, target, true);
		int lastPos = binarySearch(nums, target, false);
		return new int[]{firstPos, lastPos};
	}

	public static int firstPosition(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		int mid = 0;
		while (start <= end) {
			mid = start + (end - start) / 2;
			if (nums[mid] == target
					&& (mid == 0 || nums[mid] != nums[mid - 1])) {
				return mid;
			} else if (nums[mid] >= target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

	public static int lastPosition(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		int mid = 0;
		while (start <= end) {
			mid = start + (end - start) / 2;
			if (nums[mid] == target
					&& (mid == end || nums[mid] != nums[mid + 1])) {
				return mid;
			} else if (nums[mid] <= target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return -1;
	}

	// Efficient solution
	public static int binarySearch(int[] nums, int target, boolean isStart) {
		int start = 0;
		int end = nums.length - 1;
		int index = -1;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] < target) {
				start = mid + 1;
			} else if (nums[mid] > target) {
				end = mid - 1;
			} else {// When equals to target
				index = mid;
				if (isStart) {
					end = mid - 1;// still have to explore left side to see
									// further same no exists.
				} else {
					start = mid + 1;// still have to explore right side to see
									// further same no exists.
				}
			}
		}
		return index;
	}
}
