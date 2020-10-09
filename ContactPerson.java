package com.addressbook;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ContactPerson {
	Scanner obj = new Scanner(System.in);
	
	// Array list to store contact person details
	private ArrayList<PersonInfo> person = new ArrayList<PersonInfo>();

	public void setPerson(ArrayList<PersonInfo> person) {
		this.person = person;
	}

	public ArrayList<PersonInfo> getPerson() {
		return person;
	}

	public void createAddressBook(AddressBookDict addressBook) {
		System.out.println("Enter the Address Book Name");
		String add_book_name = obj.next();
		addressBook.addAddressBook(add_book_name);
		System.out.println("Address book created");
	}

	public void createConatct(AddressBookDict addressBook) {
		System.out.println("Enter the address book name to which you want to add this contact");
		String addressBookName = obj.next();
		PersonInfo p = new PersonInfo();
		PersonInfo p1 = addPerson(p);
		boolean createContact = addressBook.addContact(addressBookName, p1);
		if (createContact == false) {
			System.out.println("Contact cant be created try with another name");
		} else {
			System.out.println("Contact Added");
		}
	}

	// Method to add contact person details
	public PersonInfo addPerson(PersonInfo p) {
		System.out.println("Enter First Name");
		String fname = obj.next();
		System.out.println("Enter Last Name");
		String lname = obj.next();
		System.out.println("Enter Address");
		String address = obj.next();
		System.out.println("Enter City");
		String city = obj.next();
		System.out.println("Enter State");
		String state = obj.next();
		System.out.println("Enter the six digit Zip Code");
		String zipCode = obj.next();
		String pattern3 = "^[1-9]{1}[0-9]{5}$";
		Pattern zip_pattern = Pattern.compile(pattern3);
		Matcher m3 = zip_pattern.matcher(zipCode);
		if (m3.matches() == false) {
			System.out.println("zip code not in format enter again");
			zipCode = obj.next();
		}
		System.out.println("Enter the ten digit Phone Number");
		String phoneNo = obj.next();
		String pattern1 = "^[1-9]{1}[0-9]{9}$";
		Pattern mobile_pattern = Pattern.compile(pattern1);
		Matcher m1 = mobile_pattern.matcher(phoneNo);
		if (m1.matches() == false) {
			System.out.println("phone number not in format enter again");
			phoneNo = obj.next();
		}
		System.out.println("Enter Email");
		String email = obj.next();
		String pattern2 = "^[a-zA-Z0-9]+((\\.[0-9]+)|(\\+[0-9]+)|(\\-[0-9]+)|([0-9]))*@*+[a-zA-Z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern email_sample = Pattern.compile(pattern2);
		Matcher m2 = email_sample.matcher(email);
		if (m2.matches() == false) {
			System.out.println("email not in format enter again");
			email = obj.next();
		}
		p = new PersonInfo(fname, lname, address, city, state, zipCode, phoneNo, email);
		return p;
	}

	// Method to check if list is empty
	public boolean isEmpty() {
		return person.isEmpty();
	}

	// Method to check all contacts available
	public void viewAllContacts(AddressBookDict addressBook) {
		System.out.println("Enter the address book name of whose contact list you want to see");
		String addressBookName = obj.next();
		List<PersonInfo> ContactList = addressBook.getContactList(addressBookName);
		if (ContactList.isEmpty()) {
			System.out.println("List is empty");
		} else {
			System.out.println("Contacts in address book " + addressBookName + "are :");
			ContactList.stream().forEach((System.out::println));
			System.out.print("\n");
		}
	}

	// Method to modify details
	public void modify(AddressBookDict addressBook) {
		System.out.println("Enter the address book name whose contact you want to edit");
		String addressBookName = obj.next();
		System.out.println("Enter the name whose contact you want to edit");
		String name = obj.next();
		PersonInfo p = addressBook.getContactByName(addressBookName, name);
		if (p == null) {
			System.out.println("No such contact exists");
		} else {
			while (true) {
				System.out.println(
						"1. First name\n 2.Last name\n 3.Address\n 4. City\n 5. State\n 6. Zip\n 7. Phone number\n 8.Email\n 0. Exit");
				System.out.println("Enter the info to be modified");
				int info_name = obj.nextInt();
				switch (info_name) {
				case 1:
					System.out.println("Enter new First Name");
					p.setFirst_name(obj.next());
					break;
				case 2:
					System.out.println("Enter new Last Name");
					p.setLast_name(obj.next());
					break;
				case 3:
					System.out.println("Enter new Address");
					p.setAddress(obj.next());
					break;
				case 4:
					System.out.println("Enter new City");
					p.setCity(obj.next());
					break;
				case 5:
					System.out.println("Enter new State");
					p.setState(obj.next());
					break;
				case 6:
					System.out.println("Enter new Zip Code");
					p.setZip(obj.next());
					break;
				case 7:
					System.out.println("Enter new Phone Number");
					p.setPhno(obj.next());
					break;
				case 8:
					System.out.println("Enter new Email");
					p.setEmail(obj.next());
					break;
				}
				if (info_name == 0) {
					break;
				}
			}
		}
	}

	// Method to remove contact details
	public void remove(AddressBookDict addressBook) {
		System.out.println("Enter the address book name from where you want to delete the contact");
		String addressBookName = obj.next();
		System.out.println("Enter the person name whose contact you want to delete");
		String name = obj.next();
		PersonInfo p = addressBook.getContactByName(addressBookName, name);
		if (p == null) {
			System.out.println("No such contact exists");
		} else {
			addressBook.removeContact(addressBookName, p);
			System.out.println("Details of " + name + " removed");
		}
	}

	// method to get person entries by name
	public void getPersonByCityName(AddressBookDict addressBook) {
		System.out.println("Enter the address book name whose contacts you want to see by city name");
		String addressBookName = obj.next();
		List<PersonInfo> ContactList = addressBook.getContactList(addressBookName);
		Map<String, List<PersonInfo>> personByCity = (ContactList.stream()
				.collect(Collectors.groupingBy(PersonInfo::getCity, Collectors.toList())));
		personByCity.entrySet().forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
		if (personByCity.isEmpty()) {
			System.out.println("Add contacts to get person by cities");
		}
	}

	// method to get person entries by state name
	public void getPersonByStateName(AddressBookDict addressBook) {
		System.out.println("Enter the address book name whose contacts you want to see by state name");
		String addressBookName = obj.next();
		List<PersonInfo> ContactList = addressBook.getContactList(addressBookName);
		Map<String, List<PersonInfo>> personByState = (ContactList.stream()
				.collect(Collectors.groupingBy(PersonInfo::getState, Collectors.toList())));
		personByState.entrySet().forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
		if (personByState.isEmpty()) {
			System.out.println("Add contacts to get person by cities");
		}
	}

	// method to sort person entries by name
	public void sortByName(AddressBookDict addressBook) {
		System.out.println("Enter the address book name whose contacts you want to see in sorted order by name");
		String addressBookName = obj.next();
		List<PersonInfo> ContactList = addressBook.getContactList(addressBookName);
		if (ContactList.isEmpty()) {
			System.out.println("Empty list");
		}
		List<PersonInfo> sortedByName = new ArrayList<PersonInfo>();
		ContactList.stream().sorted((con1, con2) -> (con1.getFirst_name() + con1.getLast_name())
				.compareTo(con2.getFirst_name() + con2.getLast_name())).forEach(con -> sortedByName.add(con));
		for (PersonInfo p : sortedByName) {
			System.out.println(p);
		}
	}

	// method to sort person entries by city
	public void sortByCity(AddressBookDict addressBook) {
		System.out.println("Enter the address book name whose contacts you want to see in sorted order by city");
		String addressBookName = obj.next();
		List<PersonInfo> ContactList = addressBook.getContactList(addressBookName);
		if (ContactList.isEmpty()) {
			System.out.println("Empty list");
		}
		List<PersonInfo> sortedByCity = new ArrayList<PersonInfo>();
		ContactList.stream().sorted((con1, con2) -> (con1.getCity().compareTo(con2.getCity())))
				.forEach(con -> sortedByCity.add(con));
		for (PersonInfo p : sortedByCity) {
			System.out.println(p);
		}
	}

	// method to sort person entries by State
	public void sortByState(AddressBookDict addressBook) {
		System.out.println("Enter the address book name whose contacts you want to see in sorted order by state");
		String addressBookName = obj.next();
		List<PersonInfo> ContactList = addressBook.getContactList(addressBookName);
		if (ContactList.isEmpty()) {
			System.out.println("Empty list");
		}
		List<PersonInfo> sortedByState = new ArrayList<PersonInfo>();
		ContactList.stream().sorted((con1, con2) -> con1.getState().compareTo(con2.getState()))
				.forEach(con -> sortedByState.add(con));
		for (PersonInfo p : sortedByState) {
			System.out.println(p);
		}
	}

	// method to sort person entries by Zip Code
	public void sortByZip(AddressBookDict addressBook) {
		System.out.println("Enter the address book name whose contacts you want to see in sorted order  by zip code");
		String addressBookName = obj.next();
		List<PersonInfo> ContactList = addressBook.getContactList(addressBookName);
		if (ContactList.isEmpty()) {
			System.out.println("Empty list");
		}
		List<PersonInfo> sortedByZip = new ArrayList<PersonInfo>();
		ContactList.stream().sorted((con1, con2) -> con1.getZip().compareTo(con2.getZip()))
				.forEach(con -> sortedByZip.add(con));
		for (PersonInfo p : sortedByZip) {
			System.out.println(p);
		}
	}

	// method to count entries by city name
	public void getCountByCity(AddressBookDict addressBook) {
		System.out.println("Enter the address book name whose contacts you want to see in sorted order  by zip code");
		String addressBookName = obj.next();
		List<PersonInfo> ContactList = addressBook.getContactList(addressBookName);
		System.out.println("Enter the city name");
		String cityName = obj.next();
		Long personByCity = ContactList.stream().filter(PersonInfo -> PersonInfo.getCity().equals(cityName)).count();
		System.out.println("No of person in same city : " + personByCity);
	}

	// method to count entries by state name
	public void getCountByState(AddressBookDict addressBook) {
		System.out.println("Enter the address book name whose contacts you want to see in sorted order  by zip code");
		String addressBookName = obj.next();
		List<PersonInfo> ContactList = addressBook.getContactList(addressBookName);
		System.out.println("Enter the city name");
		String cityName = obj.next();
		Long personByState = ContactList.stream().filter(PersonInfo -> PersonInfo.getState().equals(cityName)).count();
		System.out.println("No of person in same city : " + personByState);
	}
}
