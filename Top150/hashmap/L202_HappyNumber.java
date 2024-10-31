package hashmap;

import java.util.HashSet;
import java.util.Set;

public class L202_HappyNumber {
	public static void main(String[] args) {
		int n = 19;
		boolean happy = isHappy(n);
		System.out.println(n + " is " + happy);
	}

	public static boolean isHappy(int n) {
		Set<Integer> set = new HashSet<>();
		while (true) {
			int sum = 0;
			while (n != 0) {
				int digit = n % 10;
				sum += Math.pow(digit, 2.0);
				n /= 10;
			}

			if (sum == 1) {
				return true;
			}

			if (!set.add(sum)) {
				return false;
			}

			n = sum;
		}
	}
}
