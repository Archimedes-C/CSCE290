import java.util.ArrayList;
/**
 * @author Andrew Chisolm, Bryan Munoz, Matt Olson, Daniel Ruiz, Jaden Arnold
 * The Facade for the camp system
 */


 
public class CampSystemFACADE {

    private Account account;
    private AccountList accountList;
    private UserList userList;
    private SessionList sessionList;
    /**
     * Creates a new list for all types of users
     */
    public CampSystemFACADE() {
        userList = UserList.getInstance();
        accountList = AccountList.getInstance();
        sessionList = SessionList.getInstance();
    }
    /**
     * Prints the title of the method 
     * @param working the current method
     */
    public void current(String working) {
        System.out.println("");
        System.out.println("*********** "+ working +" ***********");
    }

    /**
     * Accessor for account
     * @return the current account
     */
    public Account getAccount() {
        return account;
    }

    /**
     * Returns true if there is an account with the given username
     * @param username account username
     * @return true if there is an account with the given username
     */
    public boolean findAccount(String username) {
        return accountList.getAccount(username) != null;
    }

    /**
     * Checks to see if the entered password is correct
     * @param username user-entered username
     * @param password user-entered password
     * @return results
     */
    public boolean checkPassword(String username, String password) {
        return accountList.getAccount(username).getPassword().equals(password);
    }

    /**
     * Log ins the user using account information
     * Assumes username and password are correct
     * @param username The username that the user set
     * @param password The password that the user set
     */
    public void login(String username, String password){
        account = accountList.getAccount(username);
    }
    /**
     * Creates an account with the username and password that the user set
     * Logs in to the new account
     * @param username The username assoicated with the users account
     * @param password The password associated with the users account
     * @return a String to be printed
     */
    public String signUp(String username, String password){
        account = new Account(username, password);
        accountList.addAccount(account);
        return "Account created.";
    }
    /**
     * Gets the session based on week
     * @param week the session numbeer
     * @return the session
     */
    public Session getSession(int week){
        return sessionList.getSession(week);
    }

    /**
     * Finds a list of all the sessions a camper is enrolled in
     * @param camper the camper
     * @return sessions camper is enrolled in
     */
    public ArrayList<Session> getCamperSessions(Camper camper) {
        ArrayList<Session> sessions = new ArrayList<Session>();
        for(Session session : sessionList.getSessions()) {
            for(Cabin cabin : session.getCabins()) {
                for(Camper c : cabin.getCampers()) {
                    if(c.getId().equals(camper.getId())) {
                        sessions.add(session);
                    }
                }
            }
        }
        return sessions;
    }

    /**
     * Views the users in the system
     * @param user the user that will be viewed
     * @return the user that is viewed
     */
    public String viewUser(User user){
        return user.getFullName();
    }
    /**
     * Views the schedule of the attendee
     * @param attendee the attendee of the camp
     * @return the schedule
     */
    public String viewSchedule(Attendee attendee){
        current("Schedule");
        return null;
    }

    public Camper registerCamper(String first, String last, String phone, String email, String bday, String address, String Gname, String Pcare, String Pname, String Pphone, EmergencyContact contact, EmergencyContact contact2 , ArrayList<String> Allergies, ArrayList<String> Diet) {
        Camper camper = new Camper(first, last, phone, email, bday, address, Gname, Pcare, Pname, Pphone, contact, contact2, Allergies, Diet);
        account.addUser(camper);
        userList.addUser(camper);
        DataWriter.saveAllUsers();
        DataWriter.saveAllAccounts();
        return camper;
    }
    /**
     * Calcuates how much it would cost to go to the camp
     * @param weeks the amount of weeks the camper is attending
     * @return the total cost based on the amount of weeks
     */
    public int calculatePrice(int weeks){
        current("Payment");
        return 0;
    }


}
