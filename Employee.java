package Homework1;
import java.util.Date;
/*
 * Course: CS2302
 * Section: 01
 * Name: Harrison Jordan
 * Professor: Shaw
 * Assignment #: Homework 1
 */
public class Employee extends Person {
	private String office;
	private double salary;
	private MyDate dateHired;

	//No-Arg Constructor
	Employee() {

	}
	
	//Seven-Arg Constructor
	Employee(String name, String address, String phoneNumber, String emailAddress, 
			String office, double salary, MyDate dateHired){
		super(name, address, phoneNumber, emailAddress);
		this.office = office;
		this.salary = salary;
		this.dateHired = dateHired;
	}
	
	//String representation of field data
	public String toString(){
		return "Employee\n" + super.toString() + "\nOffice: " + office + "\nSalary: $" + String.format("%.2f", salary) + "\nDate Hired: "+ dateHired;
	}
}
