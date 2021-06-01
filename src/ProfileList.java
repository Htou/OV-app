import org.json.JSONObject;
import org.json.JSONTokener;
import java.io.*;
import java.util.ArrayList;

//BluePrint ProfileList class

public class ProfileList {

//    final String fname = "profiles.json";
//
//    File file = new File( fname );

    public ProfileList(){
    }

    private ArrayList<Profile> profiles = new ArrayList<>();

    //addprofile to profileList
    public void addProfile( Profile profile )
    {
        profiles.add( profile );
    }

    //save profilList in file with filewriter
    public void save( File file ) {
        try
        {
            FileWriter fileWriter = new FileWriter( file );

            for (Profile p : profiles)
            {
                fileWriter.write( p.toJSON().toString() + "\n");
            }
            Profile p = new Profile( "===EOF===","" );
            fileWriter.write( p.toJSON().toString() );

            fileWriter.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    //load profileList in file with FileInputStream
    public void load( File file) {
        profiles.clear();

        try
        {
            InputStream inputStream = new FileInputStream( file );

            //The JSONTokener allows an application to break a string into tokens
            JSONTokener tokener = new JSONTokener( inputStream );

            while (true )
            {
                JSONObject object = new JSONObject( tokener );
                System.out.println(object);
                Profile profile = new Profile( object.get("name").toString(),
                        object.get("password").toString() );

                if ( !profile.getName().equals( "===EOF==="))
                {
                    profiles.add( profile );
                }
                else
                {
                    break;
                }
            }

        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    //prints profiles
    public void write() {
        for (var p : profiles)
        {
            p.write();
        }
    }

    public ProfileList(ArrayList<Profile> profiles){
        this.profiles = profiles;
    }

    public ArrayList<Profile> getProfiles(){
        return this.profiles;
    }

}
