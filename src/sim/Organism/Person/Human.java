package sim.Organism.Person;

import java.util.ArrayList;

import sim.Constants;

public class Human
{
	private static ArrayList<Long> allHashes;
	private long humanHash;
	public boolean gender;  // True => Male  False => female
	public int age;
	public String birthday;
	public String name;
	
	////Constructor////
	public Human()
	{
		//only create new hash array if none already made, avoids overwriting previous
		allHashes = allHashes == null ? new ArrayList<Long>(): allHashes;
		long temp = 0;
		do
		{
			temp = Constants.RAND.nextLong();
		}
		while (allHashes.contains(temp));
		
		this.humanHash = temp;
		this.gender = false;
		this.age = 0;
		this.name =  "UnNamed";
		this.birthday = "None";
		
		
	}
	
	public Human(String name, boolean gender, int age, String birthday)
	{
		allHashes = allHashes == null ? new ArrayList<Long>(): allHashes;
		long temp = 0;
		do
		{
			temp = Constants.RAND.nextLong();
		}
		while (allHashes.contains(temp));

		this.humanHash = temp;
		
		this.age = age;
		this.gender = gender;
		this.birthday = birthday;
		this.name = name;
	}
	
	public String toString()
	{
		return humanHash + " " + age + " " + gender + " " + name + " " + birthday;
	}
	
	////Getters////
	public long getHumanHash()
	{
		return this.humanHash;
	}
	
	public boolean getGender()
	{
		return this.gender;
	}
	
	public int getAge()
	{
		return this.age;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	////Setters////
	public void setGender(boolean gender)
	{
		this.gender = gender;
	}
	
	public void setAge(int age)
	{
		this.age = age;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setBirthday(String birthday)
	{
		this.birthday = birthday;
	}
}
