package challenge.may_2020;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString_387 {

    public int firstUniqChar(String s) {
        Map<Character, Node> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.putIfAbsent(s.charAt(i), new Node(i));
            map.get(s.charAt(i)).count++;
        }

        int minIndex = Integer.MAX_VALUE;
        for(Character key: map.keySet()) {
            if (map.get(key).count == 1) {
                minIndex = Math.min(minIndex, map.get(key).index);
            }
        }
        return minIndex == Integer.MAX_VALUE ? -1 : minIndex;
    }

    class Node {
        int count;
        int index;
        Node (int index) {
            this.index = index;
        }
    }

    // two pointers, slow and fast
    public int firstUniqChar2(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        int len = s.length();
        if (len == 1) {
            return 0;
        }

        int slow = 0, fast = 1;
        char[] chars = s.toCharArray();
        int[] count = new int[26];
        count[chars[slow] - 'a']++;
        while (fast < len) {
            count[chars[fast ] - 'a']++;
            // if slow pointer is not a unique character anymore, move to the next unique one
            while (slow < len && count[chars[slow] - 'a'] > 1) {
                slow++;
            }
            // no unique character exist
            if (slow >= len) {
                return -1;
            }
            // not yet visited by the fast pointer
            if (count[chars[slow] - 'a'] == 0) {
                count[chars[slow] - 'a']++;
                fast = slow;// reset the fast pointer
            }
            fast++;
        }
        return slow;
    }
}
