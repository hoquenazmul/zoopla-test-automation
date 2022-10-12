package practice.collections.codes;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

public class MapClass {

// Why you need map or how you handle data structure or how you store the data in excel sheet? 
// By map family 

// Map is a interface & implemented many class, HashMap, HashTable, LinkedHashMap, TreeMap etc..
// Map dosen't allow duplicate keys 
// Map allow only one null key 
// Map allow as many as duplicate values  

	// @Test
	public void getMap() {
		Map<Integer, String> map = new HashMap<>();
		map.put(101, "Sarower");
		map.put(102, "Alam");
		map.put(103, "Liton");
		map.put(104, "Ruhul");
		map.put(105, "Sobhan");
		map.put(null, "Sobhan");
		map.put(null, "Sobhan");

		// for (String name : map) {

		for (Entry<Integer, String> name : map.entrySet()) {
			System.out.println("Key Num : " + name.getKey() + " Values : " + name.getValue());
			// System.out.println(" Values : " + name.getValue());

		}
	}

	@Test
	public void getUniquValues() {
		Map<Integer, String> map = new HashMap<>();
		map.put(101, "Alam");
		map.put(102, "Alam");
		map.put(103, "Alam");
		map.put(104, "Alam");
		map.put(105, "Alam");

	for (Entry<Integer, String> name : map.entrySet()) {
			System.out.println("Key Num : " + name.getKey() + " Values : " + name.getValue());
			// System.out.println(" Values : " + name.getValue());

		}
	}

	// Why & when to use map?
	// Maps are perfect to use for key-value association mapping such as
	// dictionaries
	// The map are used to perform lookups by keys or when some one wants to
	// retrieve
	// and update element by keys

	// What is the deference between HashMap & HashTable
	// HashMap:
	// Non Synchronized
	// We can make the HashMap as synchronized by calling this code Map object =
	// synchronized
	// HashMap allows only one null key & multiple null values
	// HashMap is a new class from JDK 1.2
	// HashMap Is faster
	// HashMap inherit abstructMap class

	// HashTable: Synchronized
	// Synchronized
	// HashTable is internally Synchronized and can't be un-Synchronized
	// HashTable dosen't allows null key and value
	// HashTable is slow
	// HashTable inherits from dictionary class

}