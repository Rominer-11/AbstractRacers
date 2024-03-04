/**
 * Hare.java
 * @author August Cho
 * @version 2024-03-04
 */

public class Hare extends AbstractRacer
{
	private int energy;
	private int resting;

	public Hare(String name)
	{
		super(name);
		energy = (int) (Math.random() * 10);
	}

	public void move()
	{
		if (energy > 0)
		{
			setPosition(getPosition() + 3);
			energy--;
			if (energy == 0)
			{
				resting = (int) (Math.random() * 10);
			}
		}
		else
		{
			resting--;
			if (resting == 0)
			{
				energy = (int) (Math.random() * 10);
			}
		}
	}
}
