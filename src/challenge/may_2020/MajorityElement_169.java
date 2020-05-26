package challenge.may_2020;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement_169 {

    //Map
    public int majorityElement(int[] nums) {
        int n = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], 0);
            map.put(nums[i], map.get(nums[i]) + 1);
            if (map.get(nums[i]) > n) {
                return nums[i];
            }
        }

        return -1;
    }

    /**
     * Moore-Boyer vote algorithm
     * http://www.cs.utexas.edu/~moore/best-ideas/mjrty/index.html
     * When we move the pointer forward over an element e:
     * - If the counter is 0, we set the current candidate to e and we set the counter to 1.
     * - If the counter is not 0, we increment or decrement the counter according to whether e is the current candidate.
     */
    public int majorityElement2(int[] nums) {
        int count = 0, candidate = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if (num != candidate) {
                count--;
            } else {
                count++;
            }
        }
        return candidate;
    }
}
