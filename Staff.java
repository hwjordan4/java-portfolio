package Homework1;
/*
 * Course: CS2302
 * Section: 01
 * Name: Harrison Jordan
 * Professor: Shaw
 * Assignment #: Homework 1
 */
public class Staff extends Employee{
	private String title;
	
	//No-Arg Constructor
	public Staff(){
		
	}
	
	//Eight-Arg Constructor
	public Staff(String name, String address, String phoneNumber, String emailAddress, 
			String office, double salary, MyDate dateHired, String title){
		super(name, address, phoneNumber, emailAddress, office, salary, dateHired);
		this.title = title;
	}
	
	//String representation of field data
	public String toString(){
		return "Staff\n" + super.toString() + "\nTitle: " + title;
	}
}
