package sim.Maths;

import sim.World.Space.AstronomicalObjects.Planet;

public class Gravitation {
    public static double SurfaceGravity(double mass, double radius) {
    	double surfaceGravity = 0;
    	radius *= 1000; //Convert to meters
    	surfaceGravity = (sim.Constants.G * mass) / sim.Maths.Operators.square(radius);
    	return surfaceGravity;
        //a = (G*M)/r^2
    }
    
    public static double SurfaceGravity(Planet planet) {
    	double surfaceGravity = 0;
    	double mass = planet.getMass();
    	double radius = planet.radius;
    	
    	radius *= 1000; //Convert to meters
    	surfaceGravity = (sim.Constants.G * mass) / sim.Maths.Operators.square(radius);
    	return surfaceGravity;
        //a = (G*M)/r^2
    }
    
    public static double gravitationalForceBetweenObjects(double mass_one, double mass_two, double distance) {
    	double forceGravity = 0;
    	forceGravity = (sim.Constants.G * mass_one * mass_two) / (distance * distance);  
    	return forceGravity;
        //F = G*m1*m2 /r^2
    }
}
