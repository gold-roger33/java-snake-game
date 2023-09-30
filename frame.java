import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;



public class frame extends JFrame implements ActionListener {

static int UNIT_SIZE=25;
static int GAME_UNIT=(600*600)/UNIT_SIZE;

int X_ARRAY[]= new int[GAME_UNIT];
int Y_ARRAY[]= new int[GAME_UNIT];
int X_apple, Y_apple;

int body=6;
char direction='U';
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



           for(int i=1;i<body;i++){

            if(i==0){
              g.setColor(Color.GREEN);
              g.drawRect(X_ARRAY[i],Y_ARRAY[i],UNIT_SIZE,UNIT_SIZE);
            }
            else{
              g.setColor(Color.green);
              g.drawRect(X_ARRAY[i],Y_ARRAY[i],UNIT_SIZE,UNIT_SIZE);
            }
           }        


            g.setColor(Color.red);
            g.fillOval(X_apple,Y_apple,20, 20); 
                  
        }
        
        };
           snakPanel.setBackground(Color.BLACK);                    
            add(snakPanel);
            setVisible(true); 

            
        timer = new Timer(100, this);
        timer.start();

        X_apple = Y_apple = 100; 
          
         
    }
       private void moveSnake() {
      
       switch (direction){
        case 'U':
        Y_ARRAY[0] -= UNIT_SIZE;
        break;
        
        case 'D':
        Y_ARRAY[0] += UNIT_SIZE;
        break;

        case 'R':
        X_ARRAY[0] += UNIT_SIZE;
        break;

        case 'L':
        X_ARRAY[0] -= UNIT_SIZE;
        break;

        default:
      }
      for (int i = body - 1; i > 0; i--) {
        X_ARRAY[i] = X_ARRAY[i - 1];
        Y_ARRAY[i] = Y_ARRAY[i - 1];
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
    
    
     private void checkcollion(){
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

    }

    public void gamestart(){
      moveSnake();
    }  
    @Override
    public void actionPerformed(ActionEvent e) {
        moveSnake();
        checkcollision();
        repaint(); // Repaint the panel
    }
  }