/**
 * AbstractRacer.java
 * @author August Cho
 * @version 2024-03-04
 */

public abstract class AbstractRacer
{
	static int ids = 0;
	private String name;
	private int position;
	private int id;

	public AbstractRacer(String name)
	{
		this.name = name;
		this.position = 0;
		this.id = ids;
		ids++;
	}

	public abstract void move();

	public String toString()
	{
		return "Racer[ID " + id + ", " + name + ", Position: " + position + "]";
	}

	public int getPosition()
	{
		return position;
	}
	public void setPosition(int position)
	{
		this.position = position;
	}
	public int getId()
	{
		return id;
	}
}
