

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class guessGame extends JFrame {
	private JTextField tfGuess; //where user enters their guess
	private JLabel lblOutput; //output too high or too low
	private int theNumber; //the number to compare the guess to
	private int tries = 8; //the number of tries the player gets. set to 8 so that it does'nt go all the way down to 0
	
	public void checkGuess() {
		//get the users guess
		String guessText = tfGuess.getText();
		String message = "";
		
		try {
			int guess = Integer.parseInt(guessText); //the number the users enters
			
			tries--;
			
			//check if its too high
			if((guess > theNumber) && tries !=0) 
			{
				message = guess + " is too high." + tries + " tries left";
				lblOutput.setText(message);
			}
			//too low
			else if ((guess < theNumber) && tries !=0)
			{
				message = guess + " is too low." + tries + " tries left";
				lblOutput.setText(message);
			}
			else if((guess<theNumber || guess>theNumber) && tries<=0) {
				int choice = JOptionPane.showConfirmDialog(null, message + " Play again?"); // int choice holds true or false for the yes or no options displayed
				message = "Sorry you ran out of tries";
				//lblOutput.setText(message);
					if (choice == 0) {
						newGame();
					}
					else {
						System.exit(1);
					}
				
			}
			else 
			{
				message = guess + " is Correct. Play again?"; 	//improve by adding the number of tries
				lblOutput.setText(message);
				newGame();
			}
		}
		catch(Exception e) {
			lblOutput.setText("ENTER A WHOLE NUMBER");
		}
		finally {
			tfGuess.requestFocus();
			tfGuess.selectAll();
		}
		
	}
	
	public void newGame () 
	{
		theNumber = (int)(Math.random() * 100 +1);
		tries = 8;
	}
	
	public guessGame() {
		setTitle("Guess Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblMyGuessingGame = new JLabel("MY GUESSING GAME");
		lblMyGuessingGame.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMyGuessingGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyGuessingGame.setBounds(0, 32, 434, 14);
		getContentPane().add(lblMyGuessingGame);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 78, 414, 41);
		getContentPane().add(panel);
		
		JLabel lblGuessANumber = new JLabel("Guess a number between 1 and 100.");
		panel.add(lblGuessANumber);
		
		tfGuess = new JTextField();
		tfGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		panel.add(tfGuess);
		tfGuess.setColumns(10);
		
		JButton btnGuess = new JButton("Guess");
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				checkGuess();
			}
		});
		btnGuess.setBounds(173, 151, 89, 23);
		getContentPane().add(btnGuess);
		
		lblOutput = new JLabel("Enter a number above. You have " + (tries -1 )+ " tries."); // less 1 to display 7 tries
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(93, 206, 248, 23);
		getContentPane().add(lblOutput);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		guessGame theGame = new guessGame();
		theGame.newGame();
		theGame.setSize(new Dimension(430, 330));
		theGame.setVisible(true);
		//center window
	}
}
