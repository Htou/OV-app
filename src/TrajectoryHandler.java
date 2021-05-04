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

      ArrayList<Station> stationUtrechtToZwolle = new ArrayList();
      stationUtrechtToAmsterdam.add(new Station("Utrecht CS",4,4.2));
      stationUtrechtToAmsterdam.add(new Station("Utrecht Overvecht",5 ,11.1));
      stationUtrechtToAmsterdam.add(new Station("Bilthoven",3 ,2.9));
      stationUtrechtToAmsterdam.add(new Station("Den Dolder",9 ,13.5));
      stationUtrechtToAmsterdam.add(new Station("Amesfoort Centraal",4,11.8));
      stationUtrechtToAmsterdam.add(new Station("Amesfoort Schothorst",3 ,5.0));
      stationUtrechtToAmsterdam.add(new Station("Amesfoort Vathorst",5,9.5));
      stationUtrechtToAmsterdam.add(new Station("Nijkerk",5 ,11.0));
      stationUtrechtToAmsterdam.add(new Station("Putten",5 ,7.2));
      stationUtrechtToAmsterdam.add(new Station("Ermelo",4 ,6.6));
      stationUtrechtToAmsterdam.add(new Station("Hardewijk",8 ,11.7));
      stationUtrechtToAmsterdam.add(new Station("Nunspeet",6 ,12.0));
      stationUtrechtToAmsterdam.add(new Station("'t Harde",7 ,11.6));
      stationUtrechtToAmsterdam.add(new Station("Wezep",7 ,10.5));
      stationUtrechtToAmsterdam.add(new Station("Zwolle Centraal",0 ,0));
      Trajectory trajectoryUtrechtToZwolle = new Trajectory(stationUtrechtToZwolle,30,20,"train");




      //Bus trajectories
      //===========================================================================================================
      ArrayList<Station> utrechtToAmesfoort = new ArrayList();
      utrechtToAmesfoort.add(new Station("Utrecht CS",4 ,1.5));
      utrechtToAmesfoort.add(new Station("Vredenburg",1 ,2.4));
      utrechtToAmesfoort.add(new Station("Neude",1 ,0.3));
      utrechtToAmesfoort.add(new Station("Janskerkhof",1 ,1.0));
      utrechtToAmesfoort.add(new Station("Stadsschouwburg",2 ,1.5));
      utrechtToAmesfoort.add(new Station("Wittevrouwen",1 ,2.4));
      utrechtToAmesfoort.add(new Station("Oorsprongpark",2 ,1.7));
      utrechtToAmesfoort.add(new Station("Archimedeslaan",1 ,2.6));
      utrechtToAmesfoort.add(new Station("Steinenburglaan",1 ,0.8));
      utrechtToAmesfoort.add(new Station("Kerklaan, De Bilt",3 ,3.4));
      utrechtToAmesfoort.add(new Station("KNMI, De Bilt",3 ,5.3));
      utrechtToAmesfoort.add(new Station("Amesfoortseweg, De Bilt",0,0)); // end station
      Trajectory trajectoryUtrechtToAmesfoort = new Trajectory(utrechtToAmesfoort,30,20,"bus");


      ArrayList<Station> utrechtToZeist = new ArrayList();
      utrechtToZeist.add(new Station("Utrecht CS",4 ,1.5));
      utrechtToZeist.add(new Station("Neude",1 ,0.3));
      utrechtToZeist.add(new Station("Janskerkhof",1 ,1.0));
      utrechtToZeist.add(new Station("Stadsschouwburg",2 ,1.5));
      utrechtToZeist.add(new Station("Wittevrouwen",1 ,2.4));
      utrechtToZeist.add(new Station("Oorsprongpark",2 ,1.7));
      utrechtToZeist.add(new Station("KNMI, De Bilt",4 ,2.4));// end station
      utrechtToZeist.add(new Station("Jordanlaan",5 ,1.5));// end station
      utrechtToZeist.add(new Station("Winkelcentrum Vollenhove",1 ,0.3));// end station
      utrechtToZeist.add(new Station("Gunningenlaan Vollenhove",1 ,0.5));// end station
      utrechtToZeist.add(new Station("L-Flat",1 ,0.7));// end station
      utrechtToZeist.add(new Station("De Dreef/Panweg",3 ,0.6));// end station
      utrechtToZeist.add(new Station("Nepveulaan",4 ,1.5));// end station
      utrechtToZeist.add(new Station("Schaerweijdelaan",3 ,1.5));// end station
      utrechtToZeist.add(new Station("Steylaan",3 ,0.7));// end station
      utrechtToZeist.add(new Station("Bussation zeist",0 ,0));// end station
      Trajectory trajectoryUtrechtToZeist = new Trajectory(utrechtToZeist,30,20, "bus");

      //Bus trajectories
      trajectoryList.add(trajectoryUtrechtToZeist);
      trajectoryList.add(trajectoryUtrechtToAmesfoort);

      //Train trajectories
      trajectoryList.add(trajectoryUtrechtToAmsterdam);
      trajectoryList.add(trajectoryUtrechtToZwolle);

      return trajectoryList;
   }

   public ArrayList<Trajectory> loadBusTrajectory(){


      return trajectoryList;
   }



   public Trajectory getTrajectory(int index){
      return trajectoryList.get(index);
   }
}
