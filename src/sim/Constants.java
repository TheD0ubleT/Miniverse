package sim;

import java.util.Random;

public final class Constants
{
	/////TIME and TICK///////  (Time given in seconds)
	public static final int TIME_STEP = 3600; //Smallest time increment Step for given Calculation
	public static final int SMALL_BIG_FACTOR = 24; // Number of small steps to execute before doing BigStep actions
	public static final int BIG_STEP = TIME_STEP * SMALL_BIG_FACTOR; //Big step is here to execute less important actions less often 
	
	/////Dynamic Time//////
	public static long UNIX_TIME;
	private static int STEPS_DONE;
	
	////Random Generators////
	public final static Random RAND = new Random();
	
	////Math////
	public static final double PI = 3.1415926535d;
	public static final double E = 2.7182818284d;
	
	////Physics////
	public static final double G = 6.67408e-11; //Gravitational constant
	public static final double H = 6.62607004e-34; //Planck's constant
	public static final double C = 299_792_458; //Speed of light
	public static final double ELEMETARY_CHARGE = 1.602176565e-19; //Charge of a protons or electron (+/-)
	public static final double MOL = 6.02214129e23; //Avogadro's number
	
	public static final double PROTON_MASS = 1.6726e-24; //Mass of a proton
	public static final double NEUTRON_MASS = 1.6726e-24; //Mass of a neutron
	public static final double ELECTRON_MASS = 9.1094e-23; //Mass of a electron
	
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
