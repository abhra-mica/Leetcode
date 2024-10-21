public class L162_PeakElement {
	public static void main(String[] args) {
		System.out
				.println(findPeakElementBinary(new int[]{1, 2, 1, 3, 5, 6, 4}));
	}

	public static int findPeakElementLinear(int[] arr) {
		if (arr.length == 1) {
			return arr[0];
		}
		for (int i = 0; i < arr.length - 1; i++) {
			if (i == 0 && arr[0] > arr[1]) {
				return 0;
			} else if (i == arr.length - 1 && arr[i] > arr[i - 1]) {
				return arr.length - 1;
			} else if (arr[i] > arr[i + 1] && arr[i] > arr[i - 1]) {
				return arr[i];
			}
		}
		return -1;
	}

	public static int findPeakElementBinary(int[] arr) {
		int start = 0;
		int end = arr.length - 1;
		int mid = 0;

		while (start <= end) {
			mid = (start + end) / 2;
			if ((mid == 0 || arr[mid] > arr[mid - 1])
					&& (mid == arr.length - 1 || arr[mid] > arr[mid + 1])) {
				return mid;
			} else if (arr[mid] < arr[mid + 1]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return -1;
	}
}
