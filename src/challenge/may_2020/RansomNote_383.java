package challenge.may_2020;

import java.util.HashMap;
import java.util.Map;

public class RansomNote_383 {

	public boolean canConstruct(String ransomNote, String magazine) {
		if (ransomNote.length() > magazine.length()) {
			return false;
		}

		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < ransomNote.length(); i++) {
			char ch = ransomNote.charAt(i);
			int fromIndex = map.getOrDefault(ch, 0);
			if (magazine.indexOf(ransomNote.charAt(i), fromIndex) > -1) {
				map.put(ch, magazine.indexOf(ransomNote.charAt(i), fromIndex)+1);
			} else return false;
		}
		return true;
	}
}
