package application;

//Name: Jehad Hamayel
//ID: 1200348
public class Movie extends Media {
	// Movie traits
	private String rating;

	// Constructor to add a new Movie
	public Movie(String code, String title, int copiesAvailable, String rating) {
		super(code, title, copiesAvailable);
		this.rating = rating;
	}

////Method to return Movie information as String
	@Override
	public String toString() {
		return "Movie: " + "Code: " + super.getCode() + ",title:" + super.getTitle() + ", rating:" + rating
				+ ", copiesAvailable:" + super.getCopiesAvailable();
	}

////getter and setter for Movie media;
	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}
}