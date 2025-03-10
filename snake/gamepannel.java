package snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.*;

public class gamepannel extends JPanel implements ActionListener{

     static final int SCREEN_WIDTH=600;
     static final int SCREEN_HEIGHT=600;
     static final int SCREEN_HEIGHT1=700;
     static final int UNIT_SIZE=25;
     static final int GAME_UNITS= (SCREEN_HEIGHT*SCREEN_WIDTH)/UNIT_SIZE;
     static final int DELAY = 100;
     final int[] x= new int[GAME_UNITS];   
     final int[] y= new int[GAME_UNITS];  
     int bodyparts=5;
     int appleeaten=0;
     int appleX,appleY;
     char direction='R';
     boolean running= false;
     Timer timer;
     Random random;   
     JLabel label = new JLabel();
     

    gamepannel(){
        random=new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setLayout(new FlowLayout());
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();
    }

    public void startGame(){
         newapple();
         running=true;
          timer = new Timer(DELAY,this);
          timer.start();
          
    }
    public void newapple(){
        appleX=random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
        appleY=random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);

    }

    public void draw(Graphics g){
        if(running)
        {    for(int i=0;i<SCREEN_HEIGHT/UNIT_SIZE;i++){
                 g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, SCREEN_HEIGHT);
                 g.drawLine(0, i*UNIT_SIZE, SCREEN_WIDTH,i*UNIT_SIZE);
                 }
             g.setColor(Color.red);
             g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);

             for(int i=0;i<bodyparts;i++){
                 if(i==0){
                     g.setColor(Color.green);
                     g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                 }
                 else{
                     g.setColor(new Color(45,180,0));
                     g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                    }
            }
            g.setColor(Color.red);
            g.setFont(new Font("Ink Free", Font.BOLD, 40));
            FontMetrics metrics= getFontMetrics(g.getFont());
            g.drawString("SCORE: "+appleeaten, (SCREEN_WIDTH-metrics.stringWidth("SCORE: "+appleeaten))/2,g.getFont().getSize());
         }
        else
         gameOver(g);
    }

    public void move(){
          for(int i=bodyparts;i>0;i--){
            x[i]=x[i-1];
            y[i]=y[i-1];
          }
          switch(direction){
            case 'U': y[0]=y[0]-UNIT_SIZE;
            break;
            case 'D': y[0]=y[0]+UNIT_SIZE;
            break;
            case 'L': x[0]=x[0]-UNIT_SIZE;
            break;
            case 'R': x[0]=x[0]+UNIT_SIZE;
            break;
          }
    }

    public void checkApple(){
        if(x[0]==appleX && y[0]==appleY){
            appleeaten=appleeaten+1;
            bodyparts+=1;
            newapple();
        }

    }

    public void gameOver(Graphics g){

        g.setColor(Color.red);
        g.setFont(new Font("Ink Free", Font.BOLD, 40));
        FontMetrics metrics1= getFontMetrics(g.getFont());
        g.drawString("SCORE: "+appleeaten, (SCREEN_WIDTH-metrics1.stringWidth("SCORE: "+appleeaten))/2,g.getFont().getSize());

        g.setColor(Color.red);
        g.setFont(new Font("Ink Free", Font.BOLD, 80));
        FontMetrics metrics2= getFontMetrics(g.getFont());
        g.drawString("GAME OVER", (SCREEN_WIDTH-metrics2.stringWidth("GAME OVER"))/2,SCREEN_HEIGHT/2);

    }

    public void checkCollision(){
        for(int i=bodyparts;i>0;i--){
            if(x[0]==x[i] && (y[0]==y[i])){
                running=false;
            }
        }
        if(x[0]<0){
            running=false;
        }
         if(x[0]>SCREEN_WIDTH){
            running=false;
        }
        if(y[0]<0){
            running=false;
        }
        if(y[0]>SCREEN_HEIGHT){
            running=false;
        }
       if(running==false)
       timer.stop();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(running){
            move();
            checkApple();
            checkCollision();
        }
        repaint();
    }

   public class MyKeyAdapter extends KeyAdapter{
       @Override
       public void keyPressed(KeyEvent e){
        switch(e.getKeyCode()){
            case KeyEvent.VK_RIGHT: if(direction!='L'){
                direction='R';
            }
            break;
            case KeyEvent.VK_LEFT: if(direction!='R'){
                direction='L';
            }
            break;
            case KeyEvent.VK_UP: if(direction!='D'){
                direction='U';
            }
            break;
            case KeyEvent.VK_DOWN: if(direction!='D'){
                direction='D';
            }
            break;
        }

       }
    }
    
}
