
import java.util.ArrayList;

/**
 * @author Andrew Chisolm, Bryan Munoz, Matt Olson, Daniel Ruiz, Jaden Arnold
 * Each session has up to nine cabins.
 * Each session lasts one week.
 */
public class Session {
    private ArrayList<Cabin> cabins;
    private int week;
    private String theme;
    /**
     * Sets the Session information
     * @param week The week of the session
     */
    public Session(int week) {
        this.week = week;
        cabins = new ArrayList<Cabin>();
    }

    /**
     * Accessor for week
     * @return week
     */
    public int getWeek() {
        return week;
    }

    /**
     * Accessor for theme
     * @return theme
     */
    public String getTheme() {
        return theme;
    }

    /**
     * Accessor for cabins
     * @return cabins
     */
    public ArrayList<Cabin> getCabins() {
        return cabins;
    }

    /**
     * Sets the theme for the session
     * @param theme the theme
     */
    public void setTheme(String theme) {
        this.theme = theme;
    }

    /**
     * Adds a cabin to the session
     * @param cabin the cabin being added
     */
    public void addCabin(Cabin cabin) {
        cabins.add(cabin);
    }

    /**
     * Returns Session formation in a readable format
     */
    public String toString() {
        return "Week " + this.week + ": " + this.theme;
    }
}