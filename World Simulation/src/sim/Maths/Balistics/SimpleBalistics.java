package sim.Maths.Balistics;

import sim.Constants;
import sim.Maths.Operators;
import sim.Maths.Vector;
import sim.World.Space.Coordinates;
import sim.World.Space.AstronomicalObjects.AstronomicalObject;

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
	
	//gets acceleration vector based on object and ceter of mass
	public Vector getAcceleration(AstronomicalObject object)
	{
		return new Vector(getGravitationalPull(object, 'x'), getGravitationalPull(object, 'y'), getGravitationalPull(object, 'z'));
	}
	
	//calculates vector length on given axis
	//returns 0 if axis not known
	private double getGravitationalPull(AstronomicalObject obj, char axis)
	{
		if (axis == 'x')
			return (Constants.G * mass * obj.getMass()) / Operators.square(this.centerOfMass.getX() - obj.getCoordinates().getX());
		if (axis == 'y')
			return (Constants.G * mass * obj.getMass()) / Operators.square(this.centerOfMass.getY() - obj.getCoordinates().getY());
		if (axis == 'z')
			return (Constants.G * mass * obj.getMass()) / Operators.square(this.centerOfMass.getZ() - obj.getCoordinates().getZ());
		
		return 0d;
	}
}
