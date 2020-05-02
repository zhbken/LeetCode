package problems;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseCodeWords_804 {

	/**
	 * Note:
	 * The length of words will be at most 100.
	 * Each words[i] will have length in range [1, 12].
	 * words[i] will only consist of lowercase letters.
	 */
	public int uniqueMorseRepresentations(String[] words) {
		String[] morse = new String[]{
				".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.",
				"---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
		Set<String> transformation = new HashSet<>();
		for (String word : words) {
			StringBuilder str = new StringBuilder();
			for (int i = 0; i < word.length(); i++) {
				str.append(morse[word.charAt(i) - 97]);
			}
			transformation.add(str.toString());
		}

		return transformation.size();
	}
}
