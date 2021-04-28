import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Gui extends JFrame {
    Container mainContainer = this.getContentPane();
    CardLayout cl = new CardLayout();

    Gui() {
    }


    public Gui(String title) {
        super(title);
        this.setSize(600, 600);
        this.setLocation(100, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainContainer.setLayout(cl);
        mainContainer.add(navigateGui(), "1");
        mainContainer.add(showTrajectsGui(), "2");
        mainContainer.add(showTrackPanelGui(), "3");

        cl.show(mainContainer, "2");
    }

    public JPanel navigateGui() {
        JPanel navigatePanel = new JPanel();

        navigatePanel.setLayout(new BorderLayout(8, 6));


        ////////////////////////////////
        ///         top       /////////
        ///////////////////////////////
        navigatePanel.add(loginAndSettings(), BorderLayout.NORTH);

        GridBagConstraints gbc = new GridBagConstraints();


        //////////////////////
        ///     center      //
        //////////////////////
        JPanel center = new JPanel();
        center.setBorder(new LineBorder(Color.black, 3));
        ;
        center.setLayout(new GridLayout(3, 1));
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
        centerTextfields.setLayout(new GridLayout(3, 1, 0, 20));
        centerTextfields.add(fromTextField);
        centerTextfields.add(toTextField);

        //navigate
        JButton navigate = new JButton("Navigate");
        centerTextfields.add(navigate);
        navigate.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                cl.show(mainContainer, "2");


            }
        });



        //center labels
        JPanel centerLabels = new JPanel();
        centerLabels.setLayout(new GridLayout(3, 1, 0, 20));
        centerLabels.add(toLabel);
        centerLabels.add(fromLabel);
        centerLabels.add(new JLabel());

        JPanel centerGrid = new JPanel();
        centerGrid.setLayout(new GridBagLayout());
        centerGrid.add(centerLabels);
        centerGrid.add(centerTextfields);

        //radio buttons
        JRadioButton r1 = new JRadioButton("Bus");
        JRadioButton r2 = new JRadioButton("Trein");
        r1.setBounds(75, 50, 100, 30);
        r2.setBounds(75, 100, 100, 30);
        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);

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
        bottom.setBorder(new LineBorder(Color.black, 3));

        bottom.setLayout(new BorderLayout());


        navigatePanel.add(bottom, BorderLayout.SOUTH);





        bottom.add(languagePanel());


        return navigatePanel;

    }

    public JPanel showTrajectsGui() {
        JPanel panel = new JPanel(new BorderLayout(8, 6));

        JPanel panelCenter = new JPanel(new BorderLayout());
        JPanel panelNorth = new JPanel(new GridLayout());
        JPanel panelSouth = new JPanel(new GridLayout());

        panel.add(panelCenter, BorderLayout.CENTER);
        panel.add(panelNorth, BorderLayout.NORTH);
        panel.add(panelSouth, BorderLayout.SOUTH);

        JPanel panelCenterCenter = new JPanel(new GridLayout(1, 2));
        JPanel panelCenterNorth = new JPanel(new GridLayout(1, 2));

        panelCenter.add(panelCenterCenter, BorderLayout.CENTER);
        panelCenter.add(panelCenterNorth, BorderLayout.NORTH);


        panelCenterNorth.add(new JLabel("Departure"));
        panelCenterNorth.add(new JLabel("Arrival"));

        panelCenterCenter.add(new JLabel("Amsterdam"));

        List<String> myList = new ArrayList<>();
        for (int index = 0; index < 40; index++) {
            myList.add("List Item " + index);
        }

        final JList<String> list = new JList<String>(myList.toArray(new String[myList.size()]));
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(list);
        list.setLayoutOrientation(JList.VERTICAL);
        panelCenterCenter.add(scrollPane);

        ////////////////////////////////
        ///         top       /////////
        ///////////////////////////////
        panel.add(loginAndSettings(), BorderLayout.NORTH);



        /////////////////////////
        //      bottom      ////
        ////////////////////////

        panelSouth.add(languagePanel());
        return panel;


    }

    public JPanel showTrackPanelGui() {
        JPanel panel = new JPanel(new BorderLayout());
        JPanel panelCenter = new JPanel(new GridLayout(1, 2));
        JPanel panelSouth = new JPanel(new GridLayout());

        panel.add(loginAndSettings(), BorderLayout.NORTH); //north
        panel.add(panelCenter, BorderLayout.CENTER);
        panel.add(panelSouth, BorderLayout.SOUTH);

        panelCenter.setBorder(new LineBorder(Color.blue, 3));
        panelSouth.setBorder(new LineBorder(Color.green, 3));


        ////////////////////////////////
        ///         Center      ////////
        ///////////////////////////////
        JPanel centerPanelRight = new JPanel(new GridBagLayout());
        panelCenter.add(new JButton("Map"));
        panelCenter.add(centerPanelRight);

        /////////////////////////
        //      bottom      ////
        ////////////////////////

        panelSouth.add(languagePanel());

        return panel;
    }

    public JPanel loginAndSettings(){
        JPanel topPanel = new JPanel();
        topPanel.setBorder(new LineBorder(Color.black, 3));
        topPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        JButton login = new JButton("Login");
        gbc.insets = new Insets(0, 0, 0, 200);
        topPanel.add(login, gbc);
        gbc.insets = new Insets(0, 200, 0, 0);


        String[] comboBoxItems = {"Settings1", "Settings2"};
        JComboBox<String> cb = new JComboBox<>(comboBoxItems);
        cb.setEditable(false);
        topPanel.add(cb);

        return topPanel;


    }

    public JPanel languagePanel(){
        JPanel language = new JPanel(new GridLayout(1,4));

        //add empty spaces to bottom grid
        language.add(new JLabel());
        language.add(new JLabel());

        //language label
        JPanel languageLabel = new JPanel(new GridLayout(1,2));
        language.add(languageLabel);
        languageLabel.add(new JLabel());
        languageLabel.add(new JLabel("Language:"));


        String[] comboBoxItems = {"English", "Dutch"};
        JComboBox<String> cb = new JComboBox<>(comboBoxItems);
        cb.setEditable(false);
        cb.setSelectedIndex(0);
        language.add(cb);



        return language;

    }

    public void startGui() {
        Gui myLayout = new Gui("OV app");
        myLayout.setVisible(true);
    }

    Public ResourceBundle = messages (String word);
    ResourceBundle messages = ResourceBundle.getBundle(String word);



}
