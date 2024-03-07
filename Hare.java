/**
 * Hare.java
 * @author August Cho
 * @version 2024-03-04
 */

public class Hare extends AbstractRacer
{
	private int energy;
	private boolean resting;

	public Hare(String name)
	{
		super(name);
		this.energy = (int) (Math.random() * 10);
		this.resting = false;
	}

	public void move()
	{
		if (!resting)
		{
			setPosition(getPosition() + 2);
			energy--;
			if (energy <= 0)
			{
				resting = true;
				energy = (int) (Math.random() * 10);
			}
		}
		else
		{
			energy--;
			if (energy <= 0)
			{
				resting = false;
				energy = (int) (Math.random() * 10);
			}
		}
	}
}
