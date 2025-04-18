package array_string;

import java.util.ArrayList;
import java.util.List;

public class L118_PascalTriangle {
	public static void main(String[] args) {

	}

	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<>();

		if (numRows == 0) {
			return result;
		}

		for (int i = 1; i <= numRows; i++) {
			List<Integer> row = new ArrayList<>();
			for (int j = 0; j < i; j++) {
				if (j == 0 || j == i - 1) {
					row.add(1);
				} else {
					row.add(result.get(i - 2).get(j)
							+ result.get(i - 2).get(j - 1));
				}

			}
			result.add(row);
		}
		return result;
	}
}
