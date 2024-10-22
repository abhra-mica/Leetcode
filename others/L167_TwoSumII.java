public class L167_TwoSumII {
	public int[] twoSum(int[] numbers, int target) {
		int begin = 0;
		int end = numbers.length - 1;
		int sum = 0;
		while (begin < end) {
			if (target == sum) {
				return new int[] { begin + 1, end + 1 };
			} else if (sum < target) {
				begin++;
			} else {
				end--;
			}
		}
		return new int[] {};
	}
}
