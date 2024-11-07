package array_string;

public class L80_RemoveDuplicatesfromSortedArrayII {
	public static void main(String[] args) {
		int[] nums = {1, 1, 1, 2, 2, 3, 4, 5, 6, 6, 6, 6};
		int result = removeDuplicates(nums);
		System.out.println("Total Unique Count== " + result);
	}

	public static int removeDuplicates(int[] nums) {
		int index = 0;
		for (int ele : nums) {
			if (index == 0 || index == 1 || nums[index - 2] != ele) {
				nums[index++] = ele;
			}
		}
		return index;
	}
}
