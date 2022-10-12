package hashcodeAndEqual;

public class Human {
	// what is difference between hash-code and equals in java
	
	
	// When we create the class internally parent class is object
	// class & contain 11 different method, Hash code method one of them

	// So human class extends object class to call hash code method

	public int dlNum;
	public String name;

	public Human(int dlNum, String name) {
		this.dlNum = dlNum;
		this.name = name;
	}

// @Override
// type hash-code & hit control space then automatically pup-up hash-code method
// public int hashCode() {
// Hash-code method call object class that's why we are see super keyword
// return super.hashCode(); 
//	}
	
	@Override
	//type hash-code & hit control space then automatically pup-up hash-code method
	public int hashCode() {
	// Hash-code method call object class that's why we are see super keyword
	return dlNum; 
	}
}
