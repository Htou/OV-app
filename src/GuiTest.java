import java.awt.*;
import javax.swing.*;

public class GuiTest {





    public static void test2(){
        //Creating object of LoginFrame class and setting some of its properties
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("JFrame Test");
        frame.setLayout(new GridLayout(4, 2));
        frame.add(new JLabel("First Name:"));
        frame.add(new JTextField());
        frame.add(new JLabel("Last Name:"));
        frame.add(new JTextField());
        frame.add(new JButton("Register"));

        int frameWidth = 200;
        int frameHeight = 100;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds((int) screenSize.getWidth() - frameWidth, 0, frameWidth, frameHeight);
        frame.setVisible(true);
    }
    public static void test() {
        JFrame f = new JFrame();

        //settings
        f.getContentPane().setBackground(new Color(255,255,255));


        JButton button;

        JPanel p = new JPanel();

        p.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JTextField textfield1 = new JTextField();
        JTextField textfield2 = new JTextField();




        textfield1.setPreferredSize(new Dimension(200, 20));
        textfield2.setPreferredSize(new Dimension(200, 20));



        //center
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        //buttons
        gbc.insets = new Insets(20, 0, 0, 0);
        p.add(textfield1,gbc);
        p.add(textfield2,gbc);




        f.setDefaultCloseOperation(3);
        f.setSize(800, 800);
        f.setVisible(true);
        f.add(p);
        // setLayout(null);
    }
}