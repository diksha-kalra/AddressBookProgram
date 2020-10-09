package com.addressbook;

import java.util.*;

public class AddressBookMain {

	public static void main(String[] args) {

		// Printing welcome message
		System.out.println("Welcome To Address Book Program");

		Scanner obj = new Scanner(System.in);
		AddressBookDict address = new AddressBookDict();
		ContactPerson contactPerson = new ContactPerson();
		boolean flag = true;
		while (flag == true) {
			System.out.println("Enter 1 to add addressbook");
			System.out.println("Enter 2 to add contact");
			System.out.println("Enter 3 to view details");
			System.out.println("Enter 4 to modify details");
			System.out.println("Enter 5 to delete contact details");
			System.out.println("Enter 6 to get persons of same city");
			System.out.println("Enter 7 to get persons of same State");
			System.out.println("Enter 8 to get count of person belonging to same city");
			System.out.println("Enter 9 to get count of person belonging to same state");
			System.out.println("Enter 10 to get sorted list of contacts by person name");
			System.out.println("Enter 11 to get sorted list by city names");
			System.out.println("Enter 12 to get sorted list by state names");
			System.out.println("Enter 13 to get sorted list by zip codes");
			System.out.println("Enter 14 to view all address book details");
			System.out.println("Enter 15 to display person across address book on basis of city");
			System.out.println("Enter 16 to display person across address book on basis of state");
			System.out.println("Enter 0 to exit");
			System.out.println("Enter the action to perform");
			int ch1 = obj.nextInt();
			if (ch1 == 1) {
				contactPerson.createAddressBook(address);
				flag = true;
			}
			if (ch1 == 2) {
				contactPerson.createConatct(address);
				flag = true;
			}
			if (ch1 == 3) {
				contactPerson.viewAllContacts(address);
				flag = true;
			}
			if (ch1 == 4) {
				contactPerson.modify(address);
				flag = true;
			}
			if (ch1 == 5) {
				contactPerson.remove(address);
				flag = true;
			}
			if (ch1 == 6) {
				contactPerson.getPersonByCityName(address);
				flag = true;
			}
			if (ch1 == 7) {
				contactPerson.getPersonByStateName(address);
				flag = true;
			}
			if (ch1 == 8) {
				contactPerson.getCountByCity(address);
				flag = true;
			}
			if (ch1 == 9) {
				contactPerson.getCountByState(address);
				flag = true;
			}
			if (ch1 == 10) {
				contactPerson.sortByName(address);
				flag = true;
			}
			if (ch1 == 11) {
				contactPerson.sortByCity(address);
				flag = true;
			}
			if (ch1 == 12) {
				contactPerson.sortByState(address);
				flag = true;
			}
			if (ch1 == 13) {
				contactPerson.sortByZip(address);
				flag = true;
			}
			if (ch1 == 14) {
				address.viewAddressBook();
				flag = true;
			}
			if (ch1 == 15) {
				address.searchAddressBookByCity();
				flag = true;
			}
			if (ch1 == 16) {
				address.searchAddressBookByState();
				flag = true;
			}
			if (ch1 == 0) {
				flag = false;
			}
		}
		obj.close();
	}
}