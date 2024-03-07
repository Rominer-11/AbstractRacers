/**
 * RaceRunner.java
 * @author August Cho
 * @version 2024-03-05
 */

import java.util.Scanner;
import java.util.ArrayList;

public class RaceRunner
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);

		System.out.println("Enter race length.");
		int length = in.nextInt();
		System.out.println(length);
		Race race = new Race(length);

		boolean raceFinished = false;
		ArrayList<AbstractRacer> winners = new ArrayList<AbstractRacer>();
		
		race.addRacer(new Tortoise("Boberton"));
		race.addRacer(new Hare("Joberton"));

		while (!raceFinished)
		{
			winners = race.update();
			if (winners.size() >= 1)
			{
				raceFinished = true;
				System.out.println("Finished");
			}
		}

		for (AbstractRacer racer : winners)
		{
			System.out.println(racer.toString());
		}
	}
}
