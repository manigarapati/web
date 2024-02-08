package day3.week1.bank;

public class BankAccountManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount savings = new SavingsAccount(100);
		savings.setAccountNumber("202882658672");
		savings.setAccountHolderName("G L M DATHATREYA");
		System.out.println(savings.getAccountNumber());
		System.out.println(savings.getAccountHolderName());
		savings.deposit(500);
		savings.checkBalance();
		savings.withdraw(700);
		savings.checkBalance();
		savings.withdraw(200);
		savings.checkBalance();
		
		BankAccount checkings = new CheckingsAccount(5,5);
		checkings.setAccountNumber("3258015071761");
		checkings.setAccountHolderName("Garapati ViJAYA DURGA");
		System.out.println(checkings.getAccountHolderName());
		System.out.println(checkings.getAccountNumber());		
		checkings.deposit(300);
		checkings.checkBalance();
		checkings.withdraw(500);
		checkings.checkBalance();
		checkings.withdraw(100);
		checkings.checkBalance();
		checkings.withdraw(100);
		checkings.checkBalance();
		checkings.withdraw(50);
		checkings.checkBalance();
		checkings.deposit(500);
		checkings.checkBalance();
		checkings.withdraw(100);
		checkings.checkBalance();
		
		BankAccount account1 = new BankAccount();
		account1.setAccountNumber("202882658673");
		account1.setAccountHolderName("lohith");
		account1.deposit(10000);
		account1.checkBalance();
		
		
		BankAccount account2 = new BankAccount();
		account2.setAccountNumber("3258015051567");
		account2.setAccountHolderName("mani");
		account2.deposit(2000);
		account2.checkBalance();
		
		account1.transfer(2000, account2);
		account1.checkBalance();
		account2.checkBalance();
		
		account2.transfer(1000, account1);
		account1.checkBalance();
		account2.checkBalance();
	}

}
