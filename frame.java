import java.awt.*;
import javax.swing.*;
import java.util.Random;



public class frame extends JFrame  {

static int UNIT_SIZE=25;
static int GAME_UNIT=(600*600)/UNIT_SIZE;

int X_ARRAY[]= new int[GAME_UNIT];
int Y_ARRAY[]= new int[GAME_UNIT];

int bodypart=6;
char direction='U';

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
           

           Random rx =new Random();
           Random ry =new Random();
        
           int X_apple=rx.nextInt(25)*UNIT_SIZE;
           int Y_apple=ry.nextInt(25)*UNIT_SIZE;




           for(int i=1;i<bodypart;i++){

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
      for (int i = bodypart - 1; i > 0; i--) {
        X_ARRAY[i] = X_ARRAY[i - 1];
        Y_ARRAY[i] = Y_ARRAY[i - 1];
      }

      
      }
    }












/* 
    checkcollion(){


    }

    gamestart(){



    }
    gameover(){
      
    }
*/