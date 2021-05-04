import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Gui extends JFrame {
    private ResourceBundle messages;
    private Container mainContainer;
    private CardLayout cl;

    private RouteData routeData;
    private int selectedPanel;
    private int previousPanel;
    // because swing is retarded a copy needs to be made of locationB
    // inside of the GUI because we can't call other methods from the methods in here.
    private ArrayList<LocalTime> times;
    private LocalTime time;
    private double distance = 0.0;
    private ArrayList<String> trajectoryStations = new ArrayList<String>();
    private String locationB;
    private String language;


    //make panels global variables
    private JPanel navigatePanel = new JPanel();
    private JPanel trajectorysPanel = new JPanel();
    private JPanel showTrackPanel = new JPanel();

    private BackEndImplementation backEnd;


    public Gui(String title) {
        super(title);
        this.setSize(600, 600);
        this.setLocation(100, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainContainer = this.getContentPane();
        cl = new CardLayout();

        times = new ArrayList<>();

        String str = "00:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        time = LocalTime.parse(str, formatter);

        mainContainer.setLayout(cl);
        language = "NE";
        selectedPanel = 1;
        updatePanel();
        routeData = new RouteData();
        backEnd = new BackEndImplementation();


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


        JTextField fromTextField = new JTextField("Utrecht");
        JTextField toTextField = new JTextField("Maarssen");
        JLabel fromLabel = language == "NE" ? new JLabel(("van")) : new JLabel(("from"));
        JLabel toLabel = language == "NE" ? new JLabel(("naar")) : new JLabel(("to"));


        //set size textfields
        fromTextField.setPreferredSize(new Dimension(200, 20));
        toTextField.setPreferredSize(new Dimension(200, 20));


        //center textfield
        JPanel centerTextfields = new JPanel();
        centerTextfields.setLayout(new GridLayout(5, 1, 0, 0));

        JLabel wrongLocationA = new JLabel();
        JLabel wrongLocationB = new JLabel();


        centerTextfields.add(fromTextField);
        centerTextfields.add(wrongLocationA);
        centerTextfields.add(toTextField);
        centerTextfields.add(wrongLocationB);


        //navigate
        JButton navigate = language == "NE" ? new JButton("Navigeren") : new JButton("Navigate");
        centerTextfields.add(navigate);
        navigate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                routeData.setLocationB(toTextField.getText());


                if (backEnd.isRouteValid(routeData.getLocationB())) {


                    routeData.resetTime();
                    routeData.setDistance(backEnd.calcDistanceToStation(routeData.getLocationB()));
                    routeData.addMinutesTime(backEnd.calcMinutesToStation(routeData.getLocationB()));


                    times = backEnd.generateListDepartureTimes(routeData.getTime(), 20);
                    distance = routeData.getDistance();
                    time = routeData.getTime();
                    trajectoryStations = backEnd.generateRoute(routeData.getLocationB());
                    locationB = routeData.getLocationB();


                    trajectorysPanel = trajectorysGui();


                    selectedPanel = 2;
                    updatePanel();

                } else {
                    if (language == "NE") {
                        wrongLocationB.setText("Verkeerde invoer");
                    } else {
                        wrongLocationB.setText("Wrong input, try again");
                    }


                }

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
        JRadioButton r1 = new JRadioButton("Bus");
        JRadioButton r2 = language == "NE" ? new JRadioButton("Trein") : new JRadioButton("Train");
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

        if (language == "NE") {
            panelCenterNorth.add(new JLabel("Reisinformatie"));
        } else {
            panelCenterNorth.add(new JLabel("Travel Info"));
        }
        JLabel arrival = new JLabel();


        arrival.setText(locationB);
        panelCenterNorth.add(arrival);


        JPanel panelRouteInformationAndStations = new JPanel(new GridLayout(2, 1));
        panelCenterCenter.add(panelRouteInformationAndStations);

        JPanel panelRouteInformation = new JPanel(new GridLayout(20, 1));
        JPanel panelStationsInfo = new JPanel(new GridLayout(1, 1));
        panelRouteInformationAndStations.add(panelRouteInformation);
        panelRouteInformationAndStations.add(panelStationsInfo);


        panelRouteInformation.add(new JLabel("Utrecht Centraal"));

        long distanceRoundOff = Math.round(distance);

        if (language == "NE") {
            panelRouteInformation.add(new JLabel(("Afstand: ") + Double.toString(distanceRoundOff) + "km"));
            panelRouteInformation.add(new JLabel(("Reistijd: ") + time.toString()));
        } else {
            panelRouteInformation.add(new JLabel(("Distance: ") + Double.toString(distanceRoundOff) + "km"));
            panelRouteInformation.add(new JLabel(("Travel Time: ") + time.toString()));
        }


        JList trajectoryStationsJList = new JList(trajectoryStations.toArray());
        JScrollPane stationsPane = new JScrollPane();
        stationsPane.setViewportView(trajectoryStationsJList);
        trajectoryStationsJList.setLayoutOrientation(JList.VERTICAL);
        panelStationsInfo.add(stationsPane);


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
            JButton goBackButton = language == "NE" ? new JButton("Vorige"): new JButton("Go back");
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

        if (language == "NE") {
            languageLabel.add(new JLabel(("Taal")));
        } else {
            languageLabel.add(new JLabel(("Language")));
        }


        String[] comboBoxItems = language == "NE"? new String[]{("Nederlands"), ("Engels")} : new String[]{ ("English"), ("Dutch")};
        JComboBox<String> cb = new JComboBox<>(comboBoxItems);
        cb.setEditable(false);
        cb.setSelectedIndex(0);
        languagePanel.add(cb);

        cb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (language == "NE") {
                    language = cb.getSelectedIndex() == 0 ? "NE" : "EN";
                } else {
                    language = cb.getSelectedIndex() == 1 ? "NE" : "EN";
                }
                updatePanel();
            }
        });{


            return languagePanel;

        }


    }
}

