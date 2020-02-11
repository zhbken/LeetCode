package algorithms;

/**
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Example 2:
 * <p>
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 */
public class PlusOne {

    public static void main(String[] args) {
        print(new int[]{9});
        print(new int[]{2, 9, 9});
        print(new int[]{0});
        print(new int[]{1, 0});
        print(new int[]{1, 2, 3});
        print(new int[]{4,3,2,1});
    }

    public static void print(int[] arr) {
        PlusOne obj = new PlusOne();
        for (int i : obj.plusOne(arr)) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                return digits;
            }
        }

        if (digits[0] == 0) {
            int arr[] = new int[digits.length + 1];
            arr[0] = ++digits[0];
            return arr;
        }

        return new int[0];
    }
}
