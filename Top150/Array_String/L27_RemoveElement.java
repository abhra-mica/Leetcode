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

	//Not give correct output like nums = {3}, val = 3
	public static int removeElementImproper(int[] nums, int val) {
		int start = 0;
		int end = nums.length - 1;

		while (start < end) {
			if (nums[start] == val) {
				int temp = nums[start];
				nums[start] = nums[end];
				nums[end] = temp;
				end--;
			} else {
				start++;
			}
		}
		return start + 1;
	}
}
