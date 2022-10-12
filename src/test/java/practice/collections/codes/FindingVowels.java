package practice.collections.codes;

public class FindingVowels {

	// You can read a character in a String using the charAt() method.
	// To find the vowels in a given String you need to compare every
	// character in it with the vowel letters.

	public static void main(String args[]) {
		reverseVowels("MohammedAlam");
		String str = new String("Hi Welcome to Tutorialspoint");
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o'
					|| str.charAt(i) == 'u') {
				System.out.println("Given string contains " + str.charAt(i) + " at the index " + i);
			}
		}
	}

	public static String reverseVowels(String s) {
		StringBuilder sb = new StringBuilder();
		char[] ch = s.toCharArray();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u'
					|| c == 'U') {
				sb.append(c);

			}
		}
		if (sb.length() < 1)
			return s;
		sb.reverse();
		for (int i = 0, j = 0; i < ch.length; i++) {
			if (ch[i] == 'a' || ch[i] == 'A' || ch[i] == 'e' || ch[i] == 'E' || ch[i] == 'i' || ch[i] == 'I'
					|| ch[i] == 'o' || ch[i] == 'O' || ch[i] == 'u' || ch[i] == 'U') {
				ch[i] = sb.charAt(j++);
			}
		}
		return String.valueOf(ch);
	}
}
