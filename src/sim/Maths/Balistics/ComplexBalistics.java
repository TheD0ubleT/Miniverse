package sim.Maths.Balistics;

import sim.Constants;
import sim.Maths.Operators;
import sim.Maths.Vector;
import sim.World.Space.Coordinates;
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
	
	////Calculate trajectories////
	public void updateAllPositions(double timeStep)
	{
		Vector acc;
		for (int i = 0; i < astronomicalObjects.length; i++) // for each object
		{
			acc = new Vector();
			for (int j = 0; j < astronomicalObjects.length; j++) // for each Other object
			{
				if (i != j)
				{
					acc = Operators.vectorAdd(acc, new Vector(
							getGravitationalPull(astronomicalObjects[i], astronomicalObjects[j], 'x'),
							getGravitationalPull(astronomicalObjects[i], astronomicalObjects[j], 'y'),
							getGravitationalPull(astronomicalObjects[i], astronomicalObjects[j], 'z')));
				}
			}
			astronomicalObjects[i].setCoordinates(new Coordinates(
					calculateNewPosOnAxis('x', timeStep, acc.getCoordinates().getX(), astronomicalObjects[i].getSpeed().getX(), astronomicalObjects[i].getCoordinates().getX()),
					calculateNewPosOnAxis('y', timeStep, acc.getCoordinates().getY(), astronomicalObjects[i].getSpeed().getY(), astronomicalObjects[i].getCoordinates().getY()),
					calculateNewPosOnAxis('z', timeStep, acc.getCoordinates().getZ(), astronomicalObjects[i].getSpeed().getZ(), astronomicalObjects[i].getCoordinates().getZ())));
		}
	}
	
	public double calculateNewPosOnAxis(char axis, double timeStep, double acceleration, double currentSpeed, double currentPosition)
	{
		// using newton's second law:
		// position on x axis at time t: x(t) = (1/2)*Ax*t^2 + t * Vx0 + x0 
		return (0.5 * acceleration * Operators.square(timeStep)) + currentSpeed * timeStep + currentPosition;
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
