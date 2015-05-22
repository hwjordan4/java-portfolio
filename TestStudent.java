package objectoriented;

//******************************************************************
//  The TestStudent driver class
//******************************************************************

public class TestStudent {
  public static void main(String[] args) {
    Student student = new Student(111223333, 1970, 5, 3);
    BirthDate date = student.getBirthDate();
    System.out.println("Old Birthdate: " + date);
    date.setYear(2010); // Now the student birth year is changed!
    System.out.println("New Birthdate: " + date);
  }
}
