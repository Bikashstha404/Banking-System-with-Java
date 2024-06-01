package Bank;

import java.util.LinkedList;
import javax.swing.*;

import java.awt.Font;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GUI extends JFrame{
	private Transaction transferObject;
	private StringBuilder sbAllData;
	private LinkedList<Account> globalAccounts;
	private JLabel showAllData;
	private JButton showAllButton, depositButton, withdrawButton, transferButton;
	private JTextField accDeposit, accWithdraw, acc1Transfer, acc2Transfer, depositInput, withdrawInput, transferAmount;
	
	public GUI(LinkedList<Account> accounts) {
		super("Banking System");
		setLayout(null);
		
		globalAccounts = accounts;
		sbAllData = new StringBuilder();
		
		//Used for showing information Data
		sbAllData.append("<html>");
		for (Account acc : globalAccounts) {
		    sbAllData.append("Name: " + acc.getFirstName() + " " + acc.getLastName() + ", Account Number: " + acc.getAccountNum() + ", Balance: " + acc.getBalance()).append("<br>");
		}
		sbAllData.append("</html>");
		showAllButton = new JButton("Show All");
		depositButton = new JButton("Deposit");
		withdrawButton = new JButton("Withdraw");
		transferButton = new JButton("Transfer");
		
		showAllButton.setBounds(10, 160, 120, 30);
		add(showAllButton);
		
		showAllData = new JLabel();
		showAllData.setBounds(10, 10, 500, 500);
		showAllData.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(showAllData);
        
        accDeposit = new JTextField("Account Number for Deposit");
        accDeposit.setBounds(10, 10, 200, 30);
        add(accDeposit);
        
        depositInput = new JTextField("Deposit Amount");
        depositInput.setBounds(220, 10, 200, 30);
        add(depositInput);

        depositButton.setBounds(430, 10, 120, 30); 
        add(depositButton);

        accWithdraw = new JTextField("Account Number for Withdraw");
        accWithdraw.setBounds(10, 60, 200, 30);
        add(accWithdraw);


        withdrawInput = new JTextField("Withdraw Amount");
        withdrawInput.setBounds(220, 60, 200, 30);
        add(withdrawInput);

        withdrawButton.setBounds(430, 60, 120, 30);
        add(withdrawButton);
        
    
        acc1Transfer = new JTextField("Account 1 for Transfer");
        acc1Transfer.setBounds(10, 110, 200, 30);
        add(acc1Transfer);

        acc2Transfer = new JTextField("Account 2 for Transfer");
        acc2Transfer.setBounds(220, 110, 200, 30);
        add(acc2Transfer);

        transferAmount = new JTextField("Transfer Amount");
        transferAmount.setBounds(430, 110, 120, 30); 
        add(transferAmount);
        
        transferButton.setBounds(560, 110, 120, 30);
        add(transferButton);
		
        HandlerClass handler = new HandlerClass();	
		
        showAllButton.addActionListener(handler);
        depositButton.addActionListener(handler);
        withdrawButton.addActionListener(handler);
        transferButton.addActionListener(handler);
	}
	
	private class HandlerClass implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == showAllButton) {
//                JOptionPane.showMessageDialog(GUI.this, sbAllData.toString(), "All Account Data", JOptionPane.INFORMATION_MESSAGE);
				showAllData.setText("");
				showAllData.setText(sbAllData.toString());
            } 
			else if (e.getSource() == depositButton) {
                int accNum = Integer.parseInt(accDeposit.getText());
                int amount = Integer.parseInt(depositInput.getText());
                
                for (Account acc : globalAccounts) {
                    if (acc.getAccountNum() == accNum) {
                        acc.deposit(amount);
                        showAllData.setText(sbAllData.toString());
                        System.out.print("TranserSucesfull");
                        break;
                    }
                }
            } 
			else if (e.getSource() == withdrawButton) {
//                int accNum = Integer.parseInt(accWithdraw.getText());
//                int amount = Integer.parseInt(withdrawInput.getText());
//                for (Account acc : globalAccounts) {
//                    if (acc.getAccountNum() == accNum) {
//                        acc.withdraw(amount);
//                        showAllData.setText(sbAllData.toString());
//                        break;
//                    }
//                }
            }
			else if (e.getSource() == transferButton) {
//                int accNum1 = Integer.parseInt(acc1Transfer.getText());
//                int accNum2 = Integer.parseInt(acc2Transfer.getText());
//                int amount = Integer.parseInt(transferAmount.getText());
//                
//                Account sourceAccount = null;
//                Account destinationAccount = null;
//                for (Account acc : globalAccounts) {
//                    if (acc.getAccountNum() == accNum1) {
//                        sourceAccount = acc;
//                    } else if (acc.getAccountNum() == accNum2) {
//                        destinationAccount = acc;
//                    }
//                }
//                if (sourceAccount != null && destinationAccount != null) {
//                	transferObject.transfer(sourceAccount, destinationAccount, amount);
//                    showAllData.setText(sbAllData.toString());
//                } else {
//                    JOptionPane.showMessageDialog(GUI.this, "One or both accounts not found", "Transfer Error", JOptionPane.ERROR_MESSAGE);
//                }
            }
		}
		
	}
}
