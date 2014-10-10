// this class inherits from Person but is the parent class of full & part time students
// this class is an abstract class and so the children of it will inherit it's methods

package compSoc;

public abstract class Student extends Person {
	// member variables
	String studentID;
	String course;

	// Enhancements:
	//String department;
	//int hours;
	//int moduleNum;
	
	// member methods
		// constructors
	public Student()
	{
		super();
		setStudent();
	}
	
		// sets (the sets are a safety net, you don't want other classes directly handling the variables
	public void setStudent()
	{
		setStudentID();
		setCourse();
	}
	
	public void setStudentID()
	{
		System.out.print("Enter ID: ");
		this.studentID = console.nextLine();
	}
	
	public void setCourse()
	{
		System.out.print("Enter Course: ");
		this.course = console.nextLine();
	}
	
		// gets
	public String getStudentID()
	{
		return studentID;
	}
	
	public String getCourse()
	{
		return course;
	}
	
		// toString
	public String toString ()
	{
		return String.format("%s%nCourse: %s%nStudent Number: %s", super.toString(), getCourse(), getStudentID());
	}
	
		// abstract methods
	public abstract boolean studentHasPaid();
	public abstract String calcGPA(double [] modules);
	public abstract String feeInfo();
	public abstract String payFee() throws FeeException;
}
