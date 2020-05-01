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
					resultArray[i] = j+1;
					break;
				}
			}
		}
		return resultArray;
	}
}
