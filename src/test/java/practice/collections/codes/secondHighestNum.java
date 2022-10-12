package practice.collections.codes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.testng.annotations.Test;

public class secondHighestNum {
	// How to find second highest number 1st way
	//@Test
	public static void secoundNum() {
		int array[] = { 10, 20, 25, 63, 96, 57 };
		int size = array.length;
		Arrays.sort(array);
		System.out.println("sorted Array ::" + Arrays.toString(array));
		int res = array[size - 2];
		System.out.println("2nd largest element is ::" + res);
	}

	// How to find second highest number 2nd way
	 @Test
	public static void sortedtest() {
		int[] randomIntegers = { 1, 5, 4, 2, 8, 1, 8, 9, 9 };
		SortedSet<Integer> set = new TreeSet<Integer>();
		for (int i : randomIntegers) {
			set.add(i);
		}
		// Remove the maximum value; print the largest remaining item
		set.remove(set.last());

		System.out.println("second highest number is : " + set.last());
		System.out.println("<<<<<<<<<<End>>>>>>>>>>>>");
	}

	// How to find prime number
	//@Test
	public static void findprimeNum() {
		int num = 13;
		for (int i = 2; i < num / 2; i++) {
			if (num % i == 0) {
				System.out.println(" Not prime number ::" + num);
				break;
			} else {
				System.out.println("This is a prime number ::" + num);
				break;
			}
		}
	}
  //@Test
	public void getHighestNum() {
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(1);
		al.add(2);
		al.add(3);
		al.add(4);
		al.add(4);
		al.add(4);
		al.add(3);
		al.add(3);
		System.out.println(al);

		List<Integer> duplicate = al.stream().distinct().collect(Collectors.toList());
		System.out.println("My unique value is :" + duplicate);
		
		int j = Collections.max(duplicate);		
		duplicate.remove(duplicate.indexOf(j));
		
		int max2 = Collections.max(duplicate);
		System.out.println(max2);
	}
}