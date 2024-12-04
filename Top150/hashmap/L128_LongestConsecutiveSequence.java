package hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class L128_LongestConsecutiveSequence {
	public static void main(String[] args) {
		int[] arr = {1, 9, 3, 10, 4, 20, 2};
		int result = consecutiveSubSequenceII(arr);
		System.out.println("Longest consecuitive sequence= " + result);
	}

	// All test cases pass in leetcode
	public static int consecutiveSubSequenceII(int[] nums) {
		Set<Integer> set = new HashSet<>();
		int longestConsecutiveSeq = 0;

		for (int i : nums) {
			set.add(i);
		}

		for (int i = 0; i < nums.length; i++) {
			int currentConsecutiveSeq = 1;
			// start of the sequence
			if (!set.contains(nums[i] - 1)) {
				int nextNum = nums[i] + 1;
				while (set.contains(nextNum)) {
					currentConsecutiveSeq++;
					nextNum++;
				}
				longestConsecutiveSeq = Math.max(longestConsecutiveSeq,
						currentConsecutiveSeq);
			}
		}
		return longestConsecutiveSeq;
	}

	// Get time limit exceeded error
	public static int consecutiveSubsequence(int[] nums) {
		Map<Integer, Boolean> map = new HashMap<>();
		int longestConsecutiveSeq = 0;

		for (int i : nums) {
			map.put(i, false);
		}

		for (int i = 0; i < nums.length; i++) {
			// We move if we didn't taken the number previously
			int currentConsecutiveSequence = 1;
			if (!map.get(nums[i])) {
				map.put(nums[i], true);
				int nextNum = nums[i] + 1;
				// moving forward
				while (map.containsKey(nextNum) && map.get(nextNum) == false) {
					currentConsecutiveSequence++;
					nextNum++;
				}

				// moving backward
				int prevName = nums[i] - 1;
				while (map.containsKey(prevName)
						&& map.get(prevName) == false) {
					currentConsecutiveSequence++;
					prevName--;
				}
			}
			longestConsecutiveSeq = Math.max(longestConsecutiveSeq,
					currentConsecutiveSequence);
		}
		return longestConsecutiveSeq;
	}
}
