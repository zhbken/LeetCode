package challenge.may_2020;

import java.util.Stack;

public class RemoveKDigits_402 {
	public String removeKdigits(String num, int k) {
		Stack<Character> stack = new Stack<>();

		if (k == num.length()) return "0";
		if (k == 0) return num;

		for (int i = 0; i < num.length(); i++) {
			while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
				stack.pop();
				k--;
			}
			stack.push(num.charAt(i));
		}

		while (k-- > 0) {
			stack.pop();
		}
		StringBuilder builder = new StringBuilder();
		while (!stack.isEmpty()) {
			builder.append(stack.pop());
		}
		builder.reverse();
		while (builder.length() > 1 && builder.charAt(0) == '0') {
			builder.deleteCharAt(0);
		}

		return builder.toString();
	}
}
