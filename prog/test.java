package prog;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Random;

public class test {
    public static void main(String[] args){
        JFrame frame = new JFrame("Test"); //lag ny fane

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //hva skjer når fanen lukkes?



        JPanel panel = new JPanel(); //panel??
        panel.setLayout(new FlowLayout()); //???

        //knapp
        JButton button = new JButton();
        button.setText("button");
        panel.add(button);

        frame.add(panel);

        frame.setSize(400,200); //size
        frame.setVisible(true); //vis

        run(frame);


    }

    public static void run(JFrame frame){
        
        Random random = new Random();

        int x = random.nextInt(1);
        int y = random.nextInt(1);

        System.out.println(x);
        System.out.println(y);

        //frame.getWidth();

        int topOffsett = frame.getHeight();// - frame.getContentPane().getSize().height;
        y = y + topOffsett;

        int vx = 2;
        int vy = 2;

        long lastime = System.currentTimeMillis();
        long curtime = System.currentTimeMillis();

        while(true){
            curtime = System.currentTimeMillis();

            if(curtime - lastime > 30){
                frame.setLocation(x, y);

                x = x + vx;
                y = y + vy;

                lastime = curtime;

            }

        }
    }
}

