package run.MiniverseComponentTest;

import sim.Organism.Person.*;

public class HumanTest
{
	
	public static String[] HumanNames = {"Kenny", "Andrew", "Mary"};
	public static int[] HumanGenders = {1, 2, 0};
	public static int[] HumanAges = {60, 20, 10};
	public static String[] HumanBirthdays = {"September", "July", "January"};
	
	public static Human[] people = new Human[HumanNames.length];

	public static void main(String[] args)
	{
		for(int i=0; i<HumanNames.length; i++) 
		{
			people[i] = new Human(HumanNames[i], HumanGenders[i], HumanAges[i], HumanBirthdays[i]);
			System.out.println(people[i].toString());
		}
		
		System.out.println("Finished");
	}

}
