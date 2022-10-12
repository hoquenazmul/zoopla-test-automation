package practice.collections.codes;

//Java code to find largestthreeelements in an array

import java.util.Arrays;

class largestthreeelements {
	
	void find3largest(int[] arr) {
		Arrays.sort(arr); 
		int n = arr.length;
		int check = 0, count = 1;

		for (int i = 1; i <= n; i++) {

			if (count < 4) {
				if (check != arr[n - i]) {
					// to handle duplicate values
					System.out.print(arr[n - i] + " ");
					check = arr [n - i];
					count++;
				}
			} else
				break;
		}
	}

	// Driver code
	public static void main(String[] args) {
		largestthreeelements obj = new largestthreeelements();
		int[] arr = { 12, 45, 1, -1, 45, 54, 23, 5, 0, -10 };
		obj.find3largest(arr);
		
		
		int n = arr.length;
        print3largest(arr, n);
	}
	
	/* Function to print three largest elements */
    static void print3largest(int arr[], int arr_size)
    {
        int i, first, second, third;
 
        /* There should be atleast three elements */
        if (arr_size < 3) {
            System.out.print(" Invalid Input ");
            return;
        }
 
        third = first = second = Integer.MIN_VALUE;
        for (i = 0; i < arr_size; i++) {
            /* If current element is greater than first*/
            if (arr[i] > first) {
                third = second;
                second = first;
                first = arr[i];
            }
 
            /* If arr[i] is in between first and
            second then update second  */
            else if (arr[i] > second) {
                third = second;
                second = arr[i];
            }
 
            else if (arr[i] > third)
                third = arr[i];
        }
 
        System.out.println("Three largest elements are " + first + " " + second + " " + third);
    }
 


}
