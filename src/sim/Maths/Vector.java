package sim.Maths;

import sim.World.Space.Coordinates;
import sim.World.Space.Space;

public class Vector
{
	private Coordinates coordinates;
	
	////Constructor////
	public Vector()
	{
		coordinates = new Coordinates();
	}
	
	public Vector(double x, double y, double z)
	{
		this.coordinates = new Coordinates(x, y, z);
	}
	
	//return length of vector
	public double getNorm()
	{
		return Space.distance(new Coordinates(), coordinates);
	}
	
	//returns vector coordinates
	public Coordinates getCoordinates()
	{
		return this.coordinates;
	}
}
