package problems;

public class FindNumbersWithEvenNumberOfDigits_1295 {
	public int findNumbers(int[] nums) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			int x = nums[i];
			int digitCount = 0;
			while (x != 0) {
				x = x / 10;
				digitCount++;
			}
			if (digitCount % 2 == 0) {
				count++;
			}
		}
		return count;
	}
}
