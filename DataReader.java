import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * @author Andrew Chisolm, Bryan Munoz, Matt Olson, Daniel Ruiz, Jaden Arnold
 * The data writer for JSON files that gets information from the arraylist
 */
public class DataReader extends DataConstants {
    /**
     * Gets all the accounts in the arrayList Account
     * Must be run after getAllUsers
     * @return All acounts in the system
     */
    public static ArrayList<Account> getAllAccounts(){
        ArrayList<Account> accounts = new ArrayList<Account>();
        try {
            FileReader reader = new FileReader(ACCOUNT_FILE_NAME);
            JSONArray accountsJSON = (JSONArray)new JSONParser().parse(reader);
            for(int i=0; i < accountsJSON.size(); i++)
            {
                JSONObject accountJSON = (JSONObject)accountsJSON.get(i);
                String username = (String)accountJSON.get(ACCOUNT_USERNAME);
                String password = (String)accountJSON.get(ACCOUNT_PASSWORD);
                Account account = new Account(username, password);
                JSONArray userListJSON = (JSONArray)accountJSON.get(ACCOUNT_USERS);
                for(Object id : userListJSON) {
                    if (UserList.getInstance().getUserByUUID(UUID.fromString((String)id)) != null)
                        account.addUser(UserList.getInstance().getUserByUUID(UUID.fromString((String)id)));
                }
                accounts.add(account);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return accounts;
    }
    
    /**
     * Get an ArrayList of Users from users.json
     * @return All the users in the system
     */
    public static ArrayList<User> getAllUsers(){
        ArrayList<User> users = new ArrayList<User>();
        ArrayList<Camper> campers = getAllCampers();
        for(Camper camper : campers) {
            users.add(camper);
        }

        ArrayList<Counselor> counselors = getAllCounselors();
        for(Counselor counselor : counselors) {
            users.add(counselor);
        }
        
        ArrayList<Director> directors = getAllDirectors();
        for(Director director : directors) {
            users.add(director);
        }
        return users;
    }

    public static ArrayList<Camper> getAllCampers() {
        ArrayList<Camper> campers = new ArrayList<Camper>();
        try {
            FileReader reader = new FileReader(USER_FILE_NAME);
            JSONArray usersJSON = (JSONArray)new JSONParser().parse(reader);
            JSONObject camperListJSON = (JSONObject)usersJSON.get(0);
            JSONArray campersJSON = (JSONArray)camperListJSON.get(USER_CAMPER_LIST);
            
            for(int i = 0; i < campersJSON.size(); i++) {  // looping through each camper
                JSONObject camperJSON = (JSONObject)campersJSON.get(i);
                UUID id = UUID.fromString((String)camperJSON.get(USER_ID));
                String firstName = (String)camperJSON.get(USER_FIRST_NAME);
                String lastName = (String)camperJSON.get(USER_LAST_NAME);
                String phone = (String)camperJSON.get(USER_PHONE);
                String email = (String)camperJSON.get(USER_EMAIL);
                String birthdate = (String)camperJSON.get(ATTENDEE_BIRTHDATE);
                String address = (String)camperJSON.get(ATTENDEE_ADDRESS);
                String guardianName = (String)camperJSON.get(ATTENDEE_GUARDIAN_NAME);
                String pediatricCare = (String)camperJSON.get(ATTENDEE_PEDIATRIC_CARE);
                String pediatritianName = (String)camperJSON.get(ATTENDEE_PEDIATRITIAN_NAME);
                String pediatritianPhone = (String)camperJSON.get(ATTENDEE_PEDIATRITIAN_PHONE);
                String emergencyContactName = (String)camperJSON.get(ATTENDEE_EMERGENCY_CONTACT_NAME);
                String emergencyContactPhone = (String)camperJSON.get(ATTENDEE_EMERGENCY_CONTACT_PHONE);
                String emergencyContactName2 = (String)camperJSON.get(ATTENDEE_EMERGENCY_CONTACT_NAME_2);
                String emergencyContactPhone2 = (String)camperJSON.get(ATTENDEE_EMERGENCY_CONTACT_PHONE_2);
                ArrayList<String> allergies = new ArrayList<String>();
                for(int j=0; j<((JSONArray)camperJSON.get(ATTENDEE_ALLERGIES)).size();j++){
                    allergies.add((String)(((JSONArray)camperJSON.get(ATTENDEE_ALLERGIES)).get(j)));
                }
                ArrayList<String> diets = new ArrayList<String>();
                for(int j=0; j<((JSONArray)camperJSON.get(ATTENDEE_DIETS)).size();j++){
                    diets.add((String)(((JSONArray)camperJSON.get(ATTENDEE_DIETS)).get(j)));
                }
                int strikes = ((Long)camperJSON.get(CAMPER_STRIKES)).intValue();
                Camper camper = new Camper(id, firstName, lastName, phone, email, birthdate, address,
                    guardianName, pediatricCare, pediatritianName, pediatritianPhone,
                    new EmergencyContact(emergencyContactName,emergencyContactPhone), new EmergencyContact(emergencyContactName2, emergencyContactPhone2), allergies,
                    diets, strikes);
                
                campers.add(camper);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return campers;
    }

    public static ArrayList<Counselor> getAllCounselors() {
        ArrayList<Counselor> counselors = new ArrayList<Counselor>();
        try {
            FileReader reader = new FileReader(USER_FILE_NAME);
            JSONArray usersJSON = (JSONArray)new JSONParser().parse(reader);
            JSONObject counselorListJSON = (JSONObject)usersJSON.get(1);
            JSONArray counselorsJSON = (JSONArray)counselorListJSON.get(USER_COUNSELOR_LIST);
            
            for(int i = 0; i < counselorsJSON.size(); i++) {  // looping through each counselor
                JSONObject counselorJSON = (JSONObject)counselorsJSON.get(i);
                UUID id = UUID.fromString((String)counselorJSON.get(USER_ID));
                String firstName = (String)counselorJSON.get(USER_FIRST_NAME);
                String lastName = (String)counselorJSON.get(USER_LAST_NAME);
                String phone = (String)counselorJSON.get(USER_PHONE);
                String email = (String)counselorJSON.get(USER_EMAIL);
                String birthdate = (String)counselorJSON.get(ATTENDEE_BIRTHDATE);
                String address = (String)counselorJSON.get(ATTENDEE_ADDRESS);
                String guardianName = (String)counselorJSON.get(ATTENDEE_GUARDIAN_NAME);
                String pediatricCare = (String)counselorJSON.get(ATTENDEE_PEDIATRIC_CARE);
                String pediatritianName = (String)counselorJSON.get(ATTENDEE_PEDIATRITIAN_NAME);
                String pediatritianPhone = (String)counselorJSON.get(ATTENDEE_PEDIATRITIAN_PHONE);
                String emergencyContactName = (String)counselorJSON.get(ATTENDEE_EMERGENCY_CONTACT_NAME);
                String emergencyContactPhone = (String)counselorJSON.get(ATTENDEE_EMERGENCY_CONTACT_PHONE);
                String emergencyContactName2 = (String)counselorJSON.get(ATTENDEE_EMERGENCY_CONTACT_NAME_2);
                String emergencyContactPhone2 = (String)counselorJSON.get(ATTENDEE_EMERGENCY_CONTACT_PHONE_2);
                ArrayList<String> allergies = new ArrayList<String>();
                for(int j=0; j<((JSONArray)counselorJSON.get(ATTENDEE_ALLERGIES)).size();j++){
                    allergies.add((String)(((JSONArray)counselorJSON.get(ATTENDEE_ALLERGIES)).get(j)));
                }
                ArrayList<String> diets = new ArrayList<String>();
                for(int j=0; j<((JSONArray)counselorJSON.get(ATTENDEE_DIETS)).size();j++){
                    diets.add((String)(((JSONArray)counselorJSON.get(ATTENDEE_DIETS)).get(j)));
                }
                String bio = (String)counselorJSON.get(COUNSELOR_BIO);
                Counselor counselor = new Counselor(id, firstName, lastName, phone, email, birthdate, address,
                guardianName, pediatricCare, pediatritianName, pediatritianPhone,
                new EmergencyContact(emergencyContactPhone,emergencyContactName),  new EmergencyContact(emergencyContactPhone2, emergencyContactName2), allergies,
                diets, bio);
                counselors.add(counselor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return counselors;
    }

    public static ArrayList<Director> getAllDirectors() {
        ArrayList<Director> directors = new ArrayList<Director>();
        try {
            FileReader reader = new FileReader(USER_FILE_NAME);
            JSONArray usersJSON = (JSONArray)new JSONParser().parse(reader);
            JSONObject directorListJSON = (JSONObject)usersJSON.get(2);
            JSONArray directorsJSON = (JSONArray)directorListJSON.get(USER_DIRECTOR_LIST);
            
            for(int i = 0; i < directorsJSON.size(); i++) {  // looping through each director
                JSONObject directorJSON = (JSONObject)directorsJSON.get(i);
                UUID id = UUID.fromString((String)directorJSON.get(USER_ID));
                String firstName = (String)directorJSON.get(USER_FIRST_NAME);
                String lastName = (String)directorJSON.get(USER_LAST_NAME);
                String phone = (String)directorJSON.get(USER_PHONE);
                String email = (String)directorJSON.get(USER_EMAIL);
                Director director = new Director(id, firstName, lastName, phone, email);
                directors.add(director);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return directors;
    }
    
    /**
     * Gets all the Sessions in the arrayList Session
     * @return All sessions in the system
     */
    public static ArrayList<Session> getAllSessions(){
        ArrayList<Session> sessions = new ArrayList<Session>();
        try {
            FileReader reader = new FileReader(SESSION_FILE_NAME);
            JSONArray sessionsJSON = (JSONArray)new JSONParser().parse(reader);
            for(int i=0; i < sessionsJSON.size(); i++) {  // loops through sessions
                JSONObject sessionJSON = (JSONObject)sessionsJSON.get(i);
                int week = ((Long)sessionJSON.get(SESSION_WEEK)).intValue();
                Session session = new Session(week);
                String theme = (String)sessionJSON.get(SESSION_THEME);
                session.setTheme(theme);
                JSONArray cabinsJSON = (JSONArray)sessionJSON.get(SESSION_CABINS);
                for(int j = 0; j < cabinsJSON.size(); j++) {  // loops through cabins
                    JSONObject cabinJSON = (JSONObject)cabinsJSON.get(j);
                    int cabinNum = ((Long)cabinJSON.get(CABIN_NUM)).intValue();
                    Cabin cabin = new Cabin(cabinNum);
                    cabin.setCounselor((Counselor)UserList.getInstance().getUserByUUID(UUID.fromString((String)cabinJSON.get(CABIN_COUNSELOR))));
                    JSONArray campersJSON = (JSONArray)cabinJSON.get(CABIN_CAMPERS);
                    for(int k = 0; k < campersJSON.size(); k++) {  // loops through campers in cabin
                        cabin.addCamper((Camper)UserList.getInstance().getUserByUUID(UUID.fromString((String)campersJSON.get(k))));
                    }
                    JSONArray scheduleJSON = (JSONArray)cabinJSON.get(CABIN_SCHEDULE);
                    HashMap<String, ArrayList<Activity>> schedule = new HashMap<String, ArrayList<Activity>>();
                    for(int k = 0; k < scheduleJSON.size(); k++) {  // loops through days in cabin schedule
                        JSONObject dailyScheduleJSON = (JSONObject)scheduleJSON.get(k);
                        JSONArray activitiesJSON = (JSONArray)dailyScheduleJSON.get(SCHEDULE_ACTIVITIES);
                        ArrayList<Activity> activities = new ArrayList<Activity>();
                        for(int l = 0; l < activitiesJSON.size(); l++) {  // loops through activities in day
                            activities.add(Activity.valueOf((String)activitiesJSON.get(l)));
                        }
                        schedule.put((String)dailyScheduleJSON.get(SCHEDULE_DAY),activities);
                    }
                    session.addCabin(cabin);
                }
                sessions.add(session);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
        return sessions;
    }
}
