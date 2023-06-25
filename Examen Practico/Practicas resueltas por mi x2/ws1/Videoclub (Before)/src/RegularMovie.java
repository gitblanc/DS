
public class RegularMovie implements MovieType {

	@Override
	public double getCharge(int daysRented) {
		double res = 2;
		if (daysRented > 2)
			res += (daysRented - 2) * 1.5;
		return res;
	}

	@Override
	public int getFrequentRenterPoints(int daysRented) {
		return 1;
	}

}
