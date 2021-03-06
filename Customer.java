
import java.util.Random;
import java.util.ArrayList;

public class Customer {

	private long idNr;
	private String name;
	private Random rand = new Random();
	private ArrayList<Integer> customerNbrCompare = new ArrayList<Integer>();
	private int customerNbr;

	/**
	 * Skapar en kund (kontoinnehavare) med namnet ’name’ och id-nummer ’idNr’.
	 * Kunden tilldelas också ett unikt kundnummer.
	 */
	public Customer(String name, long idNr) {
		this.name = name;
		this.idNr = idNr;

		int randomCustomerNbr = rand.nextInt(1000000000);
		for (Integer i : customerNbrCompare) {
			while (customerNbrCompare.get(i) == randomCustomerNbr) {
				randomCustomerNbr = rand.nextInt(1000000000);
			}
		}
		customerNbrCompare.add(randomCustomerNbr);
		this.customerNbr = randomCustomerNbr;
	}

	/** Tar reda på kundens namn. */
	public String getName() {
		return this.name;
	}

	/** Tar reda på kundens personnummer. */
	public long getIdNr() {
		return this.idNr;
	}

	/** Tar reda på kundens kundnummer. */
	public int getCustomerNr() {
		return customerNbr;
	}

	/** Returnerar en strängbeskrivning av kunden. OBS PUBLIC, KOLLA OM RÄTT */
	public String toString() {
		return "Namn: " + this.name + " | " + "Kundnummer: " + this.customerNbr + " | " + "Personnummer: " + (this.idNr);
	}
}