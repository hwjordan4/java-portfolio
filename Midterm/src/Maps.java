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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;

public class Maps {
	/*
	 * A file contains information about students (name, student number, number
	 * of hours, gpa). Write a program that lists the frequency (in decreasing
	 * order) of occurrence of students names.
	 */
	public static void main(String[] args) {

		String fileName = "students.txt";
		Scanner scan = null;
		Map<String, Integer> studentNames = new HashMap<String, Integer>();

		try {
			scan = new Scanner(new File(fileName));

			while (scan.hasNextLine()) {
				Student stu = createStudent(scan.nextLine());
				if (stu.getName() != null) {
					if (studentNames.containsKey(stu.getName())) {
						int value = studentNames.get(stu.getName());
						value++;
						studentNames.put(stu.getName(), value);
					} else
						studentNames.put(stu.getName(), 1);
				}
			}

			List<Map.Entry<String, Integer>> sortedList = 
					new ArrayList<Map.Entry<String, Integer>>(studentNames.entrySet());

			Collections.sort(sortedList, new CompareMapValues<String, Integer>());

			for (Map.Entry<String, Integer> entry : sortedList) {
				if (entry.getKey().length() > 15)
					System.out
							.println(entry.getKey() + "\t" + entry.getValue());
				else if (entry.getKey().length() < 8)
					System.out.println(entry.getKey() + "\t\t\t"
							+ entry.getValue());
				else
					System.out.println(entry.getKey() + "\t\t"
							+ entry.getValue());
			}
		} catch (FileNotFoundException e) {

			System.out.println("File Not Found!!");
		} catch (NumberFormatException e) {
			System.out.println("Number format exception!!");
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
