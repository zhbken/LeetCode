package problems;

public class ToLowerCase709 {
	public String toLowerCase(String str) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >=65 && str.charAt(i) <= 90) {
				builder.append((char) (str.charAt(i) + 32));
			} else {
				builder.append(str.charAt(i));
			}
		}

		return builder.toString();
	}
}
