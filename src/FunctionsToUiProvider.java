import java.io.File;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class FunctionsToUiProvider {
    public RouteData routeData;
    private TrajectoryHandler trajectoryList;
    public ResourceBundle messages;
    public ProfileList profiles;
    private Profile selectedProfile;


    public FunctionsToUiProvider() {
        trajectoryList = new TrajectoryHandler();
        routeData = new RouteData();
        routeData.setTrajectoryList(trajectoryList.loadTrainTrajectory());
        this.messages = ResourceBundle.getBundle("MessagesBundle");

        final String fname = "profiles.json";

        File file = new File( fname );


        ProfileHandler profileHandler = new ProfileHandler();
        profiles = new ProfileList(profileHandler.loadProfiles());
        profiles.load(file);
    }




    public boolean checkIfProfileExists(String name, String password){
        for (Profile profile : profiles.getProfiles()){
            if (profile.getName().equals(name) && profile.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    //Saves selected profile
    public void setSelectedProfile(Profile selectedProfile){
        this.selectedProfile = selectedProfile;
    }

    // fetches selected profile
    public Profile getSelectedProfile(){
        return this.selectedProfile;
    }

    public void saveLoggedInProfile(String name, String password){
        for (Profile profile : profiles.getProfiles()){
            if (profile.getName().equals(name) && profile.getPassword().equals(password)){
                setSelectedProfile(profile);
            }
        }
    }

    public ArrayList<String> generateRoute(Trajectory selectedTrajectory) {
        ArrayList<String> generatedRoute = new ArrayList<String>();

        int indexA = selectedTrajectory.indexOf(routeData.getLocationA());
        int indexB = selectedTrajectory.indexOf(routeData.getLocationB());


        for (int i = indexA; i <= indexB; i++) {
            generatedRoute.add(selectedTrajectory.getStationName(i));
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


        //we start at 0 so the program can just go through the list and add the distances
        double totalDistance = 0.0;
        for (int i = indexA; i < indexB; i++) {
            totalDistance = totalDistance + selectedTrajectory.getDistanceToNextStation(i);
        }

        return totalDistance;
    }

    public ArrayList<String> getArrivalAndDepartureTimes(int listLenght, Trajectory trajectory, String locationA, String locationB) {
        ArrayList<LocalTime> departureTimes = generateListArrivalTimesAtLocation(listLenght, trajectory, locationA);
        ArrayList<LocalTime> arrivalTimes = generateListArrivalTimesAtLocation(listLenght, trajectory, locationB);

        ArrayList<String> listArrivalTimesDepartureTimes = new ArrayList<String>();

        for(int i = 0; i < listLenght; i++) {
            String stringDepartureTime = departureTimes.get(i).toString();
            String stringArrivalTime = arrivalTimes.get(i).toString();

            listArrivalTimesDepartureTimes.add(stringDepartureTime + "-" + stringArrivalTime);
        }
        return listArrivalTimesDepartureTimes;
    }

    private ArrayList<LocalTime> generateListArrivalTimesAtLocation(int listLength, Trajectory trajectory, String location) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        int possibleIncrementsBetweenDepartureTimes = trajectory.getIncrements();
        int firstDepartureTime = trajectory.getFirstDepartureTime();

        ArrayList<Station> stationListTrajectory = trajectory.getStationList();
        for (int i = 0; i < trajectory.indexOf(location); i++) {
            firstDepartureTime = firstDepartureTime + stationListTrajectory.get(i).getTimeToNextStation();
            // refactor this code

        }
        // bug: fix that the firstDepartureTime can over 60

        //get local time
        LocalTime currentTime = LocalTime.parse("00:00", formatter).now();


        String[] currentTimeSplit = currentTime.toString().split(":");
        int currentMinutes = Integer.parseInt(currentTimeSplit[1]);
        int currentHours = Integer.parseInt(currentTimeSplit[0]);

        int departureHour = currentHours;

        // calculate closest departure time
        int departureMinute = firstDepartureTime;
        while (!(currentMinutes <= departureMinute)) {
            departureMinute = departureMinute + possibleIncrementsBetweenDepartureTimes;
        }

        // if departure time is over 60 minutes it converts it to a new hour with the current departure time
        if (departureMinute > 60) {
            departureMinute = departureMinute - possibleIncrementsBetweenDepartureTimes;
            departureHour = departureHour + 1;

        }

        //if departure time is 24 hour it converts it to 00 hours midnight in the string
        String departureTimeString;
        if (departureHour == 24) { // if it's 24 than the time needs to be 00:minutes
            departureTimeString = (String) ("00" + ":" + departureMinute);
        } else {
            departureTimeString = (String) (departureHour + ":" + departureMinute);
        }

        // generates list of possible departure times or arrival times, it depends on the locationA-B
        LocalTime departureTime = LocalTime.parse(departureTimeString, formatter);
        ArrayList<LocalTime> listDepartureTimes = new ArrayList<LocalTime>();
        for (int i = 0; i < listLength; i++) {
            listDepartureTimes.add(departureTime);
            departureTime = departureTime.plusMinutes(possibleIncrementsBetweenDepartureTimes);
        }

        return listDepartureTimes;
    }
    
    
    // filters the right trajectory out that the user needs to navigate and sends it to the gui
    public Trajectory fetchRightTrajectory() {
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
    
    // validates if fetched trajectory exists or is possible
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
