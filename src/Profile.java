

public class Profile {
    private String name;
    private String password;
    private TravelHistoryList travelHistoryList;


    public Profile(String name, String password) {
        this.name = name;
        this.password = password;
        this.travelHistoryList = new TravelHistoryList();
    }

    public String getName() {
        return this.name;
    }

    public String getPassword() {
        return this.password;
    }

    public TravelHistoryList getTravelHistorylist() {
        return this.travelHistoryList;
    }

}

