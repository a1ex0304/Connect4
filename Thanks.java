//Import java swing methods
import javax.swing.JFrame;
import javax.swing.JLabel;
public class Thanks extends JFrame{
  public void Thanks(){
    JFrame frame = new JFrame();
    //Make new label
    JLabel label = new JLabel("Thanks for Playing");
    //Set the bounds, size, layout, etc
    label.setBounds(175,200,200,40);
    frame.add(label);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(530,420);
    frame.setLayout(null);
  	frame.setVisible(true);
  }
}
