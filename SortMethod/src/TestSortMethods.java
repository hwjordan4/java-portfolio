/* Harrison Jordan
 * CS 3401
 * Section 02
 * Prof. Gayler
 * 03/13/2015
 * Assignment 6
 */
import java.util.Random;
public class TestSortMethods {
/*
 * Write a program that obtains the execution time of 
 * selection sort, bubble sort, merge sort, quick sort, heap sort, and radix sort 
 * for input size 50000, 100000, 150000, 200000, 250000, and 300000.  
 * Your program should create the data randomly and print a table with the rows 
 * being the data size and the columns being the sort algorithm.
 */
	public static void main(String[] args) {
		Random r = new Random();
		String[][] data = new String[6][6];
		final int SIZE = 5000;
		
		
		// INSERTION SORT
		int index = 0;
		int multiplier = 1;
		while (index < 6) {

			double[] insertion = new double[SIZE * multiplier];
			for (int i = 0; i < insertion.length; i++)
				insertion[i] = r.nextInt(10000) * 1.5;

			long Start = System.currentTimeMillis();
			InsertionSort.insertionSort(insertion);
			long End = System.currentTimeMillis() - Start;
			data[index][0] = ""+End;
			index++;
			multiplier++;
		}
	
		//BUBBLE SORT
		index = 0;
		multiplier = 1;
		while (index < 6) {
			int[] bubble = new int[SIZE * multiplier];
			for (int i = 0; i < bubble.length; i++)
				bubble[i] = r.nextInt(10000);

			long Start = System.currentTimeMillis();
			BubbleSort.bubbleSort(bubble);
			long End = System.currentTimeMillis() - Start;
			data[index][1] = ""+End;
			index++;
			multiplier++;
		}
		
		//MERGE SORT
		index = 0;
		multiplier = 1;
		while (index < 6) {
			int[] merge = new int[SIZE * multiplier];
			for (int i = 0; i < merge.length; i++)
				merge[i] = r.nextInt(10000);

			long Start = System.currentTimeMillis();
			MergeSort.mergeSort(merge);
			long End = System.currentTimeMillis() - Start;
			data[index][2] = ""+End;
			index++;
			multiplier++;
		}
		
		//QUICK SORT
		index = 0;
		multiplier = 1;
		while (index < 6) {
			int[] quick = new int[SIZE * multiplier];
			for (int i = 0; i < quick.length; i++)
				quick[i] = r.nextInt(10000);

			long Start = System.currentTimeMillis();
			BubbleSort.bubbleSort(quick);
			long End = System.currentTimeMillis() - Start;
			data[index][3] = "" + End;
			index++;
			multiplier++;
		}
		
		//HEAP SORT
		index = 0;
		multiplier = 1;
		while (index < 6) {
			int[] heap = new int[SIZE * multiplier];
			for (int i = 0; i < heap.length; i++)
			heap[i] = r.nextInt(10000);

			long Start = System.currentTimeMillis();
			BubbleSort.bubbleSort(heap);
			long End = System.currentTimeMillis() - Start;
			data[index][4] = "" + End;
			index++;
			multiplier++;
		}
		
		//RADIX SORT
		index = 0;
		multiplier = 1;
		while (index < 6) {
			int[] radix = new int[SIZE * multiplier];
			for (int i = 0; i < radix.length; i++)
				radix[i] = r.nextInt(10000);

			long Start = System.currentTimeMillis();
			BubbleSort.bubbleSort(radix);
			long End = System.currentTimeMillis() - Start;
			data[index][5] = ""+End;
			index++;
			multiplier++;
		}
	
		displayArray(data);

	}
	
	public static void displayArray(String[][] s){
		int size = 5000;
		int multi = 1;
		int i=0;
		System.out.println("\t\tInsertion\tBubble\t\tMerge\t\tQuick\t\tHeap\t\tRadix");
		
		for(i = 0; i < s.length; i++){
			System.out.print(size*multi +  "\t\t");
			for(int j = 0; j < s[i].length; j++)
				System.out.print(s[i][j] + "\t\t");
			multi++;
			System.out.println();
		}
	}

}
