package intervals;

import java.util.Arrays;

public class L452_MinimumNumberOfArrowsToBurstBalloons {
	public static void main(String[] args) {
		int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
		int result = findMinArrowShots(points);
		System.out.println("Balllons Required= " + result);
	}

	public static int findMinArrowShots(int[][] points) {
		Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
		int arrows = 1;
		int[] currPoint = points[0];

		for (int i = 1; i < points.length; i++) {
			if (currPoint[1] >= points[i][0]) {
				continue;
			} else {
				arrows++;
				currPoint = points[i];
			}
		}
		return arrows;
	}
}
