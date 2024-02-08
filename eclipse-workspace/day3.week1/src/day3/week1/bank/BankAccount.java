package day3.week1.bank;

public class BankAccount {
	 private String accountNumber;
	 private String accountHolderName;
	 private double balance;
	 
	 
	 
	 public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void deposit(double amount) {
		 this.balance = this.balance + amount;
	 }
	 public void withdraw(double amount) {
		 if(this.balance >= amount) {
			 this.balance = this.balance - amount;
		 }
	 }
	 public void checkBalance() {
		System.out.println(this.balance);
	 }
	 
	 public void transfer(double amount, BankAccount account) {
		 if(this.balance >= amount) {
			 if(account.getAccountNumber().length() == 12) { 
				 this.withdraw(amount);
				 account.deposit(amount);
			 } else {
				 System.out.println("Invalid Account - " + account.getAccountNumber() + " - "+ account.getAccountHolderName());
			 }
		 }else {
			 System.out.println(" Insufficent funds !!!");
		 }
	 }
}
