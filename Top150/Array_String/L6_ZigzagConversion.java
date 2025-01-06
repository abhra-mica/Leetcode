package array_string;

import java.util.Arrays;

public class L6_ZigzagConversion {
	public static void main(String[] args) {
		String s = "PAYPALISHIRING";
		String result = convert(s, 6);
		System.out.println(result);
	}

	public static String convert(String s, int numRows) {
		/*
		 * When only one row is available then it should be the answer and also
		 * without below check within the while loop when i==0 deltaSouth will
		 * be calculated as zero,so will be in a infinite loop
		 */
		if (numRows == 1) {
			return s;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < numRows; i++) {
			int idx = i;
			int deltaSouth = 2 * (numRows - 1 - i);
			int deltaNorth = 2 * i;
			boolean goingSouth = true;
			
			while (idx < s.length()) {
				sb.append(s.charAt(idx));
				if (i == 0) {//Go down then up always
					idx += deltaSouth;
				} else if (i == numRows - 1) {//Go up and down always
					idx += deltaNorth;
				} else {
					if (goingSouth) {
						idx += deltaSouth;
					} else {
						idx += deltaNorth;
					}
					goingSouth = !goingSouth;
				}
			}
		}
		return sb.toString();
	}

	public static String convert1(String s, int numRows) {
		String[] ans = new String[numRows];
		Arrays.fill(ans, "");

		int i = 0;
		while (i < s.length()) {
			for (int idx = 0; idx < numRows && i < s.length(); idx++) {
				ans[idx] += s.charAt(i++);
			}

			for (int idx = numRows - 2; idx > 0 && i < s.length(); idx--) {
				ans[idx] += s.charAt(i++);
			}
		}

		StringBuilder sb = new StringBuilder();
		for (String str : ans) {
			sb.append(str);
		}
		return sb.toString();
	}
}
