package array_string;

import java.util.Arrays;

public class L6_ZigzagConversion {
	public static void main(String[] args) {
		String s = "PAYPALISHIRING";
		String result = convert(s, 3);
		System.out.println(result);
	}

	public static String convert(String s, int numRows) {
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
