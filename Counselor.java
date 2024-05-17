
import java.util.ArrayList;
import java.util.UUID;

/**
 * @author Andrew Chisolm, Bryan Munoz, Matt Olson, Daniel Ruiz, Jaden Arnold
 * A counselor at the camp
 */
public class Counselor extends Attendee {
    
    private String bio;
    /**
     * The counsleors information before the ID
     * @param firstName The first name of the counsleor
     * @param lastName The last name of the counsleor
     * @param phone The phone number for the counsleor
     * @param email The email of the counsleor
     * @param birthdate The birthday of the counsleor
     * @param address The address of the counsleor
     * @param guardianName The parent of the counsleor
     * @param pediatricCare The name of the counsleors pediatric clinic
     * @param pediatritianName The name of the counsleors pediatritian
     * @param pediatritianPhone The phone number of the counsleors pediatritian
     * @param contact The emergency contact information for the counselor
     * @param allergies The allergies that the counselor has
     * @param diets The diet that the counselor has
     * @param bio The bio that the counselor made
     */
    public Counselor(String firstName, String lastName, String phone, String email,
                     String birthdate, String address, String guardianName, String pediatricCare,
                     String pediatritianName, String pediatritianPhone,
                     EmergencyContact contact, EmergencyContact contact2, ArrayList<String> allergies,
                     ArrayList<String> diets, String bio) {
        super(firstName, lastName, phone, email, birthdate, address, guardianName, pediatricCare,
        pediatritianName, pediatritianPhone, contact, contact2, allergies, diets);
        this.bio = bio;
    }
    /**
     * Counselor information after the id is made
     * @param id The randomly generated id for the counseleor
     * @param firstName The first name of the counsleor
     * @param lastName The last name of the counsleor
     * @param phone The phone number for the counsleor
     * @param email The email of the counsleor
     * @param birthdate The birthday of the counsleor
     * @param address The address of the counsleor
     * @param guardianName The parent of the counsleor
     * @param pediatricCare The name of the counsleors pediatric clinic
     * @param pediatritianName The name of the counsleors pediatritian
     * @param pediatritianPhone The phone number of the counsleors pediatritian
     * @param contact The emergency contact information for the counselor
     * @param allergies The allergies that the counselor has
     * @param diets The diet that the counselor has
     * @param bio The bio that the counselor made
     */
    public Counselor(UUID id, String firstName, String lastName, String phone, String email,
                     String birthdate, String address, String guardianName, String pediatricCare,
                     String pediatritianName, String pediatritianPhone,
                     EmergencyContact contact, EmergencyContact contact2, ArrayList<String> allergies,
                     ArrayList<String> diets, String bio) {
        super(id, firstName, lastName, phone, email, birthdate, address, guardianName, pediatricCare,
              pediatritianName, pediatritianPhone, contact, contact2, allergies, diets);
        this.bio = bio;
    }

    /**
     * Accesor for bio
     * @return bio
     */
    public String getBio() {
        return bio;
    }

    /**
     * Adds a strike to a camper
     * @param camper the camper
     */
    public void addStrike(Camper camper) {
        camper.addStrike();
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
        ret += "\nAllergies: ";
        for(String allergy : this.allergies) ret+=allergy + " ";
        ret += "\nDiets: ";
        for(String diet : this.diets) ret+=diet + " ";
        ret += "\nBio: " + bio;
        return ret;
    }
}
