package Lab04;
/*
 * Course: CS2302
 * Section: 01
 * Name: Harrison Jordan
 * Professor: Shaw
 * Assignment #: Lab04
 */
public class CheckingAndSaving {
	
	//Main method
	public static void main(String[] args){
		SavingAccount sA = new SavingAccount(102, 1000);
		
		System.out.println(sA);
		sA.deposit(1500.00);	//Tests depositing
		System.out.println(sA);
		sA.withdraw(3000.00);  //Test overdraw withdrawing
		System.out.println(sA);
		sA.withdraw(500.00);   //Tests regular withdrawing
		System.out.println(sA);
		
		System.out.println();
		
		CheckingAccount cA = new CheckingAccount(101, 1000, 1000);
		
		System.out.println(cA);
		cA.deposit(1500.00);	//Tests depositing
		System.out.println(cA);
		cA.withdraw(200.00);    //Tests regular withdraw
		System.out.println(cA);
		cA.withdraw(3000.00);  //Test overdraft limit withdrawing
		System.out.println(cA);
		cA.withdraw(5000.00);   //Tests overdraw past limit withdrawing
		System.out.println(cA);
	}
}
