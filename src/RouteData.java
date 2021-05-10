import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class RouteData {
    private String locationA;
    private String locationB;
    private double distance;
    private LocalTime time;
    private String vehicleIdentifier;
    private Trajectory selectedTrajectory;
    private ArrayList<Trajectory> trajectoryList;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

    public RouteData() {
        String str = "00:00";
        time = LocalTime.parse(str, formatter);

        distance = 0.0;
        vehicleIdentifier = "train";
        trajectoryList = new ArrayList();
    }


    public void addMinutesTime(int minutes) {
        time = time.plusMinutes(minutes);
    }

    public LocalTime getTime() {
        return time;
    }

    public void resetTime() {
        time = LocalTime.parse("00:00", formatter);


    }

    public String getLocationA() {
        return locationA;
    }

    public void setLocationA(String locationA) {
        this.locationA = locationA;
    }

    public String getLocationB() {
        return locationB;
    }

    public void setLocationB(String locationB) {
        this.locationB = locationB;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getVehicleIdentifier() {
        return vehicleIdentifier;
    }

    public void setVehicleIdentifier(String vehicleIdentifier) {
        this.vehicleIdentifier = vehicleIdentifier;
    }


    public ArrayList<Trajectory> getTrajectoryList() {
        return trajectoryList;
    }

    public void setTrajectoryList(ArrayList<Trajectory> trajectoryList) {
        this.trajectoryList = trajectoryList;
    }

    public Trajectory getSelectedTrajectory() {
        return selectedTrajectory;
    }

    public void setSelectedTrajectory(Trajectory selectedTrajectory) {
        this.selectedTrajectory = selectedTrajectory;
    }

    public ArrayList<Trajectory> getTrajectorysWithVehicleIdentifier() {
        ArrayList<Trajectory> newTrajectoryList = new ArrayList<>();
        for (Trajectory trajectory : trajectoryList) {
            if (trajectory.getVehicleIdentifier().equals(getVehicleIdentifier())) {
                newTrajectoryList.add(trajectory);
            }
        }
        return newTrajectoryList;
    }


    public ArrayList<String> getPossibleDepartureStation(String arrivalStation) {
        ArrayList<String> arrivalStations = new ArrayList<>();
        arrivalStations.add("kies start locatie");
        for (Trajectory trajectory : trajectoryList) {
            if (trajectory.getVehicleIdentifier().equals(getVehicleIdentifier())) {
                if (arrivalStation == null) {

                } else if (trajectory.isStationInTrajectory(arrivalStation) == false) {
                    continue;

                }
                for (int i = 0; i < (trajectory.getStationList().size() - 1); i++) {
                    String stationName = trajectory.getStationName(i);
                    arrivalStations.add(stationName);

                }
            }
        }
        return arrivalStations;
    }

    public ArrayList<String> getPossibleArrivalStation(String departureStation) {
        ArrayList<String> arrivalStations = new ArrayList<>();
        arrivalStations.add("kies eind locatie");

        for (Trajectory trajectory : trajectoryList) {
            if (trajectory.getVehicleIdentifier().equals(getVehicleIdentifier())) {


                if (departureStation == null) {


                } else if (trajectory.isStationInTrajectory(departureStation) == false) {
                    continue;

                }
                for (int i = 1; i < (trajectory.getStationList().size()); i++) {
                    String stationName = trajectory.getStationName(i);
                    arrivalStations.add(stationName);

                }
            }
        }
        return arrivalStations;

    }
}

