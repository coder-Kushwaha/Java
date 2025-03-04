package GUIProjects.GuessTheNumberGame;


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.plaf.ColorUIResource;

public class FirstWindow {
  JFrame frame = new JFrame();
  JButton play = new JButton();
  public static int r = 0;
  JComboBox cBox = new JComboBox();

  public void createframe() {
    frame.setSize(850, 650);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
    frame.getContentPane().setBackground(new ColorUIResource(0x123456));
    frame.setTitle("Guess The Number");
    frame.setLayout(null);
  }

  public void playButton() {
    play.setBounds(250, 200, 200, 30);
    play.setFocusable(false);
    play.setText("PLAY");
    play.setEnabled(false);
    play.addActionListener(e -> new secondwindow());
    // play.addActionListener(e -> play.setEnabled(false));
    frame.add(play);
  }

  public void difficulty() {

    JLabel di = new JLabel();
    di.setBounds(250, 250, 200, 30);
    di.setText("DIFFICULTY");
    di.setBackground(Color.white);
    di.setOpaque(true);
    di.setFont(new Font("MV Boli", Font.PLAIN, 30));

    String[] difficultylvl = { "SELECT", "EASY(0-100)", "NORMAL(0-1000)", "HARD(0-10000)" };
    cBox = new JComboBox(difficultylvl);

    cBox.addActionListener(e -> {
      this.r = cBox.getSelectedIndex();
      System.out.println(this.r);
      if (cBox.getSelectedItem() == "SELECT") {
        JOptionPane.showMessageDialog(null, "Please select a level", "ERROR", JOptionPane.ERROR_MESSAGE);
      }
      play.setEnabled(true);
    });

    cBox.setBounds(250, 300, 200, 30);
    frame.add(cBox);

    frame.add(di);

  }

  public static void main(String[] args) {
    FirstWindow window = new FirstWindow();
    window.createframe();
    window.playButton();
    window.difficulty();

  }
}
