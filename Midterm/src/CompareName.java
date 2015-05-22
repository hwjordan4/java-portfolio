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


public class CompareName implements Comparator<Student> {

	/**
	 * @param two students that cannot be null
	 * @return the value of -1, 0, or 1, depending on the lexicographical order of the alphabet
	 */
	public int compare(Student s1, Student s2) {
		assert (s1 != null);
		assert (s2 != null);

		String name1 = s1.getName();
		String name2 = s2.getName();
		int i = 1;
		
		if (name1.length() > 1 && name2.length() > 1) 
		{

			if (name1.charAt(0) < name2.charAt(0))
				return -1;
			else if (name1.charAt(0) == name2.charAt(0))
				while(i < name1.length() || i < name2.length())
				{
					if(name1.charAt(i) == name2.charAt(i))
					{
						
						if(name1.charAt(i) < name2.charAt(i))
							return -1;
						else if(name1.charAt(i) == name2.charAt(i))
							i++;
						else
							return 1;
					}
					
					else
						return 0;
					
				}
			else
				return 1;
		}
		return 0;
	}

}
