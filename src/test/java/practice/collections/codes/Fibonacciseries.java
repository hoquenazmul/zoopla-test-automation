package practice.collections.codes;

public class Fibonacciseries {

	 public static void main(String[] args) {

    // In fibonacci series, next number is the sum of previous 
	// two numbers for example 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 etc. 
    // The first two numbers of fibonacci series are 0 and 1. 
	// There are two ways to write the fibonacci series program in java: 
	// Fibonacci Series without using recursion.
		 
		    int n = 10, firstTerm = 0, secondTerm = 1;
		    System.out.println("Fibonacci Series till " + n + " terms:");

		    for (int i = 1; i <= n; ++i) {
		      System.out.print(firstTerm + ", ");

		      // compute the next term
		      int nextTerm = firstTerm + secondTerm;
		      firstTerm = secondTerm;
		      secondTerm = nextTerm;
		    }
		  }
		}