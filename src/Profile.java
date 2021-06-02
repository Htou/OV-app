import org.json.JSONArray;
import org.json.JSONObject;

public class Profile {
    private String name;
    private String password;
    private TravelHistoryList travelHistorylist;


    public Profile(String name, String password) {
        this.name = name;
        this.password = password;
        TravelHistory travelHistory = new TravelHistory();
        this.travelHistorylist = new TravelHistoryList(travelHistory);
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
        JSONObject profileJSON = new JSONObject();
        profileJSON.put("name", name);
        profileJSON.put("password", password);
        profileJSON.put("travelHistoryList", travelHistorylist.getTravelHistoryList().get(0));
        return profileJSON;
    }

    //set JSONObject to javacode(String)
    public Profile(JSONObject profileJSON) {
        name = profileJSON.getString("name");
        password = profileJSON.getString("password");

        JSONArray arr = profileJSON.getJSONArray("travelHistoryList");
        for (int i = 0; i < arr.length(); i++) {
            JSONObject historyList = arr.getJSONObject(i);
            System.out.println(historyList);
        }

    }




    //print name and password
    public void write() {
        System.out.print("name=" + name);
        System.out.print("password=" + password);
    }

}

