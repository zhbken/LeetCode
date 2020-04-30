package problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Example 1:
 *
 * Input: J = "aA", S = "aAAbbbb"
 * Output: 3
 * Example 2:
 *
 * Input: J = "z", S = "ZZ"
 * Output: 0
 */
public class JewelsAndStones771 {

	public int numJewelsInStones(String J, String S) {
		int count = 0;
		for (int i = 0; i < S.length(); i++) {
			if (J.contains(S.subSequence(i, i+1))) {
				count++;
			}
		}
		return count;
	}

	public int numJewelsInStones2(String J, String S) {
		int count = 0;
		Map<Character, Character> map = new HashMap<>();
		for (int i = 0; i < J.length(); i++) {
			map.put(J.charAt(i), J.charAt(i));
		}
		for (int i = 0; i < S.length(); i++) {
			if (map.containsKey(S.charAt(i))) {
				count++;
			}
		}
		return count;
	}
}
