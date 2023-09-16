import java.awt.*;
import javax.swing.*;
import java.util.Random;


public class frame extends JFrame{

static int UNIT_SIZE=25;
static int GAME_UNIT=(600*600)/UNIT_SIZE;


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




           int x=1;
           int n=3;
           Random rx =new Random();
           Random ry =new Random(); 
           int X_apple=rx.nextInt(getWidth()-50);
           int Y_apple=ry.nextInt(getWidth()-60);

           
           for(int i=0;i<n;i++){
           g.setColor(Color.green);
           g.fillOval(100,100+x,20, 20); 
           x=x+17;
           }
         

            g.setColor(Color.red);
            g.fillOval(X_apple,Y_apple,20, 20); 
                  
        }
        
        };
           snakPanel.setBackground(Color.BLACK);                    
            add(snakPanel);
            setVisible(true); 

          
         
    }

}
