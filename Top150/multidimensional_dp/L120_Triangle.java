package multidimensional_dp;

import java.util.List;

public class L120_Triangle {
	public static void main(String[] args) {

	}

	public static int minimumTotal(List<List<Integer>> triangle) {
		int height = triangle.size();
		int[][] dp = new int[height + 1][height + 1];

		for (int level = height - 1; level >= 0; level--) {
			for (int i = 0; i <= level; i++) {
				// Add minimum amongst 2 adjacent elements from bottom level
				dp[level][i] = triangle.get(level).get(i)
						+ Math.min(dp[level + 1][i], dp[level + 1][i + 1]);
			}
		}
		return dp[0][0];
	}
}
