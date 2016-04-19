package run.Astronomics.Motion.NeptuneDiscoveryTest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import sim.Maths.Balistics.ComplexBalistics;
import sim.Maths.Balistics.Speed;
import sim.World.Space.Coordinates;
import sim.World.Space.AstronomicalObjects.AstronomicalObject;
import sim.World.Space.AstronomicalObjects.Planet;
import sim.World.Space.AstronomicalObjects.Star;

public class SolarSystem
{
	public static ComplexBalistics balistics;

	public static void main(String[] args)
	{ /////////////////NOTE: Speeds are in m*s^-1 \\\\\\\\\\\
		Star sun = new Star(1.988550e30, new Coordinates());
		Planet mercury = new Planet(330.2e21, new Coordinates(57_909_050_000d, 0, 0), new Speed(new Coordinates(0, 47_362d, 0)));
		Planet venus = new Planet(4.8675e24, new Coordinates(108_939_000_000d, 0, 0), new Speed(new Coordinates(0, 35.2d, 0)));		
		Planet earth = new Planet(5.972e24, new Coordinates(149_598_023_000d, 0, 0), new Speed(new Coordinates(0, 29.78d, 0)));		
		Planet mars = new Planet(6.4171e23, new Coordinates(227_939_200_000d, 0, 0), new Speed(new Coordinates(0, 24.077d, 0)));		
		Planet jupiter = new Planet(1.8986e27, new Coordinates(78.299e12, 0, 0), new Speed(new Coordinates(0, 13.07d, 0)));		
		Planet saturn = new Planet(5.6836e26, new Coordinates(1_429.39e12, 0, 0), new Speed(new Coordinates(0, 9.69d, 0)));		
		Planet uranus = new Planet(8.6810e25, new Coordinates(2_875.04e12, 0, 0), new Speed(new Coordinates(0, 6.8d, 0)));		
		Planet neptune = new Planet(1.0243e26, new Coordinates(4_504.45e12, 0, 0), new Speed(new Coordinates(0, 5.43d, 0)));
		
		System.out.println("Planets created");
		
		if(new File("D:\\WithNeptune.txt").delete())
			System.out.println("File1 deleted");
		if(new File("D:\\WithoutNeptune.txt").delete())
			System.out.println("File2 deleted");
		
		AstronomicalObject[] solarSystem = {
				sun,
				mercury,
				venus,
				earth,
				mars,
				jupiter,
				saturn,
				uranus,
				neptune};
		balistics = new ComplexBalistics(solarSystem);
		
		try (FileWriter fWriter = new FileWriter("D:\\WithNeptune.txt", true);
				BufferedWriter bf = new BufferedWriter(fWriter);)
		{
			System.out.println("With neputne");
			for (int i = 0; i < 55_000; i++)
			{
				balistics.updateAllPositions(86400d);
				bf.write(getFormatedPositions(balistics.getAstronomicalObjects()) + '&');
			}
			System.out.println("Done");
		}
		catch (IOException e){}
		finally{}
		
		
		
		AstronomicalObject[] smallSolarSystem = {
				sun,
				mercury,
				venus,
				earth,
				mars,
				jupiter,
				saturn,
				uranus};
		balistics = new ComplexBalistics(smallSolarSystem);
		try (FileWriter fWriter = new FileWriter(new File("D:\\WithoutNeptune.txt"), true);
				BufferedWriter bf = new BufferedWriter(fWriter);)
		{
			System.out.println("Without neptune");
			for (int i = 0; i < 55_000; i++)
			{
				balistics.updateAllPositions(86400d);
				bf.write(getFormatedPositions(balistics.getAstronomicalObjects()) + '&');
			}
			System.out.println("Done");
		}
		catch (IOException e){}
		finally{}
		
		System.out.println("Finished");
	}
	
	public static String getFormatedPositions(AstronomicalObject[] objects)
	{
		String string = "";
		
		for (AstronomicalObject object : objects)
		{
			string += String.valueOf(object.getCoordinates().getX()) + ';' + String.valueOf(object.getCoordinates().getY()) + '|';
		}
		return string.substring(0, string.length()-1);
	}

}
