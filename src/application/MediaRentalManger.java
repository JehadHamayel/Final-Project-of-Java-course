package application;
//Name: Jehad Hamayel

//ID: 1200348

import java.util.ArrayList;
import java.util.*;

public class MediaRentalManger implements MediaRentalInt {
	// MediaRentalManger traits
	private ArrayList<Customer> customer = new ArrayList<>();;
	private ArrayList<Media> media = new ArrayList<>();
	private int value=2;


	// getters for MediaRentalManger;
	public ArrayList<Media> getMedia() {
		return media;
	}

	public ArrayList<Customer> getCustomer() {
		return customer;
	}
	// Constructor to add a new object of MediaRentalManger
	public MediaRentalManger() {

	}

	//Special Operations in the ArrayList of Customer and Media
	// adding customer to array of customer
	@Override
	public void addCustomer(String id, String mobileNumber, String name, String address, String plan) {
		customer.add(new Customer(id, mobileNumber, name, address, plan));

	}

	// adding Movie to array of media
	@Override
	public void addMovie(String code, String title, int copiesAvailable, String rating) {
		media.add(new Movie(code, title, copiesAvailable, rating));

	}

	// adding Game to array of media
	@Override
	public void addGame(String code, String title, int copiesAvailable, double weight) {

		media.add(new Game(code, title, copiesAvailable, weight));
	}

	// adding Album to array of media
	@Override
	public void addAlbum(String code, String title, int copiesAvailable, String artist, String songs) {

		media.add(new Album(code, title, copiesAvailable, artist, songs));

	}

//	Putting a purchase value for all custmers who have  LIMITED plan
	@Override
	public void setLimitedPlanLimit(int value) {
		this.value=value;
	}

	// Get all customer information
	@Override
	public String getAllCustomersInfo() {
		Collections.sort(customer);
		String info = "";
		for (int i = 0; i < customer.size(); i++) {
			info = info + customer.get(i).toString() + "\n";
		}
		return info;
	}

	// Get all the media info
	@Override
	public String getAllMediaInfo() {
		Collections.sort(media);
		String info = "";
		for (int i = 0; i < media.size(); i++) {
			info = info + media.get(i).toString() + "\n";
		}
		return info;
	}

	// Add media to the customer's interest basket
	@Override
	public boolean addToCart(String id, String code) {
		int index = -1;
		int index2 = -1;
		boolean notExistBefore = false;
		for (int i = 0; i < customer.size(); i++) {
			if (customer.get(i).getId().equals(id)) {
				index = i;
				break;
			}
		}
		for (int k = 0; k < media.size(); k++)
			if (media.get(k).getCode().equals(code)) {
				index2 = k;
				break;
			}
		if (index != -1 && index2 != -1) {
			if (customer.get(index).getInterestedInList().size() == 0) {
				customer.get(index).getInterestedInList().add(code);
				return true;
			}
			for (int j = 0; j < customer.get(index).getInterestedInList().size(); j++) {
				if (!(customer.get(index).getInterestedInList().get(j).equals(code))) {
					notExistBefore = true;
				} else {
					notExistBefore = false;
					break;
				}
			}
		}
		if (notExistBefore) {
			customer.get(index).getInterestedInList().add(code);
			return true;
		} else
			return false;
	}

	// Remove media from the customer's interest basket
	@Override
	public boolean removeFromCart(String id, String code) {
		int index = -1;

		for (int i = 0; i < customer.size(); i++) {
			if (customer.get(i).getId().equals(id)) {
				index = i;
			}
			if (index != -1) {
				for (int j = 0; j < customer.get(index).getInterestedInList().size(); j++) {
					if ((customer.get(index).getInterestedInList().get(j).equals(code))) {

						customer.get(index).getInterestedInList().remove(code);
						return true;
					}
				}
			}
		}
		return false;
	}
	 // Carrying out the purchase and reservation process for the media for 
	// customer according to the criteria allowed for the customer
	@Override
	public String processRequests(String id) {
		String info = "";
		ArrayList<String> removed = new ArrayList<>();
		int index = -1;
		for (int v = 0; v < customer.size(); v++) {
			if (customer.get(v).getId().equals(id)) {
				index = v;
				break;
			}
		}
		for (int j = 0; j < customer.get(index).getInterestedInList().size(); j++) {
			for (int k = 0; k < media.size(); k++) {
				if (customer.get(index).getInterestedInList().get(j).equals(media.get(k).getCode())) {
					if (customer.get(index).getPlan().equalsIgnoreCase("LIMITED")) {
						if (this.value > customer.get(index).getRentedList().size()
								&& (media.get(k).getCopiesAvailable() > 0)) {
							customer.get(index).getRentedList().add(media.get(k).getCode());
							removed.add(media.get(k).getCode());
							media.get(k).setCopiesAvailable(media.get(k).getCopiesAvailable() - 1);
							info = info + "Sending " + media.get(k).getTitle() + " " + "to "
									+ customer.get(index).getName() + "\n";
						}
					} else if (customer.get(index).getPlan().equalsIgnoreCase("UNLIMITED")) {
						if ((media.get(k).getCopiesAvailable() > 0)) {
							customer.get(index).getRentedList().add(media.get(k).getCode());
							removed.add(media.get(k).getCode());
							media.get(k).setCopiesAvailable(media.get(k).getCopiesAvailable() - 1);
							info = info + "Sending " + media.get(k).getTitle() + " " + "to "
									+ customer.get(index).getName() + "\n";
						}
					}
				}

			}
		}
		for (int h = 0; h < removed.size(); h++) {
			customer.get(index).getInterestedInList().remove(removed.get(h));
		}

		return info;
	}

//Returning media from the customer to the media system
	@Override
	public boolean returnMedia(String id, String code) {
		int index1 = -1;
		int index2 = -1;
		for (int i = 0; i < customer.size(); i++) {
			if (customer.get(i).getId().equals(id)) {
				index1 = i;
				break;
			}
		}
		if (index1 != -1) {
			for (int i = 0; i < customer.get(index1).getRentedList().size(); i++) {
				if (customer.get(index1).getRentedList().get(i).equals(code)) {
					customer.get(index1).getRentedList().remove(code);
					index2 = i;
					break;
				}
			}
			if (index2 != -1) {
				for (int j = 0; j < media.size(); j++) {
					if (media.get(j).getCode().equals(code)) {
						media.get(j).setCopiesAvailable(media.get(j).getCopiesAvailable() + 1);
					}
				}
			}

		}
		if (index1 != -1 && index2 != -1)
			return true;
		else
			return false;
	}

	// Do a search for the title of something in which you want to know the title
	// through different cases
	@Override
	public ArrayList<String> searchMedia(String title, String rating, String artist, String songs) {
		ArrayList<String> sMedia = new ArrayList<>();
		if (title == null && rating == null && artist == null && songs == null) {
			for (int i = 0; i < media.size(); i++) {
				sMedia.add(media.get(i).getTitle());
			}
		} else {
			if (title != null && rating == null && artist == null && songs == null)
				for (int i = 0; i < media.size(); i++) {
					if (media.get(i).getTitle().equalsIgnoreCase(title)) {
						sMedia.add(media.get(i).getTitle());
					}
				}
			else if (title != null && rating != null && artist == null && songs == null) {
				for (int i = 0; i < media.size(); i++)
					if (media.get(i) instanceof Movie)
						if (media.get(i).getTitle().equalsIgnoreCase(title)
								&& ((Movie) media.get(i)).getRating().equalsIgnoreCase(rating))
							sMedia.add(media.get(i).getTitle());
			} else if (title == null && rating != null && artist == null && songs == null) {
				for (int i = 0; i < media.size(); i++)
					if (media.get(i) instanceof Movie)
						if (((Movie) media.get(i)).getRating().equalsIgnoreCase(rating))
							sMedia.add(media.get(i).getTitle());
			} else if (title != null && rating == null && artist != null && songs == null) {
				for (int i = 0; i < media.size(); i++)
					if (media.get(i) instanceof Album)
						if (media.get(i).getTitle().equalsIgnoreCase(title)
								&& ((Album) media.get(i)).getArtist().equalsIgnoreCase(artist))
							sMedia.add(media.get(i).getTitle());
			} else if (title != null && rating == null && artist == null && songs != null) {
				for (int i = 0; i < media.size(); i++)
					if (media.get(i) instanceof Album) {
						String[] son = songs.split(",");
						for (int k = 0; k < son.length; k++) {
							son[k] = son[k].trim();
							if (media.get(i).getTitle().equalsIgnoreCase(title)
									&& (((Album) media.get(i)).getSongs().indexOf(son[k])) != -1)
								sMedia.add(media.get(i).getTitle());
						}
					}
			} else if (title != null && rating == null && artist != null && songs != null) {
				for (int i = 0; i < media.size(); i++)
					if (media.get(i) instanceof Album) {
						String[] son = songs.split(",");
						for (int k = 0; k < son.length; k++) {
							son[k] = son[k].trim();
							if (media.get(i).getTitle().equalsIgnoreCase(title)
									&& (((Album) media.get(i)).getSongs().indexOf(son[k])) != -1
									&& ((Album) media.get(i)).getArtist().equalsIgnoreCase(artist))
								sMedia.add(media.get(i).getTitle());
						}
					}

			} else if (title == null && rating == null && artist != null && songs == null) {
				for (int i = 0; i < media.size(); i++)
					if (media.get(i) instanceof Album)
						if (((Album) media.get(i)).getArtist().equalsIgnoreCase(artist))
							sMedia.add(media.get(i).getTitle());
			} else if (title == null && rating == null && artist == null && songs != null) {
				for (int i = 0; i < media.size(); i++)
					if (media.get(i) instanceof Album) {
						String[] son = songs.split(",");
						for (int k = 0; k < son.length; k++) {
							son[k] = son[k].trim();
							if ((((Album) media.get(i)).getSongs().indexOf(son[k])) != -1)
								sMedia.add(media.get(i).getTitle());
						}
					}
			} else if (title == null && rating == null && artist != null && songs != null) {
				for (int i = 0; i < media.size(); i++)
					if (media.get(i) instanceof Album) {
						String[] son = songs.split(",");
						for (int k = 0; k < son.length; k++) {
							son[k] = son[k].trim();
							if ((((Album) media.get(i)).getSongs().indexOf(son[k])) != -1
									&& ((Album) media.get(i)).getArtist().equalsIgnoreCase(artist))
								sMedia.add(media.get(i).getTitle());
						}
					}
			} else
				sMedia.add("This situation is illogical");
		}
		Collections.sort(sMedia);
		return sMedia;
	}
}