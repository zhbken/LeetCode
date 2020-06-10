package challenge.may_2020;


import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString_438 {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) {
            return list;
        }
        int[] arr = new int[26];
        for (int i = 0; i < p.length(); i++) {
            arr[p.charAt(i) - 'a']++;
        }

        // A variation of sliding window: The left and right end represent the end of a window.
        // toVisit gives # elements remaining to be visited in the window, till we slide the window.
        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {
            // If char at right end of window is present in p(charCount)
            if (arr[s.charAt(right) - 'a'] >= 1) {
                count--;
            }
            arr[s.charAt(right) - 'a']--; // Reduce count of char at right end.
            right++; // Increment right end.

            if (count == 0) {
                list.add(left);
            }

            // If you have traversed a window completely. Once you've traversed the first p.length() elements
            // ie. the first window this would always be true,
            // this is here just so that we completely scan our first window, without incrementing left.
            if (right - left == p.length()) {
                if (arr[s.charAt(left) - 'a'] >= 0) {
                    // This would increment toVisit for characters which were found at right end and were
                    // present in p(charCount) because of which we decremented toVisit in the first if block
                    // and then some characters of p were not found in the window so we need to increment.
                    count++;
                }
                arr[s.charAt(left) - 'a']++;
                left++; // Just to slide the window.
            }
        }
        return list;
    }
}
