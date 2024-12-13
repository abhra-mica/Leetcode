package binary_search;
//Works for both unique and repetitive elements
public class L153_FindMinRotatedSortedArray {
	public static void main(String[] args) {
		int[] nums = {4, 4, 5, 5, 5, 6, 7, 0, 0, 0, 1, 2};
		int result = findMin(nums);
		System.out.println("Min number= " + result);
	}

	public static int findMin(int[] nums) {
		int start = 0;
		int end = nums.length - 1;
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] > nums[end]) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		return nums[start];
	}
}
