/*****************************************
 *  @author Harrison Jordan
 ****************************************/
package objectoriented;
//******************************************************************
//  Testing the Course Class
//******************************************************************
/*
 * Course: CS2302
 * Section: 01
 * Name: Harrison Jordan
 * Professor: Shaw
 * Assignment #: Lab02
 */
public class TestCourse {
  public static void main(String[] args) {
    Course course1 = new Course("Data Structures");
    Course course2 = new Course("Database Systems");

    course1.addStudent("Peter Jones");
    course1.addStudent("Brian Smith");
    course1.addStudent("Anne Kennedy");
    course1.dropStudent("Brian Smith");

    course2.addStudent("Peter Jones");
    course2.addStudent("Steve Smith");

    System.out.println(course1);
    System.out.println(course2);
    
 
  }
}
