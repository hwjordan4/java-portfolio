/* Harrison Jordan
 * CS 3401
 * Section 02
 * Prof. Gayler
 * 03/09/2015
 * Midterm
 */
import java.util.Comparator;


public class CompareGPA implements Comparator<Student> {

	/**
	 * @param two students that cannot be null
	 * @return the value of -1, 0, or 1: for the comparator to sort descending double values
	 */
	public int compare(Student s1, Student s2) {
		assert(s1!=null);
		assert(s2!=null);
		
		double gpa1 = s1.getGpa();
		double gpa2 = s2.getGpa();
		
		if(gpa1 < gpa2)
			return -1;
		else if(gpa1 == gpa2)
			return 0;
		else
			return 1;
		
	}

}
