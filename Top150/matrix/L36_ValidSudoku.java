package matrix;

import java.util.HashSet;
import java.util.Set;

public class L36_ValidSudoku {
	public static void main(String[] args) {
		/*
		 * char[][] board = {{'5','3','.',".","7",".",".",'.','.'}
		 * ,{"6",".",".","1","9","5",".",".","."}
		 * ,{".","9","8",".",".",".",".","6","."}
		 * ,{"8",".",".",".","6",".",".",".","3"}
		 * ,{"4",".",".","8",".","3",".",".","1"}
		 * ,{"7",".",".",".","2",".",".",".","6"}
		 * ,{".","6",".",".",".",".","2","8","."}
		 * ,{".",".",".","4","1","9",".",".","5"}
		 * ,{".",".",".",".","8",".",".","7","9"}};
		 */
	}

	public static boolean isValidSudoku(char[][] board) {
		Set<String> set = new HashSet<>();
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				if (board[row][col] != '.') {
					int box = (row / 3) * 3 + col / 3;
					if (!set.add("row" + row + board[row][col])
							|| !set.add("col" + col + board[row][col])
							|| !set.add("box" + box + board[row][col])) {
						return false;
					}
				}
			}
		}
		return true;
	}
}
