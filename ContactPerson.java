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
	
	//Method to remove contact details
	public void remove(String name){
        for(int i = 0; i < person.size(); i++){
        	PersonInfo p = (PersonInfo)person.get(i); 
        	if(name.equals(p.getFirst_name())){
        		person.remove(i);
        		System.out.println("Details of "+name+" removed");
        	}
           }
		}
	//Method to modify details
     public void Modify(String name,int info_name){
    	 for(int i = 0; i < person.size(); i++){
             PersonInfo p = (PersonInfo)person.get(i); 
             if(name.equals(p.getFirst_name())){
            	 System.out.println("Modify Details");
            	 switch(info_name) {
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
             }
      } 
	
}
}
