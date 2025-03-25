package binary_search;

public class L74_Search2DMatrix {
	public static void main(String[] args) {
		// int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
		// int target = 11;
		int[][] matrix = {{1, 3}};
		int target = 3;
		boolean result = searchMatrix(matrix, target);
		System.out.println("Result= " + result);
	}
	public static boolean searchMatrix(int[][] matrix, int target) {
		int row = rowSearch(matrix, target);

		if (row == -1) {
			return false;
		}
		int start = 0;
		int end = matrix[row].length - 1;
		int mid = 0;
		while (start <= end) {
			mid = (start + end) / 2;
			if (matrix[row][mid] == target) {
				return true;
			} else if (matrix[row][mid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return false;
	}

	private static int rowSearch(int[][] matrix, int target) {
		int start = 0;
		int end = matrix.length - 1;
		int mid = 0;
		while (start <= end) {
			mid = (start + end) / 2;
			if (target >= matrix[mid][0]
					&& target <= matrix[mid][matrix[mid].length - 1]) {
				return mid;
			} else if (target < matrix[mid][0]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}
}
