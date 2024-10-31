package intervals;

import java.util.ArrayList;
import java.util.List;

public class L228_SummaryRanges {
	public static void main(String[] args) {
		// int[] nums = {0, 1, 2, 4, 5, 7};
		int[] nums = {0, 2, 3, 4, 6, 8, 9};
		List<String> result = summaryRanges(nums);
		System.out.println("Ranges== " + result);
	}

	public static List<String> summaryRanges(int[] nums) {
		int start = 0;
		int end = 0;
		String s = null;
		List<String> list = new ArrayList<>();
		while (end < nums.length) {
			if (end == nums.length - 1 || nums[end + 1] - nums[end] != 1) {
				if (start == end) {
					s = nums[start] + "";
					list.add(s);
				} else {
					s = nums[start] + "->" + nums[end];
					list.add(s);
				}
				start = end + 1;
			}
			end++;
		}
		return list;
	}
}
