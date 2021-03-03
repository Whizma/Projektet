import java.util.ArrayList;

public class Bank {
	private ArrayList<BankAccount> bankAccounts;

	/** Skapar en ny bank utan konton. */
	public Bank() {
		bankAccounts = new ArrayList<BankAccount>();
	}

	/**
	 * Öppna ett nytt konto i banken. Om det redan finns en kontoinnehavare med de
	 * givna uppgifterna ska inte en ny Customer skapas, utan istället den
	 * befintliga användas. Det nya kontonumret returneras.
	 */
	int addAccount(String holderName, long idNr) {
		int accountNumber = 0;
		if (bankAccounts.size() == 0) {
			BankAccount ba = new BankAccount(holderName, idNr);
			accountNumber = ba.getAccountNumber();
			bankAccounts.add(ba);
		} else {

			if (findHolder(idNr) != null) {
				BankAccount ba = new BankAccount(findHolder(idNr));
				bankAccounts.add(ba);

			} else {
				BankAccount ba = new BankAccount(holderName, idNr);
				bankAccounts.add(ba);

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
		boolean res = false;
		BankAccount ba1 = null;
		for (BankAccount b : bankAccounts) {
			if (number == b.getAccountNumber()) {
				ba1 = b;
				res = true;
			}
		}
		if (ba1 != null) {
			bankAccounts.remove(ba1);
		}
		return res;
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
		BankAccount tmp = null;
		for (BankAccount b : bankAccounts) {
			if (accountNumber == b.getAccountNumber()) {
				return b;
			}
		}
		return tmp;
	}

	/**
	 * Söker upp alla bankkonton som innehas av kunden med id-nummer ’idNr’. Kontona
	 * returneras i en lista. Kunderna antas ha unika id-nummer.
	 */
	ArrayList<BankAccount> findAccountsForHolder(long idNr) {
		ArrayList<BankAccount> accountList = new ArrayList<BankAccount>();
		for (BankAccount b : getAllAccounts())
			if (idNr == b.getHolder().getIdNr()) {
				accountList.add(b);
			}
		return accountList;
	}

	/**
	 * Söker upp kunder utifrån en sökning på namn eller del av namn. Alla personer
	 * vars namn innehåller strängen ’namePart’ inkluderas i resultatet, som
	 * returneras som en lista. Samma person kan förekomma flera gånger i
	 * resultatet. Sökningen är "case insensitive", det vill säga gör ingen skillnad
	 * på stora och små bokstäver.
	 */
	ArrayList<Customer> findByPartofName(String namePart) {
		ArrayList<Customer> accountList = new ArrayList<Customer>();
		for (BankAccount b : getAllAccounts()) {
			if (b.getHolder().getName().toLowerCase().contains(namePart.toLowerCase())) {
				accountList.add(b.getHolder());
			}
		}
		return accountList;

	}

	public ArrayList<BankAccount> getUnsortedList() {
		return this.bankAccounts;
	}

}