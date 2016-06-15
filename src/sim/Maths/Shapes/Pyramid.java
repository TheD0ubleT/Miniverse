package sim.Maths.Shapes;

import sim.Maths.Operators;
import sim.World.Space.Coordinates;

public class Pyramid
{
	private Coordinates centerOfInertia;
	private double length;
	private double width;
	private double altitude;
	
	public Pyramid(Coordinates centerOfInertia, double length, double width, double altitude)
	{
		this.length = length;
		this.width = width;
		this.altitude = altitude;
		this.centerOfInertia = centerOfInertia;
	}
	
	////Getters////
	public Coordinates getCenterOfInertia()
	{
		return this.centerOfInertia;
	}
	
	public double getLength()
	{
		return this.length;
	}

	public double getAltitude()
	{
		return this.altitude;
	}
	
	public double getWidth()
	{
		return this.width;
	}

	public double getSlant(double adjacentSide) //getSlant uses input of adjacent side to find original sides slant. BE AWARE that confusing the input will cause wrong output value
	{
		return Math.sqrt(Operators.square(altitude) + Operators.square(adjacentSide / 2.0));
	}
	
	public double getVolume()
	{
		return baseArea() * altitude / 3;
	}
	
	public double baseArea()
	{
		return length * width;
	}
	
	public double basePerimeter()
	{
		return 2 * length + 2 * width;
	}
	
	public double lateralOneArea()
	{
		return width * getSlant(length) / 2;
	}
	
	public double lateralTwoArea()
	{
		return length * getSlant(width) / 2;
	}
	
	public double totalLateralArea()
	{
		return 2 * lateralOneArea() + 2 * lateralTwoArea();
	}
	
	public double getSurfaceArea()
	{
		return totalLateralArea() + baseArea();
	}
	
	////Setters////
	public void setCenterOfInertia(Coordinates centerOfInertia)
	{
		this.centerOfInertia = centerOfInertia;
	}
	
	public void setLength(double length)
	{
		this.length = length;
	}
	
	public void setWidth(double width)
	{
		this.width = width;
	}
	
	public void setAltitude(double altitude)
	{
		this.altitude = altitude;
	}
}
