package array_string;

public class L42_TrappingRainWater {

	public static void main(String[] args) {
		// int[] height = {4, 2, 0, 3, 2, 5};
		int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		int waterLogged = trap(height);
		System.out.println("Total water logged==> " + waterLogged);
	}

	public static int trap(int[] height) {
		int n = height.length;
		int[] left = new int[n];
		left[0] = height[0];
		int[] right = new int[n];
		right[n - 1] = height[n - 1];

		for (int i = 1; i < n; i++) {
			left[i] = Math.max(height[i], left[i - 1]);
			right[n - i - 1] = Math.max(height[n - i - 1], right[n - i]);
		}

		int totalWater = 0;

		for (int i = 0; i < n; i++) {
			totalWater += Math.min(left[i], right[i]) - height[i];
		}

		return totalWater;
	}
}
