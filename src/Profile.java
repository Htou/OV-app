public class Profile {
    private String name;
    private String password;

    public Profile(String name, String password){
        this.name = name;
        this.password = password;
    }

    public String getName(){
        return name;
    }
    public String getPassword(){
        return password;
    }
}
