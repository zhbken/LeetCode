package challenge.june_2020;

public class PermutationSequence_60 {

    public String getPermutation(int n, int k) {
        int[] arr = new int[n + 1];
        arr[0] = 1;
        for (int i = 1; i <= n; i++) {
            arr[i] = arr[i - 1] * i;
        }

        int[] x = new int[n + 1];
        StringBuilder builder = new StringBuilder();
        for (int i = n; i > 0; i--) {
            int f = arr[i] / i;
            int a = 0;
            if (k % f == 0) {
                a = k / f;
            } else {
                a = k / f + 1;
            }

            int count = 0;
            for (int j = 1; j <= n; j++) {
                if (x[j] == 0) {
                    count++;
                }
                if (count == a && x[j] != 1) {
                    builder.append(j);
                    x[j] = 1;
                    break;
                }
            }
            k = k % f;
            if (k == 0) k = f;
        }
        return builder.toString();
    }
}
