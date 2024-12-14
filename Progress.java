//Import java swing methods
import javax.swing.JFrame;
import javax.swing.JLabel;
public class Progress extends JFrame{
  public void Progress(){
    JFrame frame = new JFrame();
    //Make a new Label
    JLabel Progresslabel = new JLabel("Game in Progress");
    //Set the bounds, size, layout, etc
    Progresslabel.setBounds(250,200,200,40);
    frame.add(Progresslabel);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(530,420);
    frame.setLayout(null);
  	frame.setVisible(true);
  }
}
