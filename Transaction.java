package Bank;

public class Transaction {
	public void transfer(Account sourceAccount, Account destinationAccount, int amount) {
		if(sourceAccount.getBalance() >= amount) {
			sourceAccount.withdraw(amount);
			destinationAccount.deposit(amount);
			//System.out.println("Transfer Successful!");
		}
		else {
			System.out.println("Transfer Failed: Insufficient Funds.");
		}
	}
}
