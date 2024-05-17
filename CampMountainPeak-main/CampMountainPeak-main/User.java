import java.util.UUID;

/**
 * @author Andrew Chisolm, Bryan Munoz, Matt Olson, Daniel Ruiz, Jaden Arnold
 * Abstract class holding all information shared by all users
 */
public abstract class User {
    
    protected UUID id;
    protected String firstName;
    protected String lastName;
    protected String phone;
    protected String email;
    /**
     * Information that all users have and creates a random id
     * @param firstName The first name of the user
     * @param lastName The last name of the user
     * @param phone The phone number associated with the user
     * @param email The email associated with the email
     */
    public User(String firstName, String lastName, String phone, String email) {
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }
    /**
     * Information after the random id has been created
     * @param id The randomly generated id that was given to the user
     * @param firstName The first name of the user
     * @param lastName The last name of the user
     * @param phone The phone number associated with the user
     * @param email The email associated with the email
     */
    public User(UUID id, String firstName, String lastName, String phone, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }

    /**
     * Accessor for name
     * @return user's full name
     */
    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    /**
     * Accessor for id
     * @return user's id
     */
    public UUID getId() {
        return this.id;
    }

    /**
     * Gets the first name of the user
     * @return The first name of the user
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * Gets the last name of the user
     * @return The last name of the user
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * Gets the phone number of the user
     * @return The phone number of the user
     */
    public String getPhone() {
        return phone;
    }
    /**
     * Gets the email of the user
     * @return The email of the user
     */
    public String getEmail() {
        return email;
    }

    /**
     * Returns a String with all User information in a readable format
     */
    public abstract String toString();
}
