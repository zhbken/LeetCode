package problems;

public class FlippingAnImage_832 {

	public int[][] flipAndInvertImage(int[][] A) {
		for (int i = 0; i < A.length; i++) {
			for (int j = 0, k = A.length -1; j < k; j++, k--) {
				int tmp = A[i][j];
				//A[i][j] = A[i][k] ^ 0;
			}
		}

		return A;
	}
}
