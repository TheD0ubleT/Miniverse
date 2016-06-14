package sim.Maths.Volume;

import sim.Constants;
import sim.Maths.Operators;
import sim.World.Space.Coordinates;

public class Cylinder
{
	private Coordinates centerOfInertia;
	private double radius;
	private double height;
	
	public Cylinder(Coordinates centerOfInertia, double radius, double height)
	{
		this.height = height;
		this.radius = radius;
		this.centerOfInertia = centerOfInertia;
	}
	
	////Getters////
	public Coordinates getCenterOfInertia()
	{
		return this.centerOfInertia;
	}
	
	public double getVolume() //Volume
	{
		return getFaceArea() * height;
	}
	
	public double getLateralArea() //For lateral side without faces
	{
		return 2 * Constants.PI * radius * height;
	}
	
	public double getFaceArea() //For faces (top or bottom)
	{
		return Constants.PI * Operators.square(radius);
	}
	
	public double getSurfaceArea() //For Surface area (Lateral + 2*Face)
	{
		return getLateralArea() + 2 * Constants.PI * Operators.square(radius);
	}
	
	////Setters////
	public void setCenterOfInertia(Coordinates centerOfInertia)
	{
		this.centerOfInertia = centerOfInertia;
	}
}
