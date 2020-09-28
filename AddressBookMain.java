package com.addressbook;
import java.util.*;


public class AddressBookMain{
	
	public static void main(String[] args) {
		
			//Printing welcome message
			System.out.println("Welcome To Address Book Program");
			
			ContactPerson add = new ContactPerson();
			// while loop to take inputs from person
			Scanner obj = new Scanner(System.in);
			AddressBookDict address=new AddressBookDict();
			while(true) {
				System.out.println("Enter 1 to add addressbook");
				System.out.println("Enter 0 to exit");
				int ch1=obj.nextInt();
				if(ch1==1) {
					System.out.println("Enter the Address Book Name");
					String add_book_name=obj.next();
					PersonInfo p=new PersonInfo();
					address.addAddressBook(add_book_name,p);
					while(true) {
						System.out.println("Enter 1 to add details");
						System.out.println("Enter 2 for viewing all contact details");
						System.out.println("Enter 3 to modify details");
						System.out.println("Enter 4 to delete details of a person");
						System.out.println("Enter 0 to exit");
						System.out.println("Enter the action to perform");
						int ch=obj.nextInt();
						if(ch==1) {
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
								PersonInfo p1=(PersonInfo)iter.next();
								System.out.println("Address Book Name"+add_book_name);
								System.out.println("First Name-"+p1.getFirst_name());
								System.out.println("Last Name-"+p1.getLast_name());
								System.out.println("Address-"+p1.getAddress());
								System.out.println("City-"+p1.getCity());
								System.out.println("State-"+p1.getState());
								System.out.println("ZIP-"+p1.getZip());
								System.out.println("Phone Number-"+p1.getPhno());
								System.out.println("Email-"+p1.getEmail());
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
				else {
					break;
				}
			}
		}
	}


