package compSoc;

public final class Lecturer extends Guest {

	// variables
	String course;
	
	// constructor
	public Lecturer() {
		super();
		setLecturer();
		memberCount++;
	}

	// sets
	public void setLecturer()
	{
		setWork();
	}
	
	public void setWork()
	{
		System.out.print("What course do you teach? ");
		course = console.nextLine();
	}
	
	// gets
	public String getCourse()
	{
		return course;
	}
	
	// toString
	public String toString ()
	{
		return String.format("%s%nWork: %s", super.toString(), getCourse());
	}
}
