package graph_general;

public class L130_SurroundedRegions {
	public static void main(String[] args) {
		char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'},
				{'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
		solve(board);
		System.out.println(board);
	}

	public static void solve(char[][] board) {
		if (board == null || board.length == 0) {
			return;
		}

		int totalRow = board.length - 1;
		int totalCol = board[0].length - 1;

		// Check for first and last row
		for (int i = 0; i <= totalCol; i++) {
			if (board[0][i] == 'O') {
				mark_cell_X(board, 0, i, totalRow, totalCol);
			}
			if (board[totalRow][i] == 'O') {
				mark_cell_X(board, totalRow, i, totalRow, totalCol);
			}
		}

		// Check for first and last column
		for (int j = 0; j <= totalRow; j++) {
			if (board[j][0] == 'O') {
				mark_cell_X(board, j, 0, totalRow, totalCol);
			}
			if (board[j][totalCol] == 'O') {
				mark_cell_X(board, j, totalCol, totalRow, totalCol);
			}
		}

		for (int row = 0; row <= totalRow; row++) {
			for (int col = 0; col <= totalCol; col++) {
				if (board[row][col] == '#') {
					board[row][col] = 'O';
				} else if (board[row][col] == 'O') {
					board[row][col] = 'X';
				}
			}
		}
	}
	public static void mark_cell_X(char[][] board, int row, int col,
			int totalRow, int totalCol) {

		if (row < 0 || row > totalRow || col < 0 || col > totalCol
				|| board[row][col] != 'O') {
			return;
		}

		board[row][col] = '#';

		mark_cell_X(board, row - 1, col, totalRow, totalCol);
		mark_cell_X(board, row + 1, col, totalRow, totalCol);
		mark_cell_X(board, row, col + 1, totalRow, totalCol);
		mark_cell_X(board, row, col - 1, totalRow, totalCol);
	}
}
