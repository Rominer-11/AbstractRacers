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
		while (true)
		{
			System.out.println("Enter race length.");
			int length = in.nextInt();
			race(length);
		}
	}
	
	public static void race(int length)
	{
		Race race = new Race(length);

		boolean raceFinished = false;
		ArrayList<AbstractRacer> winners = new ArrayList<AbstractRacer>();
		
		race.addRacer(new Tortoise("Tortoiseerton"));
		race.addRacer(new Hare("Hareerton"));
		race.addRacer(new BananaKart("BananaKarterton"));

		while (!raceFinished)
		{
			winners = race.update();
			if (winners.size() >= 1)
			{
				raceFinished = true;
				System.out.println("Finished");
			}
		}
		
		if (winners.size() == 1)
		{
			System.out.println("The winner is...");
			for (AbstractRacer racer : winners)
			{
				System.out.println(racer.toString());
			}
		}
		else
		{
			System.out.println("It's a tie! The winners are...");
			for (AbstractRacer racer : winners)
			{
				System.out.println(racer.toString());
			}
		}
	}
}
