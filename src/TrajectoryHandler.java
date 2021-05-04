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
      Trajectory trajectoryUtrechtToZeist = new Trajectory(utrechtToZeist,30,20);

      trajectoryList.add(trajectoryUtrechtToAmesfoort);




      trajectoryList.add(trajectoryUtrechtToZeist);
      trajectoryList.add(trajectoryUtrechtToAmesfoort);
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
