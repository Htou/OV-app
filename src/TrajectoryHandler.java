import java.util.ArrayList;

public class TrajectoryHandler {
   private ArrayList<Trajectory> trajectoryList = new ArrayList();


   public ArrayList<Trajectory> loadTrajectory(){
      ArrayList<Station> stationUtrechtToAmsterdam = new ArrayList();

      stationUtrechtToAmsterdam.add(new Station("Utrecht",3 ,2.04));
      stationUtrechtToAmsterdam.add(new Station("Utrecht Zuilen",5 ,5.29));
      stationUtrechtToAmsterdam.add(new Station("Maarssen",4 ,4.83));
      stationUtrechtToAmsterdam.add(new Station("Breukelen",10 ,12.1));
      stationUtrechtToAmsterdam.add(new Station("Abcoude",0 ,0));       //end station
      Trajectory trajectoryUtrechtToAmsterdam = new Trajectory(stationUtrechtToAmsterdam);

      trajectoryList.add(trajectoryUtrechtToAmsterdam);

      return trajectoryList;
   }

   public Trajectory getTrajectory(int index){
      return trajectoryList.get(index);
   }


}
