package practice.collections.codes;

import org.testng.annotations.Test;

public class LoopingConcept {

	//@Test
	public static void basicLoop() {

		for (int i = 0; i < 10; i++) {
			System.out.println(i);
		}
	}
	
	//@Test
	public static void advanceLoop() {
      String []cars = {"BMW", "NISSAN", "TOYOTA", "TESLA"};
      System.out.println(cars);
      
	for (String myCar : cars) {
		System.out.println(myCar);
		}
	}
	
    //@Test
	public static void whileLoop() {
     int i = 1;
     while (true) {
    	 System.out.println(i);
    	 i++;
     }
     
	}
	
    @Test
	public static void doWhileLoop() {
     int i = 0;
    do {
    	 System.out.println(i);
    	 
    	 i++;
     } while(i<5);
     
	}
    
    
}

// 52-25 69th
// Maspeth, NY, 11378