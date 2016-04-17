package sim.World.Space.AstronomicalObjects;

import sim.Maths.Balistics.Speed;
import sim.World.Space.Coordinates;

public class Planet extends AstronomicalObject
{
	public double radius;
	
	////Constructor////
	public Planet(double mass, Coordinates coordinates)
	{
		super(mass, coordinates);
		radius = 0;
	}

	public Planet(double mass, Coordinates coordinates, Speed initialSpeed)
	{
		super(mass, coordinates, initialSpeed);
		radius = 0;
	}
	
	public Planet(double mass, double radius, Coordinates coordinates, Speed initialSpeed)
	{
		super(mass, coordinates, initialSpeed);
		this.radius = radius;
	}	
}
