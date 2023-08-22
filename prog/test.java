package prog;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.FlowLayout;

public class test {
    public void main(String[] args){
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
        frame.setLocationRelativeTo(null); //lag i midten av skjermen
        frame.setVisible(true); //vis

        run(frame);


    }

    public void run(JFrame frame){
            int a = 0;
            int b = 0;
            long lastime = System.currentTimeMillis();
            long curtime = System.currentTimeMillis();

            while(true){

                
                frame.setLocation(a, b);

                a = a + 1;
                b = b + 1;

            }
        }
}

