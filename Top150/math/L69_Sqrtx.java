package math;

public class L69_Sqrtx {
	public static void main(String[] args) {
		int result = mySqrt(1);
		System.out.println(result);
	}

	public static int mySqrt(int x) {
		if (x == 0) {
			return 0;
		}
		int start = 1;// If we mark it as 1 then the code will fail for input 1
						// say arithmetic exception divided by zero
		int end = x;
		int mid = -1;
		int ans = -1;
		while (start <= end) {
			mid = start + (end - start) / 2;

			if (x / mid == mid) {
				return mid;
			} else if (x / mid < mid) {
				end = mid - 1;
			} else {
				start = mid + 1;
				ans = mid;
			}
		}
		return ans;
	}
}
