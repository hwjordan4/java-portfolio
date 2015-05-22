/**
 * Modification of EvaluateExpression
 * @author Liang
 *
 */
/* Harrison Jordan
 * CS 3401
 * Section 02
 * Prof. Gayler
 * 03/13/2015
 * Assignment 6
 */
import java.util.Comparator;
public class CompareIntegers implements Comparator<Integer> {
	public int compare(Integer one, Integer two){
		return one.compareTo(two);
	}
}
