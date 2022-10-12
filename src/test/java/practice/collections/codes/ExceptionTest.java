package practice.collections.codes;

import java.io.File;
import java.io.FileReader;
import org.testng.annotations.Test;
import java.io.FileNotFoundException;

public class ExceptionTest {

	// @Test
	public static void ArithmeticException() {
		int a = 0, b = 10;
		int c = 0;
		try {
			c = b / a;
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
			System.out.println("We are just printing the stack trace.\n"
					+ "ArithmeticException is handled. But take care of the variable \"c\"");
		}
		System.out.println("Value of c :" + c);
	}

	// @Test
	public static void NullPointerException() {
		try {
			String a = ""; // null value
			System.out.println(a.charAt(0));
		} catch (NullPointerException e) {
			System.out.println("NullPointerException..");
		}
	}

	// @Test
	public static void FileNotFoundException() {
		try {
			// Following file does not exist
			File file = new File("E://filelkjh'oi.txt");
			FileReader fr = new FileReader(file);
		} catch (FileNotFoundException e) {
			System.out.println("File does not exist");
		}
	}

	// @Test
	public static void NumberFormatException() {
		try {
			// "alam" is not a number
			int num = Integer.parseInt("alam");
			System.out.println(num);
		} catch (NumberFormatException e) {
			System.out.println("Number format exception");
		}
	}

	// @Test
	public static void ArrayIndexOutOfBoundsException() {
		try {
			int a[] = new int[5];
			a[6] = 9; // accessing 7th element in an array of size 5
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Array Index is Out Of Bounds");
		}
	}

	@Test
	public static void tryCatch() {
		try {
			int a = 0, b = 10;
			int c = 0;
			c = b / a;
		} catch (ArithmeticException e) {
			System.out.println("Arithmetic Exception occurs");

			int a[] = new int[5];
			a[6] = 9; // accessing 7th element in an array of size 5
		} catch (ArrayIndexOutOfBoundsException e) {

			System.out.println("ArrayIndexOutOfBounds Exception occurs");
		}

		catch (Exception e) {

			System.out.println("Parent Exception occurs");
		}
		System.out.println("rest of the code");
	}

	// @Test
	public static void tryCatchFinaly() {
		int a[] = new int[2];
		try {
			System.out.println("Access element three :" + a[3]);

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Exception thrown :" + e);

		} finally {
			a[0] = 6;
			System.out.println("First element value: " + a[0]);
			System.out.println("The finally statement is executed");
		}
	}

	// @Test
	static void validate_Age(int age) {
		// if specified age is < 18, throw ArithmeticException
		if (age < 18) {
			throw new ArithmeticException("Not eligible to vote and drive!!");
		} else // print the message
			System.out.println("Eligible to vote and drive!!");
	}

	// @Test
	public static void main(String args[]) {
		// call validate_Age method
		validate_Age(10);

	}
}
