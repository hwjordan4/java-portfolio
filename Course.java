package objectoriented;
//******************************************************************
//  The Course Class - an object class to store course data
//******************************************************************
/*
 * Course: CS2302
 * Section: 01
 * Name: Harrison Jordan
 * Professor: Shaw
 * Assignment #: Lab02
 */
import java.util.Arrays;
public class Course
{
  private String courseName;
  private String[] students = new String[100];
  private int numberOfStudents;
    
  public Course(String courseName) {
    this.courseName = courseName;
  }
  
  //Adds student
  public void addStudent(String student) {
    students[numberOfStudents] = student;
    numberOfStudents++;
    Arrays.sort(students, 0, numberOfStudents);
  }
  
  //Gets array of students
  public String[] getStudents() {
    return students;
  }
  
  //Gets the number of students
  public int getNumberOfStudents() {
    return numberOfStudents;
  }  
  
  //Gets the course name
  public String getCourseName() {
    return courseName;
  }  
  
  //Drops a given student
  public void dropStudent(String student) {
	  int pos = -1;
	  for(int i = 0; i < numberOfStudents; i++){
		  if(students[i].equals(student)){
				  pos = i;
				  break;
			  }
		  }
	  if(pos > -1){
		  for(; pos < numberOfStudents-1; pos++){
			  students[pos] = students[pos+1];
			  }
			  numberOfStudents--;
	  	}
	  else{
		  System.out.println("Student not in course.");
	  }
  }
  
  //Returns a string representation of the course name and list of students
  public String toString(){
	  String result;
	  result ="Number of Students in " + courseName + ": " + numberOfStudents;
	  for(int i=0; i<numberOfStudents; i++){
			  result += "\n" + students[i];
		 }
	  return result;
  }
}