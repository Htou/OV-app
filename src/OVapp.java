public class OVapp {
    private TrajectoryHandler trajectoryList;
    RouteData routeData;

    public OVapp(){
        trajectoryList = new TrajectoryHandler();
        trajectoryList.loadTrajectory();
        trajectoryList.getTrajectory(0);

        routeData = new RouteData();
    }


    public void runProgram() {
        calcDistanceToStation("Maarssen");
        System.out.println(routeData.getDistanceFromAToB());


        Gui gui = new Gui();
        gui.startGui();

    }

    public void calcDistanceToStation(String station){
        Trajectory utrechtToAmsterdam = trajectoryList.getTrajectory(0); // there is only one trajectory atm so it starts at Utrecht.


        //check if station is in list
        // if it return -1 the station name doesn't exist

        int index = utrechtToAmsterdam.indexOf(station);
        if (index == -1){
            routeData.setDistanceFromAToB(-1);



        } else {
            //we start at 0 so the program can just go through the list and add the distances
            double totalDistance = 0.0;
            for (int i = 0; i < index; i++) {
                totalDistance = totalDistance + utrechtToAmsterdam.getDistanceToNextStation(index);
            }

            routeData.setDistanceFromAToB(totalDistance);


        }






    }
}
