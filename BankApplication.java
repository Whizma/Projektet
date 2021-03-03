
// System.out och scanner 
import java.util.Scanner;

public class BankApplication {
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		scan.useDelimiter(System.lineSeparator());
		Bank bankish = new Bank();
		bankish.addAccount("Anna B", 1234);
		bankish.addAccount("Anna B", 5678);

		while (true) {
			System.out.println("");
			printMenuText();
			int userInput = scan.nextInt();
			if (userInput == 1) {
				System.out.println("Val: 1. Hitta konto utifrån innehavare");
				System.out.println("Skriv in en innehavares ID");
				long id = scan.nextLong();
				if (bankish.findAccountsForHolder(id).size() == 0) {
					System.out.println("Den innehavaren har inga konton");
				} else {
					for (BankAccount b : bankish.findAccountsForHolder(id)) {
						System.out.println(b.toString());
					}
				}

			}

			else if (userInput == 2) {
				System.out.println("2. Sök kontoinnehavare utifrån (del av) namn");
				System.out.println("Skriv in en innehavares namn");
				String name = scan.next();
				if (bankish.findByPartofName(name).size() == 0) {
					System.out.println("Den innehavaren har inga konton");
				} else {
					for (Customer c : bankish.findByPartofName(name)) {
						System.out.println(c.toString());
					}

				}
			} else if (userInput == 3) {
				int counter = 0;
				System.out.println("3. Sätt in");
				System.out.println("Skriv in kontonumret till kontot du vill sätta in summan på");
				int accountNumber = scan.nextInt();
				for (BankAccount c : bankish.getAllAccounts()) {
					if (counter == 0) {
						if (accountNumber != c.getAccountNumber()
								&& c == bankish.getAllAccounts().get(bankish.getAllAccounts().size() - 1)) {
							System.out.println("Det finns inget konto med det kontonumret");
							counter++;

						}
						for (BankAccount b : bankish.getAllAccounts()) {
							if (accountNumber == b.getAccountNumber()) {
								System.out.println("Skriv in summan du vill sätta in");
								double amount = scan.nextDouble();
								while (b.getAmount() + amount < 0) {
									System.out.println(
											"Insättningen misslyckades, du kan inte sätta in en negativ summa!");
									System.out.println("Skriv in summan du vill sätta in");
									amount = scan.nextDouble();
								}
								b.deposit(amount);
								System.out.println("Du satte in " + amount + " på kontot " + accountNumber);
								counter++;
							}
						}
					}
				}

			} else if (userInput == 4) {
				{
					int count2 = 0;
					System.out.println("4. Ta ut");
					System.out.println("Skriv in kontonumret till kontot du vill ta ut summan från");
					int accountNumber = scan.nextInt();
					{
						if (bankish.findByNumber(accountNumber) == null) {
							System.out.println("Det finns inget konto med det kontonumret");
						}
					}
					for (BankAccount b : bankish.getAllAccounts()) {
						if (accountNumber == b.getAccountNumber() && count2 == 0) {
							System.out.println("Skriv in summan du vill ta ut");
							double amount = scan.nextDouble();
							while (b.getAmount() - amount < 0) {
								System.out.println(
										"Uttaget misslyckades, du har endast " + b.getAmount() + " på kontot!");
								System.out.println("Skriv in summan du vill ta ut");
								amount = scan.nextDouble();
							}

							b.withdraw(amount);
							System.out.println("Du tog nyss ut " + amount + " från kontot " + accountNumber);
						}
					}
				}
			} else if (userInput == 5) {
				int counter = 0;
				double amount = 0;
				BankAccount temp = null;

				System.out.println("Skriv in kontonumret till kontot du vill sätta in summan på");
				int toAccountNumber = scan.nextInt();
				for (BankAccount a : bankish.getAllAccounts()) {
					if (a == bankish.findByNumber(toAccountNumber) && counter == 0) {
						temp = a;
						if (toAccountNumber != a.getAccountNumber()
								&& a == bankish.getAllAccounts().get(bankish.getAllAccounts().size() - 1)
								&& counter > 0) {
							System.out.println("Det finns inget konto med det kontonumret");
							counter++;

						}
					}

				}

				int count = 0;
				int count2 = 0;
				System.out.println("Skriv in kontonumret till kontot du vill ta ut summan från");
				int fromAccountNumber = scan.nextInt();
				for (BankAccount b : bankish.getAllAccounts()) {
					if (fromAccountNumber != b.getAccountNumber() && bankish.getAllAccounts().size() == count) {
						System.out.println("Det finns inget konto med det kontonumret");
						count++;
					}
					for (BankAccount b1 : bankish.getAllAccounts()) {
						if (fromAccountNumber == b1.getAccountNumber() && count2 == 0) {
							System.out.println("Skriv in summan du vill ta ut");
							amount = scan.nextDouble();
							while (b1.getAmount() - amount < 0) {
								System.out.println(
										"Uttaget misslyckades, du har endast " + b1.getAmount() + " på kontot!");
								System.out.println("Skriv in summan du vill ta ut");
								amount = scan.nextDouble();
							}

							b1.withdraw(amount);
							temp.deposit(amount);
							count2++;
							System.out.println("Du för över " + amount + " från " + fromAccountNumber + " till kontot "
									+ toAccountNumber);
						}

					}

				}
			} else if (userInput == 6) {
				System.out.println("6. Skapa konto");
				System.out.println("Skriv in ditt namn");
				String accountName = scan.next();
				System.out.println("Skriv in personnummer");
				long idNbr = scan.nextLong();
				bankish.addAccount(accountName, idNbr);
				System.out.println(
						"Ditt nya konto: " + bankish.getUnsortedList().get(bankish.getUnsortedList().size() - 1));

			} else if (userInput == 7) {
				System.out.println("7. Ta bort konto");
				System.out.println("Skriv in kontonumret till kontot du vill ta bort");
				int removeAccountNumber = scan.nextInt();
				if (bankish.removeAccount(removeAccountNumber)) {
					System.out.println("Ditt konto har tagits bort");
				} else {
					System.out.println("Det finns inget konto med det kontonummret");
				}

			} else if (userInput == 8) {
				System.out.println("8. Skriv ut konton");
				System.out.println("Lista på konton: ");
				if (bankish.getAllAccounts().size() == 0) {
					System.out.println("Det finns inga konton i banken");
				} else {
					for (int i = 0; i < bankish.getAllAccounts().size(); i++) {
						System.out.println(bankish.getAllAccounts().get(i));
					}
				}
			} else if (userInput == 9) {
				break;
			} else {
				System.out.println("Välj ett giltigt alternativ!");
			}
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
		System.out.println("9. Avsluta");
	}

}