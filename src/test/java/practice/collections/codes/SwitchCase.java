package practice.collections.codes;

public class SwitchCase {
	public static void getDays(int days) {
		int day = days;
		String dayString;
		// switch statement with int data type
		switch (day) {
		case 1:
			dayString = "Monday";
			break;
		case 2:
			dayString = "Tuesday";
			break;
		case 3:
			dayString = "Wednesday";
			break;
		case 4:
			dayString = "Thursday";
			break;
		case 5:
			dayString = "Friday";
			break;
		case 6:
			dayString = "Saturday";
			break;
		case 7:
			dayString = "Sunday";
			break;
		default:
			dayString = "Invalid day";
		}
		System.out.println(dayString);
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		SwitchCase.getDays(3);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
