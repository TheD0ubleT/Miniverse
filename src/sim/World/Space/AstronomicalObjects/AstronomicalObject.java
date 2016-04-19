package sim.World.Space.AstronomicalObjects;

import sim.Maths.Balistics.Speed;
import sim.World.Space.Coordinates;

public abstract class AstronomicalObject
{
	private double mass;
	private Coordinates coordinates;
	private Speed speed;
	
	////Constructor////	
	public AstronomicalObject(double mass, Coordinates coordinates)
	{
		this.coordinates = coordinates;
		this.mass = mass;
		this.speed = new Speed();
	}
	
	public AstronomicalObject(double mass, Coordinates coordinates, Speed initialSpeed)
	{
		this.coordinates = coordinates;
		this.mass = mass;
		this.speed = initialSpeed;
	}
	
	////Getters////
	public Coordinates getCoordinates()
	{
		return this.coordinates;
	}
	
	public double getMass()
	{
		return this.mass;
	}
	
	public Speed getSpeed()
	{
		return this.speed;
	}
	
	////Setters////
	public void setCoordinates(Coordinates currentCoordinates)
	{
		this.coordinates = currentCoordinates;
	}
	
	////Overrides////
	@Override
	public boolean equals(Object obj)
	{
		if (this.getClass() != obj.getClass())
			return false;
		
		AstronomicalObject object = (AstronomicalObject) obj;
		if (this.mass != object.getMass())
			return false;
		if (this.coordinates != object.getCoordinates())
			return false;
		if (this.speed != object.getSpeed())
			return false;
		
		return true;
	}

	public void setSpeed(Speed speed)
	{
		this.speed = speed;
	}
}
