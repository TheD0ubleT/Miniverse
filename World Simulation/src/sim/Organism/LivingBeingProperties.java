package sim.Organism;

public abstract class LivingBeingProperties
{
	//STATIC
	private static long nbrOfBeings;
	
	//Classes
	
	
	//BOOL
	private boolean hasBrain;
	private boolean isAlive;
	
	//INT
	private int age;
	
	///////////Constructors////////
	public LivingBeingProperties()
	{
		nbrOfBeings++;
		
		this.hasBrain = false;
		this.isAlive = true;
		
		this.age = 0;
	}
	
	public LivingBeingProperties(int age)
	{
		nbrOfBeings++;
		
		this.hasBrain = false;
		this.isAlive = true;
		
		this.age = age;
	}
	
	public LivingBeingProperties(boolean hasBrain, boolean isAlive)
	{
		nbrOfBeings++;
		
		this.hasBrain = hasBrain;
		this.isAlive = isAlive;
		
		this.age = 0;
	}
	
	////////////////////////////////
	//////////Interactions//////////
	////////////////////////////////
	
	//////////Inside Organism///////
	
	//////////Between Organisms////
	
	/////////With Environement/////
	
	//////////Getters//////////////
	
	public int getAge()
	{
		return age;
	}
	
	public boolean getIsAlive()
	{
		return isAlive;
	}
	
	public boolean getHasBrain()
	{
		return hasBrain;
	}
	
	public static long getNbrOfBeings()
	{
		return nbrOfBeings;
	}
	
	//////////Setters//////////////
	
	public void setAge(int Age)
	{
		this.age = Age;
	}
}
