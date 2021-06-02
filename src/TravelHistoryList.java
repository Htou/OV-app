import java.util.ArrayList;

public class TravelHistoryList {
    private ArrayList<TravelHistory> travelHistoryList;

    TravelHistoryList(TravelHistory travelHistory){
        this.travelHistoryList = new ArrayList<TravelHistory>();
        travelHistoryList.add(travelHistory);
    }

    public void addTravelHistory(TravelHistory travelHistory) {
        this.travelHistoryList.add(travelHistory);
    }


    public ArrayList getTravelHistoryList(){
        return this.travelHistoryList;
    }

    public TravelHistory getHistory(int index) {
        return this.travelHistoryList.get(index);
    }
}
