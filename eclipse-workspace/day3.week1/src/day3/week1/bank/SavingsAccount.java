package day3.week1.bank;

public class SavingsAccount extends BankAccount {
	private double minimumBalance;
	SavingsAccount(double minimumBalance){
		this.minimumBalance = minimumBalance;
	}
	SavingsAccount(){}
	
	@Override
	public void withdraw(double amount) {
		double balance = getBalance();
		 if(balance >= amount && balance-amount >= minimumBalance) {
			 balance = balance - amount;
			 setBalance(balance);
		 } else {
			 System.out.println("Insufficient funds !!!");
		 }
	}
	

}
