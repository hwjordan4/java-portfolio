/*
 * Harrison Jordan
 * CS3401
 * Section 02
 * Prof. Gayler
 * 03/13/2015
 * Assignment 6
 */

import java.util.*;



public class SortedArrays {
	/*
	 * Write a generic method that determines whether an array is sorted. Note
	 * that the boolean argument specifies whether the ordering being checked is
	 * ascending (true) or descending (false) order. You need to test your
	 * method using multiple arrays.
	 */

	public static void main(String[] args) {
		Integer[] integers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		Double[] doubles = {2.3, 2.2, 2.1, 2.0, 1.9, 1.8, 1.5};
		Character[] chars = {'a', 'c', 'z', 'd', 'f', 'l'};
		
		Comparator<Integer>comp = new CompareIntegers();
		Comparator<Double>comp1 = new CompareDoubles();
		Comparator<Character>comp2 = new CompareChars();
		    
		if(genericMethods.ordered(integers, comp, true))
			System.out.println("The integer array is sorted");
		else
			System.out.println("The integer array is not sorted");
		
		
		if(genericMethods.ordered(doubles, comp1, false))
			System.out.println("The doubles array is sorted");
		else
			System.out.println("The doubles array is not sorted");
		
		if(genericMethods.ordered(chars, comp2, true))
			System.out.println("The character array is sorted");
		else
			System.out.println("The character array is not sorted");
	}

}

class genericMethods {

	public static <E> boolean ordered(E[] list, Comparator<? super E> comp,
			boolean ascending) {
		assert (list != null);

		boolean sorted = true;

		if (list.length == 0 || list.length == 1) {
			sorted = true;
		}

		else {

			if (ascending) {
				int i = 1;
				while (i < list.length) {
					if (comp.compare(list[i - 1], list[i]) > 0)
						sorted = false;
					i++;
				}
			} else if (!ascending) {
				int i = 1;
				while (i < list.length) {
					if (comp.compare(list[i - 1], list[i]) < 0)
						sorted = false;
					i++;
				}
			}
		}

		return sorted;

	}
}
