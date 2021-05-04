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
      Trajectory trajectoryUtrechtToAmsterdam = new Trajectory(stationUtrechtToAmsterdam,30,20,"train");


      ArrayList<Station> utrechtToAmesfoortBus = new ArrayList();

      utrechtToAmesfoortBus.add(new Station("Utrecht CS",4 ,1.5));
      utrechtToAmesfoortBus.add(new Station("Vredenburg",1 ,2.4));
      utrechtToAmesfoortBus.add(new Station("Neude",1 ,0.3));
      utrechtToAmesfoortBus.add(new Station("Janskerkhof",1 ,1.0));
      utrechtToAmesfoortBus.add(new Station("Stadsschouwburg",2 ,1.5));
      utrechtToAmesfoortBus.add(new Station("Wittevrouwen",1 ,2.4));
      utrechtToAmesfoortBus.add(new Station("Oorsprongpark",2 ,1.7));
      utrechtToAmesfoortBus.add(new Station("Archimedeslaan",1 ,2.6));
      utrechtToAmesfoortBus.add(new Station("Steinenburglaan",1 ,0.8));
      utrechtToAmesfoortBus.add(new Station("Kerklaan, De Bilt",3 ,3.4));
      utrechtToAmesfoortBus.add(new Station("KNMI, De Bilt",3 ,5.3));
      utrechtToAmesfoortBus.add(new Station("Amesfoortseweg, De Bilt",0,0)); // end station
      Trajectory trajectoryUtrechtToAmsterdamBus = new Trajectory(utrechtToAmesfoortBus,30,20,"bus");


      trajectoryList.add(trajectoryUtrechtToAmsterdamBus);
      trajectoryList.add(trajectoryUtrechtToAmsterdam);

      return trajectoryList;
   }

   public ArrayList<Trajectory> loadBusTrajectory(){


      return trajectoryList;
   }



   public Trajectory getTrajectory(int index){
      return trajectoryList.get(index);
   }
}
