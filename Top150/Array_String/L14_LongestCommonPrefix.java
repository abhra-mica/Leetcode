import java.util.Arrays;

public class L14_LongestCommonPrefix {
	public static void main(String[] args) {
		String[] strs = {"dog", "racecar", "car"};
    	//String[] strs = {"flower","flow","flight"};
		String result = longestCommonPrefix(strs);
		System.out.println("Longest Common Prefix == " + result);
	}

	public static String longestCommonPrefix(String[] strs) {
		Arrays.sort(strs);
		String first = strs[0];
		String last = strs[strs.length - 1];
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < first.length(); i++) {
			if (first.charAt(i) != last.charAt(i)) {
				break;
			}
			sb.append(first.charAt(i));
		}

		return sb.toString();
	}

	 public static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];

        int i = 0;
        while (i < first.length()) {
            if (first.charAt(i) != last.charAt(i)) {
                break;
            }
            i++;
        }
        return first.substring(0, i);
    }
}
