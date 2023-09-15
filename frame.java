import java.awt.*;
import javax.swing.*;
import java.util.Random;


public class frame extends JFrame{

public frame()
      {

        setTitle("Snake Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400, 50, 600, 600);

         JPanel panel = new JPanel() {
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
            panel.setBackground(Color.BLACK);                    
            add(panel);
            setVisible(true);

    }

}
