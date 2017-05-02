package ca.stepmonster.travel.model;


/**
 * Created by judy on 4/26/17.
 */
public class User {
    private String name;
    private String password;
    private String displayName;

    public User(String name, String password) {
        this.name = name;
        this.displayName = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setDisplayName(String name) {
        if (null != name)
            this.displayName = name;
    }

    public String getDisplayName(){
        return displayName;
    }

    public void setPassword(String password){
        if (null != password)
            this.password = password;
    }

}
