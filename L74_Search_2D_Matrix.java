public class L74_Search_2D_Matrix {
	public static void main(String[] args) {
		int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
		int target = 23;
		searchElement(matrix, target);
	}

	public static void searchElement(int[][] matrix, int target) {
		int rowIdx = findPossibleRow(matrix, target);
		boolean isFind = binarySearchOverRow(rowIdx, matrix, target);
		System.out.println(target + " find= " + isFind);
	}

	static int findPossibleRow(int[][] matrix, int target) {
		int start = 0;
		int end = matrix.length - 1;
		int mid = 0;

		while (start <= end) {
			mid = (start + end) / 2;
			if (matrix[mid][0] <= target
					&& target <= matrix[mid][matrix.length - 1]) {
				return mid;
			} else if (target > matrix[mid][0]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return -1;
	}

	public static boolean binarySearchOverRow(int rowIdx, int[][] matrix,
			int target) {
		int start = 0;
		int end = matrix[rowIdx].length - 1;
		int mid = 0;

		while (start <= end) {
			mid = (start + end) / 2;
			if (matrix[rowIdx][mid] == target) {
				return true;
			} else if (target < matrix[rowIdx][mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return false;
	}
}
