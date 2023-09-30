import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;



public class frame extends JFrame implements ActionListener {

static int UNIT_SIZE=25;
static int GAME_UNIT=(600*600)/UNIT_SIZE;

final int X_ARRAY[]= new int[GAME_UNIT];
final int Y_ARRAY[]= new int[GAME_UNIT];
int X_apple, Y_apple;

int body=6;
char direction='U';
boolean running=false;
Timer timer;

public frame()
      {

        setTitle("Snake Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400, 50, 600, 600);
        
        
         JPanel snakPanel =new JPanel(){   


           protected void paintComponent(Graphics g) {
           super.paintComponent(g);
          
            
            
           for(int i=0;i<600/UNIT_SIZE;i++){
           g.drawLine(i*UNIT_SIZE,0,i*UNIT_SIZE,600);  
           g.drawLine(0,i*UNIT_SIZE,600,i*UNIT_SIZE);  
           }   


           
           for(int i=0;i<body;i++){

            if(i==0){
              g.setColor(Color.blue);
              g.fillRect(X_ARRAY[i],Y_ARRAY[i],UNIT_SIZE,UNIT_SIZE);
            }
            else{
               g.setColor(Color.green);
              g.fillRect(X_ARRAY[i],Y_ARRAY[i],UNIT_SIZE,UNIT_SIZE);
            }
           }        


            g.setColor(Color.red);
            g.fillOval(X_apple,Y_apple,20, 20); 
                  
        }
        
        };
           snakPanel.setBackground(Color.BLACK);                    
            add(snakPanel);
            setVisible(true); 


        for (int i = 0; i < body; i++) {
          X_ARRAY[i] = 250 - i * UNIT_SIZE;
          Y_ARRAY[i] = 250;
      }

        X_apple = Y_apple = 100; 

        addKeyListener(new KeyAdapter() {
          @Override
          public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            if (key == KeyEvent.VK_UP && direction != 'D') {
              direction = 'U';
          } else if (key == KeyEvent.VK_DOWN && direction != 'U') {
              direction = 'D';
          } else if (key == KeyEvent.VK_LEFT && direction != 'R') {
              direction = 'L';
          } else if (key == KeyEvent.VK_RIGHT && direction != 'L') {
              direction = 'R';
              }
          }
      });
      setFocusable(true);
      requestFocusInWindow();
         
    }

      public void startgame(){
        randomapple();
        running=true;
        timer = new Timer(25, this);
        timer.start();

      }

       private void moveSnake() {

        for (int i = body-1; i > 0; i--) {
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
     private void appleeaten(){

      if(X_ARRAY[0]== X_apple && Y_ARRAY[0]==Y_apple){

        randomapple();
        body++;
      } 
    }
       private void randomapple()
            {
           Random rx =new Random();
           Random ry =new Random();
           X_apple=rx.nextInt(25)*UNIT_SIZE;
           Y_apple=ry.nextInt(25)*UNIT_SIZE;
          }
    
    
     private void checkCollision(){
      for(int i=1;i<=body;i++){

      if(X_ARRAY[0]==X_ARRAY[i] && Y_ARRAY[0] ==Y_ARRAY[i] )
      {
        gameover();
      }}
      
      if (X_ARRAY[0] < 0 || X_ARRAY[0] >= 600 || Y_ARRAY[0] < 0 || Y_ARRAY[0] >= 600) {
        gameover();
      }
    }

    private void gameover(Graphics g){
      g.setColor(Color.WHITE);
      g.setFont(new Font("arial", Font.BOLD, 50));
      g.drawString("Game Over", 550, 300);
      timer.stop();
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
      if(running){
        moveSnake();
        randomapple();
        checkCollision();
        appleeaten();
      }
        repaint(); // Repaint the panel
  
    }
  }