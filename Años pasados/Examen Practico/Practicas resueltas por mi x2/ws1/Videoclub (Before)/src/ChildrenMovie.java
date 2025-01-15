
public class ChildrenMovie implements MovieType {

	@Override
	public double getCharge(int daysRented) {
		double res = 1.5;
		if (daysRented > 3)
			res += (daysRented - 3) * 1.5;
		return res;
	}

	@Override
	public int getFrequentRenterPoints(int daysRented) {
		return 1;
	}

}
