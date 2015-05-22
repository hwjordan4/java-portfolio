/*************************************
*   @author Harrison Jordan
*************************************/
/* Harrison Jordan
 * CS 3401
 * Section 02
 * Prof. Gayler
 * 03/09/2015
 * Midterm
 */
import java.text.DecimalFormat;
import java.text.NumberFormat;


public class Student {

	private String name;
	private String studentNumber;
	private int numberOfHours;
	private double gpa;
	NumberFormat df = new DecimalFormat("#0.00");
	
	public Student(){
		
	}
	
	public Student(String name, String studentNumber, int numberOfHours,
			double gpa) {
		super();
		this.name = name;
		this.studentNumber = studentNumber;
		this.numberOfHours = numberOfHours;
		this.gpa = gpa;
	}



	public String getName() {
		return name;
	}
	public String getStudentNumber() {
		return studentNumber;
	}
	public int getNumberOfHours() {
		return numberOfHours;
	}
	public double getGpa() {
		return gpa;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public void setNumberOfHours(int numberOfHours) {
		this.numberOfHours = numberOfHours;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	public String toString(){
		if(name.length() > 15)
			return name + "\t" + studentNumber + "\t\t" + numberOfHours + "\t" + df.format(gpa);
		else if(name.length() < 8)
			return name + "\t\t\t" + studentNumber + "\t\t" + numberOfHours + "\t" + df.format(gpa);
		else
			return name + "\t\t" + studentNumber + "\t\t" + numberOfHours + "\t" + df.format(gpa);
	}

}

