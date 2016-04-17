package sim.World.Space.AstronomicalObjects;

import sim.Maths.Balistics.Speed;
import sim.World.Space.Coordinates;

public class Star extends AstronomicalObject
{
	@SuppressWarnings("unused")
	private double radius;
	@SuppressWarnings("unused")
	private double temperature;

	////Constructor////
	public Star(double mass, Coordinates coordinates)
	{
		super(mass, coordinates);
		radius = 0;
	}

	public Star(double mass, Coordinates coordinates, Speed initialSpeed)
	{
		super(mass, coordinates, initialSpeed);
		radius = 0;
	}
	
	public Star(double mass, double radius, Coordinates coordinates, Speed initialSpeed)
	{
		super(mass, coordinates, initialSpeed);
		this.radius = radius;
	}	
}
