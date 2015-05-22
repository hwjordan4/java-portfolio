/*****************************************
 *  @author Harrison Jordan
 ****************************************/

package Homework1;
/*
 * Course: CS2302
 * Section: 01
 * Name: Harrison Jordan
 * Professor: Shaw
 * Assignment #: Homework 1
 */
public class TestEveryone {

	//Main method
	public static void main(String[] args) {
		Person p = new Person("Harrison", "123 Street", "7701234567" , "email@gmail.com");
		Student s = new Student("Harrison", "123 Street", "7701234567" , "email@gmail.com", 3);
		Employee e = new Employee("Harrison", "123 Street", "7701234567" , "email@gmail.com", "1000 Clendenin", 100000, new MyDate(2003, 12, 25));
		Faculty f = new Faculty("Harrison", "123 Street", "7701234567" , "email@gmail.com", "1000 Clendenin", 65000.00, new MyDate(2012, 7, 6),"Mon 10-11, Wed 2-3", "Professor");
		Staff st = new Staff("Harrison", "123 Street", "7701234567" , "email@gmail.com", "1000 Clendenin", 35000, new MyDate() ,"Maintenence");
		
		System.out.println(p);										//Test toString() method for person
		System.out.println("-------------------------------");
		System.out.println(s);										//Test toString() method for student
		System.out.println("-------------------------------");
		System.out.println(e);										//Test toString() method for employee
		System.out.println("-------------------------------");
		System.out.println(f);										//Test toString() method for faulty
		System.out.println("-------------------------------");
		System.out.println(st);										//Test toString() method for staff
		System.out.println("-------------------------------");
		

	}

}
