package two_pointer;

public class L11_ContainerWithMostWater {
	public static void main(String[] args) {
		int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
		int result = maxArea(height);
		System.out.println(result);
	}

	public static int maxArea(int[] height) {
		int left = 0;
		int right = height.length - 1;
		int max = 0;

		while (left < right) {
			int min_h = Math.min(height[left], height[right]);
			max = Math.max(max, min_h * (right - left));
			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}

		}
		return max;
	}
}
