package sim;

import java.util.Random;

public class Constants
{
	/////TIME and TICK///////
	public static final int TIME_STEP = 3600;
	public static final int SMALL_BIG_FACTOR = 24;
	public static final int BIG_STEP = TIME_STEP * SMALL_BIG_FACTOR;
	
	/////Dynamic Time//////
	public static long UNIX_TIME;
	private static int STEPS_DONE;
	
	////Random Generators////
	public static Random rand = new Random();
	
	////Math////
	public static double PI = 3.1415926535d;
	public static double E = 2.7182818284d;
	
	////Physics////
	public static double G = 6.67408e-11; //Gravitational constant
	public static double H = 6.62607004e-34; //Planck's constant
	public static double C = 299_792_458; //Speed of light
	public static double ELEMETARY_CHARGE = 1.602176565e-19;
	public static double MOL = 6.02214129e23; //Avogadro's number
	
	////////////////////////////////////////////////////
	//////////METHODS//////METHODS//////METHODS/////////
	////////////////////////////////////////////////////
	public static boolean isBigTick()
	{
		return STEPS_DONE == 0;
	}
	
	public static void tickSmall() 
	{
		//if small steps has arrived to big step, set STEPS_DONE to 0
		//else increment STEPS_DONE by 1
		STEPS_DONE = ((STEPS_DONE >= SMALL_BIG_FACTOR -1) ? 0 : STEPS_DONE+1);
	}
}
