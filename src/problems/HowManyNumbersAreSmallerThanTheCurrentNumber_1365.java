package problems;

import java.util.Arrays;

public class HowManyNumbersAreSmallerThanTheCurrentNumber_1365 {
	public int[] smallerNumbersThanCurrent(int[] nums) {
		int[] sortedArray = new int[nums.length];

		for (int i = 0; i < nums.length; i++) {
			sortedArray[i] = nums[i];
		}

		int[] resultArray = new int[nums.length];
		Arrays.sort(sortedArray);
		for (int i = 0; i < nums.length; i++) {
			int index = Arrays.binarySearch(sortedArray, nums[i]);

			for (int j = index; j >= 0; j--) {
				if (sortedArray[j] != sortedArray[index]) {
					resultArray[i] = j + 1;
					break;
				}
			}
		}
		return resultArray;
	}

	/**
	 * Constraints:
	 * 2 <= nums.length <= 500
	 * 0 <= nums[i] <= 100
	 */
	public int[] smallerNumbersThanCurrent_constraint_dependent(int[] nums) {
		int[] digitCountArr = new int[102]; // create digit counting array for 101 digits
		for (int i = 0; i < nums.length; i++) {
			digitCountArr[nums[i] + 1]++; // count each digit occupancy
		}
		for (int i = 0; i < 101; i++) {
			digitCountArr[i + 1] += digitCountArr[i]; // sum each prev digit counts
		}

		int[] resultArray = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			resultArray[i] = digitCountArr[nums[i]];
		}
		return resultArray;
	}
}
