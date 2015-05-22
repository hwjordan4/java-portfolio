/**
 * Modification of EvaluateExpression
 * @author Liang
 *
 */
/* Harrison Jordan
 * CS 3401
 * Section 02
 * Prof. Gayler
 * 03/09/2015
 * Midterm
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
/*
 * A file contains information about books (title, author, ISBN number). 
 * Write a program that determines the number of distinct authors for the books 
 * in this file.
 */
public class Distinct {
  public static void main(String[] args) {
	

			
			String fileName = "books.txt";
			Scanner scan = null;
			try {
				scan = new Scanner(new File(fileName));
			
			} catch (FileNotFoundException e) {
				
				System.out.println("File Not Found!!");
			}
			
			Set<String> authors = new HashSet<String>();
			
			while(scan.hasNextLine()){
				Book b = new Book();
				String n = scan.nextLine();
				String[] s = n.split(", ");
				b.setTitle(s[0]);
				b.setAuthor(s[1]);
				b.setISBN(s[2]);
				
				authors.add(b.getAuthor());
			}
    
			System.out.println("Distinct Authors");
			System.out.println("-----------------");
			Iterator<String> i = authors.iterator();
			while(i.hasNext()){
				System.out.println(i.next());
			}

  
  }
}