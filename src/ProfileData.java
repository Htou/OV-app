import java.util.ArrayList;

public class ProfileData {
    private ArrayList<Profile> profiles;
    private Profile selectedProfile;



    public ProfileData(ArrayList<Profile> profiles){
        this.profiles = profiles;
    }


    public ArrayList<Profile> getProfiles(){
        return this.profiles;
    }

    public Profile getSelectedProfile(){
        return selectedProfile;
    }

    public void setSelectedProfile(Profile selectedProfile){
        this.selectedProfile = selectedProfile;
    }

}

