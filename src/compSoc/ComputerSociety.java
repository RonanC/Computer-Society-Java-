/*
	This project implements the following concepts (among others):
	Polymorphism
	Inheritance
	Interfaces
	Abstract Classes
	Final Classes
	Static Variables
	Exception Throw
	Use of super keyword
	Printing to files
	Message Boxes
	
	Composition:
	Speaker is a Person
	Person has a Speaker
 */

package compSoc;

import java.util.*;
import java.io.*;
import javax.swing.*;

public class ComputerSociety {
	
	public static Scanner console = new Scanner(System.in);
	
	// mixture of part time & full time
	public static List<Person> personList = new ArrayList<Person>();
	public static List<FullTimeStudent> fullTimeList = new ArrayList<FullTimeStudent>();
	public static List<PartTimeStudent> partTimeList = new ArrayList<PartTimeStudent>();
	
	// both guests
	public static List<Lecturer> lecturerList = new ArrayList<Lecturer>();
	public static List<Speaker> speakerList = new ArrayList<Speaker>();
	
	public static void main(String[] args) throws FileNotFoundException{
		// variables
		int choice = 2013;
		
		// header
		System.out.println("\n===================================================================");
		System.out.println("\tWelcome to the Computer Society Database");
		System.out.println("===================================================================");
		
		while(choice != 0)
		{
			System.out.println("\n\tChoose Option - 0/Quit?");
			System.out.println("===================================================================");
	        System.out.println("1: Member Options\t\t2: Computer Society Info");
	        System.out.println("3: Coder Info\n");
	        
	        do
	        {
	        	choice = enterChoice();
		        
		        if(choice >= 0 && choice <= 3)
		        {
			        switch(choice)	// add this to the 
			        {
			        	case 0:
			        		break;
			        		
			        	case 1:
			        		personType();
			        		break;
			        		
			        	case 2:
			        		compSocInfo();
			        		break;
			        	case 3:
			        		coderInfo();
			        		break;
			        } // end switch
		        } // end if
		       
		        if(choice < 0 || choice > 3)
		        {
		        	errorSelect();
		        }
		       
	        }while(choice < 0 || choice > 3);
		}
		
		// footer
		System.out.println("===================================================================");
		/*System.out.println("Thanks for using the Computer Society Database");
		System.out.println("Goodbye");
		System.out.println("==============================================\n\n");*/
		
		JOptionPane.showMessageDialog(null, "Thanks for using the Computer Society Database\n\n\t\tGoodbye");
	}
	
	public static void personType() throws FileNotFoundException
	{
		int choice;
		int guiChoice;
		
		System.out.println("\n\tChoose Person Type - 0/Quit");
		System.out.println("=====================================");
        System.out.println("1: Student\t\t2: Guest");
        System.out.println("3: Member Count\t\t4: Print Members to File\n");
        System.out.println("5: View All Members\n");
        
        do
        {
        	choice = enterChoice();
	        
	        if(choice >= 0 && choice <= 5)
	        {
		        switch(choice)	// add this to the 
		        {
		        	case 0:
		        		break;
		        		
		        	case 1:
		        		studentType();
		        		break;
		        		
		        	case 2:
		        		guestType();
		        		break;
		        		
		        	case 3:
		        		System.out.println("\nMember Count: " + Person.memberCount);
		        		break;
		        		
		        	case 4:
		        		guiChoice = JOptionPane.showConfirmDialog(null, "Are you sure?\nDoing this will overwrite any previously saved file");
		        		
		        		if(guiChoice == 0)
		        		{
		        			membersToFile();
		        		}
		        		break;
		        	
		        	case 5:
		        		for(int i = 0; i < personList.size(); i++)
		        		{
		        			System.out.printf("%d)\n%s\n",(i+1), fullTimeList.get(i).getName());
		        		}
		        		break;
		        		
		        } // end switch
	        } // end if
	       
	        if(choice < 0 || choice > 5)
	        {
	        	errorSelect();
	        }
	       
        }while(choice < 0 || choice > 5);
	}
	
	public static void studentType()
	{
		int choice;
		
		System.out.println("\n\tChoose Student Type - 0/Quit");
		System.out.println("===================================================================");
        System.out.println("1: Full-Time\t\t2: Part-Time\n");
        
        do
        {
        	choice = enterChoice();
	        
	        if(choice >= 0 && choice <= 2)
	        {
		        switch(choice)	// add this to the 
		        {
		        	case 0:
		        		break;
		        		
		        	case 1:
		        		fullTimeMenu();
		        		break;
		        		
		        	case 2:
		        		partTimeMenu();
		        		break;
		        } // end switch
	        } // end if
	       
	        if(choice < 0 || choice > 2)
	        {
	        	errorSelect();
	        }
	       
        }while(choice < 0 || choice > 2);
	}
	
	public static void guestType() throws FileNotFoundException
	{
		int choice;
		
		System.out.println("\n\tChoose Guest Type - 0/Quit");
		System.out.println("===================================================================");
        System.out.println("1: Lecturer\t\t2: Speaker\n");
        
        do
        {
        	choice = enterChoice();
	        
	        if(choice >= 0 && choice <= 2)
	        {
		        switch(choice)	// add this to the 
		        {
		        	case 0:
		        		break;
		        		
		        	case 1:
		        		lecturerMenu();
		        		break;
		        		
		        	case 2:
		        		speakerMenu();
		        		break;
		        } // end switch
	        } // end if
	        
	        if(choice < 0 || choice > 2)
	        {
	        	errorSelect();
	        }
        }while(choice < 0 || choice > 2);
	}
	
	public static void fullTimeMenu(){
		int choice, nameIndex;
		
        do
        {
    		System.out.println("\n\tChoose Full-Time Student Option - 0/Quit");
    		System.out.println("===================================================================");
            System.out.println("1: Create\t\t2: Select Student");
            System.out.println("3: Student List\n");
            //System.out.println("3: Pay Member Fee	4: View Paid Amount\n");
            //System.out.println("3: Pay Fee				4: Calculate GPA\n");
            //System.out.println("5: Check Hours			6: getModules\n");	// add methods to add/subtract hours and modules (maybe have a module array that lists modules)
            
            choice = enterChoice();
	        
	        if(choice >= 0 && choice <= 3)
	        {
		        switch(choice)	// add this to the 
		        {
		        case 0:
		        	break;
		        
	        	case 1:	// add new student
	        		fullTimeList.add(new FullTimeStudent());
	        		int tempIndex = (fullTimeList.size() - 1);
	        		personList.add(fullTimeList.get(tempIndex));
        			break;
	        	
	        	case 2: // select specific student
	        		do
	        		{
		        		System.out.println("Enter Student Number (from Student List) [0 to Cancel]");
		        		nameIndex = enterChoice();
		        		
		        		if(nameIndex < 0 || nameIndex > fullTimeList.size())
		        		{
		        			errorSelect();
		        		}
	        		}while((nameIndex < 0 || nameIndex > (fullTimeList.size())) && nameIndex != 0);
	        		
	        		if(nameIndex != 0)
	        		{
	        			fullTimeStudentSelect((nameIndex - 1));
	        		}
	        		break;
	        		
	        	case 3: // view list of students
	        		for(int i = 0; i < fullTimeList.size(); i++)
	        		{
	        			System.out.printf("%d)\n%s\n",(i+1), fullTimeList.get(i).getName());
	        		}
        			break;
		        } // end switch
	        } // end if
	        
	        if(choice < 0 || choice > 3)
	        {
	        	errorSelect();
	        }
        }while(choice != 0);
	}
	
	public static void fullTimeStudentSelect(int nameIndex)
	{
		int choice;
		
        do
        {
    		System.out.println("\n\t" + fullTimeList.get(nameIndex).getName() +" - 0/Quit");
    		System.out.println("===================================================================");
            System.out.println("1: Pay Fee\t\t2: View Paid Amount");
            System.out.println("3: View Personal Info");
            //System.out.println("3: Pay Member Fee	4: View Paid Amount\n");
            //System.out.println("3: Pay Fee				4: Calculate GPA\n");
            //System.out.println("5: Check Hours			6: getModules\n");	// add methods to add/subtract hours and modules (maybe have a module array that lists modules)
            
            choice = enterChoice();
	        
	        if(choice >= 0 && choice <= 3)
	        {
		        switch(choice)	// add this to the 
		        {
		        case 0:	// quit
		        	break;
		        
	        	case 1:	// pay fee
	        		try 
	        		{
						System.out.println(fullTimeList.get(nameIndex).payFee());
					} catch (FeeException e)
					{
						System.out.println(e.getMessage());
					}
        			break;
	        	
	        	case 2: // check fee amount paid
	        		System.out.println(fullTimeList.get(nameIndex).feeInfo());
	        		break;
	        		
	        	case 3: // view personal info
	        		System.out.println(fullTimeList.get(nameIndex).toString());
	        		break;
		        } // end switch
	        } // end if
	        
	        if(choice < 0 || choice > 3)
	        {
	        	errorSelect();
	        }
        }while(choice != 0);
	}

	public static void partTimeMenu(){
		int choice, nameIndex;
		
        do
        {
    		System.out.println("\n\tChoose Part-Time Student Option - 0/Quit");
    		System.out.println("===================================================================");
            System.out.println("1: Create\t\t2: Select Student");
            System.out.println("3: Part-Time Student List			\n");
   
            choice = enterChoice();
	        
	        if(choice >= 0 && choice <= 3)
	        {
		        switch(choice)	// add this to the 
		        {
		        case 0:
		        	break;
		        
	        	case 1:	// add new student
	        		partTimeList.add(new PartTimeStudent());
        			break;
	        	
	        	case 2: // select specific student
	        		do
	        		{
		        		System.out.println("Enter Student Number (from Student List) [0 to Cancel]");
		        		nameIndex = enterChoice();
		        		
		        		if(nameIndex < 0 || nameIndex > partTimeList.size())
		        		{
		        			errorSelect();
		        		}
	        		}while((nameIndex < 0 || nameIndex > (partTimeList.size())) && nameIndex != 0);
	        		
	        		if(nameIndex != 0)
	        		{
	        			partTimeStudentSelect((nameIndex - 1));
	        		}
	        		break;
	        		
	        	case 3: // view list of students
	        		for(int i = 0; i < partTimeList.size(); i++)
	        		{
	        			// used for checking if part time student is apart of the student class
	        			//if(studentList.getClass() == PartTimeStudent.class)
	        			//{
	        				System.out.printf("\n%d)\n%s\n",(i+1), partTimeList.get(i).getName());
	        			//}
	        		}
        			break;
		        } // end switch
	        } // end if
	        
	        if(choice < 0 || choice > 3)
	        {
	        	errorSelect();
	        }
        }while(choice != 0);
	}
	
	public static void partTimeStudentSelect(int nameIndex)
	{
		int choice;
		
        do
        {
    		System.out.println("\n\t" + partTimeList.get(nameIndex).getName() +" - 0/Quit");
    		System.out.println("===================================================================");
            System.out.println("1: Pay Fee\t\t2: View Paid Amount");
            System.out.println("3: View Personal Info");
       
            choice = enterChoice();
	        
	        if(choice >= 0 && choice <= 3)
	        {
		        switch(choice)	// add this to the 
		        {
		        case 0:	// quit
		        	break;
		        
	        	case 1:	// pay fee
	        		try 
	        		{
						System.out.println(partTimeList.get(nameIndex).payFee());
					} catch (FeeException e)
					{
						System.out.println(e.getMessage());
					}
        			break;
	        	
	        	case 2: // check fee amount paid
	        		System.out.println(partTimeList.get(nameIndex).feeInfo());
	        		break;
	        		
	        	case 3: // view personal info
	        		System.out.println(partTimeList.get(nameIndex).toString());
	        		break;
		        } // end switch
	        } // end if
	        
	        if(choice < 0 || choice > 3)
	        {
	        	errorSelect();
	        }
        }while(choice != 0);
	}
	
	public static void lecturerMenu(){
		int choice, nameIndex;
		
        do
        {
    		System.out.println("\n\tChoose Lecturer Option - 0/Quit");
    		System.out.println("===================================================================");
            System.out.println("1: Create\t\t2: Select Lecturer");
            System.out.println("3: Lecturer List			\n");

	        System.out.print("Enter option: ");
	        choice = enterChoice();
	        
	        if(choice >= 0 && choice <= 3)
	        {
		        switch(choice)	// add this to the 
		        {
		        case 0:
		        	break;
		        
	        	case 1:	// add new student
	        		lecturerList.add(new Lecturer());
        			break;
	        	
	        	case 2: // select specific lecturer
	        		do
	        		{
		        		System.out.println("Enter Lecturer Number (from Lecturer List) [0 to Cancel]");
		        		nameIndex = enterChoice();
		        		
		        		if(nameIndex < 0 || nameIndex > lecturerList.size())
		        		{
		        			errorSelect();
		        		}
	        		}while((nameIndex < 0 || nameIndex > (lecturerList.size())) && nameIndex != 0);
	        		
	        		if(nameIndex != 0)
	        		{
	        			lecturerSelect((nameIndex - 1));
	        		}
	        		break;
	        		
	        		
	        	case 3: // view list of students
	        		for(int i = 0; i < lecturerList.size(); i++)
	        		{
	        			System.out.printf("%d)\n%s\n",(i+1), lecturerList.get(i).getName());
	        		}
        			break;
		        } // end switch
	        } // end if
	        
	        if(choice < 0 || choice > 3)
	        {
	        	errorSelect();
	        }
        }while(choice != 0);
	}
	
	public static void lecturerSelect(int nameIndex){
		int choice;
		
        do
        {
    		System.out.println("\n\t" + lecturerList.get(nameIndex).getName() +" - 0/Quit");
    		System.out.println("===================================================================");
            System.out.println("1: Change course\t\t2: View Personal Info			\n");
            
            choice = enterChoice();
	        
	        if(choice >= 0 && choice <= 2)
	        {
		        switch(choice)
		        {
		        case 0:	// quit
		        	break;
		        
	        	case 1:	// pay fee
	        		lecturerList.get(nameIndex).setWork();
        			break;
        			
	        	case 2: // view personal info
	        		System.out.println(lecturerList.get(nameIndex).toString());
	        		break;
		        } // end switch
	        } // end if
	        
	        if(choice < 0 || choice > 2)
	        {
	        	errorSelect();
	        }
        }while(choice != 0);		
	}

	public static void speakerMenu() throws FileNotFoundException{
		int choice, nameIndex, guiChoice;
		
        do
        {
    		System.out.println("\n\tChoose Speaker Option - 0/Quit");
    		System.out.println("===================================================================");
            System.out.println("1: Create\t\t2: Select Speaker");
            System.out.println("3: Speaker List\t\t4: Save Questionnaire's to file\n");

	        System.out.print("Enter option: ");
	        choice = enterChoice();
	        
	        if(choice >= 0 && choice <= 4)
	        {
		        switch(choice)	// add this to the 
		        {
		        case 0:
		        	break;
		        
	        	case 1:	// add new student
        			speakerList.add(new Speaker());
        			break;
	        	
	        	case 2: // select specific speaker
	        		do
	        		{
		        		System.out.println("Enter Speaker Number (from Speaker List) [0 to Cancel]");
		        		nameIndex = enterChoice();
		        		
		        		if(nameIndex < 0 || nameIndex > speakerList.size())
		        		{
		        			errorSelect();
		        		}
	        		}while((nameIndex < 0 || nameIndex > (speakerList.size())) && nameIndex != 0);
	        		
	        		if(nameIndex != 0)
	        		{
	        			speakerSelect((nameIndex - 1));
	        		}
	        		break;
	        		
	        		
	        	case 3: // view list of students
	        		for(int i = 0; i < speakerList.size(); i++)
	        		{
	        			System.out.printf("%d)\n%s\n",(i+1), speakerList.get(i).getName());
	        		}
        			break;
        			
	        	case 4:
	        		guiChoice = JOptionPane.showConfirmDialog(null, "Are you sure?\nDoing this will overwrite any previously saved file");
	        		
	        		if(guiChoice == 0)
	        		{
	        			questionnairesToFile();
	        		}
	        		
	        		break;
	        		
		        } // end switch
	        } // end if
	        
	        if(choice < 0 || choice > 4)
	        {
	        	errorSelect();
	        }
        }while(choice != 0);
	}
	
	public static void speakerSelect(int nameIndex){
		int choice;
		
        do
        {
    		System.out.println("\n\t" + speakerList.get(nameIndex).getName() +" - 0/Quit");
    		System.out.println("===================================================================");
            System.out.println("1: Complete Questionnaire\t\t2: View Personal Info");
            System.out.println("3: View Questionnaire Info\n");
            
            choice = enterChoice();
	        
	        if(choice >= 0 && choice <= 3)
	        {
		        switch(choice)
		        {
		        case 0:	// quit
		        	break;
		        
	        	case 1:	// pay fee
	        		speakerList.get(nameIndex).doQuestionnaire();
        			break;
        			
	        	case 2: // view personal info
	        		System.out.println(speakerList.get(nameIndex).toString());
	        		break;	
	        		
	        	case 3: // view questionnaire info
	        		System.out.println(speakerList.get(nameIndex).getQuestionnaire());
	        		break;
		        } // end switch
	        } // end if
	        
	        if(choice < 0 || choice > 3)
	        {
	        	errorSelect();
	        }
        }while(choice != 0);		
	}
	
	public static int enterChoice()
	{
		int choice;
		char temp;
		
		do
		{
			System.out.print("Enter option: ");
			
	        temp = console.next().charAt(0);
	        //choice = Integer.parseInt(temp);
	        
			choice = Character.getNumericValue(temp);
		}while(choice < 0 || choice >= 10);
		
		return choice;
	}
	
	public static void errorSelect(){
		System.out.println("\nInvalid choice, enter again (0 to Quit)\n");	
	}

	public static void membersToFile() throws FileNotFoundException
	{
		PrintWriter outMemberData = new PrintWriter("membersData.dat");
		
		outMemberData.println("Computer Society Member Data");
		outMemberData.println("============================");
		
		if(fullTimeList.size() > 0)
		{
			outMemberData.printf("%nFull-Time Students:%n");
			for(int i = 0; i < fullTimeList.size(); i++)
			{
				outMemberData.printf("%d)%n%s%n%n",(i+1), fullTimeList.get(i).toString());
			}
		}
		
		if(partTimeList.size() > 0)
		{
			outMemberData.printf("%nPart-Time Students:%n");
			for(int i = 0; i < partTimeList.size(); i++)
			{
				outMemberData.printf("%d)%n%s%n%n",(i+1), partTimeList.get(i).toString());
			}
		}
		
		if(lecturerList.size() > 0)
		{
			outMemberData.printf("%nLecturers:%n");
			for(int i = 0; i < lecturerList.size(); i++)
			{
				outMemberData.printf("%d)%n%s%n%n",(i+1), lecturerList.get(i).toString());
			}
		}
		
		if(speakerList.size() > 0)
		{
			outMemberData.printf("%nSpeakers:%n");
			for(int i = 0; i < speakerList.size(); i++)
			{
				outMemberData.printf("%d)%n%s%n%n",(i+1), speakerList.get(i).toString());
			}
		}
		
		outMemberData.close();
		
		System.out.println("\nFile Created Successfully => \"membersData.dat\"");
	}
	
	public static void questionnairesToFile() throws FileNotFoundException
	{
		PrintWriter outQuestionnaireData = new PrintWriter("questionnaireData.dat");
		
		outQuestionnaireData.println("Computer Society Questionnaire Data");
		outQuestionnaireData.println("===================================");
		
		if(speakerList.size() > 0)
		{
			outQuestionnaireData.printf("%nSpeakers:");
			for(int i = 0; i < speakerList.size(); i++)
			{
				outQuestionnaireData.printf("%n%d)%s%n",(i+1), speakerList.get(i).getQuestionnaire());
			}
		}
		
		outQuestionnaireData.close();
		
		System.out.println("\nFile Created Successfully => \"questionnaireData.dat\"");
	}
	
	public static void compSocInfo()
	{
		System.out.println("===================================");
		System.out.println("Computer Society Information");
		System.out.println("===================================");
		
		System.out.println("\nAbout:\nGMIT Computer Society - bringing people together who have \na shared interest in computing & would like to explore new areas/aspects.");
		System.out.println("\nDescription:\nStudying Software or Digital Media?\nWant to make Mobile, Tablet & Desktop Apps?\nInterested in making Games?\nCan you count in binary?\nInto sci-fi movies/tv?\nLike playing video-games?\nInterested in programming/electronics?\nWant to meet like-minded people?\nDon't be shy, come along!");
		System.out.println("\nCommittee Members:\nAuditor: Ronan Connolly\nVice Auditor: Andrew Sweeney\nSecretary: Sarabjeet Kumar\nTreasurer: Arjun Kharel\nPRO: James Ngondo\nPRO: John Walsh\nOCM: PJ Kenny\n");
	}
	
	public static void coderInfo()
	{
		System.out.println("\n\n===================================");
		System.out.println("\tCoder Information");
		System.out.println("===================================");
		
		System.out.println("This program was developed by myself, Ronan Connolly \nIt was created for a Java module for GMIT Software Development\n");
		
		System.out.println("Published by Roncon Apps\nCopyright © 2013 Roncon Apps\n");
	}
}

