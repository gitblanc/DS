import java.util.List;
import java.util.ArrayList;

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

	// genera la factura
	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		String result = "Rental Record for " + getName() + "\n";

		for (Rental each : rentals) {
			double thisAmount = each.getCharge();

			frequentRenterPoints += each.getFrequentRenterPoints();

			// Muestra el importe de esta película alquilada
			result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
			totalAmount += thisAmount;
		}

		// Añade las líneas de total
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";

		return result;
	}
}
