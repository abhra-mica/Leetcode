package matrix;

import java.util.ArrayList;
import java.util.List;

public class L54_SpiralMatrix {
	public static void main(String[] args) {
		int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
		List<Integer> list = spiralOrder(matrix);
		System.out.println(list);

	}

	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> list = new ArrayList<>();
		int rowBegin = 0;
		int rowEnd = matrix.length - 1;
		int colBegin = 0;
		int colEnd = matrix[0].length - 1;

		while (rowBegin <= rowEnd && colBegin <= colEnd) {

			// traverse right
			for (int i = colBegin; i <= colEnd; i++) {
				list.add(matrix[rowBegin][i]);
			}
			rowBegin++;

			// traverse down
			for (int i = rowBegin; i <= rowEnd; i++) {
				list.add(matrix[i][colEnd]);
			}
			colEnd--;

			// traverse left
			if (rowBegin <= rowEnd) {// Check for ArrayIndexOutOfBound
				for (int i = colEnd; i >= colBegin; i--) {
					list.add(matrix[rowEnd][i]);
				}
			}
			rowEnd--;

			// traverse up
			if (colBegin <= colEnd) {// Check for ArrayIndexOutOfBound
				for (int i = rowEnd; i >= rowBegin; i--) {
					list.add(matrix[i][colBegin]);
				}
			}
			colBegin++;
		}
		return list;
	}

	/*
	 * Without if (rowBegin <= rowEnd) and if (colBegin <= colEnd) we get stale
	 * result because colBegin, colEnd, rowBegin,rowEnd increment decrement keep
	 * happening within the loop
	 */
}
