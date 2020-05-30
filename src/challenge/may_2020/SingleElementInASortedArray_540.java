package challenge.may_2020;

public class SingleElementInASortedArray_540 {

    /**
     * Input:nums =[3,3,7,7,10,11,11]
     * Input:nums = [3, 3, 7, 7, 10, 11, 11]
     * Output:10
     */
    public int singleNonDuplicate(int[] nums) {
        int head = 0, tail = nums.length - 1, mid = 0;
        while (head < tail) {
            mid = head + (tail - head) / 2;
            if (mid % 2 == 0 && nums[mid] == nums[mid + 1]) {
                head = mid + 2;
            } else if (mid % 2 == 1 && nums[mid] == nums[mid - 1]) {
                head = mid + 1;
            } else if (mid%2 == 1 && nums[mid] != nums[mid - 1]) {
                tail = mid - 1;
            } else if (mid % 2 == 0 && nums[mid] != nums[mid + 1]) {
                tail = mid - 1;
            }
        }

        return nums[head];
    }

}
