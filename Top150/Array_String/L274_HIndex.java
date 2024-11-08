package array_string;

public class L274_HIndex {
	public static void main(String[] args) {
		int[] citations = {1, 3, 1};
		int result = hIndex(citations);
		System.out.println("Result= " + result);
	}

	public static int hIndex(int[] citations) {
		int[] aux = new int[citations.length + 1];
		int n = citations.length;
		int totalCitation = 0;
		for (int i : citations) {
			if (i >= n) {
				aux[n]++;
			} else {
				aux[i]++;
			}
		}

		for (int i = n; i >= 0; i--) {
			totalCitation += aux[i];
			if (totalCitation >= i) {
				return i;
			}
		}
		return 0;
	}
}
