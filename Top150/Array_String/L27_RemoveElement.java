public class L27_RemoveElement {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        int result = removeElement(nums, val);
        System.out.println("No. of unique elements = " + result);
    }

    public static int removeElement(int[] nums, int val) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            if (nums[start] == val) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end--] = temp;
            } else {
                start++;
            }
        }
        return start;
    }
}
