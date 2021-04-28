import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class OVapp {
    private TrajectoryHandler trajectoryList;
    public RouteData routeData;


    public OVapp() {
        trajectoryList = new TrajectoryHandler();
        trajectoryList.loadTrajectory();
        trajectoryList.getTrajectory(0);


        routeData = new RouteData();
    }


    public void runProgram() {
        //calcDistanceAndTimeToStation("Abcoude");
        //System.out.println(routeData.getTime());
        //routeData.getDistanceFromAToB();


        //Gui gui = new Gui();
        //gui.startGui();
        generateRoute("Maarssen");

    }

    public ArrayList<String> generateRoute(String arrival) {
        Trajectory utrechtToAmsterdam = trajectoryList.getTrajectory(0);
        ArrayList<String> generatedRoute = new ArrayList<String>();

        for (int i = 0; i < utrechtToAmsterdam.getStationList().size(); i++) {
            if (utrechtToAmsterdam.getStationName(i).equals(arrival)) {
                generatedRoute.add(utrechtToAmsterdam.getStationName(i));
                break;
            } else {
                generatedRoute.add(utrechtToAmsterdam.getStationName(i));
            }

        }
        System.out.println(generatedRoute);
        return generatedRoute;
    }

    public void calcDistanceAndTimeToStation(String station) {
        Trajectory utrechtToAmsterdam = trajectoryList.getTrajectory(0); // there is only one trajectory atm so it starts at Utrecht.

        //check if station is in list
        // if it return -1 the station name doesn't exist

        int index = utrechtToAmsterdam.indexOf(station);
        if (index == -1) {
            routeData.setDistanceFromAToB(-1);

        } else {
            //we start at 0 so the program can just go through the list and add the distances
            double totalDistance = 0.0;
            int minutes = 0;
            for (int i = 0; i < index; i++) {
                totalDistance = totalDistance + utrechtToAmsterdam.getDistanceToNextStation(i);
                minutes = minutes + utrechtToAmsterdam.getTimeToNextStation(i);
                System.out.println(minutes);
            }

            routeData.addMinutesTime(minutes);
            routeData.setDistanceFromAToB(totalDistance);


        }

    }


    public void generateListDepatureTimes() {

        String time = "00:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime newTime = LocalTime.parse(time, formatter);
        int minutes = routeData.getTime().getMinute();

        Trajectory utrechtToAmsterdam = trajectoryList.getTrajectory(0);

        for (int i = 0; i < 40; i++) {


        }
    }


}
