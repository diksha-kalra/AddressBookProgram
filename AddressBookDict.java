package com.addressbook;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.logging.Logger;

public class AddressBookDict {
	Scanner obj = new Scanner(System.in);
	Logger log = Logger.getLogger(AddressBookDict.class.getName());
	private TreeMap<String, ArrayList<PersonInfo>> addressBook = new TreeMap<String, ArrayList<PersonInfo>>();

	public TreeMap<String, ArrayList<PersonInfo>> getAddressBookDict() {
		return addressBook;
	}

	public void setAddressBookDict(TreeMap<String, ArrayList<PersonInfo>> addressBook) {
		this.addressBook = addressBook;
	}

	public void addAddressBook(String AddressBookName) {
		addressBook.put(AddressBookName, new ArrayList<PersonInfo>());
	}

	public void viewAddressBook() {
		if (addressBook.isEmpty()) {
			log.info("address book is empty");
		}
		for (Entry<String, ArrayList<PersonInfo>> entry : addressBook.entrySet())
			log.info("[" + entry.getKey() + ", " + entry.getValue() + "]");
	}

	public void searchAddressBookByCity() {
		if (addressBook.isEmpty()) {
			log.info("address book is empty");
		}
		log.info("Enter the city name");
		String cityName = obj.next();
		List<PersonInfo> personByCity = new ArrayList<PersonInfo>();
		for (Entry<String, ArrayList<PersonInfo>> entry : addressBook.entrySet()) {
			personByCity = (entry.getValue().stream().filter(PersonInfo -> PersonInfo.getCity().equals(cityName)))
					.collect(Collectors.toList());
			System.out.println(personByCity);
		}
	}

	public ArrayList<PersonInfo> getContactList(String addressBookName) {
		return addressBook.get(addressBookName);
	}

	public void searchAddressBookByState() {
		if (addressBook.isEmpty()) {
			log.info("address book is empty");
		}
		log.info("Enter the state name");
		String stateName = obj.next();
		List<PersonInfo> personByState = new ArrayList<PersonInfo>();
		for (Entry<String, ArrayList<PersonInfo>> entry : addressBook.entrySet()) {
			personByState = (entry.getValue().stream().filter(PersonInfo -> PersonInfo.getState().equals(stateName)))
					.collect(Collectors.toList());
			System.out.println(personByState);
		}
	}

	public boolean addContact(String addressBookName, PersonInfo p) {
		if (addressBook.containsKey(addressBookName)) {
			PersonInfo check = addressBook.get(addressBookName).stream().filter(con -> p.equals(con)).findAny()
					.orElse(null);
			if (check == null) {
				addressBook.get(addressBookName).add(p);
				return true;
			} else {
				return false;
			}
		} else {
			addAddressBook(addressBookName);
			addressBook.get(addressBookName).add(p);
			return true;
		}
	}

	public PersonInfo getContactByName(String addressBookName, String name) {
		PersonInfo p = null;
		if (addressBook.containsKey(addressBookName)) {
			p = addressBook.get(addressBookName).stream().filter(con -> (con.getFirst_name()).equals(name)).findAny()
					.orElse(null);
		}
		return p;
	}

	public void removeContact(String addressBookName, PersonInfo p) {
		addressBook.get(addressBookName).remove(p);
	}
}
