public class L27_RemoveElement {
	public static void main(String[] args) {
		int[] nums = {3};
		int val = 3;
		System.out.println(removeElement(nums, val));
	}
	
	public static int removeElement(int[] nums, int val) {
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				nums[index] = nums[i];
				index++;
			}
		}
		return index;
	}

	public static int removeElement(int[] nums, int val) {
		int start = 0;
		int end = nums.length - 1;

		if (end < 0) { // If array is empty
			return 0;
		}
		// The while loop will exist when start == end
		while (start < end) {
			if (nums[start] == val) {
				nums[start] = nums[end--];
			} else {
				start++;
			}
		}
		// if nums[start] == val then simply return start because 0 indexed
		// array , if not then current nums[start] element also need to
		// consider, so start + 1
		return nums[start] == val ? start : start + 1;
	}
}
