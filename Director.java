
import java.util.UUID;

/**
 * @author Andrew Chisolm, Bryan Munoz, Matt Olson, Daniel Ruiz, Jaden Arnold
 * The director of the camp
 */
public class Director extends User {
    /**
     * The directors information
     * @param firstName The first name of the director
     * @param lastName The last name of the director
     * @param phone The phone number of the director
     * @param email The directors email
     */
    public Director(String firstName, String lastName, String phone, String email) {
        super(firstName, lastName, phone, email);
    }
    /**
     * The directors information with the randomly generated id
     * @param id The randomly generated id associated with the director
     * @param firstName The first name of the director
     * @param lastName The last name of the director
     * @param phone The phone number of the director
     * @param email The directors email
     */
    public Director(UUID id, String firstName, String lastName, String phone, String email) {
        super(id, firstName, lastName, phone, email);
    }

    /**
     * Removes a camper from the system
     * @param firstName camper's first name
     * @param lastName camper's last name
     * @param userList the system's userList
     */
    public void rmCamper(String firstName, String lastName, UserList userList) {
        userList.removeUser(firstName, lastName);
    }

    /**
     * Returns director information in a readable format
     */
    public String toString() {
        String ret = "First Name: " + this.firstName;
        ret += "\nLast Name: " + this.lastName;
        ret += "\nPhone Number: " + this.phone;
        ret += "\nEmail: " + this.email;
        return ret;
    }
}
