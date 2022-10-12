package practice.collections.codes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.testng.annotations.Test;

public class RemoveDuplicate {

	public static int[] removeDuplicates(int[] a) {
		int i = 1;
		while (i < a.length) {
			if (a[i] == a[i - 1]) {
				System.arraycopy(a, i + 1, a, i, a.length - i - 1);
				a = Arrays.copyOf(a, a.length - 1);
			} else {
				i++;
			}
		}
		return a;
	}

	public static void main(String[] args) {
		int[] a = removeDuplicates(new int[] { 1, 1, 2, 2, 2, 3, 4, 5, 5, 6 });

		for (int num : a) {
			System.out.println(num);
		}
	}

	// @Test
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

	// How to find out duplicate values from array ? NY square, N square NYS square
	@Test
	public static void getDuplicateElement() {
		String[] value = { "Java", "Selenium", "Maven", "TestNG", "Cucumber", "Java" };
		Set<String> store = new HashSet<>();
		for (String duplicate : value) {
			if (store.add(duplicate) == false) {
				System.out.println("This is my duplicate value : " + duplicate);
			}
		}
	}

	public static void main() {
		// ArrayList with duplicate elements
		ArrayList<Integer> numbersList = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 7, 8));

		System.out.println(numbersList);

		LinkedHashSet<Integer> hashSet = new LinkedHashSet<>(numbersList);

		ArrayList<Integer> listWithoutDuplicates = new ArrayList<>(hashSet);

		System.out.println(listWithoutDuplicates);
	}
}
