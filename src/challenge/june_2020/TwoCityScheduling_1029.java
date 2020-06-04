package challenge.june_2020;

import java.util.Arrays;
import java.util.Comparator;

public class TwoCityScheduling_1029 {

    public int twoCitySchedCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }

        Arrays.sort(costs, (o1, o2) -> Math.abs(o2[0] - o2[1]) - Math.abs(o1[0] - o1[1]));
        int N = costs.length / 2;
        int sumA = 0, sumB = 0;
        int countA = 0, countB = 0;
        for (int i = 0; i < costs.length; i++) {
            if (countA < N && countB < N) {
                if (costs[i][0] < costs[i][1]) {
                    countA++;
                    sumA += costs[i][0];
                } else {
                    countB++;
                    sumB += costs[i][1];
                }
            } else if (countA == N && countB < N) {
                countB++;
                sumB += costs[i][1];
            } else if (countB == N && countA < N) {
                countA++;
                sumA += costs[i][0];
            }
        }

        return sumA + sumB;
    }
}
