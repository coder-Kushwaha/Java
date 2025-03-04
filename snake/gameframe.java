package snake;
import javax.swing.JFrame;
public class gameframe extends JFrame {

    public gameframe(){
        this.add(new gamepannel());
        this.setTitle("SNAKE");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
         this.pack();
        this.setLocationRelativeTo(null);
    }
    
}
