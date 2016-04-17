package sim.World.Space;

public class Coordinates
{
	//coordinates over the 3 axis
	private double x;
	private double y;
	private double z;
	
	////Constructor////
	public Coordinates()
	{
		this.x = 0;
		this.y = 0;
		this.z = 0;
	}
	
	public Coordinates(double x, double y, double z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	////Getters////
	public double getX()
	{
		return this.x;
	}
	
	public double getY()
	{
		return this.y;
	}
	
	public double getZ()
	{
		return this.z;
	}
	
	////Setters////
	public void setX(double x)
	{
		this.x = x;
	}
	
	public void setY(double y)
	{
		this.y = y;
	}
	public void setZ(double z)
	{
		this.z = z;
	}
}
