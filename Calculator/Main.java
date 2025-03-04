package Calculator;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.plaf.ColorUIResource;

public class Main implements ActionListener{

    JFrame frame = new JFrame("CALCULATOR");
    JPanel pannel = new JPanel();
    Border border = BorderFactory.createLineBorder(Color.red, 4,true);
    JTextField textField = new JTextField();
    JButton[] numbtns = new JButton[10];
    JButton[] fncbtns = new JButton[9];
    JButton addButton,subButton,mulButton,divButton;
    JButton decButton,clrButton,delButton,eqlButton,negButton;

    Font font= new Font("Ink Free", Font.BOLD, 30);
    double num1,num2,result;
    char operator;

    Main(){
        frame.setBounds(400, 100, 510, 500);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new ColorUIResource(Color.black));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pannel.setBounds(20, 100, 450, 350);
        pannel.setBackground(new ColorUIResource(Color.CYAN));
        pannel.setOpaque(true);
        pannel.setBorder(border);
        pannel.setVisible(true);
        pannel.setLayout(new GridLayout(5, 4, 10, 10));
   
        textField.setBounds(20, 20, 450, 70);
        textField.setEditable(false);
        textField.setBorder(border);
        textField.setFont(font);

        addButton = new JButton("+");
        divButton = new JButton("/");
        mulButton = new JButton("*");
        decButton = new JButton(".");
        eqlButton = new JButton("=");
        clrButton = new JButton("CLR");
        subButton = new JButton("-");
        delButton = new JButton("DEL");
        negButton = new JButton("(-)");

        fncbtns[0] = addButton;
        fncbtns[1] = subButton;
        fncbtns[2] = mulButton;
        fncbtns[3] = divButton;
        fncbtns[4] = decButton;
        fncbtns[5] = eqlButton;
        fncbtns[6] = delButton;
        fncbtns[7] = clrButton;
        fncbtns[8] = negButton;
        for(int i=0;i<9;i++){
           fncbtns[i].addActionListener(this);
           fncbtns[i].setFont(font);
           fncbtns[i].setFocusable(false);
        }
        for(int i=0;i<10;i++){
           numbtns[i]= new JButton(String.valueOf(i));
           numbtns[i].addActionListener(this);
           numbtns[i].setFont(font);
           numbtns[i].setFocusable(false);
        }
         
        pannel.add(numbtns[1]);
        pannel.add(numbtns[2]);
        pannel.add(numbtns[3]);
        pannel.add(addButton);
        pannel.add(numbtns[4]);
        pannel.add(numbtns[5]);
        pannel.add(numbtns[6]);
        pannel.add(subButton);
        pannel.add(numbtns[7]);
        pannel.add(numbtns[8]);
        pannel.add(numbtns[9]);
        pannel.add(mulButton);
        pannel.add(decButton);
        pannel.add(clrButton);
        pannel.add(numbtns[0]);
        pannel.add(divButton);
        pannel.add(delButton);
        pannel.add(eqlButton);
        pannel.add(negButton);
        

        frame.setVisible(true);
        frame.add(textField);
        frame.add(pannel);
        frame.add(pannel);
    }
    
    
    public static void main(String[] args) {
        new Main();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
       for(int i=0;i<10;i++){
        if(e.getSource()==numbtns[i]){
            textField.setText(textField.getText().concat(String.valueOf(i)));
        }
       }
       if(e.getSource()==decButton){
         textField.setText(textField.getText().concat("."));
       }
       if(e.getSource()==addButton){
         num1=Double.parseDouble(textField.getText());
         operator='+';
         textField.setText("");
       }
       if(e.getSource()==subButton){
         num1=Double.parseDouble(textField.getText());
         operator='-';
         textField.setText("");
       }
       if(e.getSource()==mulButton){
         num1=Double.parseDouble(textField.getText());
         operator='*';
         textField.setText("");
       }
       if(e.getSource()==divButton){
         num1=Double.parseDouble(textField.getText());
         operator='/';
         textField.setText("");
       }
       if(e.getSource()==eqlButton){
         num2=Double.parseDouble(textField.getText());

         switch(operator){
            case '+': result=num1+num2;
                     break;
            case '-': result=num1-num2;
                     break;
            case '*': result=num1*num2;
                     break;
            case '/': result=num1/num2;
                     break;
         }
         textField.setText(String.valueOf(result));
       }
       if(e.getSource()==clrButton){
         textField.setText("");
       }
       if(e.getSource()==delButton){
         String s=textField.getText();
         textField.setText("");
         for(int i=0;i<s.length()-1;i++){
            textField.setText(textField.getText()+s.charAt(i));
         }
       }
       if(e.getSource()==negButton){
        textField.setText("-"+textField.getText());
       }
  }
}
