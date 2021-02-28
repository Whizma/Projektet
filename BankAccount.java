import java.util.ArrayList;
import java.util.Random;

public class BankAccount {

	private double balance;
	private String holderName;
	private ArrayList<Long> holderIdList = new ArrayList<Long>();
	private ArrayList<Integer> customerAccountNbrList = new ArrayList<Integer>();
	private int accountNbr;
	Random rand = new Random();
	Customer cust;
	private static ArrayList<Customer> customers = new ArrayList<Customer>();

	/**
	 * Skapar ett nytt bankkonto åt en innehavare med namn ’holderName’ och id
	 * ’holderId’. Kontot tilldelas ett unikt kontonummer och innehåller
	 * inledningsvis 0 kr.
	 */
	BankAccount(String holderName, long holderId) {
		this.balance = 0;
		Customer cust = new Customer(holderName, holderId);
		this.cust = cust;
		this.holderName = holderName;
		holderIdList.add(holderId);

		int randomAccountNbr = rand.nextInt(1000000000);

		for (Integer i : customerAccountNbrList) {
			while (customerAccountNbrList.get(i) == randomAccountNbr) {
				randomAccountNbr = rand.nextInt(1000000000);
			}
		}
		customerAccountNbrList.add(randomAccountNbr);
		this.accountNbr = randomAccountNbr;
		customers.add(cust);
	}

	/**
	 * Skapar ett nytt bankkonto med innehavare ’holder’. Kontot tilldelas ett unikt
	 * kontonummer och innehåller inledningsvis 0 kr.
	 */
	BankAccount(Customer holder) {
		this.balance = 0;
		this.cust = holder;
		this.holderName = holder.getName();
		int randomAccountNbr = rand.nextInt(1000000000);

		for (Integer i : customerAccountNbrList) {
			while (customerAccountNbrList.get(i) == randomAccountNbr) {
				randomAccountNbr = rand.nextInt(1000000000);
			}
		}
		customerAccountNbrList.add(randomAccountNbr);
		this.accountNbr = randomAccountNbr;
		customers.add(holder);
	}

	/** Tar reda på kontots innehavare. */
	Customer getHolder() {
		return this.cust;

	}

	/** Tar reda på det kontonummer som identifierar detta konto. */
	int getAccountNumber() {
		return this.accountNbr;

	}

	/** Tar reda på hur mycket pengar som finns på kontot. */
	double getAmount() {
		return this.balance;

	}

	/** Sätter in beloppet ’amount’ på kontot. */
	void deposit(double amount) {
		balance = balance + amount;

	}

	/**
	 * Tar ut beloppet ’amount’ från kontot. Om kontot saknar täckning blir saldot
	 * negativt.
	 */
	void withdraw(double amount) {
		balance = balance - amount;
	}

	/** Returnerar en strängrepresentation av bankkontot. */
	public String toString() {
		return "Kontoinnehavare: " + holderName + " | " + "Kontonummer: " + accountNbr + " | Saldo: " + balance;
	}
	
	public static ArrayList<Customer> getCustomers(){
		return customers;
	}
}
