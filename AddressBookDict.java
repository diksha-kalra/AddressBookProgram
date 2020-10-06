package com.addressbook;

import java.util.*;

public class AddressBookDict {
	Scanner obj = new Scanner(System.in);

	private TreeMap<String, ContactPerson> addressBook = new TreeMap<String, ContactPerson>();

	public TreeMap<String, ContactPerson> getAddressBookDict() {
		return addressBook;
	}

	public void setAddressBookDict(TreeMap<String, ContactPerson> addressBook) {
		this.addressBook = addressBook;
	}

	public void addAddressBook(String AddressBookName, ContactPerson obj) {
		addressBook.put(AddressBookName, obj);
	}

	public void viewAddressBook() {
		if (addressBook.isEmpty()) {
			System.out.println("address book is empty");
		}
		for (Map.Entry<String, ContactPerson> entry : addressBook.entrySet())
			System.out.println("[" + entry.getKey() + ", " + entry.getValue().viewAllContacts() + "]");
	}

	public void SearchAddressBook() {
		if (addressBook.isEmpty()) {
			System.out.println("address book is empty");
		}
		System.out.println("Enter the city name");
		String cityName = obj.next();
		System.out.println("Enter the state name");
		String stateName = obj.next();
		for (Map.Entry<String, ContactPerson> entry : addressBook.entrySet()) {
			System.out.println("address book name " + entry.getKey() + " people in city " + cityName + " -");
			System.out.println(entry.getValue().searchOnBasisOfCity(cityName));
		}
		for (Map.Entry<String, ContactPerson> entry : addressBook.entrySet()) {
			System.out.println("address book name " + entry.getKey() + " people in state " + stateName + " -");
			System.out.println(entry.getValue().searchOnBasisOfState(stateName));
		}
	}
}