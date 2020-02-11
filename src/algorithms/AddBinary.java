package algorithms;

/**
 * Given two binary strings, return their sum (also a binary string).
 * <p>
 * The input strings are both non-empty and contains only characters 1 or 0.
 * <p>
 * Example 1:
 * <p>
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 * <p>
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 */
public class AddBinary {

    public static void main(String[] args) {
        AddBinary obj = new AddBinary();
        System.out.println(obj.addBinary("1111", "1111")); // "11110"
        System.out.println(obj.addBinary("11", "1"));
        System.out.println(obj.addBinary("110", "1"));
        System.out.println(obj.addBinary("100", "101"));
        System.out.println(obj.addBinary("1010", "1011"));
    }

    public String addBinary(String a, String b) {

        String maxString = a.length() >= b.length() ? a : b;
        String minString = a.length() >= b.length() ? b : a;
        StringBuilder builder = new StringBuilder();
        boolean tmp = false;
        char mx, mn;
        int x, y;
        for (int i = 0; i < maxString.length(); i++) {
            x = maxString.length() - 1 - i;
            y = minString.length() - 1 - i;

            mx = x >= 0 && maxString.length() > x ? maxString.charAt(x) : '0';
            mn = y >= 0 && minString.length() > y ? minString.charAt(y) : '0';

            if (mx == '1' && mn == '1') {
                if (tmp) {
                    builder.append(1);
                } else {
                    tmp = true;
                    builder.append(0);
                }
            } else if ((mx == '0' && mn == '1') || (mx == '1' && mn == '0')) {
                if (tmp) {
                    builder.append(0);
                } else {
                    builder.append(1);
                }
            } else if (mx == '0' && mn == '0') {
                if (tmp) {
                    builder.append(1);
                    tmp = false;
                } else {
                    builder.append(0);
                }
            }

        }

        if (tmp) {
            builder.append(1);
        }

        return builder.reverse().toString();
    }
}
