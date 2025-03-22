package backtracking;

import java.util.ArrayList;
import java.util.List;

public class L39_CombinationSum {
	public static void main(String[] args) {
		int[] candidates = {2, 3, 6, 7};
		int target = 7;
		List<List<Integer>> result = combinationSum(candidates, target);
		System.out.println(result);
	}

	public static List<List<Integer>> combinationSum(int[] candidates,
			int target) {
		List<List<Integer>> ans = new ArrayList<>();
		findCombinations(0, candidates, target, ans, new ArrayList<>());
		return ans;
	}

	private static void findCombinations(int idx, int[] arr, int target,
			List<List<Integer>> ans, List<Integer> ds) {

		if (idx == arr.length) {
			if (target == 0) {
				ans.add(new ArrayList<>(ds));
			}
			return;
		}

		if (arr[idx] <= target) {
			ds.add(arr[idx]);
			findCombinations(idx, arr, target - arr[idx], ans, ds);
			ds.remove(ds.size() - 1);
		}
		findCombinations(idx + 1, arr, target, ans, ds);
	}
}
