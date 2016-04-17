package sim.Organism.ImuneSystem;

import java.util.ArrayList;

import sim.Constants;
import sim.Organism.Sickness.Sickness;

public class ImuneSystem
{
	private ArrayList<Antibody> antibodyMemory;
	private ArrayList<Sickness> sicknesses;
	public boolean isSick = false;
	
	
	
	////Action//////
	
	//Attacks sicknesses if sick
	public void checkIfSick()
	{
		if (!sicknesses.isEmpty())
		{
			for(Sickness sickness : sicknesses)
				attackSickness(sickness);
		}			
	}
	
	////////Tick/////////////////
		////Memory update////////
	
	//Adds antibody to person's memory
	public void addToMemory(Antibody antibody)
	{
		antibodyMemory.add(antibody);
	}
	
	//Executes method every bigtick
	public void tickMem()
	{
		if(Constants.isBigTick())
			for (Antibody antibody : antibodyMemory)
				antibody.TICK();
	}
	
		////Fight Sickness////
	//Attack sickness if 
	public void attackSickness(Sickness sickness)
	{
		boolean fought = false;
		for(Antibody antibody : antibodyMemory) // for each antibody
		{
			if (antibody.killsAntigene(sickness.getAntigene().getAntigeneHash())) //if it's the correct antibody
			{
				fought = true;
				if (antibody.oneShotsAntigene(sickness.getAntigene().getAntigeneHash(), sickness.getSicknessPotency()))
					//if antibody is strong enough, remove th sickness (you're cured)
				{
					sicknesses.remove(sickness);
					antibody.jobDone();
				}
				else //if not, reduce sickness potency.
				{
					sickness.setSicknessPotency(antibody.getEfficiency() - sickness.getSicknessPotency());
				}
				break;
			}
		}
		//if it doesn't have an antibody yet, try making one.
		if (!fought && makesAntigene(sickness))
			antibodyMemory.add(makeAntibody(sickness));
	}
	
	//uses probabilit to choose whether 
	public boolean makesAntigene(Sickness sickness)
	{
		return true;//will be changed
	}
	
	//returns new antibody sor this sickness
	public Antibody makeAntibody(Sickness sickness)
	{
		return new Antibody(sickness.getAntigene().getAntigeneHash(), sickness.getImunityPeriod()/Constants.TIME_STEP + 1);
	}
}
