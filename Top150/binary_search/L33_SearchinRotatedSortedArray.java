package binary_search;

public class L33_SearchinRotatedSortedArray {
	public static void main(String[] args) {
		int[] nums = {4, 5, 6, 7, 0, 1, 2};
		int target = 0;
		int result = search(nums, target);
		System.out.println("Result = " + result);
	}
	public static int search(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		int mid = 0;

		while (start <= end) {
			mid = start + (end - start) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] <= nums[end]) {// array is right sorted
				if (target > nums[mid] && target <= nums[end]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			} else {// If the array is left sorted
				if (target < nums[mid] && target >= nums[start]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			}
		}
		return -1;
	}
}
