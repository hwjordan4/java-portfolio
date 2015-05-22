/*************************************
*   @author Harrison Jordan
*************************************/
/* Harrison Jordan
 * CS 3401
 * Section 02
 * Prof. Gayler
 * 03/22/2015
 * Assignment 7
 */
import java.util.ListIterator;

public class TestTwoWayLinkedList {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		TwoWayLinkedList<String> list = new TwoWayLinkedList<String>();

		list.add("FC Barcelona");
		System.out.println("(1) " + list);

		list.add(0, "Real Madrid");
		System.out.println("(2) " + list);

		list.add("Manchester United");
		System.out.println("(3) " + list);

		list.add(2, "Chelsea");
		System.out.println("(4) " + list);

		list.addFirst("Liverpool");
		System.out.println("(5) " + list);

		list.remove(3);
		System.out.println("(6) " + list);

		if (list.contains("Real Madrid"))
			System.out.println("(7) Contain method works.");

		list.removeLast();
		System.out.println("(8) " + list);

		System.out.print("(9) List Iterator: ");
		ListIterator<String> li = list.listIterator();
		while (li.hasNext())
			System.out.print(li.next() + " ");

		list.clear();
		System.out.println("\nAfter clearing the list, the list size is "
				+ list.size());
		
	
		
	}
}
