
import java.util.ArrayList;
import java.util.UUID;

/**
 * @author Andrew Chisolm, Bryan Munoz, Matt Olson, Daniel Ruiz, Jaden Arnold
 * An Attendee is anyone attending the camp (counselors and campers)
 */
public abstract class Attendee extends User {
    
    protected String birthdate;
    protected String address;
    protected String guardianName;
    protected String pediatricCare;
    protected String pediatritionName;
    protected String pediatritionPhone;
    protected EmergencyContact contact;
    protected EmergencyContact contact2;
    protected ArrayList<String> allergies;
    protected ArrayList<String> diets;
    /**
     * The attendee before the randomly generated id
     * @param firstName The first name of the attendee
     * @param lastName The last name of the attendee
     * @param accounttype The account type of the attendee
     * @param email The email of the attendee
     * @param birthdate The birthday of the attendee
     * @param address The home address of the attendee
     * @param guardianName The name of the attendee's guardian
     * @param pediatritianCare The name of the attendee's pediatric clinic
     * @param pediatritianName The name of the attendee's pediatritian
     * @param accounttype2 The 2nd account type of the attendee
     * @param contact The phone number of the attendee
     * @param allergies The allergies that the attendee has
     * @param diets The diet the attendee has
     */
    public Attendee(String firstName, String lastName, String accounttype, String email,
                    String birthdate, String address, String guardianName,  String pediatricCare,
                    String pediatritianName, String accounttype2,
                    EmergencyContact contact, EmergencyContact contact2, ArrayList<String> allergies,
                    ArrayList<String> diets) {
        super(firstName, lastName, accounttype, email);
        this.birthdate = birthdate;
        this.address = address;
        this.guardianName = guardianName;
        this.pediatricCare = pediatricCare;
        this.pediatritionName = pediatritianName;
        this.pediatritionPhone = accounttype2;
        this.contact = contact;
        this.contact2 = contact2;
        this.allergies = allergies;
        this.diets = diets;
    }
    /**
     * The attendee after the id is created
     * @param id The randomly generated id for the attendee
     * @param firstName The first name of the attendee
     * @param lastName The last name of the attendee
     * @param email The email of the attendee
     * @param birthdate The birthday of the attendee
     * @param address The home address of the attendee
     * @param guardianName The name of the attendee's guardian
     * @param pediatritianName The name of the attendee's pediatritia
     * @param contact The phone number of the attendee
     * @param allergies The allergies that the attendee has
     * @param diets The diet the attendee has
     */
    public Attendee(UUID id,String firstName, String lastName, String accounttype, String email,
                    String birthdate, String address, String guardianName,  String pediatricCare,
                    String pediatritianName, String accounttype2,
                    EmergencyContact contact, EmergencyContact contact2, ArrayList<String> allergies,
                    ArrayList<String> diets) {
        super(id, firstName, lastName, accounttype, email);
        this.birthdate = birthdate;
        this.address = address;
        this.guardianName = guardianName;
        this.pediatricCare = pediatricCare;
        this.pediatritionName = pediatritianName;
        this.pediatritionPhone = accounttype2;
        this.contact = contact;
        this.contact2 = contact2;
        this.allergies = allergies;
        this.diets = diets;
    }

    /**
     * Gets the birthday of the attendee
     * @return The birthday of the attendee
     */
    public String getBirthdate() {
        return birthdate;
    }
    /**
     * Gets the Address of the attendee
     * @return The Address of the attendee
     */
    public String getAddress() {
        return address;
    }
    /**
     * Gets the guardian name of the attendee
     * @return The guardian of the attendee
     */
    public String getGuardianName() {
        return guardianName;
    }
      /**
     * Gets the attendees pediatritians name
     * @return The attendees pediatritians name
     */
    public String getPediatritianCare() {
        return pediatricCare;
    }
    /**
     * Gets the attendees pediatritians name
     * @return The attendees pediatritians name
     */
    public String getPediatritianName() {
        return pediatritionName;
    }
    /**
     * Gets the attendees pediatritians phone number
     * @return The attendees pediatritians phone number
     */
    public String getPediatritianPhone() {
        return pediatritionPhone;
    }
    /**
     * Gets the attendees emergency contact
     * @return The attendees emergency contact
     */
    public EmergencyContact getEmergencyContact() {
        return contact;
    }
      /**
     * Gets the attendees emergency contact
     * @return The attendees emergency contact
     */
    public EmergencyContact getEmergencyContact2() {
        return contact2;
    }
    /**
     * Gets the attendees allergies
     * @return The attendees allergies
     */
    public ArrayList<String> getAllergies() {
        return allergies;
    }
    /**
     * Gets the attendees diet
     * @return The attendees diet
     */
    public ArrayList<String> getDiets() {
        return diets;
    }
}
