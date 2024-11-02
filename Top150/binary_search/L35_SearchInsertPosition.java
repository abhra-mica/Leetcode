package binary_search;

public class L35_SearchInsertPosition {
	public static void main(String[] args) {
		int[] nums = {4, 5, 6, 7, 8, 9};
		int target = 1;
		int result = searchInsert(nums, target);
		System.out.println("Insert Position == " + result);
	}
	public static int searchInsert(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		int mid = -1;
		while (start <= end) {
			mid = start + (end - start) / 2;

			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return start;
	}
}
