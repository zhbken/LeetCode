package problems;

public class HammingDistance_461 {

	public int hammingDistance(int x, int y) {
		int xor = x ^ y;
		return countBinaryOnes(xor);
	}

	public int hammingDistance2(int x, int y) {
		int xor = x ^ y;

		return Integer.bitCount(xor);
	}

	private int countBinaryOnes(int x) {
		int count = 0;

		while (x != 0) {
			if (x%2==1) {
				count++;
			}
			x/=2;
		}

		return count;
	}
}
