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


}

