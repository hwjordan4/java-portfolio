/*************************************
*   @author Harrison Jordan
*************************************/

/* Harrison Jordan
 * CS 3401
 * Section 02
 * Prof. Gayler
 * 02/02/2015
 * Assignment 3-2
 */
import java.util.*;

public class TestLinkedList {

	public static void main(String[] args) {
		
		// Creation of 500,000 elements in a linked list
		LinkedList<Integer> ints = new LinkedList<Integer>();
		int i = 0;
		while (i < 500000) {
			ints.add(i);
			i++;
		}
		
		// Time recorded for get() method in a loop
		long startTimeGET = System.currentTimeMillis();
		for (int j = 0; j < ints.size(); j++)
			ints.get(j);
		long endTimeGET = System.currentTimeMillis() - startTimeGET;
		
		
		// Time recorded for iterator() method 
		Iterator<Integer> iterator = ints.iterator();
		long startTimeITERATOR = System.currentTimeMillis();
		while(iterator.hasNext())
			iterator.next();
		long endTimeITERATOR = System.currentTimeMillis() - startTimeITERATOR;
		
		System.out.println("\nTraverse List Using Get Method: "+ endTimeGET + " milliseconds");
		System.out.println("\nTraverse List Using Iterator: "+ endTimeITERATOR + " milliseconds");
			

	}

}
