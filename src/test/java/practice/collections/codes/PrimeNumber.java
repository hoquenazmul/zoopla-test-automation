package practice.collections.codes;

import org.testng.annotations.Test;

public class PrimeNumber {

	// Prime number in Java: Prime number is a number that is greater than 1 and
	// divided by 1 or itself only. In other words, prime numbers can't be divided 
	// by other numbers than itself or 1. For example 2, 3, 5, 7, 11, 13, 17.... 
	// are the prime numbers.
	@Test
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
	
}
	
