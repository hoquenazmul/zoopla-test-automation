package practice.collections.codes;

import java.util.Arrays;

public class FindArrayNumberOneOne {

	// Given a sorted array num, remove the duplicates in-place such that duplicates appeared
	// at most twice and return the new length.Note that the input array is passed in by 
	// reference, which means a modification to the input array will be known to the 
	// caller.Example:
	
		//Input: nums = [0,0,1,1,1,1,2,3,3]
		//Output: 7, nums = [0,0,1,1,2,3,3]
		//Explanation: Your function should return length = 7	
	
	
	public static void main(String[] args) {
		int[] x = { 0, 0, 1, 1, 1, 1, 2, 3, 3 };
		System.out.println("Input Array: " + Arrays.toString(x));
		int outArrLength = processArray(x);
		System.out.println(outArrLength);
		System.out.println("Output Array:");
		for (int i = 0; i < outArrLength; i++) {
			System.out.print(x[i] + " ");
		}
		System.out.println();
	}

	public static int processArray(int[] arr) {
		int arrLength = arr.length;
		int j = 0;
		for (int i = 0; i < arrLength; i++) {
			if (i < arrLength - 2 && arr[i] == arr[i + 2]) {
				continue;
			}
			arr[j++] = arr[i];
		}
		return j;
	}
}
