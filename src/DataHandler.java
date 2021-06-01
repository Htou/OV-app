import com.google.gson.Gson;

import java.io.*;

public class DataHandler {

    public static ProfileList loadProfileList() throws IOException {

        Gson gson = new Gson();
        Reader reader = new FileReader("/home/yawgmoth/Dropbox/HU-ADSD/S1/Periode1/OV-app/src/ProfileData.json");

        ProfileList profileList = gson.fromJson(reader, ProfileList.class);

        reader.close();
        return profileList;

    }


    public static void saveProfileList(ProfileList profileList) throws IOException {
        Writer writer = new FileWriter("/home/yawgmoth/Dropbox/HU-ADSD/S1/Periode1/OV-app/src/ProfileData.json");
        Gson gson = new Gson();
        // 1. Java object to JSON file
        gson.toJson(profileList, writer);
        writer.flush(); //flush data to file   <---
    }


    public static void createUserProfile() throws IOException {
        //ProfileList profileList = DataHandler.loadProfileList();
        ProfileList profileList = new ProfileList();
        Profile profile = new Profile("Hichem", "123");

        profileList.addProfile(profile);
        profileList.addProfile(profile);
        profileList.addProfile(profile);
        profileList.addProfile(profile);
        profileList.addProfile(profile);
        profileList.addProfile(profile);

        DataHandler.saveProfileList(profileList);
    }

}
