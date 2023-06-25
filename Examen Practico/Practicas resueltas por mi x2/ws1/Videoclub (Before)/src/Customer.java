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

	public String statement() {
		String result = "Rental Record for " + getName() + "\n";

		for (Rental each : rentals) {
			result += "\t" + each.getMovie().getTitle() + "\t"
					+ String.valueOf(each.getMovie().getCharge(each.getDaysRented())) + "\n";
		}

		// Añade las líneas de total
		result += "Amount owed is " + String.valueOf(getTotalAmount()) + "\n";
		result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";

		return result;
	}

	private int getTotalFrequentRenterPoints() {
		int total = 0;
		for (Rental each : rentals) {
			total += each.getMovie().getFrequentRenterPoints(each.getDaysRented());
		}
		return total;
	}

	private double getTotalAmount() {
		double total = 0.0;
		for (Rental each : rentals) {
			total += each.getMovie().getCharge(each.getDaysRented());
		}
		return total;
	}
}
