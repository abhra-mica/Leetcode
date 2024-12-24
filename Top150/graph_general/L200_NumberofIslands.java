package graph_general;

public class L200_NumberofIslands {
	public static void main(String[] args) {
		// char[][] grid = {{0, 1, 1, 1, 0}, {0, 0, 0, 1, 1}, {0, 1, 1, 1, 0},
		// {0, 1, 1, 0, 0}, {0, 0, 0, 0, 0}};

		char[][] grid = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'},
				{'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};

		int result = numIslands(grid);
		System.out.println("No of islands= " + result);
	}

	public static int numIslands(char[][] grid) {
		if (grid.length == 0) {
			return 0;
		}

		int totalIslands = 0;
		int totalRow = grid.length;
		int totalCol = grid[0].length;

		for (int row = 0; row < totalRow; row++) {
			for (int col = 0; col < totalCol; col++) {
				if (grid[row][col] == '1') {
					mark_current_Island(grid, row, col, totalRow, totalCol);
					totalIslands++;
				}
			}
		}
		return totalIslands;
	}

	private static void mark_current_Island(char[][] grid, int row, int col,
			int totalRow, int totalCol) {
		if (row < 0 || row == totalRow || col < 0 || col == totalCol
				|| grid[row][col] != '1') {
			return;
		}

		grid[row][col] = '2';

		mark_current_Island(grid, row - 1, col, totalRow, totalCol);
		mark_current_Island(grid, row + 1, col, totalRow, totalCol);
		mark_current_Island(grid, row, col + 1, totalRow, totalCol);
		mark_current_Island(grid, row, col - 1, totalRow, totalCol);
	}
}
