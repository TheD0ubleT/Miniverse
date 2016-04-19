package sim.World.Space.AstronomicalObjects;

import sim.Maths.Balistics.Speed;
import sim.World.Space.Coordinates;

public abstract class AstronomicalObject
{
	private double mass;
	private Coordinates currentCoordinates;
	private Coordinates previousCoordinates;
	private Speed speed;
	
	////Constructor////	
	public AstronomicalObject(double mass, Coordinates coordinates)
	{
		this.currentCoordinates = coordinates;
		this.previousCoordinates = coordinates;
		this.mass = mass;
		this.speed = new Speed();
	}
	
	public AstronomicalObject(double mass, Coordinates coordinates, Speed initialSpeed)
	{
		this.currentCoordinates = coordinates;
		this.previousCoordinates = coordinates;
		this.mass = mass;
		this.speed = initialSpeed;
	}
	
	////Getters////
	public Coordinates getCurrentCoordinates()
	{
		return this.currentCoordinates;
	}
	
	public Coordinates getPreviousCoordinates()
	{
		return this.previousCoordinates;
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
	public void setCurrentCoordinates(Coordinates currentCoordinates)
	{
		this.previousCoordinates = this.currentCoordinates;
		this.currentCoordinates = currentCoordinates;
	}
	
	public void setPreviousCoordinates(Coordinates previousCoordinates)
	{
		this.previousCoordinates = previousCoordinates;
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
		if (this.currentCoordinates != object.getCurrentCoordinates())
			return false;
		if (this.previousCoordinates != object.getPreviousCoordinates())
			return false;
		if (this.speed != object.getSpeed())
			return false;
		
		return true;
	}

	public void setSpeed(Speed speed)
	{
		this.speed = speed;
	}
	
	public void setSpeed(double timeStep)
	{
		this.speed = new Speed(
				new Coordinates((currentCoordinates.getX() - previousCoordinates.getX())/timeStep,
				(currentCoordinates.getY() - previousCoordinates.getY())/timeStep,
				(currentCoordinates.getZ() - previousCoordinates.getZ())/timeStep));
	}
}
