package com.addressbook;
import java.util.*;


public class AddressBookMain{
	
	public static void main(String[] args) {
		Scanner obj = new Scanner(System.in);
		
		//Creating object of contactperson class
		ContactPerson add = new ContactPerson();
		int ch=0;
		
		//Printing welcome message
		System.out.println("Welcome To Address Book Program");
		// while loop to take inputs from person
		while(true) {
			System.out.println("Enter 1 to add details");
			System.out.println("Enter 2 for viewing all contact details");
			System.out.println("Enter 3 to modify details");
			System.out.println("Enter 4 to delete details of a person");
			System.out.println("Enter 0 to exit");
			System.out.println("Enter the action to perform");
			ch=obj.nextInt();
		if(ch==1) {
			PersonInfo p=new PersonInfo();
			System.out.println("Enter First Name");
			p.setFirst_name(obj.next());
			System.out.println("Enter Last Name");
			p.setLast_name(obj.next());
			System.out.println("Enter Address");
			p.setAddress(obj.next());
			System.out.println("Enter City");
			p.setCity(obj.next());
			System.out.println("Enter State");
			p.setState(obj.next());
			System.out.println("Enter Zip Code");
			p.setZip(obj.next());
			System.out.println("Enter Phone Number");
			p.setPhno(obj.next());
			System.out.println("Enter Email");
			p.setEmail(obj.next());
			add.addPerson(p);
			}
		else if(ch==2) {
			ArrayList<PersonInfo> result = add.viewAllContacts();
			if(result.isEmpty()) {
				System.out.println("List is empty");
				continue;
			}
			Iterator<PersonInfo> iter=result.iterator();
			while(iter.hasNext()) {
				PersonInfo p=(PersonInfo)iter.next();
				System.out.println("First Name-"+p.getFirst_name());
				System.out.println("Last Name-"+p.getLast_name());
				System.out.println("Address-"+p.getAddress());
				System.out.println("City-"+p.getCity());
				System.out.println("State-"+p.getState());
				System.out.println("ZIP-"+p.getZip());
				System.out.println("Phone Number-"+p.getPhno());
				System.out.println("Email-"+p.getEmail());
				}
			}
		else if(ch==3) {
			ArrayList<PersonInfo> result = add.viewAllContacts();
			if(result.isEmpty()) {
				System.out.println("List is empty");
				continue;
			}
			else {
			System.out.println("Enter the name of person whose contact is to be modified");
			String name=obj.next();
			while(true) {
			System.out.println("1. First name\n 2.Last name\n 3.Address\n 4. City\n 5. State\n 6. Zip\n 7. Phone number\n 8.Email\n 0. Exit");
			System.out.println("Enter the info to be modified");
			int info_name=obj.nextInt();
			add.Modify(name,info_name);
			if(info_name==0) {
				break;
			}
		}
		}
		}
		else if(ch==4) {
			System.out.println("Enter the name of person whose contact is to be deleted");
			String name=obj.next();
			add.remove(name);
		}
		else {
				break;
			}
		}
	}
}


