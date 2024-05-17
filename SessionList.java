
import java.util.ArrayList;

/**
 * @author Andrew Chisolm, Bryan Munoz, Matt Olson, Daniel Ruiz, Jaden Arnold
 * List of all Sessions
 */
public class SessionList {

    private ArrayList<Session> sessions;
    private static SessionList sessionList;
    /**
     * Sets the session list
     */
    private SessionList() {
        sessions = DataReader.getAllSessions();
    }

    /**
     * Creates a new instance of the object if necessary
     * @return the current instance of the object
     */
    public static SessionList getInstance() {
        if (sessionList == null) {
            sessionList = new SessionList();
        }
        return sessionList;
    }

    /**
     * Accessor for sessions
     * @return Sessions ArrayList
     */
    public ArrayList<Session> getSessions() {
        return this.sessions;
    }

    /**
     * Adds a session to the list
     * @param session the session being added
     */
    public void addSession(Session session) {
        sessions.add(session);
        DataWriter.saveAllSessions();
    }

    /**
     * Searches for a session
     * @param week week of the session
     * @return the session; null if not found
     */
    public Session getSession(int week) {
        for(Session session : sessions) {
            if(session.getWeek() == week) {
                return session;
            }
        }
        return null;
    }
}
