package sim.Organism.Person;

import java.util.ArrayList;

import sim.Constants;

public class Human
{
	private static ArrayList<Long> allHashes;
	private long humanHash;
	public int gender;
	public int age;
	public String birthday;
	public String name;
	
	////Constructor////
	public Human()
	{
		allHashes = new ArrayList<Long>();
		long temp = 0;
		do
		{
			temp = Constants.RAND.nextLong();
		}
		while (allHashes.contains(temp));
		
		this.humanHash = temp;
	}
	
	public Human(String name, int gender, int age, String birthday)
	{
		allHashes = new ArrayList<Long>();
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
	
	public int getGender()
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
	public void setGender(int gender)
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
