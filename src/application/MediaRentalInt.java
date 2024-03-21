package application;

import java.util.*;

public interface MediaRentalInt {
//Methodes is passed on to his subclasses
	void addCustomer(String id, String mobileNumber, String name, String address, String plan);

	void addMovie(String code, String title, int copiesAvailable, String rating);

	void addGame(String code, String title, int copiesAvailable, double weight);

	void addAlbum(String code, String title, int copiesAvailable, String artist, String songs);

	void setLimitedPlanLimit(int value);

	String getAllCustomersInfo();

	String getAllMediaInfo();

	boolean addToCart(String id, String code);

	boolean removeFromCart(String id, String code);

	String processRequests(String id);

	boolean returnMedia(String id, String code);

	ArrayList<String> searchMedia(String title, String rating, String artist, String songs);
}
