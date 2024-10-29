public class L169_MajorityElement {
	public static void main(String[] args) {
		int[] nums = {3, 2, 3};
		int result = majorityElement(nums);
		System.out.print("Majority Element= " + result);
	}

	public static int majorityElement(int[] nums) {
		int count = 0;
		int majorityElement = 0;

		for (int ele : nums) {
			if (count == 0) {
				majorityElement = ele;
			}
			if (ele == majorityElement) {
				count++;
			} else {
				count--;
			}
		}
		return majorityElement;
	}
}
