package practice.collections.codes;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class DuplicatesCarecters {

    public static void main(String[] args) {

        String input = "iabccdeffghhijkkkl";

       // findDuplicate1(input);
       // findDuplicate2(input);
        findDuplicate3(input);

    }

    private static void findDuplicate3(String input) {

        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();

        for (int i = 0; i < input.length() - 1; i++) {
           // int ch = input.charAt(i);
            if (hm.containsKey(input.charAt(i))) {
                int value = hm.get(input.charAt(i));
                hm.put(input.charAt(i), value + 1);
            } else {
                hm.put(input.charAt(i), 1);
            }
        }
        Set<Entry<Character, Integer>> entryObj = hm.entrySet();
        for (Entry<Character, Integer> entry : entryObj) {

            if (entry.getValue() > 1) {
                System.out.println("Duplicate: " + entry.getKey());
            }
        }

    }

    private static void findDuplicate2(String input) {

        int i = 0;

        for (int j = i + 1; j < input.length(); j++, i++) {

            if (input.charAt(i) == input.charAt(j)) {
                System.out.println("Duplicate is: " + input.charAt(i));
            }
        }

    }

    private static void findDuplicate1(String input) {
        for (int i = 0; i < input.length(); i++) {

            for (int j = i + 1; j < input.length(); j++) {

                if (input.charAt(i) == input.charAt(j)) {
                    System.out.println("Duplicate is: " + input.charAt(i));
                }
            }
        }
    }
}