package multidimensional_dp;

public class L63_UniquePathsII {
	private static Integer[][] t;

	public static void main(String[] args) {
		int[][] obstacleGrid = {{0, 0}};
		int result = uniquePathsWithObstacles(obstacleGrid);
		System.out.println(result);
	}
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		t = new Integer[101][101];
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		return solve(obstacleGrid, 0, 0, m, n);
	}

	private static int solve(int[][] obstacleGrid, int i, int j, int m, int n) {
		// i <0 and j<0 will never come because back it is not going
		if (i >= m || i < 0 || j >= n || j < 0 || obstacleGrid[i][j] != 0) {
			return 0;
		}

		if (t[i][j] != null) {
			return t[i][j];
		}

		if (i == m - 1 && j == n - 1) {
			return 1;
		}

		int right = solve(obstacleGrid, i, j + 1, m, n);
		int down = solve(obstacleGrid, i + 1, j, m, n);

		return t[i][j] = right + down;
	}
}
