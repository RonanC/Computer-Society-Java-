package compSoc;

import javax.swing.*;

public final class Speaker extends Guest implements Questionnaire {
	// variables
	String work;
	
	// questionnaire variables
	String why;
	String what;
	String who;
	String favourites;
	String skills;
	String learn;
	
	// constructor
	public Speaker() {
		super();
		setSpeaker();
		memberCount++;
	}
	
	// sets
	public void setSpeaker()
	{
		setWork();
	}
	
	public void setWork()
	{
		System.out.print("Where do you work/study? ");
		work = console.nextLine();
	}
	
	// gets
	public String getWork()
	{
		return work;
	}	
	
	// toString
	public String toString ()
	{
		return String.format("%s%nWork: %s", super.toString(), getWork());
	}
	
	// overrides
	@Override
	public void doQuestionnaire()
	{
		//System.out.println("\n\tQuestionairre\t\t\n(seperate answers by comma's, hit enter to finish answer)");
		//System.out.println("=============================================");
		
		whyWhatWho();
		favourites();
		skills();
		learn();
		
		JOptionPane.showMessageDialog(null, "Thanks for filling out our Questionnaire :)");
		
		//System.out.println("\n\tThanks for filling out our Questionnaire :)\n");
	}
	
	@Override
	public void whyWhatWho() {
		//System.out.println("\nWhy did you join/come to the CS? ");
		//why = console.nextLine();
		why = JOptionPane.showInputDialog("Why did you join/come to the CS?");
	}

	@Override
	public void favourites() {
		//System.out.println("\nWhat are some of your favourite computer related things? ");
		//what = console.nextLine();
		what = JOptionPane.showInputDialog("What are some of your favourite computer related things?");
	}

	@Override
	public void skills() {
		//System.out.println("\nWhat skills would you be able to share? ");
		//skills = console.nextLine();
		skills = JOptionPane.showInputDialog("What skills would you be able to share?");
	}

	@Override
	public void learn() {
		//System.out.println("\nWhat would you like to learn/do with the CS? ");
		//learn = console.nextLine();
		learn = JOptionPane.showInputDialog("What would you like to learn/do with the CS?");
	}
	
	// getQuestionnaire
	public String getWhyWhatWho() {
		return String.format("%nWhy did you join/come to the CS?%n%s%n", why);
	}

	public String getFavourites() {
		return String.format("%nWhat are some of your favourite computer related things?%n%s%n", what);
	}

	public String getSkills() {
		return String.format("%nWhat skills would you be able to share?%n%s%n", skills);
	}

	public String getLearn() {
		return String.format("%nWhat would you like to learn/do with the CS?%n%s%n", learn);
	}
	
	public String getQuestionnaire()
	{
		return String.format("%nName: %s%n%s%s%s%s", super.getName(), getWhyWhatWho(), getFavourites(), getSkills(), getLearn());
	}
}
