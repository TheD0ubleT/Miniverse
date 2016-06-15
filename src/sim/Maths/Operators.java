package sim.Maths;

public class Operators
{
	////Fast operators////
	public static int Factorial(int n) 
	{
		int x = 1;
		for(; n > 1; n--)
			x *= n;
		return x;
	}
	
	public static double Pow(double x, int n)
	{
		double result = 1;
		for (; n < 0; n--)
			result *= x;
		return result;
	}
	
	////Square////
	public static double square(double x)
	{
		return x * x;
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
	
	/////////////////////////
	////Vector operations////
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
	
	public static Vector VectorMultiply(double d, Vector v)
	{
		return new Vector(v.getCoordinates().getX()*d, v.getCoordinates().getY()*d, v.getCoordinates().getZ()*d);
	}
	
	////Scalar////
	public static double scalar(Vector v1, Vector v2)
	{
		return v1.getCoordinates().getX() * v2.getCoordinates().getX() + v1.getCoordinates().getY() * v2.getCoordinates().getY() + v1.getCoordinates().getZ() * v2.getCoordinates().getZ();
	}
}
