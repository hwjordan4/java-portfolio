/* Harrison Jordan
 * CS 3401
 * Section 02
 * Prof. Gayler
 * 03/22/2015
 * Assignment 7
 */

import java.util.AbstractSequentialList;
import java.util.Iterator;
import java.util.ListIterator;

/*
 * Using the author's MyLinkedList class as a guide, 
 * implement a new class TwoWayLinkedList that uses a doubly linked list to store elements.  
 * This new class needs to extend the java.util.AbstractSequentialList class.  
 * 
 * You need to implement all the methods in MyLinkedList as well as the methods listIterator() 
 * and listIterator (int index).  
 * 
 * Both return an instance of java.util.ListIterator<E>.  
 * The former sets the cursor to the head of the list and the latter to the element at the specified index.
 */
@SuppressWarnings("rawtypes")
public class TwoWayLinkedList<E> extends AbstractSequentialList {

	private Node<E> head, tail;
	private int size = 0;

	public TwoWayLinkedList() {
		
	}

	@SuppressWarnings("unchecked")
	public TwoWayLinkedList(E[] objects) {
		for (int i = 0; i < objects.length; i++){
			add(objects[i]);
			size++;
		}
	}

	/** Return the head element in the list */
	public E getFirst() {
		if (size == 0) {
			return null;
		} else {
			return head.element;
		}
	}

	/** Return the last element in the list */
	public E getLast() {
		if (size == 0) {
			return null;
		} else {
			return tail.element;
		}
	}

	/** Add an element to the beginning of the list */
	public void addFirst(E e) {
		Node<E> newNode = new Node<E>(e);
		
		if(size == 0){
			head = tail = newNode;
			newNode.next = null;
			
		}
		else{
			Node<E> temp = head;
			newNode.next = temp;
			temp.previous = newNode;
			head = newNode;
			
		}
		if (tail == null)
			tail = head;
		
		size++;
	}

	/** Add an element to the end of the list */
	public void addLast(E e) {
		Node<E> newNode = new Node<E>(e);
		newNode.element = e;
		if (tail == null) {
			head = tail = newNode;
		} else {

			newNode.previous = tail;
			tail.next = newNode;
			tail = tail.next;
		}

		size++;
	}

	@SuppressWarnings("unchecked")
	public void add(int index, Object e) {
		if (index == 0) {
			addFirst((E) e);
		} else if (index >= size) {
			addLast((E) e);
		} else {
			
			Node<E> current = head;
			for (int i = 1; i < index; i++) {
				current = current.next;

			}
			Node<E> temp = current.next;
			current.next = new Node<E>((E) e);
			(current.next).next = temp;
			(current.next).previous = current;
			size++;
		}
	}

	public E removeFirst() {
		if (size == 0) {
			return null;
		} else {
			Node<E> temp = head;
			head = head.next;
			head.previous = null;
			size--;
			if (head == null) {
				tail = null;
			}
			return temp.element;
		}
	}

	public E removeLast() {
		if (size == 0) {
			return null;
		} else if (size == 1) {
			Node<E> temp = head;
			head = tail = null;
			size = 0;
			return temp.element;
		} else {
			Node<E> current = head;

			for (int i = 0; i < size - 2; i++) {
				current = current.next;
			}

			Node<E> temp = tail;
			tail = current;
			tail.previous = current.previous;
			tail.next = null;
			size--;
			return temp.element;
		}
	}

	public E remove(int index) {
		if (index < 0 || index >= size) {
			return null;
		} else if (index == 0) {
			return removeFirst();
		} else if (index == size - 1) {
			return removeLast();
		} else {
			Node<E> previous = head;

			for (int i = 1; i < index; i++) {
				previous = previous.next;
			}

			Node<E> current = previous.next;
			previous.next = current.next;
			previous.previous = previous;
			size--;
			return current.element;
		}
	}

	public String toString() {
		String result = ("[");

		Node<E> current = head;
		for (int i = 0; i < size; i++) {
			result += current.element;
			current = current.next;
			if (current != null) {
				result += ", "; // Separate two elements with a comma
			} else {
				result += "]"; // Insert the closing ] in the string
			}
		}

		return result;
	}

	public void clear() {
		size = 0;
		head = tail = null;
	}

	public boolean contains(Object e) {
		boolean contains = false;
		Node<E> current = head;
		for (int i = 0; i < size; i++) {
			if (e == current.element)
				contains = true;
			current = current.next;
		}
		return contains;
	}

	@SuppressWarnings("unchecked")
	public E get(int index) {
		E element = null;
		Node<E> current = head;
		if (index < 0 || index >= size)
			return null;
		else {
			while (index > 0) {
				current = current.next;
				index--;
			}
			element = (E) current;
			return element;
		}
	}

	@SuppressWarnings("unchecked")
	public int indexOf(Object e) {
		int index = -1;
		boolean match = false;
		Node<E> current = head;
		if (head == (E) e)
			return 0;
		else {
			int i = 1;
			while (!match && i < size) {
				if (current == (E) e) {
					index = i;
					match = true;
				}
				current = current.next;
				i++;
			}
		}
		return index;
	}

	public int lastIndexOf(Object e) {
		int index = -1;
		boolean match = false;
		Node<E> current = tail;
		if (tail == (E) e)
			return size - 1;
		else {
			int i = size;
			while (!match && i > 0) {
				if (current == (E) e) {
					index = i;
					match = true;
				}
				current = current.previous;
				i--;
			}
		}
		return index;
	}

	public E set(int index, Object e) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException();
		else if (index == 0)
			head.element = (E) e;
		else if (index == size)
			addLast((E) e);
		else {
			Node<E> current = head;
			for (int i = 0; i < index; i++)
				current = current.next;
			current.element = (E) e;

		}
		return null;

	}

	public Iterator iterator() {

		return new DoublyLinkedListIterator();
	}

	@Override
	public ListIterator listIterator(int index) {
		if (index < 0 || index > size())
			throw new IndexOutOfBoundsException();
		else
			return new DoublyLinkedListIterator(index);
	}

	//
	// LIST ITERATOR CLASS
	//
	private class DoublyLinkedListIterator implements ListIterator {
		private Node<E> current = head;
		private Node<E> lastReturned = null;
		private boolean available = false;
		private int index = -1;
		private int lastIndex = -1;

		public DoublyLinkedListIterator() {

		}

		public DoublyLinkedListIterator(int i) {
			if(i < 0 || i > size)
				throw new IndexOutOfBoundsException();
			else{
			
				if(i == -1)
				{
					lastReturned = current;
				}
				else{
					while(i >= 0){
						next();
						i--;
					}
				}
			}
		}

		public void add(Object e) {
			Node<E> newNode = new Node<E>((E)e);
			newNode.previous = lastReturned.previous;
			newNode.next = lastReturned;
			available = false;
		}

		@Override
		public boolean hasNext() {
			if (index < size)
				return true;
			else
				return false;
		}

		@Override
		public boolean hasPrevious() {
			if (index > -1)
				return true;
			else
				return false;
		}

		@Override
		public E next() {
			available = true;
			if(index == -1){
				lastReturned = head;
				index++;
				return current.element;
			}
			else{
				E e = current.element;
				lastReturned = current;
				lastIndex = index;
				current = current.next;
				index++;
				return e;
			}
		}

		@Override
		public int nextIndex() {
			int nextI = index + 1;
			return nextI;
		}

		@Override
		public E previous() {
			available = true;
			E e = current.element;
			lastIndex = index;
			lastReturned = current;
			current = current.previous;
			index--;
			
			return e;
		}

		@Override
		public int previousIndex() {
			int prevI = index - 1;
			return prevI;
		}

		@Override
		public void remove() {
			if (available) {
				Node<E> front = lastReturned.next;
				Node<E> back = lastReturned.previous;
				back.next = front;
				front.previous = back;
				size--;
				available = false;
			} else {
				throw new IllegalStateException();
			}

		}

		@Override
		public void set(Object e) {
			if (available) {
				lastReturned = (Node<E>) e;
			} else {
				throw new IllegalStateException();
			}

		}

	}

	@Override
	public int size() {

		return size;
	}

	private static class Node<E> {
		E element;
		Node<E> next;
		Node<E> previous;

		public Node(E element) {
			this.element = element;
		}

	}
}
