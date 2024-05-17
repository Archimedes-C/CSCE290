import java.util.Random;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;

/**
 * @author Andrew Chisolm, Bryan Munoz, Matt Olson, Daniel Ruiz, Jaden Arnold
 * Each cabin has one counselor and up to eight campers.
 * Everyone in the cabin shares a schedule.
 */
public class Cabin {
    private int cabinNum;
    private ArrayList<Camper> campers;
    private Counselor counselor;
    private HashMap<String, ArrayList<Activity>> schedule;
    /**
     * Sets the cabin information
     * @param cabinNum the number of the cabin
     */
    public Cabin(int cabinNum) {
        this.cabinNum = cabinNum;
        this.campers = new ArrayList<Camper>();
        this.schedule = new HashMap<String, ArrayList<Activity>>();
        generateSchedule();
    }

    /**
     * Accessor for cabinNum
     * @return cabinNum
     */
    public int getCabinNum() {
        return cabinNum;
    }

    /**
     * Accessor for camper list
     * @return list of campers
     */
    public ArrayList<Camper> getCampers() {
        return campers;
    }

    /**
     * Accessor for counselor
     * @return counselor
     */
    public Counselor getCounselor() {
        return counselor;
    }

    /**
     * Accessor for schedule
     * @return schedule
     */
    public HashMap<String, ArrayList<Activity>> getSchedule() {
        return schedule;
    }

    /**
     * Generates a random schedule for the week
     */
    public void generateSchedule() {
        Random rand = new Random();
        for(int i = 1; i <= 7; i++) {  // 7 days
            ArrayList<Activity> activities = new ArrayList<Activity>(EnumSet.allOf(Activity.class));
            ArrayList<Activity> dailySch = new ArrayList<Activity>();
            for(int j = 0; j < 3; j++) { // adds 3 random activities to the daily schedule
                Activity activity = activities.get(rand.nextInt(activities.size()));
                dailySch.add(activity);
                activities.remove(activity);  // prevents the activity from being added twice in a day
            }
            schedule.put(String.valueOf(i), dailySch);
        }
    }

    /**
     * Setter for schedule
     * @param schedule the schedule
     */
    public void setSchedule(HashMap<String, ArrayList<Activity>> schedule) {
        this.schedule = schedule;
    }

    /**
     * Adds a camper to the session
     * @param camper the camper being added
     */
    public void addCamper(Camper camper) {
        campers.add(camper);
    }
    /**
     * Sets the counselor
     * @param counselor the counselor
     */
    public void setCounselor(Counselor counselor) {
        this.counselor = counselor;
    }

    /**
     * Removes a camper from the session
     * @param firstName camper's first name
     * @param lastName camper's last name
     */
    public void rmCamper(String firstName, String lastName) {
        for(int i = 0;i<campers.size();i++){
            if(campers.get(i).getFullName().equals(firstName + " " + lastName)){
                campers.remove(i);
                break;
            }
        }
    }
    /**
     * Gets the age range of the cabin based on the number entered
     * @param cabinNum The number of the cabin
     * @return The age range of the cabin
     */
    public String cabinAge(int cabinNum){
        String stringAge = "";
        //int cabinAge = 7;
        if(cabinNum==1){
            stringAge += "Cabin "+cabinNum+": 7 and 8 years olds";
        }
        else if(cabinNum==2){
            stringAge += "Cabin "+cabinNum+": 9 and 10 years olds";
        }
        else if(cabinNum==3){
            stringAge += "Cabin "+cabinNum+": 11 and 12 years olds";
        }
        else if(cabinNum==4){
            stringAge += "Cabin "+cabinNum+": 13 and 14 years olds";
        }
        else if(cabinNum==5){
            stringAge += "Cabin "+cabinNum+": 15 and 16 years olds";
        }
        else if(cabinNum==6){
            stringAge += "Cabin "+cabinNum+": 17 and 18 years olds";
        }
        return stringAge;
    }

    /**
     * Prints the schedule for the session
     * @return a string with the schedule neatly laid out
     */
    public String printScheduleDay(int week, int day, int cabinNum) {
        String sPrint= "*******Day " + day + " Schedule*********";
        sPrint += "\n*******Cabin " + cabinNum + "*********";
        sPrint += "\n- Breakfast 7:00-8:00";
        sPrint += "\n- "+schedule.get(String.valueOf(week+day+cabinNum)).get(0)+" 8:00-12:00";
        sPrint += "\n- Lunch 12:00-13:00";
        sPrint += "\n- "+schedule.get(String.valueOf(week+day+cabinNum)).get(1)+" 13:00-:1500";
        sPrint += "\n- "+schedule.get(String.valueOf(week+day+cabinNum)).get(2)+" 15:00-17:00";
        sPrint += "\n- Dinner 17:00-19:00";
        return sPrint;
    }
}
