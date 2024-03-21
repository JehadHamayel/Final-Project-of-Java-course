package application;

//Name: Jehad Hamayel
//ID: 1200348
public class Album extends Media {
	// Album traits
	private String artist;
	private String songs;

	// Constructor to add a new Album
	public Album(String code, String title, int copiesAvailable, String artist, String songs) {
		super(code, title, copiesAvailable);
		this.artist = artist;
		this.songs = songs;
	}

	//Method to return Album information as String
	@Override
	public String toString() {
		return "Album: " + "Code: " + super.getCode() + ",title:" + super.getTitle() + ", artist:" + artist + ", songs:"
				+ songs + ", copiesAvailable:" + super.getCopiesAvailable();
	}

	// Getters and Setters for Album media
	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public void setSongs(String songs) {
		this.songs = songs;
	}

	public String getSongs() {
		return songs;
	}
}
