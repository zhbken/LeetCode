package problems;

public class DecompressRunLengthEncodedList_1313 {

	public int[] decompressRLElist(int[] nums) {
		int arrSize = 0;
		for(int i = 0; i < nums.length; i=i+2) {
			arrSize += nums[i];
		}

		int[] arr = new int[arrSize];
		int arrIndex=0;
		for(int i = 0; i < nums.length; i=i+2) {
			for (int j = 0; j < nums[i]; j++) {
				arr[arrIndex++] = nums[i+1];
			}
		}

		return arr;
	}
}
