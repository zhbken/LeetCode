package challenge.may_2020;

public class MaximumSumCircularSubarray_918 {

    // 5,-3,5,  5,-3,5
    public int maxSubarraySumCircular(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        if (A.length == 1) {
            return A[0];
        }

        //corner case when all elements are negative
        int min = A[0]; boolean hasPositive = A[0] >= 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] >= 0) {
                hasPositive = true;
                break;
            } else {
                if (A[i] > min) {
                    min = A[i];
                }
            }
        }

        if (!hasPositive) {
            return min;
        }

        int maxOne = maxSubArrayKandane(A);
        int totalSum = 0;
        for (int i = 0; i < A.length; i++) {
            totalSum += A[i];
            A[i] = -A[i];
        }
        int minSum = maxSubArrayKandane(A);
        // add minSum, because array sign was modified
        return Math.max(maxOne, totalSum + minSum);
    }

    public int maxSubArrayKandane(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int globalMax = nums[0];
        int localMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            localMax = Math.max(nums[i], nums[i] + localMax);
            if (localMax > globalMax) {
                globalMax = localMax;
            }
        }

        return globalMax;
    }

    public int maxSubarraySumCircular2(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        if (A.length == 1) {
            return A[0];
        }

        int N = A.length;
        int globalMax = A[0];
        int localMax = A[0];

        int b = 1;
        for (int i = 1; i < 2 * N; i++) {
            if (A[i % N] < A[i % N] + localMax) {
                localMax = A[i % N] + localMax;
                b++;
            } else {
                localMax = A[i % N];
                b = 1;
            }

            if (b == N) {
                localMax = localMax - A[(i - b+1)%N];
                b--;
            }

            if (localMax > globalMax && b <= N) {
                globalMax = localMax;
            }
        }

        return globalMax;
    }
}
