// created by Ronan Connolly, GMIT, 17th November 2013 for SdPd2 module for Naomi Hurley
// this program can be used as a college person data system
// this Person class is the base (abstract) class for all other classes

package compSoc;

import java.util.Scanner;

public abstract class Person 
{
	Scanner console = new Scanner(System.in);
	
	// member variables
	private String phoneNumber;
	private String name;
	private String email;
	public static int memberCount;
	
	// member methods
		// constructors (these constructors show the use of calling methods to fill out variable data)
	public Person()
	{
		setPerson();
	}
	
		// sets (these sets show the use of the "this" keyword)
		// they also show the use of calling a method from another method
	public void setPerson()
	{
		setName();
		setPhoneNumber();
		setEmail();
	}
	
	public void setName()
	{
		System.out.print("\nEnter Name: ");
		this.name = console.nextLine();
	}
	
	public void setPhoneNumber()
	{
		System.out.print("Enter Phone Number: ");
		this.phoneNumber = console.nextLine();
	}
	
	public void setEmail()
	{
		System.out.print("Enter Email: ");
		this.email = console.nextLine();
	}
	
	// gets
	public String getName()
	{
		return name;
	}
	
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	
	public String getEmail()
	{
		return email;
	}
	
		// toString
	public String toString()
	{
		return String.format("Name: %s%nPhone: %s%nEmail: %s", getName(), getPhoneNumber(), getEmail());
	}
}
	


