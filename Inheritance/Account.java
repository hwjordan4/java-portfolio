package Lab04;
/*****************************************
 *  @author Harrison Jordan
 ****************************************/
/*
 * Course: CS2302
 * Section: 01
 * Name: Harrison Jordan
 * Professor: Shaw
 * Assignment #: Lab04
 */
public abstract class Account {

	private int accountNumber;
	private double accountBalance;

	//Two-Arg Constructor 
	Account(int accountNumber, double accountBalance) {
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
	}

	// Gets account number
	protected int getAccountNumber() {
		return accountNumber;
	}

	// Sets account number
	protected void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	// Gets account balance
	protected double getAccountBalance() {
		return accountBalance;
	}

	// Sets account balance
	protected void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	// Returns a string with all data fields
	public String toString() {
		return "Account Number = " + accountNumber + "\nAccount Balance = $"
				+ String.format("%.2f", accountBalance);
	}

	// Deposits a given amount
	public abstract void deposit(double d);

	// Withdraws a given amount
	public abstract double withdraw(double w);

}
