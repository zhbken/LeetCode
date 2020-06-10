package challenge.may_2020;

public class PermutationInString_567 {

    public boolean checkInclusion(String s1, String s2) {
        int[] arr = new int[26];

        for (char ch: s1.toCharArray()) {
            arr[ch - 'a']++;
        }
        int count = s1.length();
        int n = s1.length();
        int i = 0;
        while (i < s2.length()) {
            char ch = s2.charAt(i);
            if (arr[ch - 'a'] >= 1) {
                count--;
            }
            arr[ch-'a']--;

            if (n-1 < i) {
                if (arr[s2.charAt(i - n) - 'a'] >= 0) {
                    count++;
                }
                arr[s2.charAt(i - n) - 'a']++;
            }
            if (count == 0) return true;
            i++;
        }

        return count == 0;
    }
}
