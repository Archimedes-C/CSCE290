
import java.util.ArrayList;
import java.util.UUID;

/**
 * @author Andrew Chisolm, Bryan Munoz, Matt Olson, Daniel Ruiz, Jaden Arnold
 * List of all Users
 */
public class UserList {

    private ArrayList<User> users;
    private ArrayList<Camper> campers;
    private ArrayList<Counselor> counselors;
    private ArrayList<Director> directors;
    private static UserList userList;
    /**
     * The list of users
     */
    private UserList() {
        users = DataReader.getAllUsers();
        campers = DataReader.getAllCampers();
        counselors = DataReader.getAllCounselors();
        directors = DataReader.getAllDirectors();
    }
    /**
     * Makes a new userlist if one is not there
     * @return a new UserList
     */
    public static UserList getInstance() {
        if (userList == null) {
            userList = new UserList();
        }
        return userList;
    }
    
    /**
     * Adds a user to camper nad Users then saves
     * @param camper The name of the camper
     */
    public void addUser(Camper camper) {
        users.add(camper);
        campers.add(camper);
        DataWriter.saveAllUsers();
    }
    /**
     * Adds a user to counselor and users
     * @param counselor The name of the counselor
     */
    public void addUser(Counselor counselor) {
        users.add(counselor);
        counselors.add(counselor);
        DataWriter.saveAllUsers();
    }
    /**
     * Adds a user to diectors and users
     * @param director The name of the director
     */
    public void addUser(Director director) {
        users.add(director);
        directors.add(director);
        DataWriter.saveAllUsers();
    }

    /**
     * Accessor for User ArrayList
     * @return users
     */
    public ArrayList<User> getUsers() {
        return users;
    }
    public ArrayList<Camper> getCampers() {
        return campers;
    }
    public ArrayList<Counselor> getCounselors() {
        return counselors;
    }
    public ArrayList<Director> getDirectors() {
        return directors;
    }

    /**
     * Searches for a user by name
     * @param firstName user's first name
     * @param lastName user's last name
     * @return the user; null if not found
     */
    public User getUserByName(String firstName, String lastName) {
        for(User user : users) {
            if(user.getFullName().strip().equalsIgnoreCase(firstName + " " + lastName)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Searches for a user by UUID
     * @param id UUID
     * @return the user; null if not found
     */
    public User getUserByUUID(UUID id) {
        for(User user : users) {
            if(user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Removes a user from the list
     * @param firstName user's first name
     * @param lastName user's last name
     */
    public void removeUser(String firstName, String lastName) {
        for(User user : users) {
            if(user.getFullName().strip().equalsIgnoreCase(firstName + " " + lastName)) {
                users.remove(user);
                campers.remove(user);
                counselors.remove(user);
                directors.remove(user);
            }
        }
        DataWriter.saveAllUsers();
    }
}
