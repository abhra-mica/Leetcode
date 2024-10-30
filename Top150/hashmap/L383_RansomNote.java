package hashmap;

public class L383_RansomNote {
	public static void main(String[] args) {
		String ransomNote = "aa";
		String magazine = "ab";

		boolean result = canConstruct(ransomNote, magazine);
		System.out.println("Result= " + result);
	}

	public static boolean canConstruct(String ransomNote, String magazine) {
		if (ransomNote.length() > magazine.length()) {
			return false;
		}

		// Assuming only letters, otherwise bigger array is required or HashMap
		// need to use
		int[] magHash = new int[26];

		for (int i = 0; i < magazine.length(); i++) {
			magHash[magazine.charAt(i) - 'a']++;
		}

		for (int i = 0; i < ransomNote.length(); i++) {
			int index = ransomNote.charAt(i) - 'a';
			if (magHash[index] == 0) {
				return false;
			}
			magHash[index]--;
		}
		return true;
	}
}
