package sim.Maths.Shapes;

import sim.World.Space.Coordinates;

public class RectangularPrism
{
	private Coordinates centerOfInertia;
	private double length;
	private double width;
	private double height;
	
	public RectangularPrism(Coordinates centerOfInertia, double length, double width, double height)
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
	
	public double getFaceOnePerimeter() //L Face 1
	{
		return 2 * length + 2 * height;
	}
	
	public double getFaceTwoPerimeter() //W Face 2
	{
		return 2 * length + 2 * width;
	}
	
	public double getFaceThreePerimeter() //H Face 3
	{
		return 2 * width + 2 * height;
	}
	
	public double getVolume()
	{
		return length * width * height;
	}
	
	public double faceOneArea() //L Face 1 Names cohere to adjacent face 
	{
		return length * height;
	}
	
	public double faceTwoArea() //W Face 2
	{
		return length * width;
	}
	
	public double faceThreeArea() //H Face 3
	{
		return width * height;
	}
	
	public double getSurfaceArea()
	{
		return 2 * faceOneArea() + 2 * faceTwoArea() + 2 * faceThreeArea();
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
