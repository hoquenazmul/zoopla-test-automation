package practice.collections.codes;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

public class EvenOrOddNumber {

	
	public static void main(String[] args) {
		// How you find out even number & odd number
		for (int i = 0; i <= 100; i++) {
			if (i % 2 == 0) { // Remainder or mod

				System.out.println("Even number::" + i);
			} else {
				System.out.println("Odd number::" + i);

			}
		}

	}
	public static boolean isOdd(int value) {
		if ((value % 2) == 0) {
			return false;
		} else if ((value % 2) > 0) {
		}
		return true;
	}

	@Test
	public static void main() {
	    // Integer[] values = {11,12,22,15,86,55,33,64};
		
		
		List<Integer> numberList = Arrays.asList(11,12,22,15,86,55,33,64);

		numberList.stream().filter(n -> n % 2 != 0).forEach(System.out::println);
		
		
		
		List<String> tihList = Arrays.asList("Java", "Python", "R", "C", "C++", "Hadoop");

		//using lambda expression
		tihList.forEach(p -> System.out.println(p));

	}
}
