/*************************************
*   @author Harrison Jordan
*************************************/

/* Harrison Jordan
 * CS 3401
 * Section 02
 * Prof. Gayler
 * 02/11/2015
 * Assignment 4-1
 */
package Assignment4;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSets {
/*
 *Create two linked hash sets {"George", "Jim", "Blake", "Kevin", "Michael"} 
 *and {"George", "Katie", "Kevin", "Michelle", "Ryan"} and find their union, intersection, and difference.  
 *Note that you can clone the sets to preserve the original sets from being changed by these methods. 
 *
 */
	
	
	public static void main(String[] args) 
	{
		LinkedHashSet<String> one = new LinkedHashSet<String>();
		LinkedHashSet<String> two = new LinkedHashSet<String>();
		
		one.add("George");
		one.add("Jim");
		one.add("Blake");
		one.add("Kevin");
		one.add("Michael");
		
		two.add("George");
		two.add("Katie");
		two.add("Kevin");
		two.add("Michelle");
		two.add("Ryan");
	
		System.out.println("Union");
		LinkedHashSet<String> union = findUnion(one, two);
		System.out.println("\t" + union.toString());

		System.out.println("Intersection");
		LinkedHashSet<String> intersection = findIntersection(one, two);
		System.out.println("\t" + intersection.toString());
		
		System.out.println("Difference");
		LinkedHashSet<String> difference = findDifference(one, two);
		System.out.println("\t" + difference.toString());
		

	}

/**
 * @param takes in two linked hash sets
 * @return LinkedHashSet with the difference between the first set and second set. A - B = C
 */
private static LinkedHashSet<String> findDifference(LinkedHashSet<String> one, LinkedHashSet<String> two) {
		LinkedHashSet<String> s = new LinkedHashSet<String>();
		
		s.addAll(one);
		Object[] a = two.toArray();
		for(int i = 0; i < a.length; i++)
			if((s.contains(a[i])))
				s.remove((String) a[i]);
		
	
		return s;
	}
/**
 * @param takes in two linked hash sets
 * @return LinkedHashset with the intersection between the first set and second set. 
 */
private static LinkedHashSet<String> findIntersection(LinkedHashSet<String> one, LinkedHashSet<String> two) {
		LinkedHashSet<String> s = new LinkedHashSet<String>();
		
		Object[] a = one.toArray();
		Object[] b = two.toArray();
		for(int i = 0; i < a.length; i++)
			for(int j = 0; j < b.length; j++)
				if(a[i] == b[j])
					s.add((String) a[i]);
		
		return s;
	}
/**
 * @param takes in two linked hash sets
 * @return LinkedHashSet with the union between the two sets.
 */
private static LinkedHashSet<String> findUnion(LinkedHashSet<String> one, LinkedHashSet<String> two) {
		LinkedHashSet<String> s = new LinkedHashSet<String>();
		
		s.addAll(one);
		Object[] a = two.toArray();
		for(int i = 0; i < a.length; i++)
			if(!(s.contains(a[i])))
				s.add((String) a[i]);
		
		return s;
}
	
	

}
