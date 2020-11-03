import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables 
  JLabel introLabel;
  JLabel guessLabel;

  JTextField numberText;

  JButton sumbitButton;
  JButton newNumButton; 

  JPanel mainPanel;

  //int for random number
  int randNum = (int)(Math.random()*(100 - 1 + 1))+ 1;
  

  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Title");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);

    //sets up main mainPanel
    mainPanel = new JPanel();
    mainPanel.setLayout(null);
    frame.add(mainPanel);

    //creates and sets bounds for the labels
    introLabel = new JLabel("Guess the number between 0 and 100:");
    introLabel.setBounds(270, 100, 300, 25);
    guessLabel = new JLabel("");
    guessLabel.setBounds(260, 240, 250, 25);

    //adds labels to main mainPanel
    mainPanel.add(introLabel);
    mainPanel.add(guessLabel);
    
    //creates text field and sets bounds
    numberText = new JTextField();
    numberText.setBounds(260, 145, 300, 25);

    //adds text field to j mainPanel
    mainPanel.add(numberText);

    //creates buttons and sets bounds
    sumbitButton = new JButton("Submit");
    sumbitButton.setBounds(260, 190, 100, 35);
    newNumButton = new JButton("New Number");
    newNumButton.setBounds(370, 190, 190, 35);

    //sets acction command for buttons
    sumbitButton.setActionCommand("submit");
    newNumButton.setActionCommand("reset");

    //add action listener to buttons
    sumbitButton.addActionListener(this);
    newNumButton.addActionListener(this);

    //makes buttons setVisible
    mainPanel.add(sumbitButton);
    mainPanel.add(newNumButton);
    

  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();


    if(command.equals("submit")){
      //turning users input into a int
      String userInput = numberText.getText();
      int usersGuess = Integer.parseInt(userInput);

      //to see if users guess is to low or high or equal
      if(usersGuess < randNum){
        guessLabel.setText("Your guess of " + usersGuess + " is too low");
      }else if(usersGuess > randNum){
        guessLabel.setText("Your guess of " + usersGuess + " is too high");
      //if equal
      }else{
        guessLabel.setText("You won!");
      }
    //if statement for if reset button is hit
    }else if(command.equals("reset")){
      randNum = (int)(Math.random()*(100 - 1 + 1))+ 1;
      //to reset guess text
      numberText.setText("0");
    }

  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
