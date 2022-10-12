package practice.collections.codes;

import org.testng.annotations.Test;

class PalindromeExample {

	// Palindrome Program in Java   
	// Prime number in Java: Prime number is a number that is greater   
	// than 1 and divided by 1 or itself only. In other words,  
	// prime numbers can't be divided by other numbers than itself 
	// or 1. For example 2, 3, 5, 7, 11, 13, 17.... are the prime numbers.

	@Test
	public static void PalindromeExample1() {
		int r, sum = 0, temp;
		int n = 454;  // It is the number variable to be checked for palindrome
		temp = n;
		while (n > 0) {
			r = n % 10;  // getting remainder
			sum = (sum * 10) + r;
			n = n / 10;
		}	
		if (temp == sum)
			System.out.println("palindrome number : " + temp);
		else
			System.out.println("not palindrome : " + temp);
	}
	
	@Test
	public static void PalindromeExample2() {
		String str = "mom", reverseStr = "";
		int strLength = str.length();

		for (int i = (strLength - 1); i >= 0; --i) {
			reverseStr = reverseStr + str.charAt(i);
		}
		if (str.toLowerCase().equals(reverseStr.toLowerCase())) {
			System.out.println(str + " is a Palindrome String.");
		} else {
			System.out.println(str + " is not a Palindrome String.");
		}
	}
}
