package com.addressbook;
import java.util.*;

	public class ContactPerson {
		Scanner obj=new Scanner(System.in);
	// Array list to store contact person details
	private ArrayList<PersonInfo> person=new ArrayList<PersonInfo>();
		
	public void setPerson(ArrayList<PersonInfo> person) {
		this.person=person;
	}
	
	public ArrayList<PersonInfo> getPerson() {
		return person;
	}
	
	//Method to add contact person details
	public void addPerson(PersonInfo pobj ) {
		person.add(pobj);
	}
	
	//Method to check if list is empty
		public boolean isEmpty() {
			return person.isEmpty();
		}
	
	//Method to check all contacts available 
	public ArrayList<PersonInfo> viewAllContacts(){
		return person;
	}	
}
