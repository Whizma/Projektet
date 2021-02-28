import java.util.ArrayList;

public class Bank {
	ArrayList<BankAccount> bankAccounts;

	/** Skapar en ny bank utan konton. */
	public Bank() {
		this.bankAccounts = new ArrayList<BankAccount>();

	}

	/**
	 * Öppna ett nytt konto i banken. Om det redan finns en kontoinnehavare med de
	 * givna uppgifterna ska inte en ny Customer skapas, utan istället den
	 * befintliga användas. Det nya kontonumret returneras.
	 */
	int addAccount(String holderName, long idNr) {
		int accountNumber = 0;
		int counter5 = 0;
			for (Customer c : BankAccount.getCustomers()) {
				if (idNr != c.getIdNr()) {
					BankAccount ba1 = new BankAccount(holderName, idNr);
					bankAccounts.add(ba1);
					accountNumber = ba1.getAccountNumber();

				} else {
					BankAccount ba2 = new BankAccount(c);
					accountNumber = ba2.getAccountNumber();
					bankAccounts.add(ba2);
				}
			}
		return accountNumber;
	}

	/**
	 * Returnerar den kontoinnehavaren som har det givna id-numret, eller null om
	 * ingen sådan finns.
	 */
	Customer findHolder(long idNr) {
		for (Customer c : BankAccount.getCustomers())
			if (idNr == c.getIdNr()) {
				return c;
			}
		return null;
	}

	/**
	 * Tar bort konto med nummer ’number’ från banken. Returnerar true om kontot
	 * fanns (och kunde tas bort), annars false.
	 */
	boolean removeAccount(int number) {

	}

	/**
	 * Returnerar en lista innehållande samtliga bankkonton i banken. Listan är
	 * sorterad på kontoinnehavarnas namn.
	 */
	ArrayList<BankAccount> getAllAccounts() {
		for (int i = 0; i < bankAccounts.size(); i++) {
			for (int k = i + 1; k < bankAccounts.size(); k++) {
				if (bankAccounts.get(i).getHolder().getName()
						.compareTo(bankAccounts.get(k).getHolder().getName()) > 0) {
					BankAccount tmp = bankAccounts.get(i);
					bankAccounts.set(i, bankAccounts.get(k));
					bankAccounts.set(k, tmp);
				}
			}
		}

		return bankAccounts;
	}

	/**
	 * Söker upp och returnerar bankkontot med kontonummer ’accountNumber’.
	 * Returnerar null om inget sådant konto finns.
	 */
	BankAccount findByNumber(int accountNumber) {

	}

	/**
	 * Söker upp alla bankkonton som innehas av kunden med id-nummer ’idNr’. Kontona
	 * returneras i en lista. Kunderna antas ha unika id-nummer.
	 */
	ArrayList<BankAccount> findAccountsForHolder(long idNr) {

	}

	/**
	 * Söker upp kunder utifrån en sökning på namn eller del av namn. Alla personer
	 * vars namn innehåller strängen ’namePart’ inkluderas i resultatet, som
	 * returneras som en lista. Samma person kan förekomma flera gånger i
	 * resultatet. Sökningen är "case insensitive", det vill säga gör ingen skillnad
	 * på stora och små bokstäver.
	 */
	ArrayList<Customer> findByPartofName(String namePart) {

	}

}