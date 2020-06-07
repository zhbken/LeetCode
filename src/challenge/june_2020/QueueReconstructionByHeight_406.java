package challenge.june_2020;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Example
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
public class QueueReconstructionByHeight_406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] != b[0] ? b[0] - a[0] : a[1] - b[1]);
        List<int[]> list = new LinkedList<>();
        for (int[] a : people) {
            list.add(a[1], a);
        }
        return list.toArray(new int[people.length][]);
    }
}
