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
public class Faculty extends Employee{
	private String officeHours;
	private String rank;
	
	//No-Arg Constructor
	public Faculty(){
		
	}
	
	//Nine-Arg Constructor
	public Faculty(String name, String address, String phoneNumber, String emailAddress, 
			String office, double salary, MyDate dateHired, String officeHours, String rank){
		super(name, address, phoneNumber, emailAddress, office, salary, dateHired);
		this.officeHours = officeHours;
		this.rank = rank;
	}
	
	//String representing the field data
	public String toString(){
		return "Faculty\n" + super.toString() + "\nOffice Hours: " + officeHours + "\nRank: " + rank;
	}
}
