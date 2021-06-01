import java.util.ArrayList;

public class TravelHistoryList {
    private ArrayList<TravelHistory> travelHistoryList;

    TravelHistoryList(){
        this.travelHistoryList = new ArrayList<TravelHistory>();
    }

    public void addTravelHistory(TravelHistory travelHistory) {
        this.travelHistoryList.add(travelHistory);
    }


    public ArrayList getTravelHistoryList(){
        return this.travelHistoryList;
    }

    public TravelHistory getTravelHistory(int index) {
        return this.travelHistoryList.get(index);
    }
}
