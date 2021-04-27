import java.util.ArrayList;

public class Trajectory {
    private ArrayList<Station> stationList;
    private int increments; // is how often the first train goes from the first station for example: 30

    //each half hour or 15 minutes the train departures so we need the time when it first departs so the time can be calculated further
    int firstDepartureTime;


    public Trajectory(ArrayList<Station> stationList ) {
        this.stationList = stationList;
        this.increments = increments;
        this.firstDepartureTime = firstDepartureTime;
    }

    public ArrayList<Station> getStationList(){
        return stationList;
    }

    public void setStationList(ArrayList<Station>newStationList ){
        this.stationList = newStationList;
    }

    public int indexOf(String station){

        for (int i = 0; i < stationList.size(); i++){
            Station selStation = stationList.get(i);
            if (selStation.getName().equals(station)){
                return i;
            }
        }
        return -1;

    }

    public double getDistanceToNextStation(int index){
        Station selStation = stationList.get(index);
        return selStation.getDistanceToNextStation();


    }
}
