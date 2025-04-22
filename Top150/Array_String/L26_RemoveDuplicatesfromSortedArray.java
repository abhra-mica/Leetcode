public class L26_RemoveDuplicatesfromSortedArray {
	public static void main(String[] args) {
		int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
		System.out.println(removeDuplicates(nums));
	}

	public static int removeDuplicates(int[] nums) {
		if (nums.length < 2) {
			return nums.length;
		}

		int index = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[index] != nums[i]) {
				nums[++index] = nums[i];
			}
		}
		return index + 1;
	}

	    //Another way
    public static int removeDuplicates1(int[] nums) {
        int start = 0;
        int end = 0;

        while (end < nums.length) {
            if (nums[start] != nums[end]) {
                nums[++start] = nums[end];
            }
            end++;
        }
        return start + 1;
    }
}
