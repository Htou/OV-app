public class OVapp {
    private TrajectoryHandler trajectoryList;
    private double distanceToLocationB;

    public OVapp(){
        trajectoryList = new TrajectoryHandler();
        trajectoryList.loadTrajectory();


    }

    public void runProgram() {

        Gui gui = new Gui();
        gui.startGui();

    }
    public double getDistanceToLocationB(){
        return distanceToLocationB;
    }

    public double calcDistanceToStation(String station){
        Trajectory utrechtToAmsterdam = trajectoryList.getTrajectory(0); // there is only one trajectory atm so it starts at Utrecht.


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
