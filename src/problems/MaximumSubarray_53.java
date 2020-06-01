package problems;

public class MaximumSubarray_53 {

    //Kadane’s Algorithm
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;

        int globalMax = Integer.MIN_VALUE;
        int localMax = 0;

        for (int i = 0; i < nums.length; i++) {
            localMax = Math.max(nums[i], nums[i] + localMax);
            if (localMax > globalMax) {
                globalMax = localMax;
            }
        }

        return globalMax;
    }

}
