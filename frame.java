import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;



public class frame extends JFrame implements ActionListener {

static final int UNIT_SIZE=25;
static final int GAME_UNIT=(600 * 600)/UNIT_SIZE;
int delay = 180;

 int X_ARRAY[]= new int[GAME_UNIT];
 int Y_ARRAY[]= new int[GAME_UNIT];

int body=3;
int score=0;
int X_apple, Y_apple;
char direction='U';
boolean running=false;
boolean appleeaten=false;
Timer timer;

public frame() {
        setTitle("Snake Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400, 50, 625, 700);
        
        for (int i = 0; i < body; i++) {
          X_ARRAY[i] = 250 - i * UNIT_SIZE;
          Y_ARRAY[i] = 250;
          }
  
         JPanel snakPanel =new JPanel(){   
           public void paintComponent(Graphics g) {
           super.paintComponent(g);
    
          /*      
           for(int i=0;i<600/UNIT_SIZE;i++){
           g.drawLine(i*UNIT_SIZE,0,i*UNIT_SIZE,600);  
           g.drawLine(0,i*UNIT_SIZE,600,i*UNIT_SIZE);  
           } */  

           for(int i=0;i<body;i++){
            if(i==0){
              g.setColor(Color.GRAY);
              g.fillRect(X_ARRAY[i],Y_ARRAY[i],UNIT_SIZE,UNIT_SIZE);
            }
            else{
               g.setColor(Color.green);
              g.fillRect(X_ARRAY[i],Y_ARRAY[i],UNIT_SIZE,UNIT_SIZE);
            }
           }        

            for(int i=0;i<650;i++){
            g.setColor(Color.white);
            g.drawRect(i,600,10,10);
           }
            g.setColor(Color.red);
            g.fillOval(X_apple,Y_apple,20, 20);


            if(appleeaten=true){
              g.setColor(Color.YELLOW);
              g.setFont(new Font("Britannic Bold", Font.BOLD,50));
              g.drawString("score :"+score,200,650);
              }

            if (!running) {
            String message = "Game Over!" ;
                    g.setColor(Color.RED);
                    g.setFont(new Font("times new roman", Font.BOLD, 70));
                    g.drawString(message, 100, 300);
        }
      }
        
    };
           snakPanel.setBackground(Color.BLACK);                    
            add(snakPanel);
            setVisible(true); 
            addKeyListener(new MyKeyAdapter());
            startgame();


    }

     private void moveSnake() {

        for(int i=body;i>0;i--) {
        X_ARRAY[i] = X_ARRAY[i - 1];
        Y_ARRAY[i] = Y_ARRAY[i - 1];
      }
      
       switch (direction){
        case 'U':
        Y_ARRAY[0] =Y_ARRAY[0] -UNIT_SIZE;
        break;
        
        case 'D':
        Y_ARRAY[0] =Y_ARRAY[0] + UNIT_SIZE;
        break;

        case 'R':
        X_ARRAY[0] =X_ARRAY[0]+ UNIT_SIZE;
        break;

        case 'L':
        X_ARRAY[0] =X_ARRAY[0] - UNIT_SIZE;
        break;

        default:
      }
    }


      public void startgame(){
        randomapple();
        running=true;
        timer = new Timer(delay, this);
        timer.start();

      }

        public void randomapple(){
           Random rx =new Random();
           Random ry =new Random();

           do {
            X_apple = rx.nextInt(24) * UNIT_SIZE;
            Y_apple = ry.nextInt(24) * UNIT_SIZE;
        } while (appleHitsSnake()); }
    
       private boolean appleHitsSnake() {
        for (int i = 0; i < body; i++) {
            if (X_ARRAY[i] == X_apple && Y_ARRAY[i] == Y_apple) {
                return true; 
            }
        }
        return false; 
    }


          private void appleeaten(){

            if(X_ARRAY[0]== X_apple && Y_ARRAY[0]==Y_apple){
             
              appleeaten=true;
              score=score+5;
              randomapple();
              delay=delay-5;
              System.out.print(delay);
              body++;
            } 
          }          

      private void checkCollision(){
      for(int i=1;i<=body;i++){

      if(X_ARRAY[0]==X_ARRAY[i] && Y_ARRAY[0] ==Y_ARRAY[i] )
      {
        System.out.println("BODY HIT");
         gameover();
      }}
      
      if (X_ARRAY[0] <0 || X_ARRAY[0] >= 575 || Y_ARRAY[0] <0 || Y_ARRAY[0] >= 575) {
        System.out.println("BORDER HIT");
        gameover();
      }
    }
 
    private void gameover() {
      running = false;
      timer.stop();
  }
  
     @Override
     public void actionPerformed(ActionEvent e) {
      if(running){
        moveSnake();
        appleeaten();
        checkCollision();
      }
        repaint();
  
    }
    
    
  
     public class MyKeyAdapter extends KeyAdapter {
          @Override
          public void keyPressed(KeyEvent e) {
              int key = e.getKeyCode();
              
              if (key == KeyEvent.VK_UP && direction != 'D') {
                  direction = 'U';
                  System.out.println("UP ARROW");
              } else if (key == KeyEvent.VK_DOWN && direction != 'U') {
                  direction = 'D';
                  System.out.println("DOWN ARROW");
              } else if (key == KeyEvent.VK_LEFT && direction != 'R') {
                  direction = 'L';
                  System.out.println("LEFT ARROW");
              } else if (key == KeyEvent.VK_RIGHT && direction != 'L') {
                  direction = 'R';
                  System.out.println("RIGHT ARROW");
                  }
              }
          }
        }
        