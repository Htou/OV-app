import java.util.ArrayList;

public class TrajectoryHandler {
   private ArrayList<Trajectory> trajectoryList = new ArrayList();


   public ArrayList<Trajectory> loadTrainTrajectory(){
      ArrayList<Station> stationUtrechtToAmsterdam = new ArrayList();

      stationUtrechtToAmsterdam.add(new Station("Utrecht CS",3 ,2.04));
      stationUtrechtToAmsterdam.add(new Station("Utrecht Zuilen",5 ,5.29));
      stationUtrechtToAmsterdam.add(new Station("Maarssen",4 ,4.83));
      stationUtrechtToAmsterdam.add(new Station("Breukelen",10 ,12.1));
      stationUtrechtToAmsterdam.add(new Station("Abcoude",0 ,0));
      Trajectory trajectoryUtrechtToAmsterdam = new Trajectory(stationUtrechtToAmsterdam,30,20);

      trajectoryList.add(trajectoryUtrechtToAmsterdam);

      return trajectoryList;
   }

   public ArrayList<Trajectory> loadBusTrajectory(){
      ArrayList<Station> utrechtToAmesfoort = new ArrayList();

      utrechtToAmesfoort.add(new Station("Utrecht CS",4 ,2.04));
      utrechtToAmesfoort.add(new Station("Vredenburg",1 ,2.04));
      utrechtToAmesfoort.add(new Station("Neude",1 ,2.04));
      utrechtToAmesfoort.add(new Station("Janskerkhof",1 ,2.04));
      utrechtToAmesfoort.add(new Station("Stadsschouwburg",2 ,2.04));
      utrechtToAmesfoort.add(new Station("Wittevrouwen",1 ,2.04));
      utrechtToAmesfoort.add(new Station("Oorsprongpark",2 ,2.04));
      utrechtToAmesfoort.add(new Station("Archimedeslaan",1 ,2.04));
      utrechtToAmesfoort.add(new Station("Steinenburglaan",1 ,2.04));
      utrechtToAmesfoort.add(new Station("Kerklaan, De Bilt",3 ,2.04));
      utrechtToAmesfoort.add(new Station("KNMI, De Bilt",3 ,0));
      utrechtToAmesfoort.add(new Station("Amesfoortseweg, De Bilt",0,0)); // end station
      Trajectory trajectoryUtrechtToAmsterdam = new Trajectory(utrechtToAmesfoort,30,20);

      trajectoryList.add(trajectoryUtrechtToAmsterdam);
      
      return trajectoryList;
   }



   public Trajectory getTrajectory(int index){
      return trajectoryList.get(index);
   }
}
