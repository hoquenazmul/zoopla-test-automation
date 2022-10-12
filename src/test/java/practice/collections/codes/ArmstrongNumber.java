package practice.collections.codes;

import org.testng.annotations.Test;

public class ArmstrongNumber {

	//Armstrong Number
	// An Armstrong number is a positive m-digit number that is equal to the 
	//sum of the mth powers of their digits. It is also known as pluperfect, 
	// or Plus Perfect, or Narcissistic number. It is an OEIS sequence A005188. 
	// Let’s understand it through an example.

	//Armstrong Number Example
	// 1: 11 = 1

	// 2: 21 = 2
	// 3: 31 = 3

	// 153: 13 + 53 + 33 = 1 + 125+ 27 = 153

	// 125: 13 + 23 + 53 = 1 + 8 + 125 = 134 (Not an Armstrong Number)

	// 1634: 14 + 64 + 34 + 44 = 1 + 1296 + 81 + 256 = 1643
	

    public static void main(String[] args) {

        int number = 371, originalNumber, remainder, result = 0;

        originalNumber = number;

        while (originalNumber != 0)
        {
            remainder = originalNumber % 10;
            result += Math.pow(remainder, 3);
            originalNumber /= 10;
        }

        if(result == number)
            System.out.println(number + " is an Armstrong number.");
        else
            System.out.println(number + " is not an Armstrong number.");
    }
    

    
    int power(int x, long y)
    {
        if (y == 0)
            return 1;
        if (y % 2 == 0)
            return power(x, y / 2) * power(x, y / 2);
        return x * power(x, y / 2) * power(x, y / 2);
    }
  
    /* Function to calculate order of the number */
    int order(int x)
    {
        int n = 0;
        while (x != 0) {
            n++;
            x = x / 10;
        }
        return n;
    }
  
    // Function to check whether the given number is
    // Armstrong number or not
    boolean isArmstrong(int x)
    {
        // Calling order function
        int n = order(x);
        int temp = x, sum = 0;
        while (temp != 0) {
            int r = temp % 10;
            sum = sum + power(r, n);
            temp = temp / 10;
        }
  
        // If satisfies Armstrong condition
        return (sum == x);
    }
  
    // Driver Program
    @Test
    public static void main()
    {
    	ArmstrongNumber ob = new ArmstrongNumber();
        int x = 153;
        System.out.println(x + " : " + ob.isArmstrong(x));
        x = 1253;
        System.out.println(x + " : " + ob.isArmstrong(x));
    }
}


