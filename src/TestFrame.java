import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;

public class TestFrame extends JFrame {

    private PassWordDialog passDialog;

    public TestFrame() {
        passDialog = new PassWordDialog(this, true);
        passDialog.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new TestFrame();
                frame.getContentPane().setBackground(Color.BLACK);
                frame.setTitle("Logged In");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
        });
    }
}

class PassWordDialog extends JDialog {





    public PassWordDialog() {
        this(null, true);
    }

    public PassWordDialog(final JFrame parent, boolean modal) {
        super(parent, modal);

        JButton jbtCancel = new JButton("Cancel");
        JButton jbtOk = new JButton("Login");
        JLabel jlblUsername = new JLabel("Username");
        JLabel jlblPassword = new JLabel("Password");
        JPasswordField jpfPassword = new JPasswordField();
        JTextField jtfUsername = new JTextField(15);
        JLabel jlblStatus = new JLabel(" ");

        JPanel p3 = new JPanel(new GridLayout(2, 1));
        p3.add(jlblUsername);
        p3.add(jlblPassword);

        JPanel p4 = new JPanel(new GridLayout(2, 1));
        p4.add(jtfUsername);
        p4.add(jpfPassword);

        JPanel p1 = new JPanel();
        p1.add(p3);
        p1.add(p4);


        JPanel p2 = new JPanel();
        p2.add(jbtOk);
        p2.add(jbtCancel);


        setLayout(new BorderLayout());
        add(p1, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });


        jbtOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Arrays.equals("stackoverflow".toCharArray(), jpfPassword.getPassword())
                        && "stackoverflow".equals(jtfUsername.getText())) {
                    parent.setVisible(true);
                    setVisible(false);
                } else {
                    jlblStatus.setText("Invalid username or password");
                }
            }
        });
        jbtCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                parent.dispose();
                System.exit(0);
            }
        });
    }
}