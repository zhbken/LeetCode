package problems;

public class SplitAStringInBalancedStrings_1221 {

	public int balancedStringSplit(String s) {
		int L = 0, R = 0;
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'L') {
				L++;
			} else if (s.charAt(i) == 'R') {
				R++;
			}

			if (L > 0 && L == R) {
				count++;
				L = R = 0;
			}
		}
		return count;
	}
}
