package backtracking;

import java.util.ArrayList;
import java.util.List;

public class L78_Subsets {
	public static void main(String[] args) {
		List<List<Integer>> ans = subsets(new int[]{1, 2, 3});
		System.out.println(ans);

	}
	public static List<List<Integer>> subsets(int[] arr) {
		List<Integer> curr = new ArrayList<>();
		List<List<Integer>> ans = new ArrayList<>();
		backtrack(arr, 0, curr, ans);
		return ans;
	}

	public static void backtrack(int[] arr, int i, List<Integer> curr,
			List<List<Integer>> ans) {
		if (i == arr.length) {
			ans.add(new ArrayList<>(curr));
			return;
		}

		curr.add(arr[i]);
		backtrack(arr, i + 1, curr, ans);
		curr.remove(curr.size() - 1);
		backtrack(arr, i + 1, curr, ans);
	}
}
