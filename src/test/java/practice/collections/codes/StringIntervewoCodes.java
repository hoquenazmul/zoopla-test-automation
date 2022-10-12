package practice.collections.codes;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.testng.annotations.Test;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class StringIntervewoCodes {

	 //@Test
	public void countDuplicateString() {
		String str = "smarttechitsulition";
		Map<Character, Integer> charMap = new HashMap<Character, Integer>();
		char[] arr = str.toCharArray();
		for (char value : arr) {
			if (Character.isAlphabetic(value)) {
				if (charMap.containsKey(value)) {
					charMap.put(value, charMap.get(value) + 1);
				} else {
					charMap.put(value, 1);
				}
			}
		}
		System.out.println(charMap);
	}

	public static void main(String[] args) {
		//countDuplicateCharacters("infosys");
		
		String aa = "smarttechitsulition";
		String[] stringarray = aa.split("");
		Map<String, Long> map = Arrays.stream(stringarray)
				.collect(Collectors.groupingBy(c -> c, Collectors.counting()));
		map.forEach((k, v) -> System.out.println(k + " : " + v));
	}

	// @Test
	public static void stringLenth() {
		String name = "alam"; // Initializing a String Object name
		int length = name.length(); // Calling the inbuilt length() method
		System.out.println("The length of the String \"" + name + "\" is: " + length);

		int index = name.indexOf('m');
		System.out.printf("'m' is at index %d\n", index);
	}

	// @Test
	public static void reverseWords() {
		String[] myArray = { "one", "Two", "Three", "Four", "Five", "Six", "Seven" };
		System.out.println("Original Array:" + Arrays.asList(myArray));

		Collections.reverse(Arrays.asList(myArray));
		System.out.println("Reversed Array:" + Arrays.asList(myArray));

	}

 //@Test
	public static void revarseString() {
		String text = "Mohammed Alam";
		for (int i = (text.length() - 1); i >= 0; i--) {
			char reverse = text.charAt(i);
			System.out.print(reverse);
			
			
		}
	}

	// @Test
	public static void reverseNum() {
		int number = 987654, reverse = 0;
		while (number != 0) {
			int remainder = number % 10;
			reverse = reverse * 10 + remainder;
			number = number / 10;
		}
		System.out.println("The reverse of the given number is: " + reverse);
	}

	// @Test
	public static void splitTheWord() {
		{
			String str = "Mohammed J Alam";
			String[] arrOfStr = str.split(" ");

			for (String a : arrOfStr)

				System.out.println(a);
		}
	}

	// @Test
	public static void splitTheSentence() {
		String Str = new String("Welcome-to-String-Tutorial.");
		System.out.println("Return Value :");

		for (String retval : Str.split("-")) {
			System.out.println(retval);
		}
	}

	// @Test
	// How to count string words
	public static void getCharCount() {
		String exampleString = "This is just a sample string";
		int stringLength = exampleString.length();
		System.out.println("String length: " + stringLength);
		int stringLengthWithoutSpaces = exampleString.replace(" ", "").length();
		System.out.println("String length without counting whitespaces: " + stringLengthWithoutSpaces);
	}

	//@Test
	// How to count char from strings
	public static void getCharCountWOrd() {
		String exampleString = "This is just a sample string";
		int totalCharacters = 0;
		char temp;
		for (int i = 0; i < exampleString.length(); i++) {
			temp = exampleString.charAt(i);
			if (temp == 'j')
				totalCharacters++;
		}
		System.out.println("i appears " + totalCharacters + " times in exampleString");
	}

	// @Test
	// How to count char from strings
	public static void getToVerifyTheWord() {
		String[] alphabet = new String[] { "A", "B", "C" };
		// Convert String Array to List
		List<String> list = Arrays.asList(alphabet);
		if (list.contains("A")) {
			System.out.println("Hello A");
		}
	}

	// @Test
	// How to count char from strings
	public void convartIntToString() {
		int d = 1234;
		String str = new Integer(d).toString();
		System.out.println("String str = " + str);

		// How to convert String to int
		String strs = "0111";
		int t = Integer.parseInt(strs);
		System.out.println("Int strs = " + t);
	}

	//@Test
	// Difference between == and .equals() method in Java?
	// Ans: In general, both equals() and “==” operator in Java are used to
	// compare objects to check equality but here are some of the differences
	// between the two:

	public void andEqualDifference() {
		String s1 = "HELLO";
		String s2 = "HELLO";
		System.out.println("Variable & Variable is true if == sign : " + (s1 == s2)); // true
		System.out.println("Variable & Variable is true if equal method : " + s1.equals(s2)); // true

		String s3 = new String("HELLO");
		System.out.println("Variable & Object compare is false if == sign : " + (s1 == s3)); // false

		System.out.println("Variable & Object is true if equal method : " + s1.equals(s3)); // true

		String s5 = new String("ALAM");
		String s6 = new String("ALAM");
		System.out.println("Object to object equal is true " + s5.equals(s6)); // true
		System.out.println("Object to object == is false " + (s5 == s6)); // false
	}
	     //@Test
		/// Function to print all duplicate  characters in string using HashMap
	    public static void countDuplicateCharacters()  {  
	    	String str = "Infosys";
	        // Creating a HashMap containing char
	        // as a key and occurrences as a value
	        Map<Character, Integer> map = new HashMap<Character, Integer>();
	  
	        // Converting given string into  a char array
	        char[] charArray = str.toCharArray();
	  
	        // Checking each character of charArray
	        for (char value : charArray) {
	  
	            if (map.containsKey(value)) {
	  
	                // If character is present  in map incrementing it's count by 1
	                map.put(value, map.get(value) + 1);
	            }
	            else {
	  
	                // If character is not present in map putting this character into map with 1 as it's value.
	                map.put(value, 1);
	            }
	        }
	  
	        // Traverse the HashMap, check  if the count of the character
	        // is greater than 1 then print  the character and its frequency
	        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
	  
	            if (entry.getValue() > 1) {
	                
	            	System.out.println(entry.getKey() + " : " + entry.getValue());
	            }
	        }
	    }
	  @Test
	     public static void getDuplicates() {
	    	 String str = "Infosys";
	    	    String t = "";
	    	    for (int i = 0; i < str.length() - 1; i++) {

	    	      	
	    	        for (int j = i + 1; j < str.length(); j++) {
	    	        	
	    	            if (str.charAt(i) == str.charAt(j) && !t.contains(str.charAt(j) + "")) {
	    	                t = t + str.charAt(i);
	    	            }
	    	        }
	    	    }
	    	    
	    	    
	    	    System.out.println("Duplicates : "+ t);
	    	}

	  
	  
	//@Test
    public static void main() {
		String str = "Nebraska  Nevada  New Hampshire  New Jersey  New Mexico"; 
		String str2 = "Arizona  Arkansas Nebraska  Nevada  New Hampshire  New Jersey  New Mexico";
		if (str.compareTo(str2) == 0)
		{

    }

}}