// full-time students have 6 modules

package compSoc;

public final class FullTimeStudent extends Student //implements Questionnaire 
{
	// member variables
	final int fullTimeFee = 10;	// society fee for the year
	int feeAmountPaid;	// this needs to be 10 to have been paid
	
	// member methods
		// constructors
	public FullTimeStudent()
	{
		super();
		setFullTimeStudent();
		memberCount++;
	}
	
		// sets
	
	public void setFullTimeStudent()
	{
		setFeeAmountPaid();		
	}
	
	public void setFeeAmountPaid()
	{
		System.out.print("Enter Fee Amount Paid: ");
		
		try
		{
			feeAmountPaid = console.nextInt();
		}
		catch(Exception e)
		{
			System.out.println("**Error, Invalid entry\nfee amount set to 0\n");
		}
	}
	
		// gets
	public int getStudentFeePaid()
	{
		return feeAmountPaid;
	}
	
	public int getFullTimeFee()
	{
		return fullTimeFee;
	}
	
		// toString
	public String toString()
	{
		return String.format("Student Type: Full-Time%n%s%nStudentFeePaid: %b%n", super.toString(), studentHasPaid());
	}
	
		// abstract
	public boolean studentHasPaid()
	{
		if(feeAmountPaid >= fullTimeFee)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public String calcGPA(double [] modules)
	{
		double gpa = 0;
		
		for(int i = 0; i < modules.length; i++)
		{
			gpa += modules[i];
		}
		
		gpa /= modules.length;
		
		return String.format("%.2f", gpa);
	}
	
	public String feeInfo()
	{
		return String.format("\nFull-Time Fee: %d\nPaid: %d\nUnpaid: %d\n", getFullTimeFee(), getStudentFeePaid(), (getFullTimeFee() - getStudentFeePaid()));
	}
	
	public String payFee() throws FeeException
	{
		int newAmount, pay=50;
		String temp;
		
		console.nextLine();
		System.out.print("How much would you like to pay: ");
		temp = console.nextLine();
		if(Character.isDigit(temp.charAt(0)))
		{
			pay = Integer.parseInt(temp);
		}
		else
		{
			System.out.println("Invalid entry, must be digits.");
			pay = 0;
		}
		
		if(pay > 40)
		{
			throw new FeeException("Cannot pay " + pay + ", as this exceeds amount allowed to pay\n(Pay allowed is between 1 & 40)");
		}
		
		
		newAmount = getStudentFeePaid() + pay;
		
		//setFeeAmountPaid(newAmount);
		feeAmountPaid = newAmount;
		
		return String.format("Updated Successfully\n%s\n", feeInfo());
	}
}
