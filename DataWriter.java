import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * @author Andrew Chisolm, Bryan Munoz, Matt Olson, Daniel Ruiz, Jaden Arnold
 * The data reader for JSON files that saves the information in each arrayList
 */
public class DataWriter extends DataConstants {
    /**
     * Saves the Accounts in AccountList to JSON
     */
    public static void saveAllAccounts() {
        AccountList accountList = AccountList.getInstance();
        ArrayList <Account> accounts = accountList.getAccounts();
        JSONArray accountsJSON = new JSONArray();

        for(Account account : accounts) 
        {
			accountsJSON.add(getAccountJSON(account));
		}

        try (FileWriter file = new FileWriter(ACCOUNT_FILE_NAME)) 
        {
            file.write(accountsJSON.toJSONString());
            file.flush();
        } catch (IOException e) 
        {
            e.printStackTrace();
        }
    }

    /**
     * Converts an Account to a JSONObject
     * @param account the Account
     * @return the JSONObject
     */
    public static JSONObject getAccountJSON(Account account) {
        JSONObject accountJSON = new JSONObject();

        accountJSON.put(ACCOUNT_USERNAME, account.getUsername());
        accountJSON.put(ACCOUNT_PASSWORD, account.getPassword());

        JSONArray usersJSON = new JSONArray();
        for(User user : account.getUsers()) {
            usersJSON.add(user.getId().toString());
        }
        accountJSON.put(ACCOUNT_USERS, usersJSON);

        return accountJSON;
    }

    /**
     * Saves the Users in UserList to JSON
     */
    public static void saveAllUsers(){
        UserList userList = UserList.getInstance();

        ArrayList <Camper> campers = userList.getCampers();
        JSONArray campersJSON = new JSONArray();
        for(Camper camper : campers) 
        {
			campersJSON.add(getCamperJSON(camper));
		}

        ArrayList <Counselor> counselors = userList.getCounselors();
        JSONArray counselorsJSON = new JSONArray();
        for(Counselor counselor : counselors) 
        {
			counselorsJSON.add(getCounselorJSON(counselor));
		}

        ArrayList <Director> directors = userList.getDirectors();
        JSONArray directorsJSON = new JSONArray();
        for(Director director : directors) 
        {
			directorsJSON.add(getDirectorJSON(director));
		}

        JSONObject camperListJSON = new JSONObject();
        camperListJSON.put(USER_CAMPER_LIST, campersJSON);

        JSONObject counselorListJSON = new JSONObject();
        counselorListJSON.put(USER_COUNSELOR_LIST, counselorsJSON);

        JSONObject directorListJSON = new JSONObject();
        directorListJSON.put(USER_DIRECTOR_LIST, directorsJSON);

        JSONArray usersJSON = new JSONArray();
        usersJSON.add(camperListJSON);
        usersJSON.add(counselorListJSON);
        usersJSON.add(directorListJSON);

        try (FileWriter file = new FileWriter(USER_FILE_NAME)) 
        {
            file.write(usersJSON.toJSONString());
            file.flush();
        } catch (IOException e) 
        {
            e.printStackTrace();
        }
    }

    /**
     * Puts all information specific to a User in a JSONObject
     * @param user the User
     * @return the JSONObject
     */
    public static JSONObject getUserJSON(User user) {
        JSONObject userJSON = new JSONObject();
        userJSON.put(USER_ID, user.getId());
        userJSON.put(USER_FIRST_NAME, user.getFirstName());
        userJSON.put(USER_LAST_NAME, user.getLastName());
        userJSON.put(USER_PHONE, user.getPhone());
        userJSON.put(USER_EMAIL, user.getEmail());

        return userJSON;
    }

    /**
     * Puts all information specific to an Attendee in a JSONObject
     * @param attendee the Attendee
     * @return the JSONObject
     */
    public static JSONObject getAttendeeJSON(Attendee attendee) {
        JSONObject attendeeJSON = getUserJSON(attendee);
        attendeeJSON.put(ATTENDEE_BIRTHDATE, attendee.getBirthdate());
        attendeeJSON.put(ATTENDEE_ADDRESS, attendee.getAddress());
        attendeeJSON.put(ATTENDEE_GUARDIAN_NAME, attendee.getGuardianName());
        attendeeJSON.put(ATTENDEE_PEDIATRITIAN_NAME, attendee.getPediatritianName());
        attendeeJSON.put(ATTENDEE_PEDIATRITIAN_PHONE, attendee.getPediatritianPhone());
        attendeeJSON.put(ATTENDEE_EMERGENCY_CONTACT_NAME, attendee.getEmergencyContact().getName());
        attendeeJSON.put(ATTENDEE_EMERGENCY_CONTACT_PHONE, attendee.getEmergencyContact().getPhone());
        attendeeJSON.put(ATTENDEE_EMERGENCY_CONTACT_NAME_2, attendee.getEmergencyContact2().getName());
        attendeeJSON.put(ATTENDEE_EMERGENCY_CONTACT_PHONE_2, attendee.getEmergencyContact2().getPhone());
        JSONArray allergiesJSON = new JSONArray();
        for(String allergy : attendee.getAllergies()) {
            allergiesJSON.add(allergy);
        }
        attendeeJSON.put(ATTENDEE_ALLERGIES, allergiesJSON);
        JSONArray dietsJSON = new JSONArray();
        for(String diet : attendee.getAllergies()) {
            dietsJSON.add(diet);
        }
        attendeeJSON.put(ATTENDEE_DIETS, dietsJSON);
        return attendeeJSON;
    }

    /**
     * Converts a Camper to a JSONObject
     * @param camper the Camper
     * @return the JSONObject
     */
    public static JSONObject getCamperJSON(Camper camper) {
        JSONObject camperJSON = getAttendeeJSON(camper);
        camperJSON.put(CAMPER_STRIKES, camper.getStrikes());
        return camperJSON;
    }

    /**
     * Converts a Counselor to a JSONObject
     * @param counselor the Counselor
     * @return the JSONObject
     */
    public static JSONObject getCounselorJSON(Counselor counselor) {
        JSONObject counselorJSON = getAttendeeJSON(counselor);
        counselorJSON.put(COUNSELOR_BIO, counselor.getBio());
        return counselorJSON;
    }

    /**
     * Converts a Director to a JSONObject
     * @param director the Director
     * @return the JSONObject
     */
    public static JSONObject getDirectorJSON(Director director) {
        return getUserJSON(director);
    }

    /**
     * Saves the Sessions in SessionList to JSON
     */
    public static void saveAllSessions(){
        SessionList sessionList = SessionList.getInstance();
        ArrayList<Session> sessions = sessionList.getSessions();
        JSONArray sessionsJSON = new JSONArray();

        for(Session session : sessions) {
            sessionsJSON.add(getSessionJSON(session));
        }

        try(FileWriter file = new FileWriter(SESSION_FILE_NAME)) {
            file.write(sessionsJSON.toJSONString());
            file.flush();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Converts a Session to a JSONObject
     * @param session the Session
     * @return the JSONObject
     */
    public static JSONObject getSessionJSON(Session session) {
        JSONObject sessionJSON = new JSONObject();
        sessionJSON.put(SESSION_WEEK, session.getWeek());
        sessionJSON.put(SESSION_THEME, session.getTheme());
        JSONArray cabinsJSON = new JSONArray();
        ArrayList<Cabin> cabins = session.getCabins();
        for(Cabin cabin : cabins) {
            cabinsJSON.add(getCabinJSON(cabin));
        }
        sessionJSON.put(SESSION_CABINS, cabinsJSON);
        return sessionJSON;
    }

    /**
     * Converts a Cabin to a JSONObject
     * @param cabin the Cabin
     * @return the JSONObject
     */
    public static JSONObject getCabinJSON(Cabin cabin) {
        JSONObject cabinJSON = new JSONObject();
        cabinJSON.put(CABIN_NUM, cabin.getCabinNum());
        cabinJSON.put(CABIN_COUNSELOR, cabin.getCounselor().getId().toString());
        ArrayList<Camper> campers = cabin.getCampers();
        ArrayList<String> camperIds = new ArrayList<String>();
        for(Camper camper : campers) {
            camperIds.add(camper.getId().toString());
        }
        cabinJSON.put(CABIN_CAMPERS, camperIds);

        JSONArray scheduleJSON = new JSONArray();
        HashMap<String, ArrayList<Activity>> schedule = cabin.getSchedule();
        for(String day : schedule.keySet()) {  // looping through each day in the schedule
            JSONObject dailyScheduleJSON = new JSONObject();
            JSONArray activitiesJSON = new JSONArray();
            for(Activity activity : schedule.get(day)) {  // looping through that day's activities
                activitiesJSON.add(activity.toString());
            }
            dailyScheduleJSON.put(SCHEDULE_DAY, day);
            dailyScheduleJSON.put(SCHEDULE_ACTIVITIES, activitiesJSON);
            scheduleJSON.add(dailyScheduleJSON);
        }
        cabinJSON.put(CABIN_SCHEDULE, scheduleJSON);
        return cabinJSON;
    }
}
