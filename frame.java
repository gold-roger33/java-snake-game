import java.awt.*;
import javax.swing.*;
import java.util.Random;


public class frame extends JFrame{

public frame()
      {

        setTitle("Snake Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400, 50, 600, 600);
        
        
         JPanel snakPanel =new JPanel(){
        
           protected void paintComponent(Graphics g) {
           super.paintComponent(g);

           int x=1;
           int n=3;
            
           for(int i=0;i<n;i++){
           g.setColor(Color.green);
           g.fillOval(100,100+x,20, 20); 
           x=x+17;
           }
        }
        
        };  
           snakPanel.setBackground(Color.BLACK);                    
            add(snakPanel);
            setVisible(true);    

        
         

          JPanel apple = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                     super.paintComponent(g);

                     Random rx =new Random();
                     Random ry =new Random();

                     int x=rx.nextInt(getWidth()-50);
                     int y=ry.nextInt(getWidth()-60);

                    g.setColor(Color.red);
                    g.fillOval(x,y,20, 20); 
                    
                    
                }
            };
            apple.setBackground(Color.BLACK);                    
            add(apple);
            setVisible(true);  

          
         
    }

}
