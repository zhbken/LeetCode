package challenge.may_2020;

public class ValidPerfectSquare_367 {

    public boolean isPerfectSquare(int num) {
        int head = 1, tail = num;
        int mid = 0;
        while (head <= tail) {
            mid = head + (tail - head) / 2;
            if (mid == num / mid && num % mid == 0) {
                return true;
            }

            if (mid > num / mid) {
                tail = mid - 1;
            } else {
                head = mid + 1;
            }
        }
        return false;
    }

    public boolean isPerfectSquareNewtons(int num) {
        if (num < 1) return false;
        long t = num / 2;
        while (t * t > num) {
            t = (t + num / t) / 2;
        }
        return t * t == num;
    }
}
