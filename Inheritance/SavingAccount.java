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
public class SavingAccount extends Account {

	// Two-Arg Constructor
	SavingAccount(int accountNumber, double accountBalance) {
		super(accountNumber, accountBalance);
		

	}

	// Returns string with all the field data
	public String toString() {
		return "Savings Account: \n" + super.toString();
	}

	// Deposit into account
	public void deposit(double d) {
		setAccountBalance(d + getAccountBalance());
	}

	// Withdraws from account
	public double withdraw(double w) {
		if (w > getAccountBalance()) {
			return 0.00;
		}
		setAccountBalance(getAccountBalance() - w);
		return w;
		
	}

}
