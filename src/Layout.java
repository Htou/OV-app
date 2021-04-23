import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.ComboPopup;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.concurrent.Flow;

public class Layout extends JFrame {
    public Layout (String title){
        super(title);
        this.setSize(600,600);
        this.setLocation(100,100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        Container mainContainer = this.getContentPane();
        mainContainer.setLayout(new BorderLayout(8,6));
        mainContainer.setBackground(Color.WHITE);
        //this.getRootPane().setBorder(BorderFactory.createMatteBorder(4,4,4,4,Color.GREEN));


        ////////////////////////////////
        ///         top       /////////
        ///////////////////////////////
        JPanel topPanel = new JPanel();
        topPanel.setBorder(new LineBorder(Color.black, 3));;
        topPanel.setLayout(new GridBagLayout());
        mainContainer.add(topPanel, BorderLayout.NORTH);

        GridBagConstraints gbc = new GridBagConstraints();



        JButton login = new JButton("Login");
        gbc.insets = new Insets(0, 0, 0, 200);
        topPanel.add(login,gbc);
        gbc.insets = new Insets(0, 200, 0, 0);


        String[] comboBoxItems = { "Settings1", "Settings2" };
        JComboBox<String> cb = new JComboBox<>(comboBoxItems);
        cb.setEditable(false);
        topPanel.add(cb);


        //////////////////////
        ///     center      //
        //////////////////////
        JPanel center = new JPanel();
        center.setLayout(new GridBagLayout());

        center.setBorder(new LineBorder(Color.black, 3));;
        center.setLayout(new GridBagLayout());
        mainContainer.add(center, BorderLayout.CENTER);




        JTextField fromTextField = new JTextField();
        JTextField toTextField = new JTextField();
        JLabel toLabel = new JLabel("to");
        JLabel fromLabel = new JLabel("from");


        //set size textfields
        fromTextField.setPreferredSize(new Dimension(200, 20));
        toTextField.setPreferredSize(new Dimension(200, 20));


        //center textfield
        JPanel centerTextfields = new JPanel();
        centerTextfields.setLayout(new GridLayout(2,1,0,20));
        centerTextfields.add(fromTextField);
        centerTextfields.add(toTextField);

        //center labels
        JPanel centerLabels = new JPanel();
        centerLabels.setLayout(new GridLayout(2,1,0,20));
        centerLabels.add(toLabel);
        centerLabels.add(fromLabel);

        JPanel centerCenter = new JPanel();
        centerCenter.setLayout(new GridBagLayout());
        centerCenter.add(centerLabels);
        centerCenter.add(centerTextfields);



        JPanel navigateOptions = new JPanel();
        navigateOptions.setLayout(new GridBagLayout());

        center.add(centerCenter);

        gbc.gridx = 0;
        gbc.gridy = 4;
        center.add(new Button("Navigate"),gbc);




        ///////////////////////////////
        //          bottom          //
        //////////////////////////////
        JPanel bottom = new JPanel();
        bottom.setLayout(new GridBagLayout());
        bottom.setBorder(new LineBorder(Color.black, 3));;
        bottom.setLayout(new GridBagLayout());


        mainContainer.add(bottom, BorderLayout.SOUTH);






        JPanel bottomTop = new JPanel();
        bottomTop.setLayout(new FlowLayout());
        bottomTop.setBorder(new LineBorder(Color.green, 3));

        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.gridx = 3;
        gbc.gridy = 0;
        bottom.add(bottomTop,gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;

        bottom.add(new Button("test"),gbc);







    }
    public static void main(String args[]){
        Layout myLayout = new Layout("OV app");

        myLayout.setVisible(true);
    }
}
