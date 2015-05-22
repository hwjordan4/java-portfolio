package assignment5;
/*****************************************
 *  @author Harrison Jordan
 ****************************************/
import java.util.Random;

/*
 * Harrison Jordan
 * CS3401
 * Section 02
 * Prof. Gayler
 * 02/27/2015
 * Assignment 5
 */
public class assignment_5_3 {
/*
 * Write a method that uses the divide-and-conquer approach 
 * to find the smallest number in an array.  
 * 
 * Test your method with multiple arrays.
 */
	public static void main(String[] args) {
		final int SIZE = 10;
		int[] numbers = new int[SIZE];
		int[] numbers1 = new int[SIZE+1];
		int[] numbers2 = new int[SIZE*100];
		Random r = new Random();
		
		for(int i=0; i<numbers.length; i++)
			numbers[i] = r.nextInt(1000);
		for(int i=0; i<numbers.length; i++)
			System.out.print(numbers[i]+" ");
		System.out.println("\n"+findMin(numbers));
	
		for(int i=0; i<numbers1.length; i++)
			numbers1[i] = r.nextInt(1000);
		for(int i=0; i<numbers1.length; i++)
			System.out.print(numbers1[i]+" ");
		System.out.println("\n"+findMin(numbers1));
		
		for(int i=0; i<numbers2.length; i++)
			numbers2[i] = r.nextInt(10000);
		for(int i=0; i<numbers2.length; i++)
			System.out.print(numbers2[i]+" ");
		System.out.println("\n"+findMin(numbers2));
		

	}
	/**
	 * @param integer array that cannot be null or empty
	 * @return the smallest element of the array
	 */
	private static int findMin(int[] n) {
		assert(n!=null);
		assert(n.length >= 1);
		
		int size = n.length;
		
		
		int mid;
		if(size % 2 == 0)
			mid = size / 2;
		else
			mid = size / 2 + 1;
		
		int j = size - 1;
		int min = n[0];
		int min2 = n[size-1];
		
		for(int i = 1; i<mid; i++, j--)
		{
			if(min > n[i])
				min = n[i];
			if(min2 > n[j])
				min2 = n[j];
		}
		
		if(min < min2)
			return min;
		else
			return min2;
	}

}
