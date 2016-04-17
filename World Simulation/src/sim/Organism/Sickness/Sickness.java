package sim.Organism.Sickness;

public abstract class Sickness
{
	private Antigene antigene;
	private int imunityPeriod;
	public boolean isDeadly = false;
	private double sicknessPotency;
	
	////Constructors////
	public Sickness()
	{
		this.antigene = new Antigene();
	}
	
	public Sickness(boolean isDeadly)
	{
		this.antigene = new Antigene();
		this.isDeadly = isDeadly;
	}
	
	////Getters////
	public int getImunityPeriod()
	{
		return imunityPeriod;
	}
	
	public Antigene getAntigene()
	{
		return antigene;
	}

	public double getSicknessPotency()
	{
		return sicknessPotency;
	}

	////Setters////
	public void setSicknessPotency(double sicknessPotency)
	{
		this.sicknessPotency = sicknessPotency;
	}
}
