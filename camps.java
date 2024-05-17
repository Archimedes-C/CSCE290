import java.util.ArrayList;

public class camps {
    private ArrayList<SessionList> sessions;

    public camps(ArrayList<SessionList> sessions) {
        this.sessions = sessions;
    }

    public ArrayList<SessionList> getSessions() {
        return this.sessions;
    }

    public String toString() {
        return this.sessions.toString();
    }
}
