package Movies;

public class Movie {
	public static final MovieType CHILDRENS = new ChildrenMovie();
	public static final MovieType NEW_RELEASE = new NewReleaseMovie();
	public static final MovieType REGULAR = new RegularMovie();

	private String title;
	private MovieType movieType;

	public Movie(String title, MovieType movieType) {
		this.title = title;
		this.movieType = movieType;
	}

	public String getTitle() {
		return title;
	}

	public double getCharge(int daysRented) {
		return movieType.getCharge(daysRented);
	}

	public int getFreq(int daysRented) {
		return movieType.getFrequentRenterPoints(daysRented);
	}
}
