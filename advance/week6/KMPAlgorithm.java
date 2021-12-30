package advance.week6;

public class KMPAlgorithm {

	public void kmp(String pattern, String text) {
		int[] pi = piTable(pattern);
		int m = pattern.length();
		int n = text.length();
//		int i = 0;
		int j = 0;
		for (int i = 0; i < n; i++) {
			if (j < m && pattern.charAt(j) == text.charAt(i))
				j++;
			else {
				if (j != 0) {
					if (j == m)
						System.out.println("KMP: Pattern found at index " + (i - j));
					else
						i--;
					j = pi[j - 1];
				}
			}
		}
	}

	int[] piTable(String pattern) {
		int length = pattern.length();
		int[] pi = new int[length];
		for (int i = 1; i < length; i++) {
			if (pi[i - 1] > 0 && pattern.charAt(pi[i - 1]) == pattern.charAt(i))
				pi[i] = pi[i - 1] + 1;
			else if (pattern.charAt(i) == pattern.charAt(0))
				pi[i] = 1;
		}
		return pi;
	}
}
