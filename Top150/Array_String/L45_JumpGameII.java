package array_string;

public class L45_JumpGameII {
	public static void main(String[] args) {
		int[] nums = {0};
		System.out.println(jump(nums));
	}

	public static int jump(int[] nums) {
		if (nums.length == 0 || nums.length == 1) {
			return 0;
		}

		int jump = 0;
		int destination = 0;
		int coverage = 0;

		for (int i = 0; i <= nums.length - 1; i++) {
			destination = Math.max(destination, i + nums[i]);

			if (i == coverage) {
				coverage = destination;
				jump++;

				if (destination >= nums.length - 1) {
					return jump;
				}
			}
		}
		return -1;
	}
}
