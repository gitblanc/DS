/**
 * 
 */

/**
 * @author omenp
 *
 */
public class ChildrensMovie implements MovieType {

	@Override
	public double getCharge(int daysRented) {
		double result = 1.5;
		if (daysRented > 3)
			result += (daysRented - 3) * 1.5;
		return result;
	}

	@Override
	public int getFrequentRenterPoints(int days) {
		return 1;
	}

}
