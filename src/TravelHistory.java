import java.time.LocalDate;
import java.time.LocalTime;

public class TravelHistory {
    private String locationA;
    private String locationB;
    private LocalDate travelDate;
    private LocalTime startTravelTime;

    public TravelHistory(String locationA, String locationB) {
        this.locationA = locationA;
        this.locationB = locationB;
        this.travelDate = LocalDate.now();
        this.startTravelTime = LocalTime.now();
    }

    public void setLocationA(String locationA) {
        this.locationA = locationA;
    }

    public String getLocationA() {
        return this.locationA;
    }

    public void setLocationB(String locationB) {
        this.locationB = locationB;
    }

    public String getLocationB() {
        return this.locationB;
    }

    public void setTravelDate() {
        this.travelDate = LocalDate.now();
    }

    public String getTravelDateToString() {
        return this.travelDate.toString();
    }

    public void setStartTravelTime (LocalTime startTravelTime){
        this.startTravelTime = startTravelTime;
    }

    public String getStartTravelTimeToString() {
        return this.startTravelTime.toString();
    }

    public String getTravelHistoryToString() {
        StringBuilder travelHistoryString = new StringBuilder();

        travelHistoryString.append(getLocationA());
        travelHistoryString.append(" --- ");
        travelHistoryString.append(getLocationB());
        travelHistoryString.append(", ");
        travelHistoryString.append(getStartTravelTimeToString());
        travelHistoryString.append(", ");
        travelHistoryString.append(getTravelDateToString());

        return travelHistoryString.toString();
    }

}

