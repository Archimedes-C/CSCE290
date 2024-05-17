import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * @author Andrew Chisolm
 */
class CampSystemFacadeTest {

    
    private CampSystemFACADE facade = new CampSystemFACADE();
    private UserList userList = UserList.getInstance();
    private AccountList accountList = AccountList.getInstance();
    private SessionList sessionList = SessionList.getInstance();
	
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
    public void testFindAccountFound() {
        Account account = new Account("username", "password");
        accountList.addAccount(account);
        assertTrue(facade.findAccount("username"));
    }

    @Test
    public void testFindAccountNotFound() {
        Account account = new Account("username", "password");
        accountList.addAccount(account);
        assertFalse(facade.findAccount("usernameWrong"));
    }

    @Test
    public void testFindAccountBlankUsername() {
        Account account = new Account("username", "password");
        accountList.addAccount(account);
        assertFalse(facade.findAccount(""));
    }

    @Test
    public void testFindAccountNullUsername() {
        Account account = new Account("username", "password");
        accountList.addAccount(account);
        assertFalse(facade.findAccount(null));
    }


    @Test
    public void testCheckPasswordCorrect() {
        Account account = new Account("username", "password");
        accountList.addAccount(account);
        assertTrue(facade.checkPassword("username", "password"));
    }

    @Test
    public void testCheckPasswordIncorrectPassword() {
        Account account = new Account("username", "password");
        accountList.addAccount(account);
        assertFalse(facade.checkPassword("username", "passwordWrong"));
    }

    @Test
    public void testCheckPasswordNullPassword() {
        Account account = new Account("username", "password");
        accountList.addAccount(account);
        assertFalse(facade.checkPassword("username", null));
    }

    @Test
    public void testCheckPasswordInvalidUsername() {
        Account account = new Account("username", "password");
        accountList.addAccount(account);
        assertFalse(facade.checkPassword("usernameWrong", "password"));
    }

    @Test
    public void testCheckPasswordNullUsername() {
        Account account = new Account("username", "password");
        accountList.addAccount(account);
        assertFalse(facade.checkPassword(null, "password"));
    }

    @Test
    public void testCheckPasswordNullEverything() {
        Account account = new Account("username", "password");
        accountList.addAccount(account);
        assertFalse(facade.checkPassword(null, null));
    }

    @Test
    public void testCheckPasswordIncorrectEverything() {
        Account account = new Account("username", "password");
        accountList.addAccount(account);
        assertFalse(facade.checkPassword("wrong", "wrong"));
    }

    @Test
    public void testLoginValid() {
        Account account = new Account("username", "password");
        accountList.addAccount(account);
        facade.login("username", "password");
        assertSame(account, facade.getAccount());
    }

    @Test
    public void testLoginInvalidUsername() {
        Account account = new Account("username", "password");
        accountList.addAccount(account);
        facade.login("usernameWrong", "password");
        assertNull(facade.getAccount());
    }

    @Test
    public void testLoginInvalidPassword() {
        Account account = new Account("username", "password");
        accountList.addAccount(account);
        facade.login("username", "passwordWrong");
        assertNull(facade.getAccount());
    }

    @Test
    public void testLoginBlankUsername() {
        Account account = new Account("username", "password");
        accountList.addAccount(account);
        facade.login("", "password");
        assertNull(facade.getAccount());
    }

    @Test
    public void testLoginBlankPassword() {
        Account account = new Account("username", "password");
        accountList.addAccount(account);
        facade.login("username", "");
        assertNull(facade.getAccount());
    }

    @Test
    public void testLoginNullUsername() {
        Account account = new Account("username", "password");
        accountList.addAccount(account);
        facade.login(null, "password");
        assertNull(facade.getAccount());
    }

    @Test
    public void testLoginNullPassword() {
        Account account = new Account("username", "password");
        accountList.addAccount(account);
        facade.login("username", null);
        assertNull(facade.getAccount());
    }

    @Test
    public void testLoginNullEverything() {
        Account account = new Account("username", "password");
        accountList.addAccount(account);
        facade.login(null, null);
        assertNull(facade.getAccount());
    }

    // Checks if the account was added to the list
    @Test
    public void testSignUpCorrectAccountList() {
        facade.signUp("username","password");
        assertEquals(accountList.getAccount("username").getPassword(), "password");
    }

    // Checks if the account was signed into after it was created
    @Test
    public void testSignUpCorrectSignsIn() {
        facade.signUp("username","password");
        assertEquals(facade.getAccount().getUsername(), "username");
    }

    @Test
    public void testSignUpNullUsernameSignsIn() {
        facade.signUp(null,"password");
        assertNull(facade.getAccount());
    }

    @Test
    public void testSignUpNullUsernameAccountList() {
        facade.signUp(null,"password");
        assertEquals(accountList.getAccounts().size(), 0);
    }

    @Test
    public void testSignUpNullPasswordSignsIn() {
        facade.signUp("username", null);
        assertNull(facade.getAccount());
    }

    @Test
    public void testSignUpNullPasswordAccountList() {
        facade.signUp("username",null);
        assertEquals(accountList.getAccounts().size(), 0);
    }

    @Test
    public void testSignUpBlankUsernameSignsIn() {
        facade.signUp("","password");
        assertNull(facade.getAccount());
    }

    @Test
    public void testSignUpBlankUsernameAccountList() {
        facade.signUp("","password");
        assertEquals(accountList.getAccounts().size(), 0);
    }

    @Test
    public void testSignUpBlankPasswordSignsIn() {
        facade.signUp("username", "");
        assertNull(facade.getAccount());
    }

    @Test
    public void testSignUpBlankPasswordAccountList() {
        facade.signUp("username","");
        assertEquals(accountList.getAccounts().size(), 0);
    }

    @Test
    public void testSignUpDuplicateSignsIn() {
        facade.signUp("username","password");
        facade.signUp("username","password2");
        assertNull(facade.getAccount());
    }

    @Test
    public void testSignUpDuplicateAccountList() {
        facade.signUp("username","password");
        facade.signUp("username","password2");
        assertEquals(accountList.getAccounts().size(), 1);
    }

    @Test
    public void testGetCamperSessionsNoSessions() {
        Camper camper = new Camper("Billy", "Smith", "8032345678",
            "email@gmail.com", "11042009", "300 Main St.", "Jeff Smith",
            "Palmetto Pediatrics", "John Jones",
            "8032345678", new EmergencyContact("Jeff Smith", "8032345678"),
            new EmergencyContact("Jeff Smith", "8032345679"), new ArrayList<String>(),
            new ArrayList<String>());
        userList.addUser(camper);
        assertEquals(facade.getCamperSessions(camper), new ArrayList<Session>());
    }

    @Test
    public void testGetCamperSessionsOneSession() {
        Camper camper = new Camper("Billy", "Smith", "8032345678",
            "email@gmail.com", "11042009", "300 Main St.", "Jeff Smith",
            "Palmetto Pediatrics", "John Jones",
            "8032345678", new EmergencyContact("Jeff Smith", "8032345678"),
            new EmergencyContact("Debra Smith", "8032345679"), new ArrayList<String>(),
            new ArrayList<String>());
        userList.addUser(camper);

        // Add a session, add camper to session
        Session session1 = new Session(1);
        session1.setTheme("Olympics");
        Cabin cabin1 = new Cabin(1);
        Counselor counselor = new Counselor("Billy", "Smith", "8032345678",
            "email@gmail.com", "11042009", "300 Main St.", "Jeff Smith",
            "Palmetto Pediatrics", "John Jones",
            "8032345678", new EmergencyContact("Jeff Smith", "8032345678"),
            new EmergencyContact("Debra Smith", "8032345679"), new ArrayList<String>(),
            new ArrayList<String>(), "bio");
        cabin1.setCounselor(counselor);
        cabin1.addCamper(camper);
        session1.addCabin(cabin1);

        // Add a session without camper
        Session session2 = new Session(2);
        session2.setTheme("Pirates");
        Cabin cabin2 = new Cabin(2);
        cabin2.setCounselor(counselor);
        session2.addCabin(cabin2);

        sessionList.addSession(session1);
        sessionList.addSession(session2);

        ArrayList<Session> expected = new ArrayList<Session>();
        expected.add(session1);
        assertEquals(facade.getCamperSessions(camper), expected);
    }

    @Test
    public void testGetCamperSessionsTwoSessions() {
        Camper camper = new Camper("Billy", "Smith", "8031234567",
            "email@gmail.com", "11042009", "300 Main St.", "Jeff Smith",
            "Palmetto Pediatrics", "John Jones",
            "8031234567", new EmergencyContact("Jeff Smith", "8031234567"),
            new EmergencyContact("Debra Smith", "8031234569"), new ArrayList<String>(),
            new ArrayList<String>());
        userList.addUser(camper);

        // Add a session, add camper to session
        Session session1 = new Session(1);
        session1.setTheme("Olympics");
        Cabin cabin1 = new Cabin(1);
        Counselor counselor = new Counselor("Billy", "Smith", "8031234567",
            "email@gmail.com", "11042009", "300 Main St.", "Jeff Smith",
            "Palmetto Pediatrics", "John Jones",
            "8031234567", new EmergencyContact("Jeff Smith", "8031234567"),
            new EmergencyContact("Debra Smith", "8031234569"), new ArrayList<String>(),
            new ArrayList<String>(), "bio");
        cabin1.setCounselor(counselor);
        cabin1.addCamper(camper);
        session1.addCabin(cabin1);

        // Add another session with camper
        Session session2 = new Session(2);
        session2.setTheme("Pirates");
        Cabin cabin2 = new Cabin(2);
        cabin2.setCounselor(counselor);
        cabin2.addCamper(camper);
        session2.addCabin(cabin2);

        // Add a session without camper
        Session session3 = new Session(3);
        session3.setTheme("Ninja Warrior");
        Cabin cabin3 = new Cabin(3);
        cabin3.setCounselor(counselor);
        session3.addCabin(cabin3);

        sessionList.addSession(session1);
        sessionList.addSession(session2);
        sessionList.addSession(session3);

        ArrayList<Session> expected = new ArrayList<Session>();
        expected.add(session1);
        expected.add(session2);
        assertEquals(facade.getCamperSessions(camper), expected);
    }

    @Test
    public void testGetCamperSessionsInvalidCamper() {
        
        // Add a session without camper
        Session session2 = new Session(2);
        session2.setTheme("Pirates");
        Cabin cabin2 = new Cabin(2);
        Counselor counselor = new Counselor("Billy", "Smith", "8031234567",
            "email@gmail.com", "11042009", "300 Main St.", "Jeff Smith",
            "Palmetto Pediatrics", "John Jones",
            "8031234567", new EmergencyContact("Jeff Smith", "8031234567"),
            new EmergencyContact("Debra Smith", "8031234569"), new ArrayList<String>(),
            new ArrayList<String>(), "bio");
        cabin2.setCounselor(counselor);
        session2.addCabin(cabin2);
        sessionList.addSession(session2);

        Camper camper = new Camper("Billy", "Smith", "8031234567",
            "email@gmail.com", "11042009", "300 Main St.", "Jeff Smith",
            "Palmetto Pediatrics", "John Jones",
            "8031234567", new EmergencyContact("Jeff Smith", "8031234567"),
            new EmergencyContact("Debra Smith", "8031234569"), new ArrayList<String>(), new ArrayList<String>());
        // Camper not in UserList

        ArrayList<Session> expected = new ArrayList<Session>();
        assertEquals(facade.getCamperSessions(camper), expected);
    }

    @Test
    public void testRegisterCamperValid() {
        facade.signUp("username", "password");
        facade.registerCamper("Billy", "Smith", "8031234567",
            "email@gmail.com", "11042009", "300 Main St.", "Jeff Smith",
            "Palmetto Pediatrics", "John Jones",
            "8031234567", new EmergencyContact("Jeff Smith", "8031234567"),
            new EmergencyContact("Debra Smith", "8031234569"), new ArrayList<String>(),
            new ArrayList<String>());
        
        Camper expected = new Camper("Billy", "Smith", "8031234567",
        "email@gmail.com", "11042009", "300 Main St.", "Jeff Smith",
        "Palmetto Pediatrics", "John Jones",
        "8031234567", new EmergencyContact("Jeff Smith", "8031234567"),
        new EmergencyContact("Debra Smith", "8031234569"), new ArrayList<String>(), new ArrayList<String>());

        assertEquals(userList.getUserByName("Billy", "Smith").toString(), expected.toString());
    }

    // All campers must be registered from an account
    @Test
    public void testRegisterCamperNoAccount() {
        facade.registerCamper("Billy", "Smith", "8031234567",
            "email@gmail.com@gmail.com", "11042009", "300 Main St.", "Jeff Smith",
            "Palmetto Pediatrics", "John Jones",
            "8031234567", new EmergencyContact("Jeff Smith", "8031234567"),
            new EmergencyContact("Debra Smith", "8031234569"), new ArrayList<String>(),
            new ArrayList<String>());

        assertNull(userList.getUserByName("Billy", "Smith"));
    }

    @Test
    public void testRegisterCamperNullValues() {
        facade.signUp("username", "password");
        facade.registerCamper(null, null, null, null, null, null, null, null,
            null, null, new EmergencyContact(null, null), new EmergencyContact(null, null),
            new ArrayList<String>(), new ArrayList<String>());
        
        assertEquals(userList.getUsers().size(), 0);
    }

    @Test
    public void testRegisterCamperNullEverything() {
        facade.signUp("username", "password");
        facade.registerCamper(null, null, null, null, null, null, null, null,
            null, null, null, null, null, null);
        
        assertEquals(userList.getUsers().size(), 0);
    }

    @Test
    public void testRegisterCamperInvalidPhone() {
        facade.signUp("username", "password");
        facade.registerCamper("Billy", "Smith", "abc",
            "email@gmail.com", "11042009", "300 Main St.", "Jeff Smith",
            "Palmetto Pediatrics", "John Jones",
            "abc", new EmergencyContact("Jeff Smith", "abc"),
            new EmergencyContact("Debra Smith", "abc"), new ArrayList<String>(),
            new ArrayList<String>());

        assertNull(userList.getUserByName("Billy", "Smith"));
    }

    @Test
    public void testRegisterCamperInvalidEmailNoAt() {
        facade.signUp("username", "password");
        facade.registerCamper("Billy", "Smith", "8039876543",
            "email.com", "11042009", "300 Main St.", "Jeff Smith",
            "Palmetto Pediatrics", "John Jones",
            "8039876543", new EmergencyContact("Jeff Smith", "8039876543"),
            new EmergencyContact("Debra Smith", "8039876549"), new ArrayList<String>(),
            new ArrayList<String>());

        assertNull(userList.getUserByName("Billy", "Smith"));
    }

    @Test
    public void testRegisterCamperInvalidEmailNoDot() {
        facade.signUp("username", "password");
        facade.registerCamper("Billy", "Smith", "8039876543",
            "email@gmail", "11042009", "300 Main St.", "Jeff Smith",
            "Palmetto Pediatrics", "John Jones",
            "8039876543", new EmergencyContact("Jeff Smith", "8039876543"),
            new EmergencyContact("Debra Smith", "8039876549"), new ArrayList<String>(),
            new ArrayList<String>());

        assertNull(userList.getUserByName("Billy", "Smith"));
    }

    @Test
    public void testRegisterCamperInvalidBirthdate() {
        facade.signUp("username", "password");
        facade.registerCamper("Billy", "Smith", "8039876543",
            "email@gmail", "birthdate", "300 Main St.", "Jeff Smith",
            "Palmetto Pediatrics", "John Jones",
            "8039876543", new EmergencyContact("Jeff Smith", "8039876543"),
            new EmergencyContact("Debra Smith", "8039876549"), new ArrayList<String>(),
            new ArrayList<String>());

        assertNull(userList.getUserByName("Billy", "Smith"));
    }

    @Test
    public void testCheckPasswordSyntax() { // Bryan Munoz-Romero
        facade.signUp("username", "password");
        
        //assertFalse(facade.checkPassword("username", "\"));
    }

    @Test
    public void testCreateInputErrorCamper() { // Bryan Munoz-Romero
        facade.signUp("username", "password");
        facade.registerCamper("'", "'", "'",
            "'", "'", "'", "'",
            "'", "'",
            "'", new EmergencyContact("'", "'"),
            new EmergencyContact("'", "'"), new ArrayList<String>(),
            new ArrayList<String>());

        assertEquals(userList.getUserByName("'", "'").toString(), "' '");
    }

    @Test
    public void testRegisterCamperInvalidName() { // Bryan Munoz-Romero
        facade.signUp("username", "password");
        facade.registerCamper("'", "'", "8039876543",
            "email@gmail", "010110", "300 Main St.", "Jeff Smith",
            "Palmetto Pediatrics", "John Jones",
            "8039876543", new EmergencyContact("Jeff Smith", "8039876543"),
            new EmergencyContact("Debra Smith", "8039876549"), new ArrayList<String>(),
            new ArrayList<String>());

        assertNull(userList.getUserByName("'", "'").toString());
    }
}