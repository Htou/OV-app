import java.time.LocalDateTime;

public class Station {
    private String name;
    private LocalDateTime timeToNextStation;
    private double distance;

    public Station (String name, LocalDateTime timeToNextStation, double distance) {
        this.name = name;
        this.timeToNextStation = timeToNextStation;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName){
        name = newName;
    }

    public LocalDateTime getTimeToNextStation() {
        return timeToNextStation;
    }
    public void setTimeToNextStation(LocalDateTime newTime) {
        timeToNextStation = newTime;
    }

    public double  getDistance() {
        return distance;
    }

    public void setDistance(double newDistance){
        distance = newDistance;
    }

}
