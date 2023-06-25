public class Movie {
	public static final MovieType CHILDREN = new ChildrenMovie();
	public static final MovieType NEW_RELEASE = new NewReleaseMovie();
	public static final MovieType REGULAR = new RegularMovie();

	private String title;
	private MovieType movieType;

	public Movie(String title, MovieType movieType) {
		this.title = title;
		this.movieType = movieType;
	}

	public double getCharge(int daysRented) {
		return movieType.getCharge(daysRented);
	}

	public String getTitle() {
		return title;
	}

	public int getFrequentRenterPoints(int daysRented) {
		return movieType.getFrequentRenterPoints(daysRented);
	}
}
