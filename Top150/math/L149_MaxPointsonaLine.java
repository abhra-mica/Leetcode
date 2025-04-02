package math;

public class L149_MaxPointsonaLine {
	public static void main(String[] args) {
		int[][] points = {{1, 1}, {2, 2}, {3, 3}};
		int result = maxPoints(points);
		System.out.println("Max points in a single line = " + result);
	}

	public static int maxPoints(int[][] points) {
		if (points.length == 1) {
			return 1;
		}

		int result = 0;
		for (int i = 0; i < points.length; i++) { // P1 x1,y1
			for (int j = i + 1; j < points.length; j++) {// P2 x2,y2
				int count = 2;

				int dx = points[j][0] - points[i][0];
				int dy = points[j][1] - points[i][1];

				for (int k = 0; k < points.length; k++) {// P3 x3,y3
					if (k != i && k != j) {
						// take slope from the i or j point
						int dx_ = points[k][0] - points[j][0];
						int dy_ = points[k][1] - points[j][1];

						if (dy * dx_ == dy_ * dx) {
							count++;
						}
					}
				}
				result = Math.max(result, count);
			}
		}
		return result;
	}
}
