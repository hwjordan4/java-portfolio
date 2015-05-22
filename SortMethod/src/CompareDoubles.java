/* Harrison Jordan
 * CS 3401
 * Section 02
 * Prof. Gayler
 * 03/13/2015
 * Assignment 6
 */
import java.util.Comparator;
public class CompareDoubles implements Comparator<Double> {
	public int compare(Double one, Double two){
		return one.compareTo(two);
	}
}
