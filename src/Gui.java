import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

public class Gui extends JFrame {
    private ResourceBundle messages;
    private JComboBox<Language> comboBox;
    private Container mainContainer;
    private CardLayout cl;


    private int selectedPanel;
    private int previousPanel;
    // because swing is retarded a copy needs to be made of locationB
    // inside of the GUI because we can't call other methods from the methods in here.
    private ArrayList<LocalTime> times;
    private LocalTime time;
    private double distance = 0.0;
    private ArrayList<String> trajectoryStations = new ArrayList<String>();
    private String locationB;
    private String locationA;
    private interfaceContainer interfaceContainer;
    private ArrayList<String> departureList = new ArrayList<String>();
    private ArrayList<String> arrivalList = new ArrayList<String>();

    private int selectedLanguageOptionComboBox=0;

    //for navigate gui
    private int departureSelectedIndex = 0;
    private int arrivalSelectedIndex = 0;
    private String vehicleIdentifier;

    public Gui() {
        this.setSize(600, 600);
        this.setLocation(100, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainContainer = this.getContentPane();
        cl = new CardLayout();

        vehicleIdentifier = "train";

        times = new ArrayList<>();

        String str = "00:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        time = LocalTime.parse(str, formatter);

        mainContainer.setLayout(cl);
        selectedPanel = 2;

        this.interfaceContainer = new interfaceContainer();
        this.messages = interfaceContainer.messages;
        this.setTitle(messages.getString("Title"));


        updatePanel();
    }


    public void updatePanel() {
        previousPanel = selectedPanel;
        switch (selectedPanel) {
            case 1: {
                mainContainer.add(navigateGui(), "1");
                break;
            }
            case 2: {
                mainContainer.add(trajectorysGui(), "2");
                break;
            }
            case 3: {
                mainContainer.add(trackPanelGui(), "3");
                break;
            }
        }
        cl.show(mainContainer, Integer.toString(selectedPanel));

    }

    private JPanel navigateGui() {
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

        center.setLayout(new GridLayout(3, 1));
        navigatePanel.add(center, BorderLayout.CENTER);

        JComboBox<String> departureComboBox = new JComboBox<>();
        for (String value : departureList) {
            departureComboBox.addItem(value);
        }
        JComboBox<String> arrivalComboBox = new JComboBox<>();
        for (String value : arrivalList) {
            arrivalComboBox.addItem(value);
        }
        try {
            arrivalComboBox.setSelectedIndex(arrivalSelectedIndex);
            departureComboBox.setSelectedIndex(departureSelectedIndex);
        } catch (Exception e) {
        }

        arrivalComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (arrivalComboBox.getSelectedIndex() == 0) { // if the first selection is selected than we just fill in null so the list is complete
                    departureList = interfaceContainer.routeData.getPossibleDepartureStation(null);
                } else {
                    departureList = interfaceContainer.routeData.getPossibleDepartureStation(arrivalComboBox.getSelectedItem().toString());
                }

                arrivalSelectedIndex = arrivalComboBox.getSelectedIndex();
                departureSelectedIndex = departureComboBox.getSelectedIndex();
                interfaceContainer.routeData.setLocationB(arrivalComboBox.getSelectedItem().toString());


                updatePanel();
            }
        });


        departureComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (departureComboBox.getSelectedIndex() == 0) { // if the first selection is selected than we just fill in null so the list is complete
                    arrivalList = interfaceContainer.routeData.getPossibleArrivalStation(null);
                } else {
                    arrivalList = interfaceContainer.routeData.getPossibleArrivalStation(departureComboBox.getSelectedItem().toString());
                }
                arrivalSelectedIndex = arrivalComboBox.getSelectedIndex();
                departureSelectedIndex = departureComboBox.getSelectedIndex();

                interfaceContainer.routeData.setLocationA(departureComboBox.getSelectedItem().toString());
                updatePanel();
            }
        });


        JLabel fromLabel = new JLabel(messages.getString("Van"));
        JLabel toLabel = new JLabel(messages.getString("Naar"));


        //set size textfields
        departureComboBox.setPreferredSize(new Dimension(200, 20));
        arrivalComboBox.setPreferredSize(new Dimension(200, 20));


        //center textfield
        JPanel centerTextfields = new JPanel();
        centerTextfields.setLayout(new GridLayout(5, 1, 0, 0));

        JLabel wrongLocationA = new JLabel();
        JLabel wrongLocationB = new JLabel();


        centerTextfields.add(departureComboBox);
        centerTextfields.add(wrongLocationA);
        centerTextfields.add(arrivalComboBox);
        centerTextfields.add(wrongLocationB);


        //navigate
        JButton navigate = new JButton(messages.getString("Navigeren"));
        centerTextfields.add(navigate);
        navigate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                locationA = interfaceContainer.routeData.getLocationA();
                locationB = interfaceContainer.routeData.getLocationB();


                /*
                interfaceContainer.routeData.setLocationB(toTextField.getText());


                if (interfaceContainer.isRouteValid(interfaceContainer.routeData.getLocationB())) {
                    interfaceContainer.routeData.getLocationB();

                    interfaceContainer.routeData.resetTime();
                    interfaceContainer.routeData.setDistance(interfaceContainer.calcDistanceToStation(interfaceContainer.routeData.getLocationB()));
                    interfaceContainer.routeData.addMinutesTime(interfaceContainer.calcMinutesToStation(interfaceContainer.routeData.getLocationB()));


                    times = interfaceContainer.generateListDepartureTimes(interfaceContainer.routeData.getTime(), 20);
                    distance = interfaceContainer.routeData.getDistance();
                    time = interfaceContainer.routeData.getTime();
                    trajectoryStations = interfaceContainer.generateRoute(interfaceContainer.routeData.getLocationB());
                    locationB = interfaceContainer.routeData.getLocationB();


                    trajectorysPanel = trajectorysGui();


                    selectedPanel = 2;
                    updatePanel();

                    wrongLocationB.setText(messages.getString("Verkeerde_invoer_probeer_het_nogmaals"));



                }

                 */

            }
        });


        //center labels
        JPanel centerLabels = new JPanel();
        centerLabels.setLayout(new GridLayout(3, 1, 0, 20));
        centerLabels.add(fromLabel);
        centerLabels.add(toLabel);
        centerLabels.add(new JLabel());

        JPanel centerGrid = new JPanel();
        centerGrid.setLayout(new GridBagLayout());
        centerGrid.add(centerLabels);
        centerGrid.add(centerTextfields);

        //radio buttons
        JRadioButton r1 = new JRadioButton(messages.getString("Bus"));
        JRadioButton r2 = new JRadioButton(messages.getString("Trein"));
        switch (vehicleIdentifier) {
            case "bus":
                r1 = new JRadioButton(messages.getString("Bus"), true);
                break;
            case "trein":
            case "train":
                r2 = new JRadioButton(messages.getString("Trein"), true);
                break;
        }

        r1.setBounds(75, 50, 100, 30);
        r2.setBounds(75, 100, 100, 30);
        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);

        ActionListener sliceActionListener = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                AbstractButton aButton = (AbstractButton) actionEvent.getSource();

                switch (aButton.getText()) {
                    case "Bus":
                        interfaceContainer.routeData.setVehicleIdentifier("bus");
                        vehicleIdentifier = "bus";
                        break;
                    case "Train":
                    case "Trein":
                        interfaceContainer.routeData.setVehicleIdentifier("train");
                        vehicleIdentifier = "train";
                        break;

                }
                interfaceContainer.routeData.getTrajectorysWithVehicleIdentifier();
                departureList = interfaceContainer.routeData.getPossibleDepartureStation(null);
                arrivalList = interfaceContainer.routeData.getPossibleArrivalStation(null);
                updatePanel();
            }
        };

        r1.addActionListener(sliceActionListener);
        r2.addActionListener(sliceActionListener);


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

        bottom.add(languageAndGoBackPanel(false));


        return navigatePanel;

    }

    private JPanel trajectorysGui() {
        JPanel panel = new JPanel(new BorderLayout(8, 6));

        JPanel panelCenter = new JPanel(new BorderLayout());
        JPanel panelNorth = new JPanel(new GridLayout());
        JPanel panelSouth = new JPanel(new GridLayout());

        panel.add(panelCenter, BorderLayout.CENTER);
        panel.add(panelNorth, BorderLayout.NORTH);
        panel.add(panelSouth, BorderLayout.SOUTH);

        JPanel panelCenterCenter = new JPanel(new GridLayout(1, 10));
        JPanel panelCenterNorth = new JPanel(new GridLayout(1, 2));

        panelCenter.add(panelCenterCenter, BorderLayout.CENTER);
        panelCenter.add(panelCenterNorth, BorderLayout.NORTH);

        panelCenterNorth.add(new JLabel(messages.getString("Reisinformatie")));

        panelCenterNorth.add(new JLabel(messages.getString("Vertrektijden")));

        JPanel panelRouteInformationAndStations = new JPanel(new GridLayout(2, 1));
        panelCenterCenter.add(panelRouteInformationAndStations);

        JPanel panelRouteInformation = new JPanel(new GridLayout(16, 1));
        JPanel panelStationsInfo = new JPanel(new GridLayout(1, 1));
        panelRouteInformationAndStations.add(panelRouteInformation);
        panelRouteInformationAndStations.add(panelStationsInfo);

        panelRouteInformation.add(new JLabel(messages.getString("Van_")+ locationA));
        panelRouteInformation.add(new JLabel(messages.getString("Naar_")+ locationB));
        long distanceRoundOff = Math.round(distance);


        panelRouteInformation.add(new JLabel((messages.getString("Afstand")) + Double.toString(distanceRoundOff) + "km"));
        panelRouteInformation.add(new JLabel((messages.getString("Reistijd")) + time.toString()));

        if (vehicleIdentifier.equals("train")) {
            panelRouteInformation.add(new JLabel(messages.getString("Vervoer_type") + messages.getString("Trein")));
        }else{
            panelRouteInformation.add(new JLabel(messages.getString("Vervoer_type")+vehicleIdentifier.toString()));
        }
        JPanel trajectoryInfoPanel= new JPanel(new BorderLayout());
        panelStationsInfo.add(trajectoryInfoPanel);

        JList trajectoryStationsJList = new JList(trajectoryStations.toArray());
        JScrollPane stationsInfoPane = new JScrollPane();
        stationsInfoPane.setViewportView(trajectoryStationsJList);
        trajectoryStationsJList.setLayoutOrientation(JList.VERTICAL);
        trajectoryInfoPanel.add(stationsInfoPane,BorderLayout.CENTER);
        trajectoryInfoPanel.add(new JLabel("Route"),BorderLayout.NORTH);



        JList timeJList = new JList(times.toArray());

        JScrollPane timesPane = new JScrollPane();
        timesPane.setViewportView(timeJList);
        timeJList.setLayoutOrientation(JList.VERTICAL);
        panelCenterCenter.add(timesPane);

        ////////////////////////////////
        ///         top       /////////
        ///////////////////////////////
        panel.add(loginAndSettings(), BorderLayout.NORTH);


        /////////////////////////
        //      bottom      ////
        ////////////////////////

        panelSouth.add(languageAndGoBackPanel(true));
        return panel;


    }

    private JPanel trackPanelGui() {
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
        panelCenter.add(new JButton(("Kaart")));
        panelCenter.add(centerPanelRight);

        /////////////////////////
        //      bottom      ////
        ////////////////////////

        panelSouth.add(languageAndGoBackPanel(true));

        return panel;
    }

    private JPanel loginAndSettings() {

        int rows = 5;
        JPanel topPanel = new JPanel(new GridLayout(1, 5));
        JButton login = new JButton(("Login"));
        topPanel.add(login);

        for (int i = 0; i < (rows - 1); i++) {
            topPanel.add(new JLabel());
        }

        String[] comboBoxItems = {("instelling1"), ("instelling2")};
        JComboBox<String> cb = new JComboBox<>(comboBoxItems);
        cb.setEditable(false);
        topPanel.add(cb);

        return topPanel;


    }

    private JPanel languageAndGoBackPanel(boolean goBack) {
        JPanel languagePanel = new JPanel(new GridLayout(1, 4));

        //add empty spaces to bottom grid
        if (goBack == true) {
            JButton goBackButton = new JButton(messages.getString("Vorige"));
            languagePanel.add(goBackButton);
            goBackButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    selectedPanel = selectedPanel - 1;
                    updatePanel();
                }
            });
        } else {
            languagePanel.add(new JLabel());
        }


        languagePanel.add(new JLabel());

        //languagePanel label
        JPanel languageLabel = new JPanel(new GridLayout(1, 2));
        languagePanel.add(languageLabel);
        languageLabel.add(new JLabel());

        languageLabel.add(new JLabel(messages.getString("Taal")));

        comboBox = new JComboBox<Language>();
        comboBox.setModel(new DefaultComboBoxModel<Language>(Language.values()));

        if(selectedLanguageOptionComboBox==0){
            selectedLanguageOptionComboBox=1;
            comboBox.setSelectedIndex(0);
        }else{
            selectedLanguageOptionComboBox=0;
            comboBox.setSelectedIndex(1);
        }

        languagePanel.add(comboBox);

        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                changeLanguage(((JComboBox) e.getSource()).getSelectedIndex());
            }
        });

        {
            return languagePanel;
        }
    }

    private void changeLanguage(int index) {

        Language language = comboBox.getItemAt(index);

        getBundle(language);

        updatePanel();
    }

    private ResourceBundle getBundle(Language language) {
        //ResourceBundle messages;
        if (language == Language.English)
            messages = ResourceBundle.getBundle("MessagesBundle", new Locale("en", "EN"));
        else
            messages = ResourceBundle.getBundle("MessagesBundle");
        return messages;
    }

    public Language getLanguage() {
        return (Language) this.comboBox.getSelectedItem();
    }

    public ResourceBundle getMessages() {
        return messages;
    }
}


