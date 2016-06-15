package sim.Organism.Person;

import java.util.ArrayList;

import sim.Constants;


public class Human
{
	private static ArrayList<Long> allHashes;
	private long humanHash;
	private String gender;
	private int age;
	private String birthday;
	private String firstName;
	private String lastName;
	//private public
	public static String[] HumanGenders = {"Male", "Female", "Intersex"};
	public static String[] HumanFirstNamesMale = {"Kenny", "Andrew", "Michael", "Quade"};//TODO: make a text file of thousands of names and instead make in reference text file
	public static String[] HumanFirstNamesFemale = {"Mary", "Jordyn", "Amanda", "Sydney"};
	public static String[] HumanFirstNamesIntersex = new String[HumanFirstNamesMale.length + HumanFirstNamesFemale.length];
	public static String[] HumanLastNames = {"Smith", "Miller", "Tibboles", "Craun", };
	public static int[] HumanAges = new int[122];
	
	////Constructor////
	public Human()
	{
		allHashes = new ArrayList<Long>();
		//only create new hash array if none already made, avoids overwriting previous
		allHashes = allHashes == null ? new ArrayList<Long>(): allHashes;
		long temp = 0;
		do
		{
			temp = Constants.RAND.nextLong();
		}
		while (allHashes.contains(temp));
		
		for (int i = 0; i < HumanAges.length; i++) {
			HumanAges[i] = i + 1;
		}
		
		this.humanHash = temp;
		this.age = 0;
		this.gender = "Male";
		this.birthday = "January";
		this.firstName = "Firstname";
		this.lastName = "Lastname";
		
	}
	
	public Human(String firstName, String lastName, String gender, int age, String birthday)
	{
		allHashes = new ArrayList<Long>();
		//only create new hash array if none already made, avoids overwriting previous
		allHashes = allHashes == null ? new ArrayList<Long>(): allHashes;
		long temp = 0;
		do
		{
			temp = Constants.RAND.nextLong();
		}
		while (allHashes.contains(temp));

		this.humanHash = temp;
	
		for (int i = 0; i < HumanAges.length; i++) {
			HumanAges[i] = i + 1;
		}
		
		this.age = age;
		this.gender = gender;
		this.birthday = birthday;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	////RANDOM HUMAN////
	public void HumanRandom()
	{
		this.gender = HumanGenders[Constants.RAND.nextInt(HumanGenders.length)];
		this.age = HumanAges[Constants.RAND.nextInt(HumanAges.length)];
		if(getGender() == "Male")
			this.firstName = HumanFirstNamesMale[Constants.RAND.nextInt(HumanFirstNamesMale.length)];
		else if(getGender() == "Female")
			this.firstName = HumanFirstNamesMale[Constants.RAND.nextInt(HumanFirstNamesFemale.length)];	
		else
		{
			for (int i = 0; i < HumanFirstNamesMale.length; i++) {
				HumanFirstNamesIntersex[i] = HumanFirstNamesMale[i];
			}
			for (int i = HumanFirstNamesMale.length; i < HumanFirstNamesIntersex.length; i++) {
				HumanFirstNamesIntersex[i] = HumanFirstNamesFemale[i - HumanFirstNamesMale.length];
			}
			this.firstName = HumanFirstNamesIntersex[Constants.RAND.nextInt(HumanFirstNamesIntersex.length - 1)];
		}
		this.lastName = HumanLastNames[Constants.RAND.nextInt(HumanLastNames.length)];
	}
	////TO STRING!////
	public String toString()
	{
		return humanHash + " " + age + " " + gender + " " + firstName + " " + lastName + " " + birthday;
	}
	
	////Getters////
	public long getHumanHash()
	{
		return this.humanHash;
	}
	
	public String getGender()
	{
		return this.gender;
	}
	
	public int getAge()
	{
		return this.age;
	}
	
	public String getFirstName()
	{
		return this.firstName;
	}
	
	public String getLastName()
	{
		return this.lastName;
	}
	
	public int getHumanFirstNamesIntersexLength()
	{
		return HumanFirstNamesIntersex.length;
	}

	////Setters////
	public void setGender(String gender)
	{
		this.gender = gender;
	}
	
	public void setAge(int age)
	{
		this.age = age;
	}
	
	public void setBirthday(String birthday)
	{
		this.birthday = birthday;
	}
	
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
}
