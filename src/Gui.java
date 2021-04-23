import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Gui extends JFrame {
    Container mainContainer = this.getContentPane();
    CardLayout cl = new CardLayout();


    public Gui(String title){
        super(title);
        this.setSize(600,600);
        this.setLocation(100,100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainContainer.setLayout(cl);
        mainContainer.add(showTrajects(),"1");

        cl.show(mainContainer,"1");


    }

    public JPanel showTrajects(){
        JPanel panel = new JPanel(new BorderLayout());

        panel.setLayout(new GridLayout(2,2));



        //JPanel test = new JPanel(new GridLayout(0,2));


        List<String> myList = new ArrayList<>(10);

        for (int index = 0; index < 50; index++) {
            myList.add("List Item " + index);
        }
        final JList<String> list = new JList<String>(myList.toArray(new String[myList.size()]));
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(list);
        list.setLayoutOrientation(JList.VERTICAL);
        panel.add(scrollPane);

        return panel;


    }

    public JPanel navigateGui(){
        JPanel navigatePanel = new JPanel();

        navigatePanel.setLayout(new BorderLayout(8,6));



        ////////////////////////////////
        ///         top       /////////
        ///////////////////////////////
        JPanel topPanel = new JPanel();
        topPanel.setBorder(new LineBorder(Color.black, 3));;
        topPanel.setLayout(new GridBagLayout());
        navigatePanel.add(topPanel, BorderLayout.NORTH);

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
        center.setBorder(new LineBorder(Color.black, 3));;
        center.setLayout(new GridLayout(3,1));
        navigatePanel.add(center, BorderLayout.CENTER);




        JTextField fromTextField = new JTextField();
        JTextField toTextField = new JTextField();
        JLabel toLabel = new JLabel("to");
        JLabel fromLabel = new JLabel("from");


        //set size textfields
        fromTextField.setPreferredSize(new Dimension(200, 20));
        toTextField.setPreferredSize(new Dimension(200, 20));


        //center textfield
        JPanel centerTextfields = new JPanel();
        centerTextfields.setLayout(new GridLayout(3,1,0,20));
        centerTextfields.add(fromTextField);
        centerTextfields.add(toTextField);

        //navigate
        centerTextfields.add(new JButton("Navigate"));

        //center labels
        JPanel centerLabels = new JPanel();
        centerLabels.setLayout(new GridLayout(3,1,0,20));
        centerLabels.add(toLabel);
        centerLabels.add(fromLabel);
        centerLabels.add(new JLabel());

        JPanel centerGrid = new JPanel();
        centerGrid.setLayout(new GridBagLayout());
        centerGrid.add(centerLabels);
        centerGrid.add(centerTextfields);

        //radio buttons
        JRadioButton r1=new JRadioButton("Bus");
        JRadioButton r2=new JRadioButton("Trein");
        r1.setBounds(75,50,100,30);
        r2.setBounds(75,100,100,30);
        ButtonGroup bg=new ButtonGroup();
        bg.add(r1);bg.add(r2);

        JPanel radioButtons = new JPanel();
        radioButtons.setLayout(new FlowLayout());

        radioButtons.add(r1);
        radioButtons.add(r2);

        center.add(radioButtons);




        center.add(centerGrid);

        ///////////////////////////////
        //          bottom          //
        //////////////////////////////
        JPanel bottom = new JPanel();
        bottom.setLayout(new GridBagLayout());
        bottom.setBorder(new LineBorder(Color.black, 3));;
        bottom.setLayout(new GridBagLayout());


        navigatePanel.add(bottom, BorderLayout.SOUTH);

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




        return navigatePanel;

    }
    public static void main(String args[]){
        Gui myLayout = new Gui("OV app");


        myLayout.setVisible(true);
    }
}
