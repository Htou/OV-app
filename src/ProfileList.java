import java.util.ArrayList;

public class ProfileList {


    private ArrayList<Profile> profileList = new ArrayList<>();

    public ProfileList() {
    }

    public void addProfile(Profile profile) {
        this.profileList.add(profile);
    }


    public ArrayList<Profile> getProfileList() {
        return this.profileList;
    }

}
