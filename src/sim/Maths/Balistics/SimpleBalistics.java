package sim.Maths.Balistics;

import sim.Constants;
import sim.Maths.Operators;
import sim.World.Space.Coordinates;
import sim.World.Space.AstronomicalObjects.AstronomicalObject;
import sim.World.Space.AstronomicalObjects.Star;

public class SimpleBalistics
{
	private Coordinates centerOfMass;
	private double mass;
	
	////Constructor////
	public SimpleBalistics()
	{
	}
	
	//Sets the center of mass for orbital calculations. (works with few objects)
	public void setCenterOfMass(AstronomicalObject[] astronomicalObjects)
	{
		double x = 0d, y = 0d, z = 0d;
		double totalMass = 0d;
		
		for(AstronomicalObject obj : astronomicalObjects)
		{
			totalMass += obj.getMass();
			x += obj.getCoordinates().getX()*obj.getMass();
			y += obj.getCoordinates().getY()*obj.getMass();
			z += obj.getCoordinates().getZ()*obj.getMass();
		}
		
		this.centerOfMass.setX(x/totalMass);
		this.centerOfMass.setY(y/totalMass);
		this.centerOfMass.setZ(z/totalMass);
		this.mass = totalMass;
	}
	
	public double calculateNewPosOnAxis(char axis, double timeStep, AstronomicalObject obj, double currentSpeed, double currentPosition)
	{
		// using newton's second law:
		// position on x axis at time t: x(t) = (1/2)*Ax*t^2 + t * Vx0 + x0 
		return (0.5 * getGravitationalPull(obj, new Star(this.mass, this.centerOfMass), axis) * Operators.square(timeStep)) + currentSpeed * timeStep + currentPosition;
	}
	
	//calculates vector length on given axis
	//returns 0 if axis not known
	private double getGravitationalPull(AstronomicalObject obj, AstronomicalObject obj2, char axis)
	{
		if (axis == 'x' && (obj2.getCoordinates().getX() - obj.getCoordinates().getX()) != 0)
			return (Constants.G * obj2.getMass()) / Operators.square(obj2.getCoordinates().getX() - obj.getCoordinates().getX()) * Math.signum(obj2.getCoordinates().getX() - obj.getCoordinates().getX());
		if (axis == 'y' && (obj2.getCoordinates().getY() - obj.getCoordinates().getY()) != 0)
			return (Constants.G * obj2.getMass()) / Operators.square(obj2.getCoordinates().getY() - obj.getCoordinates().getY()) * Math.signum(obj2.getCoordinates().getX() - obj.getCoordinates().getX());
		if (axis == 'z' && (obj2.getCoordinates().getZ() - obj.getCoordinates().getZ()) != 0)
			return (Constants.G * obj2.getMass()) / Operators.square(obj2.getCoordinates().getZ() - obj.getCoordinates().getZ()) * Math.signum(obj2.getCoordinates().getX() - obj.getCoordinates().getX());
		
		return 0d;
	}
}
