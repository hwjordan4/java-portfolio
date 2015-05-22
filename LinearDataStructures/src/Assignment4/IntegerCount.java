/* Harrison Jordan
 * CS 3401
 * Section 02
 * Prof. Gayler
 * 02/11/2015
 * Assignment 4-2
 */
package Assignment4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class IntegerCount {
  public static void main(String[] args) {
		// Check number of arguments passed
		if (args.length != 1) {
			System.out.println("Usage: java IntegerCount \"file name\"");
			System.exit(1);
		}
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		try {
			
			String fileName = args[0];
			Scanner scan = new Scanner(new File(fileName));
			while(scan.hasNext()){
				String c = scan.next();
				if(Character.isDigit(c.charAt(0)))
					al.add(Integer.parseInt(c));	
			}
			
		} catch (FileNotFoundException ex) {
			System.out.println("File not found: " + args[0]);
		}
    // Create a TreeMap to hold words as key and count as value
    Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
    
    Object[] ints = al.toArray();
    Integer key = null;
    for (int i = 0; i < ints.length; i++) {
    	if(!ints[i].equals(null))
    		key = al.get(i);
    	else
    		key = null;
    	if(key != null)
    		if (!map.containsKey(key)) {
    			map.put(key, 1);
    		}
    		else {
    			int value = map.get(key);
    			value++;
    			map.put(key, value);
    		}
      }
    

    // Get all entries into a set
    Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();

    // Get key and value from each entry
    for (Map.Entry<Integer, Integer> entry: entrySet)
      System.out.println(entry.getKey() + "\t" + entry.getValue());
  }
}