package sim.Maths.Volume;

import sim.Constants;
import sim.Maths.Operators;
import sim.World.Space.Coordinates;

public class Sphere
{
	private Coordinates centerOfInertia;
	private double radius;
	
	public Sphere(Coordinates centerOfInertia, double radius)
	{
		this.radius = radius;
		this.centerOfInertia = centerOfInertia;
	}
	
	////Getters////
	public Coordinates getCenterOfInertia()
	{
		return this.centerOfInertia;
	}
	
	public double getVolume()
	{
		return (4d/3d) * Constants.PI * Operators.cube(radius);
	}
	
	////Setters////
	public void setCenterOfInertia(Coordinates centerOfInertia)
	{
		this.centerOfInertia = centerOfInertia;
	}
}
