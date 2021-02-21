
// System.out och scanner 
import java.util.Scanner;

public class BankApplication {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		runApplication();
		Customer cust = new Customer("Vigge", 25);
		Customer cust1 = new Customer("eddan", 000426);
		BankAccount ba = new BankAccount(cust);
		BankAccount ba2 = new BankAccount("eddan", 000426);

	}

	private static void runApplication() {
		printMenuText();
		userInput();

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
			if (id == ) {
				
			}
			}
			
	    case 2:
		System.out.println("Val: 1. Hitta konto utifrån innehavare");
		System.out.println("Skriv in en innehavares ID");
		long id = scan.nextLong();
		if (id == )
		
	}
	}
}