import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class DataReaderTest {
    private UserList userList = UserList.getInstance();
    private AccountList accountList = AccountList.getInstance();
    private SessionList sessionList = SessionList.getInstance();
    //private DataReader dataReader = DataReader.getAllCampers();
	
	@BeforeEach
	public void setup() {
		UserList.getInstance().getUsers().clear();
        UserList.getInstance().getCampers().clear();
		UserList.getInstance().getCounselors().clear();
		UserList.getInstance().getDirectors().clear();
        AccountList.getInstance().getAccounts().clear();
        SessionList.getInstance().getSessions().clear();
        DataWriter.saveAllUsers();
        DataWriter.saveAllAccounts();
        DataWriter.saveAllSessions();
        DataReader.getAllUsers();
        DataReader.getAllAccounts();
        DataReader.getAllSessions();
	}
	
	@AfterEach
	public void tearDown() {
		UserList.getInstance().getUsers().clear();
        UserList.getInstance().getCampers().clear();
		UserList.getInstance().getCounselors().clear();
		UserList.getInstance().getDirectors().clear();
        AccountList.getInstance().getAccounts().clear();
        SessionList.getInstance().getSessions().clear();
        DataWriter.saveAllUsers();
        DataWriter.saveAllAccounts();
        DataWriter.saveAllSessions();
    }

    @Test
    public void testGetUsersCamperSizeCamperNull() {
        Camper camper = new Camper(null, "null", "null", "null", "null", "null", "null", "null", "REAL", "NAME", "NUM",  new EmergencyContact("Jeff Smith", "8031234567"), new EmergencyContact("Debra Smith", "8031234569"), new ArrayList<String>(), new ArrayList<String>(), 0);
        Camper camper2 = new Camper(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0);
        userList.addUser(camper);
        userList.addUser(camper2);
        assertEquals(2, userList.getCampers());
    }

    @Test
    public void testGetUsersCamperExist() {
        Camper camper = new Camper(null, "null", "null", "null", "null", "null", "null", "null", "REAL", "NAME", "NUM",  new EmergencyContact("Jeff Smith", "8031234567"), new EmergencyContact("Debra Smith", "8031234569"), new ArrayList<String>(), new ArrayList<String>(), 0);
        userList.addUser(camper);
        assertEquals(1, DataReader.getAllCampers().size());
    }

    @Test
    public void testGetUsersCamperExistZero(){
        assertEquals(0, DataReader.getAllCampers().size());
    }

    @Test
    public void testGetCounselorNull() {
        Counselor counselor = new Counselor(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
        userList.addUser(counselor);
        assertEquals(1, DataReader.getAllCounselors().size());
    }

    @Test
    public void testGetCounselorExist() {
        Counselor counselor = new Counselor("null", "null", "null", "null", "null", "null", "null", "null", "null", "null", new EmergencyContact("Jeff Smith", "8031234567"), new EmergencyContact("Debra Smith", "8031234569"), new ArrayList<String>(), new ArrayList<String>(), "null");
        userList.addUser(counselor);
        assertEquals(1, DataReader.getAllCounselors().size());
    }
    @Test
    public void testGetCounselorExistZero(){
        assertEquals(0, DataReader.getAllCounselors().size());
    }

    @Test
    public void testGetDirectorNull() {
        Director director = new Director(null, null, null, null);
        userList.addUser(director);
        assertEquals(1, DataReader.getAllDirectors().size());
    }

    @Test
    public void testGetDirectorExist() {
        Director director = new Director("null", "null", "null", "null");
        userList.addUser(director);
        assertEquals(1, DataReader.getAllDirectors().size());
    }

    @Test
    public void testGetDirectorExistZero(){
        assertEquals(0, DataReader.getAllDirectors().size());
    }

    
    @Test
    public void testGetAccount() {
    //  Account account = new Account
    //    assertEquals("asmith", userList.get(0).getUserName());
    }
    }


