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
		
		//For simplicity purposes, every unit will respect the International System of Units (aka. metric)
		
		//The radii are in meters
		Star sun = new Star(1.988550e30, new Coordinates());
		Planet mercury = new Planet(330.2e21, 2.440e6 ,new Coordinates(69_816_900_000d, 0, 0), new Speed(new Coordinates(0, 38_860d, 0)));
		Planet venus = new Planet(4.8675e24, 6.052e6, new Coordinates(108_939_000_000d, 0, 0), new Speed(new Coordinates(0, 34_790d, 0)));		
		Planet earth = new Planet(5.972e24, 6.371e6, new Coordinates(152_100_000_000d, 0, 0), new Speed(new Coordinates(0, 29_291d, 0)));		
		Planet mars = new Planet(6.4171e23, 3.390e6, new Coordinates(249_228_730_000d, 0, 0), new Speed(new Coordinates(0, 21_972d, 0)));		
		Planet jupiter = new Planet(1.8986e27, 6.9911e7, new Coordinates(816_620_000_000d, 0, 0), new Speed(new Coordinates(0, 12_440d, 0)));		
		Planet saturn = new Planet(5.6836e26, 5.8232e7, new Coordinates(1_503_983_449_000d, 0, 0), new Speed(new Coordinates(0, 9_137d, 0)));		
		Planet uranus = new Planet(8.6810e25, 2.5362e7, new Coordinates(3_006_318_143_000d, 0, 0), new Speed(new Coordinates(0, 6_486d, 0)));		
		Planet neptune = new Planet(1.0243e26, 2.4622e7, new Coordinates(4_553_946_490_000d, 0, 0), new Speed(new Coordinates(0, 5_385d, 0)));
		
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
				neptune
				};
		balistics = new ComplexBalistics(solarSystem);
		
		try (FileWriter fWriter = new FileWriter("D:\\WithNeptune.txt", true);
				BufferedWriter bf = new BufferedWriter(fWriter);)
		{
			System.out.println("With neputne");
			bf.write(getFormatedPositions(balistics.getAstronomicalObjects()) + '\n');
			for (int i = 0; i < 55_000; i++)
			{
				balistics.updateAllPositions(86400d);
				bf.write(getFormatedPositions(balistics.getAstronomicalObjects()) + '\n');
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
