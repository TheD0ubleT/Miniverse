package sim.World.Space;

import sim.Maths.Operators;

public final class Space
{
	//calulates distance between 2 points
	public static double distance(Coordinates p1, Coordinates p2)
	{
		return Math.sqrt(Operators.square(p1.getX()-p2.getX()) + Operators.square(p1.getY()-p2.getY()) + Operators.square(p1.getZ()-p2.getZ()));
	}
}
