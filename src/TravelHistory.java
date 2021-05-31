import java.time.LocalDate;
import java.time.LocalTime;

public class TravelHistory {
    private String locationA;
    private String locationB;
    private LocalDate travelDate;
    private LocalTime startTravelTime;
    private LocalTime endTravelTime;
    private LocalTime travelTime;

    TravelHistory(){
        this.locationA = "";
        this.locationB = "";
    }

    public void setLocationA(String locationA) {
        this.locationA = locationA;
    }

    public String getLocationA() {
        return this.locationA;
    }

    public void setLocationB(String locationB) {
        this.locationA = locationB;
    }

    public String getLocationB() {
        return this.locationB;
    }

    public void setTravelDate() {
        this.travelDate = LocalDate.now();
    }

    public LocalDate getTravelDate() {
        return this.travelDate;
    }

    public void setStartTravelTime (LocalTime startTravelTime){
        this.startTravelTime = startTravelTime;
    }

    public LocalTime getStartTravelTime() {
        return this.startTravelTime;
    }

    public void setEndTravelTime(LocalTime endTravelTime) {
        this.endTravelTime = endTravelTime;
    }

    public LocalTime getEndTravelTime() {
        return this.endTravelTime;
    }

    public void setTravelTime (LocalTime travelTime) {
        this.travelTime = travelTime;
    }

    public LocalTime setTravelTime () {
        return this.travelTime;
    }

}

