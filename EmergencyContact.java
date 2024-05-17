

/**
 * @author Andrew Chisolm, Bryan Munoz, Matt Olson, Daniel Ruiz, Jaden Arnold
 * Represents an emergency contact
 */
public class EmergencyContact {

    private String phone;
    private String name;
    /**
     * Sets the emergency contact information
     * @param phone
     * @param name
     */
    public EmergencyContact(String name, String phone) {
        this.phone = phone;
        this.name = name;
    }

    /**
     * Gets the phone number for the emergency contact
     * @return The phone number of the emergency contact
     */
    public String getPhone() {
        return phone;
    }
    /**
     * Gets the name of the emergency contact
     * @return The name of the emergency contact
     */
    public String getName() {
        return name;
    }

    /**
     * toString that displays the emergency contact information
     * @return all the emergency contact information in a readable format
     */
    public String toString() {
        return "Emergency contact name: " + this.name + "\nEmergency contact phone: " + this.phone;
    }
}