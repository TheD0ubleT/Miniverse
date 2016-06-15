package sim.World.Space;

import sim.World.Space.AstronomicalObjects.Planet;

public class Gravitation
{
    public static double SurfaceGravity(double mass, double radius)
    {
    	return (sim.Constants.G * mass) / sim.Maths.Operators.square(radius);
        //a = (G*M)/r^2
    }
    
    public static double SurfaceGravity(Planet planet)
    {    	
    	return (sim.Constants.G * planet.getMass()) / sim.Maths.Operators.square(planet.getRadius());
        //a = (G*M)/r^2
    }
    
    public static double gravitationalForceBetweenObjects(double mass_one, double mass_two, double distance)
    {
    	return (sim.Constants.G * mass_one * mass_two) / (distance * distance);
        //F = G*m1*m2 /r^2
    }
}
