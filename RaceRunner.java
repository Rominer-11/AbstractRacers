/**
 * RaceRunner.java
 * @author August Cho
 * @version 2024-03-05
 */

import java.util.Scanner;
import java.util.ArrayList;

public class RaceRunner
{
	public static Scanner in;

	public static void main(String[] args)
	{
		in = new Scanner(System.in);
		
		System.out.println("How many users are betting?");
		int[] userBalance = new int[in.nextInt()];
		int[] userBets = new int[userBalance.length];
		int[] userChoices = new int[userBalance.length];
		for (int i = 0; i < userBalance.length; i++)
		{
			System.out.println("User " + i + " has 100 tortoise coins.");
			userBalance[i] = 100;
		}
		
		while (true)
		{
			System.out.println("Enter race length.");
			int length = in.nextInt();
			race(length, userBalance, userBets, userChoices);
		}
	}
	
	public static void race(int length, int[] userBalance, int[] userBets, int[] userChoices)
	{
		Race race = new Race(length);

		boolean raceFinished = false;
		ArrayList<AbstractRacer> winners = new ArrayList<AbstractRacer>();
		ArrayList<Integer> winningUsers = new ArrayList<Integer>();

		race.addRacer(new Tortoise("Tortoiseerton"));
		race.addRacer(new Hare("Hareerton"));
		race.addRacer(new BananaKart("BananaKarterton"));

		System.out.println("Here are the racers: ");
		for (int i = 0; i < race.getRacers().size(); i++)
		{
			System.out.println(race.getRacers().get(i).toString());
		}
		System.out.print("\n");

		for (int i = 0; i < userBalance.length; i++)
		{
			System.out.println("User " + i + ", who are you betting on?");
			System.out.println("You have " + userBalance[i] + " tortoise coins.");
			int bet = in.nextInt();
			userChoices[i] = bet;
			System.out.println("How much are you betting?");
			int amount = in.nextInt();
			userBets[i] = amount;
			System.out.print("\n");
		}
		


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
				System.out.println(racer.toString() + "\n");
				for (int i = 0; i < userChoices.length; i++)
				{
					if (userChoices[i] == racer.getId())
					{
						winningUsers.add(i);
					}
				}
			}
		}
		else
		{
			System.out.println("It's a tie! The winners are...");
			for (AbstractRacer racer : winners)
			{
				System.out.println(racer.toString() + "\n");
				for (int i = 0; i < userChoices.length; i++)
				{
					if (userChoices[i] == racer.getId())
					{
						winningUsers.add(i);
					}
				}
			}
		}
		int winnerSum = 0;
		for (int i = 0; i < userBets.length; i++)
		{
			boolean winner = false;
			for (int n : winningUsers)
			{
				if (i == n)
				{
					winner = true;
				}

			}
			if (!winner)
			{
				userBalance[i] -= userBets[i];
				winnerSum += userBets[i];
				System.out.println("User " + i + " lost " + userBets[i] + " tortoise coins.\n");
			}
		}
		for (int i = 0; i < winningUsers.size(); i++)
		{
			userBalance[winningUsers.get(i)] += winnerSum / winningUsers.size();
			System.out.println("User " + winningUsers.get(i) + " gained " + (winnerSum / winningUsers.size()) + " tortoise coins.\n");
		}
	}
}
