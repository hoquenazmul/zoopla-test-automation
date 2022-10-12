package practice.collections.codes;

public class garbagecollecting {
	
	// The Garbage collector only collects the objects that are created using the new keyword. 
	// For other objects, we have to use the finalize () method to perform the cleanup.
	
	
	// finalize method: called on object once
	// before garbage collecting it
	protected void finalize() throws Throwable {
		System.out.println("Garbage collector called");
		System.out.println("Object garbage collected : " + this);
	}

	
	public static void main(String args[]) {
		garbagecollecting gc1 = new garbagecollecting();
		garbagecollecting gc2 = new garbagecollecting();
		gc1 = null; // nullify gc1

		System.gc(); // request for GC to run
		gc2 = null; // nullify gc2
		Runtime.getRuntime().gc(); //request for GC to run
	}
}
