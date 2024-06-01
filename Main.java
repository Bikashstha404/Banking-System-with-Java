package Bank;

import java.util.LinkedList;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account accounts1 = new Account("Jeffrey", "Ting", 1, 2000);
		Account accounts2 = new Account("Hiran", "Patel", 2, 1000);
		
		System.out.println("Balance of account1: Rs" + accounts1.getBalance());
		System.out.println("Balance of account2: Rs" + accounts2.getBalance());
		
		accounts1.deposit(250);
		System.out.println("Balance of account1: Rs" + accounts1.getBalance());
		
		accounts2.withdraw(500);
		System.out.println("Balance of account2: Rs" + accounts2.getBalance());
		
		Transaction t = new Transaction();
		t.transfer(accounts1, accounts2, 250);
		System.out.println("Balance of account1: Rs" + accounts1.getBalance());
		System.out.println("Balance of account2: Rs" + accounts2.getBalance());
		
		LinkedList<Account> accounts = new LinkedList<Account>();
		
		ReadAccounts readAccounts = new ReadAccounts("C:\\Users\\HP\\Desktop\\2. "
				+ "Second Semester\\Object Oriented Programming\\University Assessment\\Accounts.csv");
		
		LinkedList<String> firstNames = readAccounts.getFirstNames();
		LinkedList<String> lastNames = readAccounts.getLastNames();
		LinkedList<Integer> accountList = readAccounts.getAccounts();
		LinkedList<Integer> balanceList = readAccounts.getBalances();
		
		for(int i = 0; i < firstNames.size(); i++) {
			accounts.add(new Account(firstNames.get(i), lastNames.get(i), accountList.get(i), balanceList.get(i)));
		}
		
		Account account1 = accounts.getFirst();
		account1.deposit(100);

        Account account2 = accounts.get(1);
        account2.withdraw(5);

        Account account3 = accounts.get(2);
        Account account4 = accounts.get(3);
        t.transfer(account3, account4, 10001);

        for (Account account : accounts) {
        	System.out.println("First Name: " + account.getFirstName() +
                    ", Last Name: " + account.getLastName() +
                    ", Account Number: " + account.getAccountNum() +
                    ", Balance: Rs" + account.getBalance());
        }
        
        GUI gui = new GUI(accounts);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(700, 500);
        gui.setVisible(true);
	}

}
