package prog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;

import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.util.Random;

public class test {
    public static void main(String[] args){



        JFrame frame = new JFrame("Test"); //lag ny fane

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //hva skjer når fanen lukkes?

        JPanel panel = new JPanel(); //panel??
        panel.setLayout(new FlowLayout()); //???

        frame.add(panel);

        frame.setSize(400,200); //size
        frame.setVisible(true); //vis


        run(frame, panel);


    }

    public static void run(JFrame frame, JPanel panel){
        
        Random random = new Random();

        int x = random.nextInt(50);
        int y = random.nextInt(50);

        int dimx = Toolkit.getDefaultToolkit().getScreenSize().width;
        int dimy = Toolkit.getDefaultToolkit(). getScreenSize().height;

        System.out.println(x);
        System.out.println(y);

        //frame.getWidth();

        int topOffsett = frame.getHeight() - frame.getContentPane().getSize().height;
        y = y + topOffsett;

        int vx = 2;
        int vy = 2;

        y = y + topOffsett/4;

        System.out.println(dimy);

        long lastime = System.currentTimeMillis();
        long curtime = System.currentTimeMillis();

        while(true){
            curtime = System.currentTimeMillis();
            

            if(curtime - lastime > 15){
                frame.setLocation(x, y);
                
                if(x > dimx - frame.getWidth()){
                    vx = - vx;
                    panel.setBackground(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
                }

                if (x < 0){
                    vx = - vx;
                    panel.setBackground(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
                }

                if (y > dimy - frame.getHeight()){
                    vy = - vy;
                    panel.setBackground(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
                }

                if (y < frame.getHeight() - frame.getContentPane().getSize().height + 10){
                    vy = - vy;
                    panel.setBackground(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
                }
                x = x + vx;
                y = y + vy;

                lastime = curtime;


            }
        }
    }
}

