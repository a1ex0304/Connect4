import javax.swing.JFrame;//import JFrame
class Main {
  public static void main(String[] args) {
    Menu frame = new Menu();//Call menu
    //Set size, layout, visible and exit on close for frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(530,420);
    frame.setLayout(null);
  	frame.setVisible(true);
	}
}
