import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class BackEndImplementation {
    private TrajectoryHandler trajectoryList;
    public RouteData routeData;


    public BackEndImplementation() {
        trajectoryList = new TrajectoryHandler();
        trajectoryList.loadTrainTrajectory();
        trajectoryList.getTrajectory(0);


        routeData = new RouteData();
    }


    public void runProgram() {
        //calcDistanceAndTimeToStation("Abcoude");
        //System.out.println(routeData.getTime());
        //routeData.getDistanceFromAToB();


        //calcDistanceAndTimeToStation("Maarssen");
        //LocalTime time = routeData.getTime();
        //generateListDepartureTimes(time,40);


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
        return generatedRoute;
    }

    public int calcMinutesToStation(String station) {
        Trajectory utrechtToAmsterdam = trajectoryList.getTrajectory(0); // there is only one trajectory atm so it starts at Utrecht.

        //check if station is in list
        // if it return -1 the station name doesn't exist

        int index = utrechtToAmsterdam.indexOf(station);

        int minutes = 0;
        for (int i = 0; i < index; i++) {
            minutes = minutes + utrechtToAmsterdam.getTimeToNextStation(i);
        }
        return minutes;

    }

    public double calcDistanceToStation(String station) {
        Trajectory utrechtToAmsterdam = trajectoryList.getTrajectory(0); // there is only one trajectory atm so it starts at Utrecht.

        //check if station is in list
        // if it return -1 the station name doesn't exist

        int index = utrechtToAmsterdam.indexOf(station);
        //we start at 0 so the program can just go through the list and add the distances
        double totalDistance = 0.0;
        for (int i = 0; i < index; i++) {
            totalDistance = totalDistance + utrechtToAmsterdam.getDistanceToNextStation(i);
        }

        return totalDistance;


    }

    public ArrayList<LocalTime> generateListDepartureTimes(LocalTime travelTime, int listLength) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime newTime = LocalTime.parse("00:00", formatter);
        int minutes = travelTime.getMinute();


        Trajectory utrechtToAmsterdam = trajectoryList.getTrajectory(0);
        int increments = utrechtToAmsterdam.getIncrements();
        int firstDepartureTime = utrechtToAmsterdam.getFirstDepartureTime();

        //get local time
        LocalTime currentTime = LocalTime.parse("00:00", formatter).now();


        String[] currentTimeSplit = currentTime.toString().split(":");
        int currentMinutes = Integer.parseInt(currentTimeSplit[1]);
        int currentHours = Integer.parseInt(currentTimeSplit[0]);

        //currentMinutes = 10;

        int newMinutes = firstDepartureTime;
        int newHours = currentHours;


        if (currentMinutes >= newMinutes) {
            while (currentMinutes > newMinutes) {
                newMinutes = newMinutes + increments;
                System.out.println(newMinutes);
            }

        } else{
            newMinutes = newMinutes - 30;

        }
        if (newMinutes > 60){
            newHours = newHours + 1;
            newMinutes = newMinutes - 60;
        } else if (newMinutes <  0){
            newHours = newHours - 1;
            newMinutes = newMinutes + 60;
        }




        String departureTimeString = (String) (newHours+":"+newMinutes);
        LocalTime departureTime = LocalTime.parse(departureTimeString, formatter);
        ArrayList<LocalTime> listTime = new ArrayList<>();
        for (int i = 0; i < listLength; i++){
            departureTime = departureTime.plusMinutes(increments);
            listTime.add(departureTime);
        }
        return listTime;







        
    }

    public boolean isRouteValid(String station){
        Trajectory utrechtToAmsterdam = trajectoryList.getTrajectory(0); // there is only one trajectory atm so it starts at Utrecht.

        //will return -1 if in the route is not valid
        int index = utrechtToAmsterdam.indexOf(station);
        if (index == -1){
            return false;
        } else{
            return true;
        }


    }


}
