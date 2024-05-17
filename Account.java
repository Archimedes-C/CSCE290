import java.util.ArrayList;

/**
 * @author Andrew Chisolm, Bryan Munoz, Matt Olson, Daniel Ruiz, Jaden Arnold
 * A account in the camp system
 */
public class Account {
    private String username;
    private String password;
    private ArrayList<User> users;

    /**
     * Account information of the user
     * @param username Users username that is accoiated with there account
     * @param password Users password that is accoiated with there account
     */
    public Account(String username, String password){
        this.username = username;
        this.password = password;
        this.users = new ArrayList<User>();
    }

    /**
     * Username accessor
     * @return username
     */
    public String getUsername() {
        return username;
    }
    /**
     * Password accessor
     * @return password
     */
    public String getPassword() {
        return password;
    }
    /**
     * Accessor for list of Users
     * @return users
     */
    public ArrayList<User> getUsers() {
        return users;
    }

    /**
     * Adds the user to the arraylist
     * @param user the user
     */
    public void addUser(User user){
        users.add(user);
    }
}

