package application;

//Name: Jehad Hamayel
//ID: 1200348
public class Game extends Media {
	// Game traits
	private double weight;

	//// Constructor to add a new Game
	public Game(String code, String title, int copiesAvailable, double weight) {
		super(code, title, copiesAvailable);
		this.weight = weight;
	}

	// Method to return Game information as String
	@Override
	public String toString() {
		return "Game: " + "Code: " + super.getCode() + ",title: " + super.getTitle() + ", weight: " + weight
				+ ", copiesAvailable: " + super.getCopiesAvailable();
	}
	// Getters and Setters for Game media
	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
}