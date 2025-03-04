package GUIProjects.GuessTheNumberGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.plaf.ColorUIResource;

public class secondwindow {
    JFrame frame = new JFrame();
    JTextField textfield = new JTextField();
    int gn=0,cn;
    secondwindow(){
        frame.setSize(850, 650);
        frame.setVisible(true);
        frame.setTitle("Playing Game");
       frame.getContentPane().setBackground(new ColorUIResource(0x123456));
        frame.setLayout(null);
        frame.setResizable(false);
        textfield.setBounds(300, 200, 450, 60);
       JButton btn = new JButton("SUBMIT");
       btn.setBounds(100, 180, 100, 30);
       btn.setFocusable(false);

       JButton clr = new JButton("CLEAR");
       clr.setBounds(100, 250, 100, 30);
       clr.setFocusable(false);
       clr.addActionListener(e -> textfield.setText(null));

       guessnumber g = new guessnumber();
        g.setnumber();
         cn=g.getnumber();
        System.out.println(cn);

       JLabel guess = new JLabel();
       guess.setBounds(300, 320, 150, 30);
       guess.setVisible(true);
       guess.setText("Guess:"+0);
       guess.setOpaque(true);
       guess.setBackground(Color.white);
       guess.setFont(new Font("MV Boli",Font.PLAIN,30));
       
       JButton resetButton = new JButton("RESET");
       resetButton.setBounds(100, 320, 100, 30);
       resetButton.setFocusable(false);
       resetButton.addActionListener(e -> {
        g.setnumber();
         cn=g.getnumber();
        System.out.println(cn);
        guess.setText("Guess:"+0);
        gn=0;
        textfield.setText(null);
       });
       
       
     
       textfield.setFont(new Font("Consolas",Font.BOLD,20));
       textfield.setBackground(Color.WHITE);
       textfield.setForeground(Color.BLUE);
       textfield.setCaretColor(Color.GREEN);
    
       JButton pa = new JButton("PLAY AGAIN");
       pa.setFocusable(false);
       pa.setBounds(100, 380, 150, 30);
       pa.setVisible(false);
       btn.addActionListener(e -> {
        int un=Integer.parseInt(textfield.getText());
        if(un>cn)
         {textfield.setText("Your number is greater than the number");
          gn++;}
        else if(un<cn)
         {textfield.setText("Your number is smaller than the number");
         gn++;}
         else
         {textfield.setText("You guess the Correct number");
          gn+=1;
         pa.setVisible(true);
         pa.addActionListener(ee -> frame.dispose());
        }
        
        guess.setText("Guess:"+gn);});
        
       frame.add(clr);
       frame.add(btn);
       frame.add(textfield);
       frame.add(guess);
       frame.add(resetButton);
       frame.add(pa); 
     
    }
    
}

class guessnumber extends FirstWindow{
   private int ran_no;
   Random random = new Random();
   void setnumber(){
    int bound=1;
    switch (FirstWindow.r) {
        case 1:
              bound=100;
            break;
    
        case 2:
              bound=1000;
            break;
        case 3:
              bound=10000;
              System.out.println(bound);
            break;
    }
    ran_no=random.nextInt(bound);
   }
   int getnumber(){
    return ran_no;
   }  
}

