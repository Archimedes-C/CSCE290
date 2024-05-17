
import java.util.ArrayList;
import java.util.UUID;

/**
 * @author Andrew Chisolm, Bryan Munoz, Matt Olson, Daniel Ruiz, Jaden Arnold
 * A camper at the camp
 */
public class Camper extends Attendee {
    private int strikes;
    /**
     * Camper information
     * @param firstName The campers firstname
     * @param lastName The campers lastname
     * @param phone The parents phone number
     * @param email The parents email
     * @param birthdate The campers birthday
     * @param address The parents address
     * @param guardianName One parents name
     * @param pediatritianName The name of the campers pediatritian
     * @param pediatritianPhone The phone number of the campers pediatritian
     * @param contact The campers emergency contact number
     * @param allergies The allergies that the camper has
     * @param diets The diet that the camper has
     * @param accounttype The type of account the user is
     */
    public Camper(String firstName, String lastName, String phone, String email,
                  String birthdate, String address, String guardianName, String pediatricCare,
                  String pediatritianName, String pediatritianPhone,
                  EmergencyContact contact, EmergencyContact contact2, ArrayList<String> allergies,
                  ArrayList<String> diets) {
        super(firstName, lastName, phone, email, birthdate, address, guardianName, pediatricCare,
              pediatritianName, pediatritianPhone, contact, contact2, allergies, diets);
        this.strikes = 0;
        DataWriter.saveAllUsers();
    }
    /**
     * 
     * @param id The id that for the user
     * @param firstName The first name of the camper
     * @param lastName The last name of the camper
     * @param phone The phone number of the parent
     * @param email The parents email
     * @param birthdate The birthday of the camper
     * @param address The address of the parent
     * @param guardianName The name of the parent
     * @param pediatritianName The name of the campers pediatritian
     * @param pediatritianPhone The phone number of the campers pediatritian
     * @param contact The emergency number for the camper
     * @param allergies The allergies that the camper has
     * @param diets The diet that the camper has
     * @param strikes The amount of strikes the camper has
     */
    public Camper(UUID id, String firstName, String lastName, String phone, String email,
                  String birthdate, String address, String guardianName, String pediatricCare,
                  String pediatritianName, String pediatritianPhone,
                  EmergencyContact contact, EmergencyContact contact2, ArrayList<String> allergies,
                  ArrayList<String> diets, int strikes) {
        super(id,firstName, lastName, phone, email, birthdate, address, guardianName, pediatricCare,
        pediatritianName, pediatritianPhone, contact, contact2, allergies, diets);
        this.strikes = strikes;
    }

    /**
     * Accessor for strikes
     * @return strikes
     */
    public int getStrikes() {
        return strikes;
    }

    /**
     * Adds a strike
     */
    public void addStrike() {
        this.strikes++;
    }


    /**
     * Returns true if the camper is suspended (has 3 strikes)
     * @return true if the camper is suspended
     */
    public boolean isSuspended() {
        return strikes >= 3;
    }
    
    /**
     * Returns counselor information in a readable format
     */
    public String toString() {
        String ret = "First Name: " + this.firstName;
        ret += "\nLast Name: " + this.lastName;
        ret += "\nPhone Number: " + this.phone;
        ret += "\nEmail: " + this.email;
        ret += "\nGuardan: " + this.guardianName;
        ret += "\nPediatric Clinic: " + this.pediatricCare;
        ret += "\nPediatrition: " + this.pediatritionName;
        ret += "\nPediatrition Phone Number: " + this.pediatritionPhone;
        ret += "\n" + this.contact;
        ret += "\n" + this.contact2;
        ret += "\nAllergies: ";
        for(String allergy : this.allergies) ret+=allergy + " ";
        ret += "\nDiets: ";
        for(String diet : this.diets) ret+=diet + " ";
        ret += "\nStrikes: " +this.strikes;
        return ret;
    }
}
