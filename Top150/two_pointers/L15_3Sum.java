package two_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L15_3Sum {
	public static void main(String[] args) {
		int[] nums = {-1, 0, 1, 2, -1, -4};
		List<List<Integer>> result = threeSum(nums);
		System.out.println(result);
	}
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) { // if we do nums[i+1] then can't able to solve -1,-1,2 solution 
				continue;
			}

			int j = i + 1;
			int k = nums.length - 1;

			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				if (sum == 0) {
					result.add(Arrays.asList(nums[i], nums[j], nums[k]));
					while (j < k && nums[k] == nums[k - 1]) {
						k--;
					}
					while (j < k && nums[j] == nums[j + 1]) {
						j++;
					}
					j++;
					k--;
				} else if (sum > 0) {
					k--;
				} else {
					j++;
				}
			}
		}
		return result;
	}
}
