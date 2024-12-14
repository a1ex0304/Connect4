//import java swing methods
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
//This will extend from JFrame and will implement ActionListener because we will use button pressing
public class Menu extends JFrame implements ActionListener{
  //set various varables
  private JButton myButton;
  private JLabel myLabel;
  private JLabel myLabel2;
  private JTextField p1name;
  private JTextField p2name;
  private String name1;
  private String name2;
  int index = -1;
  int index2 = -1;
  public Menu(){
    //Set to screen to say ICS4 Culminating
    super("ICS4 Culminating");
    //Make New Game Button
    myButton = new JButton("New Game");
    myButton.setBounds(160,300,200,40);
    myButton.setFocusable(false);
    myButton.addActionListener(this);
    add(myButton);
    //Make New Label
    myLabel = new JLabel("Welcome to Connect 4");
    myLabel.setBounds(175,100,200,40);
    add(myLabel);
    //Make another Label
    myLabel2 = new JLabel("Press New Game to Play");
    myLabel2.setBounds(170,120,200,40);
    add(myLabel2);
    //Make two Textfield for the user to enter in player 1 and 2 names
    p1name = new JTextField("Enter Player 1 Name: ");
    p1name.setBounds(50,200,150,50);
    add(p1name);
    p1name.addActionListener(this);
    p2name = new JTextField("Enter Player 2 Name: ");
    p2name.setBounds(330,200,150,50);
    add(p2name);
    p2name.addActionListener(this);
    //Set name1 and name2 to Player 1 and 2. This will be the default name for each player. It will change when the user enters in a username. So if a name is not entered, then it will be Player 1 and Player 2.
    name1 = "Player 1";
    name2 = "Player 2";
    }
  //Method for when the New Game button is pressed
  public void actionPerformed(ActionEvent event){
    if (event.getSource()==myButton){
      //This will only allow the button to be clicked once
      this.dispose();     
      //Recall Progress File
      Progress GameinProgress = new Progress();
      GameinProgress.Progress();
      //Call Game file
      Game myGame = new Game();
      myGame.CreateBoard();
      //Set loop to true
      boolean loop = true;
      //Print GameBoard
      myGame.printBoard();
      while(loop){
        //Call counter class and set it as count
        myGame.counter();
        int count = myGame.counter();
        //If count can be divided by 2, it means that its player 1 turn
        if (count%2 == 0){
          myGame.p1turn();
          System.out.println();
          myGame.printBoard();
        }else{//If not then it will be player 2 turn
          myGame.p2turn();
          System.out.println();
          myGame.printBoard();
        }//We make an if statement so that if a win condition is found then it will change the boolean of winconditions and will say that someone won
        if (myGame.winconditons()!=null){
          if (myGame.winconditons()== true){
            if(count%2==0){
              System.out.print(name1+" wins");
            }else{
              System.out.print(name2+" wins");
            }Thanks endscreen = new Thanks();
            endscreen.Thanks();
            //this.dispose();
          }loop = false;
        }//If the turn count goes to 48, that means that all spaces will taken because there are 48 spots on the board and that it is a tie
        if (count==48){
          System.out.print("Its a tie");
          loop = false;
        }
        count++;
      }
    }//If the user enters in a username for player 1 or player 2(and presses enter) then it will set the username to a corresponding varable
    if (event.getSource()==p1name){
      name1 = event.getActionCommand();
    }if (event.getSource()==p2name){
      name2 = event.getActionCommand();
    }
  }
}
