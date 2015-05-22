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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/*
 * A file contains information about students (name, student number, number of hours, gpa). 
 * Write a program that creates 3 lists of these students: 
 * one sorted by name, one sorted by gpa, 
 * and one sorted by the number of hours. 
 * The program should display these lists.
 */

public class Lists {
	public static void main(String[] args) {

		String fileName = "students.txt";
		Scanner scan = null;
		List<Student> students = new ArrayList<Student>();
		try {
			scan = new Scanner(new File(fileName));

			while (scan.hasNextLine()) {

				Student stu = createStudent(scan.nextLine());
				if (stu.getName() != null)
					students.add(stu);
			}

		} catch (FileNotFoundException e) {

			System.out.println("File Not Found!!");
		} catch (NumberFormatException e) {
			System.out.println("Number format exception!!");
		}

		Collections.sort(students, new CompareName());
		System.out.println("Name\t\t\tStudent Number\t\tHours\tGPA");
		System.out.println("-------------------------------------------------------------");
		displayStudents(students);
		System.out.println();
		Collections.sort(students, new CompareHours());
		System.out.println("Name\t\t\tStudent Number\t\tHours\tGPA");
		System.out.println("-------------------------------------------------------------");
		displayStudents(students);
		System.out.println();
		Collections.sort(students, new CompareGPA());
		System.out.println("Name\t\t\tStudent Number\t\tHours\tGPA");
		System.out.println("-------------------------------------------------------------");
		displayStudents(students);

	}
	/**
	 * @param a list of student objects
	 * @return prints out the list
	 */
	private static void displayStudents(List<Student> students) {

		Iterator<Student> i = students.iterator();
		while (i.hasNext()) {
			System.out.println(i.next().toString());
		}

	}
	/**
	 * @param a line of a data from a file
	 * @return a new student with a name, number, hours, and g.p.a. assigned to it
	 */
	public static Student createStudent(String newline) {
		Student stu = new Student();
		if (!newline.isEmpty()) {

			String[] s = newline.split(", ");
			stu.setName(s[0]);
			stu.setStudentNumber(s[1]);
			stu.setNumberOfHours(Integer.parseInt(s[2]));
			stu.setGpa(Double.parseDouble(s[3]));
		}
		return stu;
	}

}
