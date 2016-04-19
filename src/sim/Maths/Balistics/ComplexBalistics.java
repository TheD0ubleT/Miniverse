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
			astronomicalObjects[i].setSpeed(86400d);
			astronomicalObjects[i].setCurrentCoordinates(new Coordinates(
					calculateNewPosOnAxis('x', timeStep, acc.getCoordinates().getX(), astronomicalObjects[i].getSpeed().getX(), astronomicalObjects[i].getCurrentCoordinates().getX()),
					calculateNewPosOnAxis('y', timeStep, acc.getCoordinates().getY(), astronomicalObjects[i].getSpeed().getY(), astronomicalObjects[i].getCurrentCoordinates().getY()),
					calculateNewPosOnAxis('z', timeStep, acc.getCoordinates().getZ(), astronomicalObjects[i].getSpeed().getZ(), astronomicalObjects[i].getCurrentCoordinates().getZ())));
		}
	}
	
	public void updateOnePosition(int objectIndex, double timeStep)
	{
		int i = objectIndex;
		Vector acc = new Vector();
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
		astronomicalObjects[i].setSpeed(86400d);
		astronomicalObjects[i].setCurrentCoordinates(new Coordinates(
				calculateNewPosOnAxis('x', timeStep, acc.getCoordinates().getX(), astronomicalObjects[i].getSpeed().getX(), astronomicalObjects[i].getCurrentCoordinates().getX()),
				calculateNewPosOnAxis('y', timeStep, acc.getCoordinates().getY(), astronomicalObjects[i].getSpeed().getY(), astronomicalObjects[i].getCurrentCoordinates().getY()),
				calculateNewPosOnAxis('z', timeStep, acc.getCoordinates().getZ(), astronomicalObjects[i].getSpeed().getZ(), astronomicalObjects[i].getCurrentCoordinates().getZ())));
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
		if (axis == 'x' && (obj2.getCurrentCoordinates().getX() - obj.getCurrentCoordinates().getX()) != 0)
			return (Constants.G * obj2.getMass()) / Operators.square(obj2.getCurrentCoordinates().getX() - obj.getCurrentCoordinates().getX()) * Math.signum(obj.getCurrentCoordinates().getX() - obj2.getCurrentCoordinates().getX());
		if (axis == 'y' && (obj2.getCurrentCoordinates().getY() - obj.getCurrentCoordinates().getY()) != 0)
			return (Constants.G * obj2.getMass()) / Operators.square(obj2.getCurrentCoordinates().getY() - obj.getCurrentCoordinates().getY()) * Math.signum(obj.getCurrentCoordinates().getX() - obj2.getCurrentCoordinates().getX());
		if (axis == 'z' && (obj2.getCurrentCoordinates().getZ() - obj.getCurrentCoordinates().getZ()) != 0)
			return (Constants.G * obj2.getMass()) / Operators.square(obj2.getCurrentCoordinates().getZ() - obj.getCurrentCoordinates().getZ()) * Math.signum(obj.getCurrentCoordinates().getX() - obj2.getCurrentCoordinates().getX());
		
		return 0d;
	}
}
