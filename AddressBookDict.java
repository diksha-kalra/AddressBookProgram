package com.addressbook;

import java.util.*;
import java.util.stream.Collectors;

public class AddressBookDict {
	private String addressBookName;
	Scanner obj = new Scanner(System.in);

	private TreeMap<String, ContactPerson> addressBook = new TreeMap<String, ContactPerson>();

	public TreeMap<String, ContactPerson> getAddressBookDict() {
		return addressBook;
	}

	public void setAddressBookDict(TreeMap<String, ContactPerson> addressBook) {
		this.addressBook = addressBook;
	}

	public void addAddressBook(String AddressBookName, ContactPerson obj) {
		setAddressBookName(AddressBookName);
		addressBook.put(AddressBookName, obj);
	}

	public void viewAddressBook() {
		if (addressBook.isEmpty()) {
			System.out.println("address book is empty");
		}
		for (Map.Entry<String, ContactPerson> entry : addressBook.entrySet())
			System.out.println("[" + entry.getKey() + ", " + entry.getValue().getPerson() + "]");
	}

	public void searchAddressBookByCity() {
		if (addressBook.isEmpty()) {
			System.out.println("address book is empty");
		}
		System.out.println("Enter the city name");
		String cityName = obj.next();
		List<PersonInfo> personByCity = new ArrayList<PersonInfo>();
		for (Map.Entry<String, ContactPerson> entry : addressBook.entrySet()) {
			personByCity = (entry.getValue().getPerson().stream()
					.filter(PersonInfo -> PersonInfo.getState().equals(cityName))).collect(Collectors.toList());
			System.out.println(personByCity);
		}
	}

	public void searchAddressBookByState() {
		if (addressBook.isEmpty()) {
			System.out.println("address book is empty");
		}
		System.out.println("Enter the state name");
		String stateName = obj.next();
		List<PersonInfo> personByState = new ArrayList<PersonInfo>();
		for (Map.Entry<String, ContactPerson> entry : addressBook.entrySet()) {
			personByState = (entry.getValue().getPerson().stream()
					.filter(PersonInfo -> PersonInfo.getState().equals(stateName))).collect(Collectors.toList());
			System.out.println(personByState);
		}
	}

	public String getAddressBookName() {
		return addressBookName;
	}

	public void setAddressBookName(String addressBookName) {
		this.addressBookName = addressBookName;
	}
}
