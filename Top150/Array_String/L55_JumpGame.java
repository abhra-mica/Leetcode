package array_string;

public class L55_JumpGame {
	public static void main(String[] args) {
		int[] nums = {2, 0, 1, 0, 4};
		System.out.println("Can Jump ==> " + canJump(nums));
	}

	public static boolean canJump(int[] nums) {
		int finalDestination = nums.length - 1;
		for (int i = nums.length - 2; i >= 0; i--) {
			if (i + nums[i] >= finalDestination) {
				finalDestination = i;
			}
		}
		return finalDestination == 0;
	}
}
