package sim.Maths.Balistics;

import sim.Constants;
import sim.Maths.Operators;
import sim.Maths.Vector;
import sim.World.Space.Coordinates;
import sim.World.Space.Space;
import sim.World.Space.AstronomicalObjects.AstronomicalObject;

public class ComplexBalistics
{
	private AstronomicalObject[] astronomicalObjects;
	
	////Constructor////
	public ComplexBalistics(AstronomicalObject[] astronomicalObjects)
	{
		this.astronomicalObjects = astronomicalObjects;
	}
	
	////Setters////
	public void setAstronomicalObjects(AstronomicalObject[] astronomicalObjects)
	{
		this.astronomicalObjects = astronomicalObjects;
	}
	
	////Getters////
	public AstronomicalObject[] getAstronomicalObjects()
	{
		return this.astronomicalObjects;
	}
	
	private Vector getAccelerationVector(AstronomicalObject obj1, AstronomicalObject obj2)
	{
		// On each axis: (example for x axis)
		// Ax(distance(obj1, obj2) * (obj2_X - obj2_X)) / (G * obj2_Mass)
		double dist_G_Mass = (Constants.G * obj2.getMass()) / Operators.cube(Space.distance(obj1.getCoordinates(), obj2.getCoordinates()));
		return new Vector(
				(obj2.getCoordinates().getX() - obj1.getCoordinates().getX()) * dist_G_Mass,
				(obj2.getCoordinates().getY() - obj1.getCoordinates().getY()) * dist_G_Mass,
				(obj2.getCoordinates().getZ() - obj1.getCoordinates().getZ()) * dist_G_Mass);
	}
	
	public void updateAllPositions(double timeStep)
	{
		Vector acc;
		for (AstronomicalObject obj1 : astronomicalObjects)
		{
			acc = new Vector();
			for (AstronomicalObject obj2 : astronomicalObjects)
				if (!obj1.equals(obj2))
					acc = Operators.vectorAdd(acc, getAccelerationVector(obj1, obj2));
			obj1.setSpeed(new Speed(new Coordinates(
					acc.getCoordinates().getX() * timeStep + obj1.getSpeed().getX(),
					acc.getCoordinates().getY() * timeStep + obj1.getSpeed().getY(),
					acc.getCoordinates().getZ() * timeStep + obj1.getSpeed().getZ())));
		}
		for (AstronomicalObject object : astronomicalObjects)
			object.setCoordinates(new Coordinates(
					object.getSpeed().getX() * timeStep + object.getCoordinates().getX(),
					object.getSpeed().getY() * timeStep + object.getCoordinates().getY(),
					object.getSpeed().getZ() * timeStep + object.getCoordinates().getZ()));
	}
}