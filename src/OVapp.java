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
        calcDistanceAndTimeToStation("Maarssen");
        LocalTime time = routeData.getTime();
        generateListDepartureTimes(time,40);



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
            }

            routeData.addMinutesTime(minutes);
            routeData.setDistanceFromAToB(totalDistance);


        }

    }


    public ArrayList<LocalTime> generateListDepartureTimes(LocalTime time, int listLength) {


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime newTime = LocalTime.parse("00:00", formatter);
        int minutes = routeData.getTime().getMinute();

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
            }

        } else{
            newMinutes = newMinutes - 30;
        }

        if (newMinutes <  0){
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

        System.out.println(listTime);

        return listTime;







        
    }


}
