package array_string;

public class L88_MergeSortedAarray {
	public static void main(String[] args) {
		/*
		 * int[] nums1 = {1, 2, 3, 0, 0, 0}; int m = 3; int[] nums2 = {2, 5, 6};
		 * int n = 3;
		 */
		int[] nums1 = {2, 0};
		int m = 1;
		int[] nums2 = {1};
		int n = 1;

		merge(nums1, m, nums2, n);
		for (int i : nums1) {
			System.out.print(i + " ");
		}
	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int k = nums1.length - 1;
		m--;
		n--;

		while (m >= 0 && n >= 0) {
			nums1[k--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
		}

		while (n >= 0) {
			nums1[k--] = nums2[n--];
		}
	}
}
