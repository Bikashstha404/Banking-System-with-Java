package Bank;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class ReadAccounts {
	public BufferedReader reader;
	public String url;
	
	public ReadAccounts(String URL) {
		this.url = URL;
		try {
			reader = new BufferedReader(new FileReader(url));
			reader.mark(99999);
			//reader.close(); yesma chai close garnw milena why??
		}
		catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	public LinkedList<String> getFirstNames(){
		LinkedList<String> firstNames = new LinkedList<String>();
		String line;
		try {
			while((line = reader.readLine()) != null) {
				String[] data = line.split(",");
				if(data.length == 4) {
					firstNames.add(data[0]);
				}
			}
			reader.reset();
		}
		catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return firstNames;
	}
	
	public LinkedList<String> getLastNames(){
		LinkedList<String> lastNames = new LinkedList<String>();
		String line;
		try {	
			while((line = reader.readLine()) != null) {
				String[] data = line.split(",");
				if(data.length == 4) {
					lastNames.add(data[1]);
				}
			}
			reader.reset();
		}
		catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return lastNames;
	}
	
	public LinkedList<Integer> getAccounts(){
		LinkedList<Integer> accountLists = new LinkedList<Integer>();
		String line;
		try {
			while((line = reader.readLine()) != null) {
				String[] data = line.split(",");
				if(data.length == 4) {
					accountLists.add(Integer.parseInt(data[2]));
				}
			}
			reader.reset();
		}
		catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return accountLists;
	}
	
	public LinkedList<Integer> getBalances(){
		LinkedList<Integer> balanceList = new LinkedList<Integer>();
		String line;
		try {
			while((line = reader.readLine()) != null) {
				String[] data = line.split(",");
				if(data.length == 4) {
					balanceList.add(Integer.parseInt(data[3]));
				}
			}
		}
		catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return balanceList;
	}
}
