package sim.Organism.Sickness;

import java.util.ArrayList;

import sim.Constants;

public class Antigene
{
	private static ArrayList<Long> allHashes;
	private long antigeneHash;
	
	////Constructor////
	public Antigene()
	{
		//Generates new hash 
		//and checks if it is already associated with a sickness
		long temp = 0;
		do{
			temp = Constants.RAND.nextLong();
		}while (allHashes.contains(temp));
		
		this.antigeneHash = temp;
	}
	
	////Getters////
	public long getAntigeneHash()
	{
		return this.antigeneHash;
	}
}
