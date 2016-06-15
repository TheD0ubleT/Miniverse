package run.MiniverseComponentTest;

import sim.Organism.Person.*;

public class HumanTest
{
	
	public static String[] HumanFirstNames = {"Kenny", "Andrew", "Mary"};
	public static String[] HumanLastNames = {"Smith", "Tibboles", "Miller"};
	public static String[] HumanGenders = {"Male", "Female", "Intersex"};
	public static int[] HumanAges = {60, 20, 10};
	public static String[] HumanBirthdays = {"September", "July", "January"};
	
	public static Human[] people = new Human[HumanFirstNames.length];

	public static void main(String[] args)
	{
		for(int i=0; i<HumanFirstNames.length; i++) 
		{
			people[i] = new Human(HumanFirstNames[i], HumanLastNames[i], HumanGenders[i], HumanAges[i], HumanBirthdays[i]);
			System.out.println(people[i].toString());
		}
		System.out.println("Finished");
	}
}