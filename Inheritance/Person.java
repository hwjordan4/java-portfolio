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
public class Person {
	private String name;
	private String address;
	private String phoneNumber;
	private String emailAddress;

	//No-Arg Constructor
	Person() {

	}

	//Three-Arg Constructor
	Person(String name, String address, String phoneNumber, String emailAddress) {
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
	}

	//String representation of field data
	public String toString() {
		return "Name: " + name + "\nAddress: " + address + "\nEmail Address: "
				+ emailAddress;
	}

}
