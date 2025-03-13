package graph_BFS;

import java.util.LinkedList;
import java.util.Queue;

public class L909_SnakesandLadders {

	public static void main(String[] args) {

	}

	public static int snakesAndLadders(int[][] board) {
		int n = board.length;
		int steps = 0;

		Queue<Integer> queue = new LinkedList<>();
		boolean[][] visited = new boolean[n][n];
		queue.add(1);
		visited[n - 1][0] = true;

		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				int x = queue.poll();
				if (x == n * n) {
					return steps;
				}

				for (int k = 1; k <= 6; k++) {
					if (k + x > n * n) {
						break;
					}
					int[] pos = findCordinates(k + x, n);
					int row = pos[0];
					int col = pos[1];

					if (visited[row][col] == true) {
						continue;
					}

					visited[row][col] = true;

					if (board[row][col] == -1) {
						queue.add(k + x);
					} else {
						queue.add(board[row][col]);
					}
				}
			}
			steps++;
		}

		return -1; // If you not able to make to the end , supposse all the last
					// 6 cells are filled with snakes.

	}

	private static int[] findCordinates(int curr, int n) {
		int row = n - (curr - 1) / n - 1;
		int col = (curr - 1) % n;

		if (row % 2 == n % 2) {
			return new int[]{row, n - 1 - col};
		} else {
			return new int[]{row, col};
		}
	}
}
