package sim.Organism.ImuneSystem;

import sim.Constants;

public class Antibody
{
	private long antigeneHash;
	
	private int timesActivated = 0;
	private double relativeAge = 0;
	private double lambda;
	
	///////Constructors//////
	public Antibody(long antigeneHash)
	{
		this.antigeneHash = antigeneHash;
	}
	
	public Antibody(long antigeneHash, int lambda)
	{
		this.antigeneHash = antigeneHash;
		this.lambda = lambda;
	}
	
	////Event checking////	
	//checks if it's the right antibody for the antigene
	public boolean killsAntigene(long antigeneHash)
	{
		return antigeneHash == this.antigeneHash;
	}
	
	//checks if antibidy completely kills sickness
	public boolean oneShotsAntigene(long antigeneHash, double sicknessStrength)
	{
		if (antigeneHash != this.antigeneHash)
			return false;
		
		return sicknessStrength < getEfficiency();
	}
	
	////Action/////
	//returns the strength of the sickness after antibody attack
	public double killAntigene(double antigeneAmount)
	{
		antigeneAmount -= getEfficiency();
		return (antigeneAmount < 0 ? 0.0d : antigeneAmount);
	}
	
	////Special/////
	//gets the antibody strength
	public double getEfficiency()
	{
		return Math.pow(10, (double)-relativeAge/(lambda * timesActivated));
	}
	
	//increments number of times the antibody has been used and has killed a disease/sickness
	public void jobDone()
	{
		this.timesActivated++;
	}
	
	////Tick/////
	//Every tick, this method is run 
	public void TICK()
	{
		makeOlder();
	}
	
	//increments antibody relative age
	private void makeOlder()
	{
		this.relativeAge += Constants.BIG_STEP;
	}
}
