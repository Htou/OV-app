public class OVapp {
    private RouteData routeData = new RouteData();

    private TrajectoryHandler trajectoryList;

    public OVapp(){
        trajectoryList = new TrajectoryHandler();
        trajectoryList.loadTrajectory();


    }


    public void runProgram() {

        Gui gui = new Gui();
        gui.startGui();

    }

    public void calcDistanceToStation(String station){
        Trajectory utrechtToAmsterdam = trajectoryList.getTrajectory(0); // there is only one trajectory atm so it starts at Utrecht.


        //check if station is in list
        // if it return -1 the station name doesn't exist

        int index = utrechtToAmsterdam.indexOf(station);
        if (index == -1){
            distanceToLocationB = -1;


        } else {
            //we start at 0 so the program can just go through the list and add the distances
            double totalDistance = 0.0;
            for (int i = 0; i < index; i++) {
                totalDistance = totalDistance + utrechtToAmsterdam.getDistanceToNextStation(index);
            }

            distanceToLocationB = totalDistance;

        }





    }
}
