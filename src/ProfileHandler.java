import java.util.ArrayList;

public class ProfileHandler {
    public ArrayList<Profile> loadProfiles(){
        ArrayList<Profile> profiles = new ArrayList<Profile>();

        Profile profile1 = new Profile("Selma","1111");
        Profile profile2 = new Profile("Thijmen","2222");
        Profile profile3 = new Profile("Hichem","3333");
        Profile profile4 = new Profile("Amine","4444");

        profiles.add(profile1);
        profiles.add(profile2);
        profiles.add(profile3);
        profiles.add(profile4);


        return profiles;
    }
}
