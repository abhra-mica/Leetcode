package backtracking;

import java.util.ArrayList;
import java.util.List;

public class L77_Combinations {
	public static void main(String[] args) {
		combine(5, 2);
	}

	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<>();
		backtrack(1, n, k, new ArrayList<Integer>(), result);
		return result;
	}

	private static void backtrack(int start, int n, int k, List<Integer> comb,
			List<List<Integer>> result) {
		if (comb.size() == k) {
			result.add(new ArrayList<>(comb));
			return;
		}

		for (int i = start; i <= n; i++) {
			comb.add(i);
			backtrack(i + 1, n, k, comb, result);
			comb.remove(comb.size() - 1);
		}
	}
}
