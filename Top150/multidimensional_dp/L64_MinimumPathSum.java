package multidimensional_dp;

import java.util.Arrays;

public class L64_MinimumPathSum {
	private static int[][] t = new int[201][201];// 201 problem contraints

	public static void main(String[] args) {
		int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
		int result = minPathSum_bottom_up(grid);
		System.out.println("Minimum Path Sum= " + result);
	}

	public static int minPathSum(int[][] grid) {
		Arrays.fill(t, -1);
		int m = grid.length;
		int n = grid[0].length;
		return solve(grid, 0, 0, m, n);
	}

	// With this approach will get time limit exceeded exception
	private static int solve(int[][] grid, int i, int j, int m, int n) {
		// Reached the last cell
		if (i == m - 1 && j == n - 1) {
			return grid[i][j];
		}

		if (i == m - 1) {// Can go only right
			return grid[i][j] + solve(grid, i, j + 1, m, n);
		} else if (j == n - 1) {// Can go only down
			return grid[i][j] + solve(grid, i + 1, j, m, n);
		} else {// if any other cell, we go to both right and down
			return grid[i][j] + Math.min(solve(grid, i + 1, j, m, n),
					solve(grid, i, j + 1, m, n));
		}
	}

	private static int solveMemoize(int[][] grid, int i, int j, int m, int n) {
		// Reached the last cell
		if (i == m - 1 && j == n - 1) {
			return grid[i][j];
		}

		if (t[i][j] != -1) {
			return t[i][j];
		}

		if (i == m - 1) {// Can go only right
			return t[i][j] = grid[i][j] + solve(grid, i, j + 1, m, n);
		} else if (j == n - 1) {// Can go only down
			return t[i][j] = grid[i][j] + solve(grid, i + 1, j, m, n);
		} else {// if any other cell, we go to both right and down
			return t[i][j] = grid[i][j] + Math.min(solve(grid, i + 1, j, m, n),
					solve(grid, i, j + 1, m, n));
		}
	}

	public static int minPathSum_bottom_up(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] t = new int[m][n];

		// Fill first row
		t[0][0] = grid[0][0];
		for (int col = 1; col < n; col++) {
			t[0][col] = grid[0][col] + t[0][col - 1];
		}

		// Fill first column
		for (int row = 1; row < m; row++) {
			t[row][0] = grid[row][0] + t[row - 1][0];
		}

		for (int row = 1; row < m; row++) {
			for (int col = 1; col < n; col++) {
				t[row][col] = Math.min(t[row - 1][col], t[row][col - 1])
						+ grid[row][col];
			}
		}
		return t[m - 1][n - 1];
	}
}
