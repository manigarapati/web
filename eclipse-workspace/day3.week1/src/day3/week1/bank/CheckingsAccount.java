package day3.week1.bank;

public class CheckingsAccount extends BankAccount {
	private double transactionFee;
	private int maxTransactions;
	private int remainingTransactions;
	CheckingsAccount(double transactionFee, int maxTransactions) {
		this.transactionFee = transactionFee;
		this.maxTransactions = maxTransactions;
		this.remainingTransactions = maxTransactions;
	}
	CheckingsAccount(){}
	
	
	
	@Override
	public void deposit(double amount) {
		double balance = getBalance();
		if(this.remainingTransactions > 0 ) {
			
			double value = balance + amount - transactionFee;
			if(value >= 0) {
				setBalance(value);
				this.remainingTransactions--;
			} else {
				System.out.println("Insufficent Funds");
			}
		} else {
			System.out.println("Maximum transactions Exceeded !!!");
		}
		 
		
		 
	 }
	
	@Override
	 public void withdraw(double amount) {
		double balance = getBalance();
		 if(this.remainingTransactions > 0 ) {
				
				double value = balance - amount - transactionFee;
				if(value >= 0) {
					setBalance(value); 
					this.remainingTransactions--;
				} else {
					System.out.println("Insufficent Funds");
				}
			} else {
				System.out.println("Maximum transactions Exceeded !!!");
			}
	 }
	

	
	

}
