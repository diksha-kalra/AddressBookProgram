package com.addressbook;

import java.util.*;
import java.util.stream.Collectors;

public class AddressBookMain {

	public static void main(String[] args) {

		// Printing welcome message
		System.out.println("Welcome To Address Book Program");

		Scanner obj = new Scanner(System.in);
		AddressBookDict address = new AddressBookDict();
		while (true) {
			System.out.println("Enter 1 to add addressbook");
			System.out.println("Enter 2 to display address book");
			System.out.println("Enter 3 to display person across address book on basis of city");
			System.out.println("Enter 4 to display person across address book on basis of city");
			System.out.println("Enter 0 to exit");
			int ch1 = obj.nextInt();
			if (ch1 == 1) {
				ContactPerson contactPerson = new ContactPerson();
				System.out.println("Enter the Address Book Name");
				String add_book_name = obj.next();
				address.addAddressBook(add_book_name, contactPerson);
				while (true) {
					System.out.println("Enter 1 to add details");
					System.out.println("Enter 2 for viewing all contact details");
					System.out.println("Enter 3 to modify details");
					System.out.println("Enter 4 to delete details of a person");
					System.out.println("Enter 5 to get persons of same city");
					System.out.println("Enter 6 to get persons of same State");
					System.out.println("Enter 7 to get count of person belonging to same city");
					System.out.println("Enter 8 to get count of person belonging to same state");
					System.out.println("Enter 9 to get sorted list of contacts by person name");
					System.out.println("Enter 10 to get sorted list of city names");
					System.out.println("Enter 11 to get sorted list of state names");
					System.out.println("Enter 0 to exit");
					System.out.println("Enter the action to perform");
					int ch = obj.nextInt();
					if (ch == 1) {
						while (true) {
							System.out.println("Enter the name of person whose conatct you need to add");
							String name = obj.next();
							boolean flag = (contactPerson.getPerson()).stream()
									.noneMatch(person -> person.getFirst_name().equals(name));
							if (flag == false) {
								System.out.println("Contact with this name exist give another name");
								continue;
							} else {
								contactPerson.addPerson();
								break;
							}
						}
					} else if (ch == 2) {
						contactPerson.viewAllContacts();
					} else if (ch == 3) {
						System.out.println("Enter the name of person whose contact is to be modified");
						String name = obj.next();
						contactPerson.Modify(name);
					} else if (ch == 4) {
						System.out.println("Enter the name of person whose contact is to be deleted");
						String name = obj.next();
						contactPerson.remove(name);
					} else if (ch == 5) {
						System.out.println("Enter the city name");
						String cityName = obj.next();
						List<PersonInfo> personByCity = new ArrayList<PersonInfo>();
						personByCity = (contactPerson.getPerson()).stream()
								.filter(PersonInfo -> PersonInfo.getCity().equals(cityName))
								.collect(Collectors.toList());
						for (PersonInfo p : personByCity) {
							System.out.println(p.getFirst_name());
						}
					} else if (ch == 6) {
						System.out.println("Enter the state name");
						String stateName = obj.next();
						List<PersonInfo> personByState = new ArrayList<PersonInfo>();
						personByState = (contactPerson.getPerson()).stream()
								.filter(PersonInfo -> PersonInfo.getState().equals(stateName))
								.collect(Collectors.toList());
						for (PersonInfo p : personByState) {
							System.out.println(p.getFirst_name());
						}
					} else if (ch == 7) {
						System.out.println("Enter the city name");
						String cityName = obj.next();
						Long personByCity = (contactPerson.getPerson()).stream()
								.filter(PersonInfo -> PersonInfo.getCity().equals(cityName)).count();
						System.out.println("No of person in same city : " + personByCity);
					} else if (ch == 8) {
						System.out.println("Enter the state name");
						String stateName = obj.next();
						Long personByState = (contactPerson.getPerson()).stream()
								.filter(PersonInfo -> PersonInfo.getState().equals(stateName)).count();
						System.out.println("No of person in same city : " + personByState);
					} else if (ch == 9) {
						List<String> sortedByName = new ArrayList<>();
						sortedByName = (contactPerson.getPerson()).stream().map(PersonInfo -> PersonInfo.toString())
								.sorted().collect(Collectors.toList());
						for (String p : sortedByName) {
							System.out.println(p);
						}
					} else if (ch == 10) {
						List<String> sortedByCity = new ArrayList<>();
						sortedByCity = (contactPerson.getPerson()).stream().map(PersonInfo -> PersonInfo.getCity())
								.sorted().collect(Collectors.toList());
						for (String p : sortedByCity) {
							System.out.println(p);
						}
					} else if (ch == 11) {
						List<String> sortedByState = new ArrayList<>();
						sortedByState = (contactPerson.getPerson()).stream().map(PersonInfo -> PersonInfo.getState())
								.sorted().collect(Collectors.toList());
						for (String p : sortedByState) {
							System.out.println(p);
						}
					} else {
						break;
					}
				}
			} else if (ch1 == 2) {
				address.viewAddressBook();
			} else if (ch1 == 3) {
				address.searchAddressBookByCity();
			} else if (ch1 == 4) {
				address.searchAddressBookByState();
			} else {
				break;
			}
		}
		obj.close();
	}
}
