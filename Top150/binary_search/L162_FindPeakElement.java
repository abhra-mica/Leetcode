package binary_search;

public class L162_FindPeakElement {
	public static void main(String[] args) {
		int[] nums = {1, 2, 1, 3, 5, 6, 4};
		int result = findPeakElement(nums);
		System.out.println("Result= " + result);
	}

	public static int findPeakElement(int[] nums) {
		int start = 0;
		int end = nums.length - 1;
		int mid = 0;
		while (start <= end) {
			mid = (start + end) / 2;

			if ((mid == 0 || nums[mid] > nums[mid - 1])
					&& (mid == nums.length - 1 || nums[mid] > nums[mid + 1])) {
				return mid;
			} else if (nums[mid + 1] > nums[mid]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return mid;
	}
}
