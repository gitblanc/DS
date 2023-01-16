import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String name;
	private List<Rental> rentals = new ArrayList<Rental>();

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental rental) {
		rentals.add(rental);
	}

	public String getName() {
		return name;
	}

	public String statement() {
		String result = "Rental Record for " + getName() + "\n";

		for (Rental each : rentals) {
			// Muestra el importe de esta película alquilada
			result += "\t" + each.getMovie().getTitle() + "\t" + each.getCharge() + "\n";
		}

		// Añade las líneas de total
		result += "Amount owed is " + getTotalAmount() + "\n";
		result += "You earned " + getTotalFrequentRenterPoints() + " frequent renter points";

		return result;
	}

	private int getTotalFrequentRenterPoints() {
		int res = 0;
		for (Rental each : rentals)
			res += each.getFreq();
		return res;
	}

	private double getTotalAmount() {
		double res = 0;
		for (Rental each : rentals)
			res += each.getCharge();
		return res;
	}
}
