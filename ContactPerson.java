package com.addressbook;

import java.util.*;

public class ContactPerson {
	Scanner obj = new Scanner(System.in);
	// Array list to store contact person details
	private ArrayList<PersonInfo> person = new ArrayList<PersonInfo>();
	PersonInfo p;

	public void setPerson(ArrayList<PersonInfo> person) {
		this.person = person;
	}

	public ArrayList<PersonInfo> getPerson() {
		return person;
	}

	// Method to add contact person details
	public void addPerson() {
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
		System.out.println("Enter Zip Code");
		String zipCode = obj.next();
		System.out.println("Enter Phone Number");
		String phoneNo = obj.next();
		System.out.println("Enter Email");
		String email = obj.next();
		PersonInfo p = new PersonInfo(fname, lname, address, city, state, zipCode, phoneNo, email);
		person.add(p);
	}

	// Method to check if list is empty
	public boolean isEmpty() {
		return person.isEmpty();
	}

	// Method to check all contacts available
	public ArrayList<PersonInfo> viewAllContacts() {
		if (person.isEmpty()) {
			System.out.println("List is empty");
		}
		Iterator<PersonInfo> iter = person.iterator();
		while (iter.hasNext()) {
			PersonInfo p1 = (PersonInfo) iter.next();
			// System.out.println("Address Book Name"+add_book_name);
			System.out.println("First Name-" + p1.getFirst_name());
			System.out.println("Last Name-" + p1.getLast_name());
			System.out.println("Address-" + p1.getAddress());
			System.out.println("City-" + p1.getCity());
			System.out.println("State-" + p1.getState());
			System.out.println("ZIP-" + p1.getZip());
			System.out.println("Phone Number-" + p1.getPhno());
			System.out.println("Email-" + p1.getEmail());
		}
		return person;
	}

	// Method to modify details
	public void Modify(String name) {
		for (int i = 0; i < person.size(); i++) {
			PersonInfo p = person.get(i);
			if (name.equals(p.getFirst_name())) {
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
			if (name.equals(p.getFirst_name()) == false) {
				System.out.println("No such name");
			}
		}
	}

	// Method to remove contact details
	public void remove(String name) {
		for (int i = 0; i < person.size(); i++) {
			PersonInfo p = (PersonInfo) person.get(i);
			if (name.equals(p.getFirst_name())) {
				person.remove(i);
				System.out.println("Details of " + name + " removed");
			}
		}
	}
}
