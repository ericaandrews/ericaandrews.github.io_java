import java.util.*;

public class Guessing_Program
{
	public static void main(String[] args)
	{
		int lowerBound = 1;
		int upperBound = 100;
		
		NumberGuesserClass rng = new RandomNumberGuesserClass(lowerBound, upperBound);	
		char response;
		
		do {
			rng.reset();
			System.out.println("Think of a number from " + lowerBound + " to " + upperBound + ".");
		
			do {
				response = promptUserAndGetResponse(rng.getCurrentGuess());
			
				if (response == 'h') 
				{
					rng.higher();
				}
				if (response == 'l') 
				{
					rng.lower();
				}
				if (response == 'r') rng.reset();
				
			} while (response != 'c');
			
		} while (shouldPlayAgain());
	}
	
	public static char promptUserAndGetResponse(int guess) {
		char response;
		Scanner input = new Scanner(System.in);
			
		do {
			System.out.print("Is it " + guess + "? (h/l/c/r): ");
			response = input.next().charAt(0);
		} while (response != 'h' && response != 'l' && response != 'c' && response != 'r');
		
		return response;
	}
	  
	public static boolean shouldPlayAgain() {
		char response;
		Scanner input = new Scanner(System.in);
		
		do {
			System.out.print("Do you want to play again? (y/n): ");
			response = input.next().charAt(0);
		} while (response != 'y' && response != 'n');
		
		return response == 'y';
	}
}