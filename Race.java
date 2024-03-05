/**
 * Race.java
 * @author August Cho
 * @version 2024-03-05
 */

import java.util.ArrayList;

public class Race
{
	private ArrayList<AbstractRacer> racers;
	private int raceLength;

	public Race(int raceLength)
	{
		this.racers = new ArrayList<AbstractRacer>();
		this.raceLength = raceLength;
	}
	public void addRacer(AbstractRacer racer)
	{
		racers.add(racer);
	}
	public ArrayList<AbstractRacer> getRacers()
	{
		return racers;
	}

	/**
	 * Moves all racers and checks for a win.
	 * @return Returns a list of winners
	 */
	public ArrayList<AbstractRacer> update()
	{
		ArrayList<AbstractRacer> winners = new ArrayList<AbstractRacer>();
		for (AbstractRacer racer : racers)
		{
			racer.move();
			if (racer.getPosition() >= raceLength)
			{
				winners.add(racer);
			}
		}
		return winners;
	}
}
