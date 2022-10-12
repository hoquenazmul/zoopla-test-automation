package practice.collections.codes;

import org.apache.commons.lang.ArrayUtils;
import org.testng.annotations.Test;

public class ArraysClass {

	//@Test
	public void getSpecificNumFromArraysAndVariable() {
		int[] vowels = { 5, 20, 30, 45, 90, 80, 95, 100, 105, 115, 200, 225, 300, 305 };
		int number = 75;
		//Object[] both
		int[] resultArray = ArrayUtils.add(vowels, number);
		// using simple iteration over the array elements
		for (int found : resultArray) {
			if (found == number) {
				System.out.println(found);
				break;
		}		}		}
	@Test
		public  void mains() {
			 int[] num = {1, 2, 3, 4, 5};
			    int toFind = 3;
			    boolean found = false;

			    for (int n : num) {
			      if (n == toFind) {
			        found = true;
			        break;
			      }
			    }			    
			    if(found)
			      System.out.println(toFind + " is found.");
			    else
			      System.out.println(toFind + " is not found.");
			  }
	
	public static void main(String[] args) {
		// declaring and initializing 2D array
		int arr[][] = { { 1, 2, 3, 4 }, { 2, 4, 0, 6 }, { 4, 4, 5, 8 } };
		// First count the value as row
		// Second count as column
		int x = arr[1][2];
		System.out.println(x); // Outputs 0

		// printing 2D array
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

		// How to declare single dimensional array
		// Array length is fixed
		// Array is faster
/*
		 * String a[]= new String[1000];
		 * a[0] = "Alam"; 
		 * a[1] = "sazzad"; 
		 * a[2] = "Mir";
		 * a[3] = "Asif"; 
		 * a[4] = "Rehan"; 
		 * a[5] = "Rehan"; 
		 * for (int i =0; i<a.length;i++) { 
		 * System.out.println(a[i]); }
		 * 
		 * System.out.println(a[1]);
		 

		
		 * // This is the old way (single dimensional) 
		 * int num[]= new int[5]; 
		 * num[0] = 100; 
		 * num[1] = 200; 
		 * num[2] = 300; 
		 * num[3] = 400; 
		 * num[4] = 500;
		


		 * //System.out.println(Arrays.asList(num));
		 * 
		 * // This is the new way (single dimensional) 
		 * int []numbers = {100, 200, 300, 400, 500};
		
		 
		 * // How to declare multidimensional array 
		 * String[][] arr = {{"Sazzad", "Alam", "Mir","Asif", "Rehan"}, 
		 * {"smart", "tech", "fahima","rokeya", "sarmin"},
		 * {"Oni", "Ani", "Hassan","Rahaman", "All students"}} ;
		 */
	}
}