import java.util.ArrayList;

public class TravelHistoryList {
    private ArrayList<String> travelHistoryListing;

    public TravelHistoryList(){
        this.travelHistoryListing = new ArrayList<String>();
        TravelHistory travelHistory = new TravelHistory();
        addTravelHistoryString(travelHistory.getTravelHistoryToString());
    }

    public void addTravelHistoryString(String travelHistoryString) {
        this.travelHistoryListing.add(travelHistoryString);
    }

    public ArrayList getTravelHistoryListToString(){
        return this.travelHistoryListing;
    }

    public String getHistoryString(int index) {
        return this.travelHistoryListing.get(index);
    }
}
