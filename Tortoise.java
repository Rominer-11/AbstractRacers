/**
 * Tortise.java
 * @author August Cho
 * @version 2024-03-04
 */

public class Tortoise extends AbstractRacer
{
	public Tortoise(String name)
	{
		super(name);
	}

	public void move()
	{
		setPosition(getPosition() + 1);
	}
}
