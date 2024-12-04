package matrix;

public class L289_GameOfLife {
	public static void main(String[] args) {

	}

	public static void gameOfLife(int[][] board) {
		int[][] dir = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0},
				{1, -1}, {0, -1}};

		int m = board.length;
		int n = board[0].length;
		int[][] rs = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				// For every cell we check what is the live cell
				// surrounding,using those rules we change count variable
				int count = 0;
				// This for loop is used calculate the count variable based on
				// eight neighbor cell
				for (int[] d : dir) {
					int p = i + d[0];
					int q = j + d[1];

					if (p >= 0 && p <= m && q >= 0 && q <= n
							&& board[p][q] == 1) {
						count++;
					}
				}

				// Now we have two condition, either the cell is live or dead
				// As our rs matrix already filled with zero we can skip 1 and 3
				// option
				// 1.Any live cell with fewer than two live neighbors dies as if
				// caused by under-population.
				// 3.Any live cell with more than three live neighbors dies, as
				// if by over-population.
				if (board[i][j] == 1) {
					if (count == 2 || count == 3) {
						rs[i][j] = 1;
					}
				} else {
					if (count == 3) {
						rs[i][j] = 1;
					}
				}

			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = rs[i][j];
			}
		}
	}
}
