
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
		int firstPtr = m - 1;
		int secondPtr = n - 1;
		int k = m + n - 1;
		while (secondPtr >= 0 && firstPtr >= 0) {
			if (nums1[firstPtr] > nums2[secondPtr]) {
				nums1[k] = nums1[firstPtr];
				firstPtr--;
			} else {
				nums1[k] = nums2[secondPtr];
				secondPtr--;
			}
			k--;
		}

		// No need to check for firstPtr as we are merging in nums1 only, if
		// secondPtr already traversed then the rest of the nums1 is already
		// sorted
		while (secondPtr >= 0) {
			nums1[k--] = nums2[secondPtr--];
		}
	}
}
