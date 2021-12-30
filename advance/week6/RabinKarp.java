package advance.week6;

public class RabinKarp {
	int m, n, q = (int) Math.pow(2, 31);

	public void search(String pattern, String text) {
		boolean noMatch = true;
		m = pattern.length();
		n = text.length();
		if (n == 0)
			throw new RuntimeException("Empty text");
		int patternHash = hashCode(pattern);
		for (int i = 0; i <= n - m; i++) {
			String subString = text.substring(i, i + m);
			int subStringHash = hashCode(subString);
			if (subStringHash == patternHash) {
				if (patternMatch(pattern, subString)) {
					noMatch = false;
					System.out.println("RabinKarp : Pattern match at index: " + i);
				}
			}
		}
		if (noMatch)
			System.out.println("No matches found");
	}

	private boolean patternMatch(String pattern, String subString) {
		for (int i = 0; i < pattern.length(); i++) {
			if (pattern.charAt(i) != subString.charAt(i))
				return false;
		}
		return true;
	}

	private int hashCode(String word) {
		int j = 0, h = 0;
		for (int i : word.toCharArray())
			h += (i - 96) * Math.pow(n, j++);
		return h % q;
	}
}
