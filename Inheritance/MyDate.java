/*****************************************
 *  @author Harrison Jordan
 ****************************************/

package Homework1;
import java.util.Date;

/*
 * Course: CS2302
 * Section: 01
 * Name: Harrison Jordan
 * Professor: Shaw
 * Assignment #: Homework 1
 */
public class MyDate {
	private int year, month, day;

	// No-Arg Constructor
	public MyDate() {
		new Date();
	}

	// Three-Arg Constructor
	public MyDate(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}

	// String representation of a date
	public String toString() {
		if (month == 1) {
			return "Jan " + day + ", " + year;
		}
		if (month == 2) {
			return "Feb " + day + ", " + year;
		}
		if (month == 3) {
			return "Mar " + day + ", " + year;
		}
		if (month == 4) {
			return "Apr " + day + ", " + year;
		}
		if (month == 5) {
			return "May " + day + ", " + year;
		}
		if (month == 6) {
			return "Jun " + day + ", " + year;
		}
		if (month == 7) {
			return "Jul " + day + ", " + year;
		}
		if (month == 8) {
			return "Aug " + day + ", " + year;
		}
		if (month == 9) {
			return "Sep " + day + ", " + year;
		}
		if (month == 10) {
			return "Oct " + day + ", " + year;
		}
		if (month == 11) {
			return "Nov " + day + ", " + year;
		}
		if (month == 12) {
			return "Dec " + day + ", " + year;
		}
		return "" + new Date();

	}

}
