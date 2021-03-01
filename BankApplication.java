
// System.out och scanner 
import java.util.Scanner;

public class BankApplication {
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		printMenuText();
		Bank bank = new Bank();
		bank.addAccount("adam", 2424);
		//		Customer cust = new Customer("Vigge", 25);
		//		BankAccount ba = new BankAccount(cust);
		//		BankAccount ba2 = new BankAccount("mads", 54525250);
		//		BankAccount b3 = new BankAccount(ba2.getHolder());
		while (true) {
			userInput();
		}

	}

	private static void printMenuText() {
		System.out.println("Mata in ditt val");
		System.out.println("1. Hitta konto utifrån innehavare");
		System.out.println("2. Sök kontoinnehavare utifrån (del av) namn");
		System.out.println("3. Sätt in");
		System.out.println("4. Ta ut");
		System.out.println("5. Överföring");
		System.out.println("6. Skapa konto");
		System.out.println("7. Ta bort konto");
		System.out.println("8. Skriv ut konton");
	}

	private static void userInput() {
		int userInput = scan.nextInt();
		switch (userInput) {
		case 1:
			System.out.println("Val: 1. Hitta konto utifrån innehavare");
			System.out.println("Skriv in en innehavares ID");
			long id = scan.nextLong();
			int counter1 = 0;
			for (Customer c : BankAccount.getCustomers())
				if (id == c.getIdNr()) {
					System.out.println(c.toString());
					counter1++;
					break;
				}

			if (counter1 < 1) {
				System.out.println("Det finns inget konto med den innehavaren");
			}
			break;
		case 2:
			System.out.println("2. Sök kontoinnehavare utifrån (del av) namn");
			System.out.println("Skriv in en innehavares namn");
			String name = scan.next();
			int counter2 = 0;
			for (Customer c : BankAccount.getCustomers())
				if (c.getName().contains(name) == true) {
					System.out.println(c.toString());
					counter2++;
				}
			if (counter2 == 0) {
				System.out.println("Det finns ingen kontoinnehavare med det namnet");
			}
			break;
		case 3:
			System.out.println("3. Sätt in");
			System.out.println("Skriv in kontonumret till kontot du vill sätta in summan på");

			break;

		case 4:
			System.out.println("4. Ta ut");
			System.out.println("Skriv in kontonumret till kontot du vill sätta in summan på");

			break;

		case 5:
			System.out.println("5. Överföring");
			System.out.println("Skriv in kontonumret till kontot du vill sätta in summan på");

			break;

		case 6:
			System.out.println("6. Skapa konto");
			System.out.println("Skriv in ditt namn");
			String accountName = scan.next();
			System.out.println("Skriv in personnummer");
			long idNbr = scan.nextLong();
			bank.addAccount(accountName, idNbr);

			break;

		case 7:
			System.out.println("7. Ta bort konto");
			System.out.println("Skriv in kontonumret till kontot du vill sätta in summan på");

			break;

		case 8:
			System.out.println("8. Skriv ut konton");
			System.out.println("Lista på konton: ");
			for (BankAccount b : bank.getAllAccounts()) {
				System.out.println(b.toString());
			}
			break;

		}
	}
}