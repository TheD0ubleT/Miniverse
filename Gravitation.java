package sim.Maths;

public class Gravitation {
    public static float GravitationalAccelerationOfObject(float gravitationalConstant, float mass, float radius) {
    	float gravitationalAcceleration = 0;
    	return gravitationalAcceleration;
        //a = (G*M)/r^2
    }
    
    public static float gravitationalForceBetweenObjects(float gravitationalConstant, float mass_one, float mass_two, float distance) {
    	float forceGravity = 0;
    	forceGravity = (gravitationalConstant * mass_one * mass_two) / (distance * distance);  
    	return forceGravity;
        //F = G*m1*m2 /r^2
    }
}
