package Lab04;

/*
 * Course: CS2302
 * Section: 01
 * Name: Harrison Jordan
 * Professor: Shaw
 * Assignment #: Lab04
 */
public class CheckingAccount extends Account {
	private double overDraftLimit;

	// Three-Arg Constructor
	CheckingAccount(int accountNumber, double accountBalance,
			double overDraftLimit) {
		super(accountNumber, accountBalance);
		this.overDraftLimit = overDraftLimit;

	}

	// Returns string with all the field dat
	public String toString() {
		return "Checking Account: \n" + super.toString()
				+ "\nOverDraft Limit = $"
				+ String.format("%.2f", overDraftLimit);
	}

	// Deposit into account
	public void deposit(double d) {
		setAccountBalance(getAccountBalance() + d);
	}

	// Withdraws from account
	public double withdraw(double w) {
		if (w > getAccountBalance() + overDraftLimit) {
			return 0.00;
		}
		setAccountBalance(getAccountBalance() - w);
		return w;
	}

}
