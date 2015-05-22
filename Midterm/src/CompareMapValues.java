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
import java.util.Comparator;
import java.util.Map;

public class CompareMapValues<K, V> implements Comparator<Map.Entry<K, V>>{

	/**
	 * @param two map entries that cannot be null
	 * @return the value of -1, 0, or 1 for the comparator to sort descending values
	 */
	public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
		assert(o1!=null);
		assert(o2!=null);
		
		int value1 = (Integer) o1.getValue();
		int value2 = (Integer) o2.getValue();
		
		if(value1 > value2)
			return -1;
		else if(value1 == value2)
			return 0;
		else
			return 1;
	}

		
	
}
