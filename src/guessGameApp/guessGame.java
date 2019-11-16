package guessGameApp;

import java.util.Scanner;

public class guessGame {
	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		
		String playAgain = "";

		
		//game loop
		do {
			int randNum = (int)(Math.random()*100 +1);
			int guess = 0;
			
			//int tries = 1; //option1
			
			//another option
			int tries = 0; //option2
			
				while ( guess != randNum) {
					System.out.println("Guess a Number between 1 and 100");
					
					//get the players guess
					guess = scan.nextInt();
					
					//increment the tries
					tries++; //option2
					
					if(guess < randNum) { 
						System.out.println(guess +" is too low. Try again.");
						//tries = tries +1; //option1
					}
						
						else if(guess > randNum) {
							System.out.println(guess + " is too high. Try again.");
							//tries++; //option1
						}
						
						else {
							System.out.println("Correct !");
							if(tries<5)
							System.out.println("it took you " + tries + " tries. Good job!");
							else
								System.out.print("it took you " + tries + " tries. You could do better! ");
						}
					} //end of loop
				
				//ask play again
				System.out.println("Play again y/n?");
				playAgain = scan.next();
			} while (playAgain.equalsIgnoreCase("y"));
				//if no
		System.out.println("Thanks for playing. bye");
		}
	}


