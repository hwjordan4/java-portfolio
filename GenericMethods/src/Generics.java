/*****************************************
 *  @author Harrison Jordan
 ****************************************/

/*
 * Harrison Jordan
 * CS3401
 * Section 02
 * Prof. Gayler
 * 01/21/2015
 * Assignment 2
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class Generics {

	public static void main(String[] args) 
	{
		try {
			
			//
			// Good Data
			// ___________
			
			System.out.println("Intial ArrayLists");
			ArrayList<Double> doubles = new ArrayList<Double>(Arrays.asList(1.2, 0.5, 11.5, 1.2, 0.5, 42.9, 1.2));
			ArrayList<String> gaCity = new ArrayList<String>(Arrays.asList("Atlanta", "Conyers", "Kennesaw" , "Kennesaw", "Savannah", "Marietta"));
			System.out.println("\t"+doubles.toString());
			System.out.println("\t"+gaCity.toString());
			System.out.println();
			
			//Distinct Elements
			System.out.println("Distinct Elements");
			ArrayList<Double> unique = distinct(doubles);
			ArrayList<String> unique2 = distinct(gaCity);
			System.out.println("\t" + unique.toString());
			System.out.println("\t" + unique2.toString());
			System.out.println();
			
			// Shuffled Elements
			System.out.println("Shuffled Elements");
			shuffle(doubles);
			shuffle(gaCity);
			System.out.println("\t" + gaCity.toString());
			System.out.println("\t" + doubles.toString());
			System.out.println();
			
			// Max Element
			System.out.println("Max Element");
			System.out.println("\t" + max(doubles));
			System.out.println("\t" + max(gaCity));
			System.out.println();
			
			
			// 
			// BAD DATA
			// __________
			
			// Distinct Elements
			System.out.println("Bad Data");
			doubles = null;
			gaCity.clear();
			ArrayList<Double> newDoubles = distinct(doubles);
			//shuffle(gaCity);
			//max(doubles);
			
		} 
		catch (IllegalArgumentException e) 
			{
			System.out.println("\t" + e.getMessage());
			}
		catch (Exception e)
		{
			System.out.println("\t" + e.getMessage());
		}
		
	}
	
	
	/**
	 * @param ArrayList of elements of at least one element
	 * @return distinct list of elements from original list
	 * @throws IllegalArgumentException is the ArrayList is null or empty
	 */
	public static <E extends Comparable<E>> ArrayList<E> distinct (ArrayList<E> list)
	{
		
		
		if(list == null)
			throw new IllegalArgumentException("ArrayList is null");
		if(list.isEmpty())
			throw new IllegalArgumentException("Arraylist empty");
		
		
		for(int i=0; i < list.size(); i++)
			for(int j=1; j < list.size(); j++)
				if(list.get(i).compareTo(list.get(j))==0 && !(i==j)){
					list.remove(j);
				}
		
		
		return list;
		
	}
	
	/**
	 * @param ArrayList of elements of at least one element
	 * @return shuffled list of elements from original list
	 * @throws IllegalArgumentException is the ArrayList is null or empty
	 */
	public static <E> void shuffle (ArrayList<E> list)
	{
		if(list == null)
			throw new IllegalArgumentException("ArrayList is null");
		if(list.isEmpty())
			throw new IllegalArgumentException("Arraylist empty");
		
		Random random = new Random();
		int r;
		E element1;
		E element2;
		
		for(int i=0; i < list.size(); i++)
		{
			r = random.nextInt(list.size());
			element1 = list.get(r);
			element2 = list.get(i);
			list.set(r, element2);
			list.set(i, element1);
		}
	}
	
	/**
	 * @param ArrayList of elements of at least one element
	 * @return largest element from ArrayList
	 * @throws IllegalArgumentException is the ArrayList is null or empty
	 */
	public static <E extends Comparable<E>> E max (ArrayList<E> list)
	{
		if(list == null)
			throw new IllegalArgumentException("ArrayList is null");
		if(list.isEmpty())
			throw new IllegalArgumentException("Arraylist empty");
		
		E maximum = list.get(0);
		
		for(int i=1; i < list.size(); i++)
		{
			if(maximum.compareTo(list.get(i)) < 0)
				maximum = list.get(i);
		}
		
		return maximum;
		
	}
	
	
	
}
