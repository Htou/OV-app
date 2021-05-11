import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class interfaceContainer {
    public RouteData routeData;
    private TrajectoryHandler trajectoryList;
    public ResourceBundle messages;

    public interfaceContainer() {
        trajectoryList = new TrajectoryHandler();
        routeData = new RouteData();
        routeData.setTrajectoryList(trajectoryList.loadTrainTrajectory());
        this.messages = ResourceBundle.getBundle("MessagesBundle");
    }


    public ArrayList<String> generateRoute(Trajectory selectedTrajectory) {
        ArrayList<String> generatedRoute = new ArrayList<String>();

        int indexA = selectedTrajectory.indexOf(routeData.getLocationA());
        int indexB = selectedTrajectory.indexOf(routeData.getLocationB());

        for (int i = indexA; i < indexB; i++) {
            if (selectedTrajectory.getStationName(i).equals(indexB)) {
                generatedRoute.add(selectedTrajectory.getStationName(i));
            }

        }
        return generatedRoute;
    }

    public int calcMinutesToStation() {
        Trajectory selectedTrajectory = routeData.getSelectedTrajectory(); // there is only one trajectory atm so it starts at Utrecht.

        //check if station is in list
        // if it return -1 the station name doesn't exist

        int indexA = selectedTrajectory.indexOf(routeData.getLocationA());
        int indexB = selectedTrajectory.indexOf(routeData.getLocationB());

        //we start at 0 so the program can just go through the list and add the distances
        int totalTime = 0;
        for (int i = indexA; i < indexB; i++) {
            totalTime = totalTime + selectedTrajectory.getTimeToNextStation(i);
        }

        return totalTime;

    }

    public double calcDistanceToStation() {
        Trajectory selectedTrajectory = routeData.getSelectedTrajectory(); // there is only one trajectory atm so it starts at Utrecht.

        //check if station is in list
        // if it return -1 the station name doesn't exist

        int indexA = selectedTrajectory.indexOf(routeData.getLocationA());
        int indexB = selectedTrajectory.indexOf(routeData.getLocationB());

        System.out.println(indexA);
        System.out.println(indexB);

        //we start at 0 so the program can just go through the list and add the distances
        double totalDistance = 0.0;
        for (int i = indexA; i < indexB; i++) {
            totalDistance = totalDistance + selectedTrajectory.getDistanceToNextStation(i);
        }

        System.out.println(totalDistance);
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

        } else {
            newMinutes = newMinutes - 30;

        }
        if (newMinutes > 60) {
            newHours = newHours + 1;
            newMinutes = newMinutes - 60;
        } else if (newMinutes < 0) {
            newHours = newHours - 1;
            newMinutes = newMinutes + 60;
        }


        String departureTimeString = (String) (newHours + ":" + newMinutes);
        LocalTime departureTime = LocalTime.parse(departureTimeString, formatter);
        ArrayList<LocalTime> listTime = new ArrayList<>();
        for (int i = 0; i < listLength; i++) {
            departureTime = departureTime.plusMinutes(increments);
            listTime.add(departureTime);
        }
        return listTime;

    }

    public boolean isRouteValid(String station) {
        Trajectory utrechtToAmsterdam = trajectoryList.getTrajectory(0); // there is only one trajectory atm so it starts at Utrecht.

        //will return -1 if in the route is not valid
        int index = utrechtToAmsterdam.indexOf(station);
        if (index == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Trajectory fetchTrajectory() {
        String locationA = routeData.getLocationA();
        String locationB = routeData.getLocationB();
        String vehicleID = routeData.getVehicleIdentifier();

        ArrayList<Trajectory> trajectories = routeData.getTrajectoryList();

        for (Trajectory trajectory : trajectories) {
            if (trajectory.getVehicleIdentifier().equals(vehicleID)) {

                if (trajectory.getStops().contains(locationA) && trajectory.getStops().contains(locationB)) {
                    return trajectory;
                }
            }
        }
        return null;
    }

    public boolean validateTrajectory(Trajectory trajectory) {
        String locationA = routeData.getLocationA();
        String locationB = routeData.getLocationB();

        if (trajectory.indexOf(locationA) < trajectory.indexOf(locationB)) {
            return true;
        } else {
            return false;
        }
    }
}
