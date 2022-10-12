package selenium.chalenges;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

import org.testng.annotations.Test;

public class Encoded_Decoded {

	static String password = "SAYEDawan2008@";

	//@Test
	public void encodedPassword() {
		Encoder encoder = Base64.getEncoder();
		String originalString = password;
		String encodedString = encoder.encodeToString(originalString.getBytes());		
		System.out.println("This is my encoded password : "+ encodedString);
		
		
		
		Decoder decoder = Base64.getDecoder();
		byte[] bytes = decoder.decode(encodedString);		
		System.out.println("This my website password : "+ new String (bytes));		
		
	}
	
	@Test
	public void getUserName() {
		byte[] encoded = Base64.getEncoder().encode(password.getBytes());
		String encodedString = new String(encoded);
		System.out.println("This is my encoded password : "+ encodedString);

		
		byte[] bytes = Base64.getDecoder().decode(encoded);
		String decodedString = new String(bytes);
		System.out.println("This is my encoded password : "+ decodedString);
		
	}
	
	// How you create the functions 
	public static String getEncodedText(String text) {
		byte[] encoded = Base64.getEncoder().encode(text.getBytes());
		String encodedString = new String(encoded);		
		return encodedString;	
	}	
	public static String getDecodedText(String text) {
		byte[] bytes = Base64.getDecoder().decode(text.getBytes());
		String decodedString = new String(bytes);	
		return decodedString;
		
	}

}
