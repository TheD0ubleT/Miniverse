package sim.Maths.Balistics;

import sim.Constants;
import sim.Maths.Operators;
import sim.Maths.Vector;
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
	public void updateAllPositions()
	{
		Vector[] vectors;
		for (int i = 0; i < astronomicalObjects.length; i++)
		{
			vectors =new Vector[astronomicalObjects.length-1];
			
			for (int j = 0, idx = 0; j < astronomicalObjects.length; j++) //for one object calculate gravitational vectors
			{
				if (i != j)
				{
					vectors[idx] = getAcceleration(astronomicalObjects[i], astronomicalObjects[j]);
					idx++;
				}
			}
			//updates position given new vector
			astronomicalObjects[i].getSpeed().getNewSpeed(Operators.vectorSum(vectors));
			astronomicalObjects[i].getSpeed().updatePosition(astronomicalObjects[i].getCoordinates());
		}
	}

	//gets acceleration vector based two objects
	public Vector getAcceleration(AstronomicalObject obj1, AstronomicalObject obj2)
	{
		return new Vector(getGravitationalPull(obj1, obj2, 'x'), getGravitationalPull(obj1, obj2, 'y'), getGravitationalPull(obj1, obj2, 'z'));
	}
	
	//calculates vector length on given axis
	//returns 0 if axis not known
	private double getGravitationalPull(AstronomicalObject obj, AstronomicalObject obj2, char axis)
	{
		if (axis == 'x')
			return (Constants.G * obj2.getMass() * obj.getMass()) / Operators.square(obj2.getCoordinates().getX() - obj.getCoordinates().getX());
		if (axis == 'y')
			return (Constants.G * obj2.getMass() * obj.getMass()) / Operators.square(obj2.getCoordinates().getY() - obj.getCoordinates().getY());
		if (axis == 'z')
			return (Constants.G * obj2.getMass() * obj.getMass()) / Operators.square(obj2.getCoordinates().getZ() - obj.getCoordinates().getZ());
		
		return 0d;
	}
}
