package intervals;

import java.util.ArrayList;
import java.util.List;

public class L57_InsertInterval {
	public static void main(String[] args) {
		int[][] intervals = {{1, 3}, {6, 9}};
		int[] newInterval = {2, 5};
		int[][] result = insert(intervals, newInterval);

		for (int i = 0; i < result.length; i++) {
			System.out.print("[" + result[i][0] + "," + result[i][1] + "]\n");
		}
	}

	public static int[][] insert(int[][] intervals, int[] newInterval) {
		List<int[]> result = new ArrayList<>();

		for (int[] interval : intervals) {
			// if current interval is completely on the left of the newInterval
			if (interval[1] < newInterval[0]) {
				result.add(interval);
				// current interval completely on the right side
			} else if (newInterval[1] < interval[0]) {
				result.add(newInterval);
				newInterval = interval;
			} else {// Overlap happens
				newInterval[0] = Math.min(newInterval[0], interval[0]);
				newInterval[1] = Math.max(newInterval[1], interval[1]);
			}
		}
		result.add(newInterval);
		return result.toArray(new int[result.size()][]);
	}
}
