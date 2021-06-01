import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


//BluePrint Profile class

public class Profile {
    private String name;
    private String password;
    private TravelHistoryList travelHistorylist;
  

    public Profile(String name, String password) {
        this.name = name;
        this.password = password;
        this.travelHistorylist = new TravelHistoryList();
    }

    public String getName() {
        return this.name;
    }

    public String getPassword() {
        return this.password;
    }

    public TravelHistoryList getTravelHistory() {
        return this.travelHistorylist;
    }

    //Convert a profile instance to a JSONObject
    public JSONObject toJSON() {
        JSONObject obj =new JSONObject();
        obj.put("name",name);
        obj.put("password",password);
        return obj;
    }

    //set JSONObject to javacode(String)
    public Profile( JSONObject obj ) {
        name = obj.getString( "name" );
        password=obj.getString("password");
    }

        //print name and password
    public void write() {
        System.out.print( "name=" + name );
        System.out.print( "passwoord"+password);
    }

}

