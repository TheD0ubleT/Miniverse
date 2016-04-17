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
	
	public AstronomicalObject(double mass,Coordinates coordinates ,Speed initialSpeed)
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
	public void setCoordinates(Coordinates coordinates)
	{
		this.coordinates = coordinates;
	}
}
