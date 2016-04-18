package sim.Maths;

public class Operators
{
	////Square////
	public static double square(double x)
	{
		return x*x;
	}
	
	public static int square(int x)
	{
		return x * x;
	}
	
	////Cube////
	public static double cube(double x)
	{
		return x * x * x;
	}
	
	public static int cube(int x)
	{
		return x * x * x;
	}
	
	//////////////
	////Vector operations////
	
	////Sum////
	public static Vector vectorSum(Vector[] vectors)
	{
		Vector sum = new Vector(0, 0, 0);
		for(Vector vector : vectors)
			sum = vectorAdd(sum, vector);
		
		return sum;
	}
	
	public static Vector vectorAdd(Vector v1, Vector v2)
	{
		return new Vector(v1.getCoordinates().getX() + v2.getCoordinates().getX(), v1.getCoordinates().getY() + v2.getCoordinates().getY(), v1.getCoordinates().getZ() + v2.getCoordinates().getZ());
	}
	
	////Scalar////
	public static double scalar(Vector v1, Vector v2)
	{
		return v1.getCoordinates().getX() * v2.getCoordinates().getX() + v1.getCoordinates().getY() * v2.getCoordinates().getY() + v1.getCoordinates().getZ() * v2.getCoordinates().getZ();
	}
}
