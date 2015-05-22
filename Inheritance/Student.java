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
public class Student extends Person {
	
	private int statusInt;
	private String status;
	
	//No-Arg Constructor
	Student(){
		
	}
	
	//Five-Arg Constructor
	Student(String name, String address, String phoneNumber, String emailAddress, int statusInt){
		super(name, address, phoneNumber, emailAddress);
		if(statusInt == 0){
			status = "Freshmen";
		}
		if(statusInt == 1){
			status = "Sophmore";
		}
		if(statusInt == 2){
			status = "Junior";
		}
		if(statusInt == 3){
			status = "Senior";
		}
		if(statusInt < 0 || statusInt > 3){
			status = "Freshmen";
		}
	}
	
	//String representation of field data
	public String toString(){
		return "Student\n" + super.toString()  + "\nStatus: " + status;
	}
}
