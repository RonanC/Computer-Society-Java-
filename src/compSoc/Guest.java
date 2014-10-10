package compSoc;

public abstract class Guest extends Person {
	// member variables
	String guestID;
	
	// member methods
		// constructors
	public Guest()
	{
		super();
		setGuest();
	}
	
		// sets (the sets are a safety net, you don't want other classes directly handling the variables
	public void setGuest()
	{
		setGuestID();
	}
	
	public void setGuestID()
	{
		System.out.print("Enter ID: ");
		guestID = console.nextLine();
	}
	
		// gets
	public String getGuestID()
	{
		return guestID;
	}
	
		// toString
	public String toString ()
	{
		return String.format("%s%nGuest Number: %s", super.toString(), getGuestID());
	}
}
