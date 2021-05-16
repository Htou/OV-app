import java.util.ArrayList;

public class TrajectoryHandler {
   private ArrayList<Trajectory> trajectoryList = new ArrayList();


   public ArrayList<Trajectory> loadTrainTrajectory(){
      ArrayList<Station> stationUtrechtToAmsterdamTrain = new ArrayList();

      stationUtrechtToAmsterdamTrain.add(new Station("Utrecht CS",3 ,2.04));
      stationUtrechtToAmsterdamTrain.add(new Station("Utrecht Zuilen",5 ,5.29));
      stationUtrechtToAmsterdamTrain.add(new Station("Maarssen",4 ,4.83));
      stationUtrechtToAmsterdamTrain.add(new Station("Breukelen",10 ,12.1));
      stationUtrechtToAmsterdamTrain.add(new Station("Abcoude",0 ,0));
      Trajectory trajectoryUtrechtToAmsterdam = new Trajectory(stationUtrechtToAmsterdamTrain,30,20,"train");

      ArrayList<Station> stationUtrechtToZwolleTrain = new ArrayList();
      stationUtrechtToZwolleTrain.add(new Station("Utrecht CS",4,4.2));
      stationUtrechtToZwolleTrain.add(new Station("Utrecht Overvecht",5 ,11.1));
      stationUtrechtToZwolleTrain.add(new Station("Bilthoven",3 ,2.9));
      stationUtrechtToZwolleTrain.add(new Station("Den Dolder",9 ,13.5));
      stationUtrechtToZwolleTrain.add(new Station("Amesfoort Centraal",4,11.8));
      stationUtrechtToZwolleTrain.add(new Station("Amesfoort Schothorst",3 ,5.0));
      stationUtrechtToZwolleTrain.add(new Station("Amesfoort Vathorst",5,9.5));
      stationUtrechtToZwolleTrain.add(new Station("Nijkerk",5 ,11.0));
      stationUtrechtToZwolleTrain.add(new Station("Putten",5 ,7.2));
      stationUtrechtToZwolleTrain.add(new Station("Ermelo",4 ,6.6));
      stationUtrechtToZwolleTrain.add(new Station("Hardewijk",8 ,11.7));
      stationUtrechtToZwolleTrain.add(new Station("Nunspeet",6 ,12.0));
      stationUtrechtToZwolleTrain.add(new Station("'t Harde",7 ,11.6));
      stationUtrechtToZwolleTrain.add(new Station("Wezep",7 ,10.5));
      stationUtrechtToZwolleTrain.add(new Station("Zwolle Centraal",0 ,0));
      Trajectory trajectoryUtrechtToZwolle = new Trajectory(stationUtrechtToZwolleTrain,30,21,"train");




      //Bus trajectories
      //===========================================================================================================
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
      Trajectory trajectoryUtrechtToAmesfoort = new Trajectory(utrechtToAmesfoortBus,30,20,"bus");


      ArrayList<Station> utrechtToZeistBus = new ArrayList();
      utrechtToZeistBus.add(new Station("Utrecht CS",4 ,1.5));
      utrechtToZeistBus.add(new Station("Neude",1 ,0.3));
      utrechtToZeistBus.add(new Station("Janskerkhof",1 ,1.0));
      utrechtToZeistBus.add(new Station("Stadsschouwburg",2 ,1.5));
      utrechtToZeistBus.add(new Station("Wittevrouwen",1 ,2.4));
      utrechtToZeistBus.add(new Station("Oorsprongpark",2 ,1.7));
      utrechtToZeistBus.add(new Station("KNMI, De Bilt",4 ,2.4));// end station
      utrechtToZeistBus.add(new Station("Jordanlaan",5 ,1.5));// end station
      utrechtToZeistBus.add(new Station("Winkelcentrum Vollenhove",1 ,0.3));// end station
      utrechtToZeistBus.add(new Station("Gunningenlaan Vollenhove",1 ,0.5));// end station
      utrechtToZeistBus.add(new Station("L-Flat",1 ,0.7));// end station
      utrechtToZeistBus.add(new Station("De Dreef/Panweg",3 ,0.6));// end station
      utrechtToZeistBus.add(new Station("Nepveulaan",4 ,1.5));// end station
      utrechtToZeistBus.add(new Station("Schaerweijdelaan",3 ,1.5));// end station
      utrechtToZeistBus.add(new Station("Steylaan",3 ,0.7));// end station
      utrechtToZeistBus.add(new Station("Bussation zeist",0 ,0));// end station
      Trajectory trajectoryUtrechtToZeist = new Trajectory(utrechtToZeistBus,30,20, "bus");

      //Bus trajectories
      trajectoryList.add(trajectoryUtrechtToZeist);
      trajectoryList.add(trajectoryUtrechtToAmesfoort);

      //Train trajectories
      trajectoryList.add(trajectoryUtrechtToAmsterdam);
      trajectoryList.add(trajectoryUtrechtToZwolle);

      return trajectoryList;
   }




   public Trajectory getTrajectory(int index){
      return trajectoryList.get(index);
   }
}
