public class L28_IndexFirstOccurrenceInString {
	public static void main(String[] args) {
		// String heystack = "sadbutsad";
		// String needle = "sad";
		String heystack = "a";
		String needle = "a";
		System.out.println("Index= " + strStr(heystack, needle));
	}

	public static int strStr(String haystack, String needle) {
		int m = haystack.length();
		int n = needle.length();

		for (int i = 0; i <= m - n; i++) {
			if (haystack.substring(i, i + n).equals(needle)) {
				return i;
			}
		}
		return -1;
	}
}
