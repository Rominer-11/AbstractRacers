/**
 * AbstractRacer.java
 * @author August Cho
 * @version 2024-03-04
 */

public abstract class AbstractRacer
{
	private String name;
	private int position;

	public AbstractRacer(String name)
	{
		this.name = name;
		this.position = 0;
	}

	public abstract void move();

	public String toString()
	{
		return "Racer[" + name + ", Position: " + position + "]";
	}

	public int getPosition()
	{
		return position;
	}
	public void setPosition(int position)
	{
		this.position = position;
	}
}
