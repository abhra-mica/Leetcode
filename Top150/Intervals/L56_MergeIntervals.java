package intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L56_MergeIntervals {
	public static void main(String[] args) {
		int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

		int[][] result = merge(intervals);

		for (int[] row : result) {
			for (int num : row) {
				System.out.print(num + ",");
			}
			System.out.println();
		}
	}

	public static int[][] merge(int[][] intervals) {
		if (intervals.length < 2) {
			return intervals;
		}

		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

		List<int[]> result = new ArrayList<>();
		int[] newInterval = intervals[0];
		/*
		 * Vital step, till the overlapping interval occurs it updated When
		 * non-overlapping intervals comes it directly add to the list
		 */
		result.add(newInterval);

		for (int[] interval : intervals) {
			if (newInterval[1] >= interval[0]) {
				newInterval[1] = Math.max(newInterval[1], interval[1]);
			} else {
				newInterval = interval;
				result.add(newInterval);
			}
		}
		return result.toArray(new int[result.size()][]);
	}
}
