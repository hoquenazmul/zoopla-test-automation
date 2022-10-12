package hashcodeAndEqual;

public class HashCodeAndEqual {
    // Hash code generate the unique number
	public static void main(String[] args) {
		Human alamHashCode = new Human(101, "Mohammed Alam");
		// Hash-code() belong to object class
		int alamID = alamHashCode.hashCode();
		System.out.println("This is alam ID : "+alamID);
		
		
		Human marwanHashCode = new Human(103, "Sayed Marwan");
		int marwanHashCodeID = marwanHashCode.hashCode();
		System.out.println("This is marwan ID : "+marwanHashCodeID);
		
		Human awanHashCode = new Human(104, "Sayed Awan");
		int awanID = awanHashCode.hashCode();
		System.out.println("This is awan ID : "+awanID);
		
		
		String stringHashCode = new String("Smart Tech");
		int stringID = stringHashCode.hashCode();
		System.out.println("This is smarttech ID : "+stringID);
		
	}
}
