import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OVapp {
    private TrajectoryHandler trajectoryList = new TrajectoryHandler();

    public void runProgram() {
        //Gui gui = new Gui();
        //gui.startGui();


        trajectoryList.loadTrajectory();

        System.out.println(calcDistanceToStation("Maarssen"));



    }
    public double calcDistanceToStation(String station){
        Trajectory utrechtToAmsterdam = trajectoryList.getTrajectory(0); // there is only one trajectory atm.

        //check if station is in list
        // if it return -1 the station name doesn't exist
        int index = utrechtToAmsterdam.indexOf(station);
        if (index == -1){

            return -1;
        }

        double totalDistance = 0.0;
        for (int i=0; i<index; i++){
            totalDistance = totalDistance + utrechtToAmsterdam.getDistanceToNextStation(index);
        }

        //we start at 0 so the program can just go through the list and add the distances
        return totalDistance;
    }
}
