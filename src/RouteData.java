import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class RouteData {
    private String locationA;
    private String locationB;
    private double distanceFromAToB;
    private static LocalTime time;

    public RouteData(){
        String str = "00:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        time = LocalTime.parse(str, formatter);
    }



    public void addMinutesTime(int minutes){
        time = time.plusMinutes(minutes);
    }
    public LocalTime getTime(){
        return time;
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

    public double getDistanceFromAToB() {
        return distanceFromAToB;
    }
    public void setDistanceFromAToB(double distanceFromAToB){

        this.distanceFromAToB = distanceFromAToB;


    }




}
