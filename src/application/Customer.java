package application;

//Name: Jehad Hamayel
//ID: 1200348
import java.util.ArrayList;

public class Customer implements Comparable<Customer> {
	// Customer traits
	private String id;
	private String mobileNumber;
	private String name;
	private String address;
	private String plan;
	private ArrayList<String> interestedInList = new ArrayList<>();;
	private ArrayList<String> rentedList = new ArrayList<>();;

	public Customer() {
	}

	// Constructor to add a new customer
	public Customer(String id, String mobileNumber, String name, String address, String plan) {

		this.id = id;
		this.mobileNumber = mobileNumber;
		this.name = name;
		this.address = address;
		this.plan = plan;
		
	}

//Method to return customer information as String
	@Override
	public String toString() {
		return "Customer: " + "ID:" + id + ",Mobile Number:" + mobileNumber + ",name: " + name + " " + ", address: "
				+ address + " " + ", plan: " + plan;
	}

	// Method for comparing customers in alphabetical order by name
	@Override
	public int compareTo(Customer c) {
		if (id.compareTo(c.id) > 0)
			return 1;
		else if (id.compareTo(c.id) < 0)
			return -1;
		else
			return 0;
	}
//getters and setters for Customer traits
	public String getId() {
		return id;
	}

	public String getAddress() {
		return address;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}
	public String getPlan() {
		return plan;
	}

	public void setId(String id) {
		this.id = id;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	public String getName() {
		return name;
	}
	// getters for Customer media;
	public ArrayList<String> getInterestedInList() {
		return interestedInList;
	}

	public ArrayList<String> getRentedList() {
		return rentedList;
	}
	//Method used in sort method
	@Override
	public boolean equals(Object o) {
		if (o instanceof Customer) {
			return this.id == ((Customer) o).id;
		} else
			return false;
	}
}