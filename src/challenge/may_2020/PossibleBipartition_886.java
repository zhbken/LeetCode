package challenge.may_2020;

import java.util.ArrayList;
import java.util.List;

public class PossibleBipartition_886 {

    public boolean possibleBipartition(int N, int[][] dislikes) {
        List<Integer>[] graph = new ArrayList[N];
        int[] groups = new int[N];

        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < dislikes.length; i++) {
            int x = dislikes[i][0] - 1;
            int y = dislikes[i][1] - 1;
            if (!graph[x].contains(y)) {
                graph[x].add(y);
            }
            if (!graph[y].contains(x)) {
                graph[y].add(x);
            }
        }

        for (int i = 0; i < N; i++) {
            if (groups[i] == 0 && !dfs(graph, groups, i, 1)) {
                return false;
            }
        }

        return true;
    }

    public boolean dfs(List<Integer>[] graph, int[] groups, int index, int group) {
        groups[index] = group;
        for (int x : graph[index]) {
            if (groups[x] == group) {
                return false;
            }
            if (groups[x] == 0 && !dfs(graph, groups, x, -group)) {
                return false;
            }
        }
        return true;
    }


    public boolean possibleBipartition2(int N, int[][] dislikes) {
        int[][] graph = new int[N][N];
        int[] groups = new int[N];

        for (int i = 0; i < dislikes.length; i++) {
            int x = dislikes[i][0] - 1;
            int y = dislikes[i][1] - 1;
            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        for (int i = 0; i < N; i++) {
            if (groups[i] == 0 && !dfs2(graph, groups, i, 1)) {
                return false;
            }
        }

        return true;
    }

    public boolean dfs2(int[][] graph, int[] groups, int index, int group) {
        groups[index] = group;
        for (int x = 0; x < graph.length; x++) {
            if (graph[index][x] == 1) {
                if (groups[x] == group) {
                    return false;
                }
                if (groups[x] == 0 && !dfs2(graph, groups, x, -group)) {
                    return false;
                }
            }
        }
        return true;
    }

}
