import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


			Scanner in = new Scanner(System.in);
			System.out.println("How much do you want to bet?");
			int startAmount = in.nextInt();
			int totalSimulations = 1000;
			int wins = 0;
			int losses = 0;
			double winPercent = 50.1;
			int winLimit = 10;
			
			for(int count = 1; count <= totalSimulations; count ++)
			{
			
			int balance = startAmount;	
			
		
		int plays = 0;
		String result = "error";
		
		while (balance > 0 && balance < winLimit) 
		{
		
			int rndNumber = (int)(Math.random()*100) + 1;

			if (rndNumber > winPercent)
			{ 
				balance--;
			}
			else 
			{ 
				balance++;
				}
			plays++;
			if (balance == 0)
			{
				result = "lose";
				losses++;
			}
			else if (balance == 10)
			{
				result = "win";
				wins++;
			}
			}
			
		System.out.println("Simulation: " + count + " Plays: " + plays + " Result: " + result);
			}
			double ruinRate = (double) losses / (double) totalSimulations;
			double alpha = (100 - winPercent) / winPercent;
			double expectedRuin = (Math.pow(alpha, startAmount) - Math.pow(alpha, winLimit)) / (1.0 - Math.pow(alpha, winLimit));
			System.out.println("Ruin rate: " + ruinRate);
			System.out.println("Expected ruin rate: " + expectedRuin);
	}
}

