package challenge.may_2020;

import java.util.Stack;

public class NumberComplement_476 {

	public int findComplement(int num) {
		int numSig = 0;
		int temp = num;
		while(temp != 0){
			temp /= 2;
			numSig++;
		}
		int mask = (1 << numSig) - 1;
		return ~(num) & mask;
	}

	public int findComplement2(int num) {
		int res = 0;
		Stack<Integer> stack = new Stack<>();
		while (num != 0) {
			stack.push(num%2);
			num /= 2;
		}
		int i = stack.size()-1;
		while (!stack.isEmpty()) {
			Integer x = stack.pop();
			if (x == 0) {
				res += Math.pow(2, i);
			}
			i--;
		}
		return res;
	}
}
