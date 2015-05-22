/*************************************
*   @author Harrison Jordan
*************************************/

/* Harrison Jordan
 * CS 3401
 * Section 02
 * Prof. Gayler
 * 02/11/2015
 * Assignment 4-3
 */
package Assignment4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

/*
 * Use these data files to write a program that enables the determination of the ranking of popularity of a name 
 * if the year, gender, and name are known.  To achieve the best efficiency, create two arrays for boy’s names and girl’s names, 
 * respectively. Each array has 10 elements for 10 years. Each element is a map that stores a name and its 
 * ranking in a pair with the name as the key. 
 */


public class BabyNameRankings
{


	public static void main(String[] args)
	{
		Map<String, Integer> boysNames = new TreeMap<String, Integer>();
		Map<String, Integer> girlsNames = new TreeMap<String, Integer>();
		
		try
		{
				int i = 2001;
				while(i < 2011)
				{
					String fileName = "";
					switch(i)
					{
					case 2001:
						fileName = "babynamesranking2001.txt";
						break;
					case 2002:
						fileName = "babynamesranking2002.txt";
						break;
					case 2003:
						fileName = "babynamesranking2003.txt";
						break;
					case 2004:
						fileName = "babynamesranking2004.txt";
						break;
					case 2005:
						fileName = "babynamesranking2005.txt";
						break;
					case 2006:
						fileName = "babynamesranking2006.txt";
						break;
					case 2007:
						fileName = "babynamesranking2007.txt";
						break;
					case 2008:
						fileName = "babynamesranking2008.txt";
						break;
					case 2009:
						fileName = "babynamesranking2009.txt";
						break;
					case 2010:
						fileName = "babynamesranking2010.txt";
					default: 
						fileName = "babynamesranking2010.txt";
					}
					String nameRank = processLine(fileName);
					
					String[] s = nameRank.split(" ");
					int boy = 0;
					int girl = 0;
					if(Character.isDigit(s[1].charAt(0)))
						boy = Integer.parseInt(s[1]);
					if(Character.isDigit(s[5].charAt(0)))
						girl = Integer.parseInt(s[5]);
					boysNames.put(s[0] + "\t\t" + i, boy);
					if(i > 2008)
						girlsNames.put(s[3] + "\t" + i, girl);
					else
						girlsNames.put(s[3] + "\t\t" + i, girl);
					i++;
				}
				Set<Map.Entry<String, Integer>> entrySetB = boysNames.entrySet();
				Set<Map.Entry<String, Integer>> entrySetG = girlsNames.entrySet();
				System.out.println("Boys");
				System.out.println("Name" + "\t\tYear" + "\tCount");
				System.out.println("------------------------------");
				for (Map.Entry<String, Integer> entry : entrySetB)
					System.out.println(entry.getKey() + "\t" + entry.getValue());
				System.out.println("\nGirls");
				System.out.println("Name" + "\t\tYear" + "\tCount");
				System.out.println("------------------------------");
				for (Map.Entry<String, Integer> entry : entrySetG)
					System.out.println(entry.getKey() + "\t" + entry.getValue());
		}
		catch (FileNotFoundException e)
		{
			System.out.println( "File not found");
		}
		 catch (Exception e)
		{
			System.out.println("unknown error occurred - terminating");
		}
		
	
	}
	/**
	 * @param Takes in the file name and creates a scanner for the file
	 * @throws File Not Found Exception
	 * @return String of first line of each file with the first integer removed
	 */
	private static String processLine(String fileName)
			throws FileNotFoundException
	{
		String result = "";
		
		Scanner input = new Scanner(new File(fileName));
		
			String line = input.nextLine();
			String[] s = line.split("\t");
			int i = 1;
			while (i < s.length)
			{
				result += s[i] + " ";
				i++;
			}
	
		input.close();
		return result;
	}

}