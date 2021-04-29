import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class RouteData {
    private String locationA;
    private String locationB;
    private double distance;
    private LocalTime time;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

    public RouteData(){
        String str = "00:00";

        time = LocalTime.parse(str, formatter);

        distance = 0.0;
    }



    public void addMinutesTime(int minutes){
        time = time.plusMinutes(minutes);
    }
    public LocalTime getTime(){
        return time;
    }
    public void resetTime(){
        time = LocalTime.parse("00:00", formatter);


    }


    public String getLocationA() {
        return locationA;
    }
    public void setLocationA(String locationA){
        this.locationA = locationA;
    }

    public String getLocationB() {
        return locationB;
    }
    public void setLocationB(String locationB){
        this.locationB = locationB;
    }

    public double getDistance() {
        return distance;
    }
    public void setDistance(double distance){
        this.distance = distance;
    }






}
