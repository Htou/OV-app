import java.util.ArrayList;

public class Trajectory {
    private ArrayList<Station> stationList;

    public Trajectory(ArrayList<Station> stationList ) {
        this.stationList = stationList;
    }
    public ArrayList<Station> getStationList(){
        return stationList;
    }
    public void setStationList(ArrayList<Station>newStationList ){
        this.stationList = newStationList;
    }
}
