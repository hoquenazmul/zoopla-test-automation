package practice.collections.codes;

import java.util.HashSet;
import java.util.Set;

public class SetClass {

	// Set is an interface implemented many classes like, HashSet, LikedHashSet,
	// TreeSet
	// Set cannot handle duplicate values
	// Set can handle only unique values
	// Set can handle only one null value
	// Set wee cannot find the index values
	// Set dose not maintain the insertion order
	// Set is Non-synchronized or not thread safe

	// Array-list is faster (non synchronized)
	// Compare to array-list array is faster
	// Array following the index
	// When array list add the new value is faster
	// when array list add the value memory size increase 50%
	// Array list allow the null value as much requirement

// 1, HashSet: If you don't want to maintain insertion order but wan to store unique values
// 2, LinkedHashSet : synchronized, If you want maintain the insertion order then you have to use LinkedHashSet
// 3, TreeSet, If you want to sort the elements then you have to use TreeSet

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		set.add("Python");
		set.add("Ruby");
		set.add("Java");
		set.add("Java");
		set.add("C++");
		set.add("C#");
		set.add("PHP");
		set.add(null);
		set.add(null);
		set.add(null);

		System.out.println(set);
		System.out.println(set.contains("Ruby"));

	}

}
