package sim.Maths.Shapes;

import sim.World.Space.Coordinates;

public class Cube
{
	private Coordinates centerOfInertia;
	private double length;
	private double width;
	private double height;
	
	public Cube(Coordinates centerOfInertia, double length, double width, double height)
	{
		this.length = length;
		this.width = width;
		this.height = height;
		this.centerOfInertia = centerOfInertia;
	}
	
	////Getters////
	public Coordinates getCenterOfInertia()
	{
		return this.centerOfInertia;
	}
	
	public double getLength() //L
	{
		return this.length;
	}
	
	public double getHeight() //H
	{
		return this.height;
	}
	
	public double getWidth() //W
	{
		return this.width;
	}
	
	public double getVolume()
	{
		return length * width * height;
	}
	
	public double lengthArea() //L Names cohere to adjacent face 
	{
		return length * height;
	}
	
	public double widthArea() //W
	{
		return length * width;
	}
	
	public double heightArea() //H
	{
		return width * height;
	}
	
	public double getSurfaceArea()
	{
		return (2 * lengthArea()) + (2 * widthArea()) + (2 * heightArea());
	}
	
	////Setters////
	public void setCenterOfInertia(Coordinates centerOfInertia)
	{
		this.centerOfInertia = centerOfInertia;
	}
	
	public void setLength(double length) //L
	{
		this.length = length;
	}
	
	public void setWidth(double width) //W
	{
		this.width = width;
	}
	
	public void setHeight(double height) //H
	{
		this.height = height;
	}
}
