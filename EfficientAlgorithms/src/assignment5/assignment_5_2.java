package assignment5;
/**
 * 
 * @author Multiple
 *
 */

/*
 * Harrison Jordan
 * CS3401
 * Section 02
 * Prof. Gayler
 * 02/27/2015
 * Assignment 5
 */

public class assignment_5_2 {
/*
 * Write a program that obtains the execution time for finding the GCD of every two consecutive Fibonacci numbers 
 * from the index 40 to index 45 using the algorithms in Listings 22.3 and 22.4 in the text.  
 * Display the results in a table.
 */
	
	/*****************************************
	 *  @author Harrison Jordan
	 ****************************************/
	public static void main(String[] args) 
	{
		
		long[] euclid = new long[6];
		long[] gcdDIVIDE = new long[6];
		
		// Euclid GCD
		int j = 0;
		for(int i = 40; i< 45; i++, j++)
		{
			long startTime = System.currentTimeMillis();
			gcd(fib(i), fib(i+1));
			long endTime = System.currentTimeMillis() - startTime;
			euclid[j] = endTime;
		}
		
		
		// Divide by 2 GCD
		
		j = 0;
		for(int i = 40; i <= 45; i++, j++)
		{
			long startTime = System.currentTimeMillis();
			gcd1(fib(i), fib(i+1));
			long endTime = System.currentTimeMillis() - startTime;
			gcdDIVIDE[j] = endTime;
		}
		
		
		
		
		System.out.println(" " + "\t\t40" + "\t41" + "\t42" + "\t43"+ "\t44"+ "\t45");
		System.out.print("GCD\t");
		for(int i=0; i<6; i++)
		{
			System.out.print("\t" + gcdDIVIDE[i]);
		}
		System.out.print("\nGCDEuclid");
		for(int i=0; i<6; i++)
		{
			System.out.print("\t" + euclid[i]);
		}
		
		
	}
	/**
	 * @param index integer
	 * @return value of index of Fibonacci sequence
	 */
	public static int fib(int n){
		int f0 = 0;
		int f1 = 1;
		int f2 = 1;
		
		if(n==0)
			return f0;
		else if(n==1)
			return f1;
		else if(n==2)
			return f2;
		
		for (int i = 3; i <= n; i++)
		{
			f0 = f1;
			f1 = f2;
			f2 = f0 + f1;
		}
		return f2;
	}
	/**
	 * @param two integer values 
	 * @return greatest common divisor of two values
	 */
	private static int gcd(int m, int n)
	{
		if(m % n==0)
			return n;
		else
			return gcd(n, m % n);
	}
	/**
	 * @param two integer values 
	 * @return greatest common divisor of two values
	 */
	private static int gcd1(int m, int n)
	{
		int gcd = 1;
		
		if(m % n == 0)
			return n;
		
		for(int k = n/2; k>=1; k--)
		{
			if(m % k == 0 && n % k == 0){
				gcd = k;
				break;
			}
		}
		return gcd;
	}


}
