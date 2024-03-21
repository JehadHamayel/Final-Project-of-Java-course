package application;

//Name: Jehad Hamayel
//ID: 1200348
public abstract class Media implements Comparable<Media> {
	// Media traits
	private String code;
	private String title;
	private int copiesAvailable;

	// Constructor to add a new Media
	public Media(String code, String title, int copiesAvailable) {
		super();
		this.code = code;
		this.title = title;
		this.copiesAvailable = copiesAvailable;
	}

	// Method to return Media information as String
	public abstract String toString();

	//// Method for comparing Media in alphabetical order by title
	@Override
	public int compareTo(Media m) {
		if (code.compareTo(m.code) > 0)
			return 1;
		else if (code.compareTo(m.code) < 0)
			return -1;
		else
			return 0;
	}

	// getters and setter for Media;
	public String getTitle() {
		return title;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCode() {
		return code;
	}

	public void setCopiesAvailable(int copiesAvailable) {
		this.copiesAvailable = copiesAvailable;
	}

	public int getCopiesAvailable() {
		return copiesAvailable;
	}
}