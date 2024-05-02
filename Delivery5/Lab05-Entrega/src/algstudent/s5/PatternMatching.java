package algstudent.s5;

public class PatternMatching {
	private String text;
	boolean[][] matches;
	private String pattern;

	public PatternMatching(String text) {
		this.text = text;
	}

	public boolean checkPattern(String pattern) {
		this.pattern = pattern;
		this.matches = new boolean[this.text.length() + 1][pattern.length() + 1];

		if (pattern.trim().isEmpty()) {
			return text.trim().isEmpty(); //true
		}
		for (int i = 0; i < this.text.length() + 1; i++) {
			for (int j = 0; j < pattern.length() + 1; j++) {
				matches[0][j] = false;
				matches[i][0] = false;
			}
		} // not needed because the array of booleans is initialized to false. Only for
			// safety
			// reasons
		matches[0][0] = true;
		for (int i = 1; i < matches.length; i++) {
			for (int j = 1; j < matches[i].length; j++) {
				if (pattern.charAt(j - 1) == '*') {
                    matches[i][j] = (matches[i][j - 1] || matches[i - 1][j] || matches[i - 1][j - 1]); //true if any of them is true
                 
                } else if (pattern.charAt(j - 1) == text.charAt(i - 1)) {
                    matches[i][j] = matches[i - 1][j - 1];
                }
                else if (pattern.charAt(j - 1) == '?') {
                    matches[i][j] = matches[i - 1][j - 1] || matches[i][j - 1];
                }

			}

		}
		return matches[this.text.length()][pattern.length()];
	}

	public void printsTable() {
		System.out.println("Text: " + text);
		System.out.println("Pattern: " + pattern);
		System.out.println("Result: " + matches[this.text.length()][pattern.length()]);
		System.out.println("Procedure: ");
		for (int i = 0; i < matches.length; i++) {
			for (int j = 0; j < matches[i].length; j++) {
				System.out.print(this.matches[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}
}
