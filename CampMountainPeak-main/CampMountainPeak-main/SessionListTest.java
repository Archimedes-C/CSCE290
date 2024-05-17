import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
/**
 * @author Matthew Olson
 */
public class SessionListTest {
    private SessionList sessionList = SessionList.getInstance();

	@BeforeEach
	public void setup() {
        SessionList.getInstance().getSessions().clear();
        DataWriter.saveAllSessions();
	}
	
	@AfterEach
	public void tearDown() {
        SessionList.getInstance().getSessions().clear();
        DataWriter.saveAllSessions();
	}

    @Test
    public void testaddSessionsduplicateWeeks(){
        Counselor counselor = new Counselor("Billy", "Smith", "8032345678",
            "email@gmail.com", "11042009", "300 Main St.", "Jeff Smith",
            "Palmetto Pediatrics", "John Jones",
            "8032345678", new EmergencyContact("Jeff Smith", "8032345678"),
            new EmergencyContact("Debra Smith", "8032345679"), new ArrayList<String>(),
            new ArrayList<String>(), "bio");

        Session session1 = new Session(1);
        session1.setTheme("Pirates");
        Cabin cabin1 = new Cabin(1);
        cabin1.setCounselor(counselor);
        session1.addCabin(cabin1);

        Session session2 = new Session(1);
        session1.setTheme("Olymics");
        Cabin cabin2 = new Cabin(2);
        cabin2.setCounselor(counselor);
        session1.addCabin(cabin2);

        ArrayList<Session> expected = new ArrayList<Session>();
        expected.add(session1);
        sessionList.addSession(session1);
        sessionList.addSession(session2);
        assertEquals(expected, sessionList.getSessions());
    }
    @Test
    public void testaddSessionsDuplicateTheme(){
        Counselor counselor = new Counselor("Billy", "Smith", "8032345678",
            "email@gmail.com", "11042009", "300 Main St.", "Jeff Smith",
            "Palmetto Pediatrics", "John Jones",
            "8032345678", new EmergencyContact("Jeff Smith", "8032345678"),
            new EmergencyContact("Debra Smith", "8032345679"), new ArrayList<String>(),
            new ArrayList<String>(), "bio");

        Session session1 = new Session(1);
        session1.setTheme("Pirates");
        Cabin cabin1 = new Cabin(1);
        cabin1.setCounselor(counselor);
        session1.addCabin(cabin1);

        Session session2 = new Session(2);
        session2.setTheme("Pirates");
        Cabin cabin2 = new Cabin(1);
        cabin2.setCounselor(counselor);
        session1.addCabin(cabin2);

        ArrayList<Session> expected = new ArrayList<Session>();
        expected.add(session1);
        sessionList.addSession(session1);
        sessionList.addSession(session2);
        assertEquals(expected, sessionList.getSessions());
    }
    @Test
    public void testaddSessionsNegitiveWeek(){
        Counselor counselor = new Counselor("Billy", "Smith", "8032345678",
            "email@gmail.com", "11042009", "300 Main St.", "Jeff Smith",
            "Palmetto Pediatrics", "John Jones",
            "8032345678", new EmergencyContact("Jeff Smith", "8032345678"),
            new EmergencyContact("Debra Smith", "8032345679"), new ArrayList<String>(),
            new ArrayList<String>(), "bio");

        Session session1 = new Session(0);
        session1.setTheme("Pirates");
        Cabin cabin1 = new Cabin(1);
        cabin1.setCounselor(counselor);
        session1.addCabin(cabin1);

        Session session2 = new Session(-1);
        session2.setTheme("Pirates");
        Cabin cabin2 = new Cabin(1);
        cabin2.setCounselor(counselor);
        session2.addCabin(cabin2);

        ArrayList<Session> expected = new ArrayList<Session>();
        expected.add(session1);
        sessionList.addSession(session2);

        assertEquals(expected, sessionList.getSessions());
    }
    @Test
    public void testaddSessionsNullTheme(){
        Counselor counselor = new Counselor("Billy", "Smith", "8032345678",
            "email@gmail.com", "11042009", "300 Main St.", "Jeff Smith",
            "Palmetto Pediatrics", "John Jones",
            "8032345678", new EmergencyContact("Jeff Smith", "8032345678"),
            new EmergencyContact("Debra Smith", "8032345679"), new ArrayList<String>(),
            new ArrayList<String>(), "bio");

        Session session1 = new Session(1);
        session1.setTheme("");
        Cabin cabin1 = new Cabin(1);
        cabin1.setCounselor(counselor);
        session1.addCabin(cabin1);

        ArrayList<Session> expected = new ArrayList<Session>();
        sessionList.addSession(session1);

        assertEquals(expected, sessionList.getSessions());
    }
}

