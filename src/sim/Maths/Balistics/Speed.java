package sim.Maths.Balistics;

import sim.Maths.Vector;
import sim.World.Space.Coordinates;

public class Speed
{
	private Coordinates speedCoordinates;
	
	////Constructor////
	public Speed()
	{
		this.speedCoordinates = new Coordinates();
	}
	
	public Speed(Coordinates speed)
	{
		this.speedCoordinates = speed;
	}
	
	//sets new position with given current speed 
	public Coordinates updatePosition(Coordinates currentPos)
	{
		currentPos.setX(currentPos.getX() + speedCoordinates.getX());
		currentPos.setY(currentPos.getY() + speedCoordinates.getY());
		currentPos.setZ(currentPos.getZ() + speedCoordinates.getZ());
		
		return currentPos;
	}
	
	//gets new speed from acceleration vector
	public void getNewSpeed(Vector acceleration, double timeStep)
	{
		speedCoordinates.setX(speedCoordinates.getX() + acceleration.getCoordinates().getX()*timeStep);
		speedCoordinates.setY(speedCoordinates.getY() + acceleration.getCoordinates().getY()*timeStep);
		speedCoordinates.setZ(speedCoordinates.getZ() + acceleration.getCoordinates().getZ()*timeStep);
	}
	
	////Getters////
	public Coordinates getSpeedCoordinates()
	{
		return this.speedCoordinates;
	}
	
	public double getX()
	{
		return this.speedCoordinates.getX();
	}
	
	public double getY()
	{
		return this.speedCoordinates.getY();
	}
	
	public double getZ()
	{
		return this.speedCoordinates.getZ();
	}
}
