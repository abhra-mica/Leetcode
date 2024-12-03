package matrix;

public class L73_SetMatrixZeroes {
	public static void main(String[] args) {
	}

	public void setZeroes(int[][] matrix) {
		// Two variables to decide first row and first column should be zero or
		// not
		boolean rowFirst = false;
		boolean colFirst = false;

		// below loop to decide the status of rowFirst and colFirst
		// And check in the inner matrix to set zeros at first row and first col
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					if (i == 0) {
						rowFirst = true;
					}
					if (j == 0) {
						colFirst = true;
					}
					matrix[i][0] = 0; // Corresponding first row cell zero
					matrix[0][j] = 0; // Corresponding first col cell zero
				}
			}
		}

		// Traverse inner matrix and make cell zero when applied
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}
		// Setting first row zero
		if (rowFirst) {
			for (int i = 0; i < matrix[0].length; i++) {
				matrix[0][i] = 0;
			}
		}

		// Setting first col zero
		if (colFirst) {
			for (int i = 0; i < matrix.length; i++) {
				matrix[i][0] = 0;
			}
		}
	}
}
