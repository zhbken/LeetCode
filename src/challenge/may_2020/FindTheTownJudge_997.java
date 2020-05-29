package challenge.may_2020;

import java.util.ArrayList;
import java.util.List;

public class FindTheTownJudge_997 {

    public int findJudge(int N, int[][] trust) {
        int[] arr = new int[N+1];

        for(int[] x: trust) {
            arr[x[0]]--;
            arr[x[1]]++;
        }

        for(int i = 1; i <= N; i++) {
            if (arr[i] == N-1) {
                return i;
            }
        }

        return -1;
    }

    public int findJudge_withlist(int N, int[][] trust) {
        boolean[] people = new boolean[N];
        List<Integer>[] graph = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList();
        }

        for (int i = 0; i < trust.length; i++) {
            graph[trust[i][1]-1].add(trust[i][0]-1);

            if (people[trust[i][0]-1] == false) {
                people[trust[i][0]-1] = true;
            }
        }

        for (int i = 0; i < N; i++) {
            if (people[i] == false && graph[i].size() == N - 1) {
                return i + 1;
            }
        }

        return -1;
    }
}
