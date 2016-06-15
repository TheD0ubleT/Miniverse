package run.MiniverseComponentTest;

import sim.Organism.Person.*;

public class AdvancedHumanTest
{
	public static void main(String[] args)
	{
		Human people = new Human();
		System.out.println("/-=-=-=NEW HUMAN=-=-=-+"); //23
		System.out.printf("%2s %s", "",people.getFirstName() + " " + people.getLastName() + "\n");
		System.out.printf("%2s %s", "",people.getHumanHash() + "\n");
		System.out.printf("%2s %s", "",people.getAge() + "\n");
		System.out.printf("%2s %s", "",people.getGender() + "\n");
		System.out.println("+-=-=-=-=-=-=-=-=-=-=-/");
		System.out.println(people.getHumanNamesIntersexLength());
	}
}