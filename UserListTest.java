import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * @author Matthew Olson
 */
class UserListTest {

    private UserList userList = UserList.getInstance();

	@BeforeEach
	public void setup() {
		UserList.getInstance().getUsers().clear();
        UserList.getInstance().getCampers().clear();
		UserList.getInstance().getCounselors().clear();
		UserList.getInstance().getDirectors().clear();
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
        DataWriter.saveAllUsers();
        DataWriter.saveAllAccounts();
        DataWriter.saveAllSessions();
	}

     @Test
     public void testaddUserCamperNullName() {
        Camper camper = new Camper(null, null, "8032345678",
        "email@gmail.com", "11042009", "300 Main St.", "Jeff Smith",
        "Palmetto Pediatrics", "John Jones",
        "8032345678", new EmergencyContact("Jeff Smith", "8032345678"),
        new EmergencyContact("Jeff Smith", "8032345679"), new ArrayList<String>(),
        new ArrayList<String>());

        userList.addUser(camper);
        ArrayList<Camper> expected = new ArrayList<Camper>();

        assertEquals(expected, userList.getCampers());
    }
    @Test
    public void testaddUserCamperInvalidPhoneNumber() {
       Camper camper = new Camper("jim", "bob", "68",
       "email@gmail.com", "11042009", "300 Main St.", "Jeff Smith",
       "Palmetto Pediatrics", "John Jones",
       "8032345678", new EmergencyContact("Jeff Smith", "68"),
       new EmergencyContact("Jeff Smith", "8035678493"), new ArrayList<String>(),
       new ArrayList<String>());

       userList.addUser(camper);
       ArrayList<Camper> expected = new ArrayList<Camper>();

       assertEquals(expected, userList.getCampers());
   }
   @Test
   public void testaddUserCamperValid() {
      Camper camper = new Camper("jim", "bob", "8032345678",
      "email@gmail.com", "11042009", "300 Main St.", "Jeff Smith",
      "Palmetto Pediatrics", "John Jones",
      "8032345678", new EmergencyContact("Jeff Smith", "8032345678"),
      new EmergencyContact("Jeff Smith", "8032345679"), new ArrayList<String>(),
      new ArrayList<String>());

      userList.addUser(camper);
      ArrayList<Camper> expected = new ArrayList<Camper>();
      expected.add(camper);
      assertEquals(expected, userList.getCampers());
  }
   @Test
     public void testaddUserCamperInvalidEmail() {
        Camper camper = new Camper("jim", "bob", "8032345678",
        "emailgmailcom", "11042009", "300 Main St.", "Jeff Smith",
        "Palmetto Pediatrics", "John Jones",
        "8032345678", new EmergencyContact("Jeff Smith", "8032345678"),
        new EmergencyContact("Jeff Smith", "8032345679"), new ArrayList<String>(),
        new ArrayList<String>());

        userList.addUser(camper);
        ArrayList<Camper> expected = new ArrayList<Camper>();

        assertEquals(expected, userList.getCampers());
    }
    @Test
    public void testaddUserCamperInvlaidBirthday() {
        Camper camper = new Camper("Jim", "bob", "8032345678",
        "email@gmail.com", "14042009", "300 Main St.", "Jeff Smith",
        "Palmetto Pediatrics", "John Jones",
        "8032345678", new EmergencyContact("Jeff Smith", "8032345678"),
        new EmergencyContact("Jeff Smith", "8032345679"), new ArrayList<String>(),
        new ArrayList<String>());

        userList.addUser(camper);
        ArrayList<Camper> expected = new ArrayList<Camper>();

        assertEquals(expected, userList.getCampers());
    }
    @Test
    public void testaddUserCamperNullPediatricCareCenter() {
        Camper camper = new Camper("jim", "bob", "8032345678",
        "email@gmail.com", "11042009", "300 Main St.", "Jeff Smith",
        null, "John Jones",
        "8032345678", new EmergencyContact("Jeff Smith", "8032345678"),
        new EmergencyContact("Jeff Smith", "8032345679"), new ArrayList<String>(),
        new ArrayList<String>());

        userList.addUser(camper);
        ArrayList<Camper> expected = new ArrayList<Camper>();

        assertEquals(expected, userList.getCampers());
    }
    @Test
    public void testaddUserCounselorValid() {
        Counselor counselor = new Counselor("Billy", "Smith", "8031234567",
        "email@gmail.com", "11042009", "300 Main St.", "Jeff Smith",
        "Palmetto Pediatrics", "John Jones",
        "8031234567", new EmergencyContact("Jeff Smith", "8031234567"),
        new EmergencyContact("Debra Smith", "8031234569"), new ArrayList<String>(),
        new ArrayList<String>(), "bio");

        userList.addUser(counselor);
        ArrayList<Counselor> expected = new ArrayList<Counselor>();
        expected.add(counselor);

        assertEquals(expected, userList.getCounselors());
    }
    @Test
    public void testaddUserCounselorNullBio() {
        Counselor counselor = new Counselor("Billy", "Smith", "8031234567",
        "email@gmail.com", "11042009", "300 Main St.", "Jeff Smith",
        "Palmetto Pediatrics", "John Jones",
        "8031234567", new EmergencyContact("Jeff Smith", "8031234567"),
        new EmergencyContact("Debra Smith", "8031234569"), new ArrayList<String>(),
        new ArrayList<String>(), null);

        userList.addUser(counselor);
        ArrayList<Counselor> expected = new ArrayList<Counselor>();

        assertEquals(expected, userList.getCounselors());
    }
    @Test
    public void testaddUserCounselorNullAddress() {
        Counselor counselor = new Counselor("Billy", "Smith", "8031234567",
        "email@gmail.com", "11042009", null, "Jeff Smith",
        "Palmetto Pediatrics", "John Jones",
        "8031234567", new EmergencyContact("Jeff Smith", "8031234567"),
        new EmergencyContact("Debra Smith", "8031234569"), new ArrayList<String>(),
        new ArrayList<String>(), "bio");

        userList.addUser(counselor);
        ArrayList<Counselor> expected = new ArrayList<Counselor>();

        assertEquals(expected, userList.getCounselors());
    }
    @Test
    public void testaddUserDirectorAllNull() {
        Director director = new Director(null, null, null, null);

        userList.addUser(director);
        ArrayList<Camper> expected = new ArrayList<Camper>();

        assertEquals(expected, userList.getDirectors());
    }
    @Test
    public void testaddUserDirectorInvalidEmail() {
        Director director = new Director("Franklin", "Bob", "8035457755", "email@gmailcom" );

        userList.addUser(director);
        ArrayList<Camper> expected = new ArrayList<Camper>();

        assertEquals(expected, userList.getDirectors());
    }
    @Test
    public void testaddUserDirectorValid() {
        Director director = new Director("Franklin", "Bob", "8035457755", "email@gmail.com" );

        userList.addUser(director);
        ArrayList<Director> expected = new ArrayList<Director>();
        expected.add(director);

        assertEquals(expected, userList.getDirectors());
    } 
    @Test
    public void testRemoveUserDirectorValid() {
        Director director = new Director("Franklin", "Bob", "8035457755", "email@gmail.com" );
        Director director2 = new Director("Billy", "Bob", "8035457755", "email@gmail.com" );
        userList.addUser(director);
        userList.addUser(director2);
        userList.removeUser("Franklin", "Bob");
        ArrayList<Director> expected = new ArrayList<Director>();
        expected.add(director2);
        assertEquals(expected, userList.getDirectors());
    } 
    @Test
    public void testRemoveUserDirectorNullFirstName() {
        Director director = new Director(null, "Bob", "8035457755", "email@gmail.com" );
        Director director2 = new Director("Billy", "Bob", "8035457755", "email@gmail.com" );
        userList.addUser(director);
        userList.addUser(director2);
        userList.removeUser(null, "Bob");
        ArrayList<Director> expected = new ArrayList<Director>();
        expected.add(director2);
        assertEquals(expected, userList.getDirectors());
    } 
    @Test
    public void testRemoveUserDirectorNullLastName() {
        Director director = new Director("Franklin", null, "8035457755", "email@gmail.com" );
        Director director2 = new Director("Billy", "Bob", "8035457755", "email@gmail.com" );
        userList.addUser(director);
        userList.addUser(director2);
        userList.removeUser("Franklin", null);
        ArrayList<Director> expected = new ArrayList<Director>();
        expected.add(director2);
        assertEquals(expected, userList.getDirectors());
    } 
    @Test
    public void testRemoveUserDirectorDuplicateName(){
        Director director = new Director("Franklin", "Bob", "8035457755", "email@gmail.com" );
        Director director2 = new Director("Franklin", "Bob", "8035457755", "email@gmail.com" );
        userList.addUser(director);
        userList.addUser(director2);
        userList.removeUser("Franklin", "Bob");
        ArrayList<Director> expected = new ArrayList<Director>();
        
        assertEquals(expected, userList.getDirectors());
    } 
    @Test
    public void testRemoveUserDirectorSameFirstName() {
        Director director = new Director("Franklin", "Bob", "8035457755", "email@gmail.com" );
        Director director2 = new Director("Franklin", "Bill", "8035457755", "email@gmail.com" );
        userList.addUser(director);
        userList.addUser(director2);
        userList.removeUser("Franklin", "Bob");
        ArrayList<Director> expected = new ArrayList<Director>();
        expected.add(director2);
        assertEquals(expected, userList.getDirectors());
    } 
    @Test
    public void testRemoveUserDirectorSameLastName() {
        Director director = new Director("Franklin", "Bob", "8035457755", "email@gmail.com" );
        Director director2 = new Director("Billy", "Bob", "8035457755", "email@gmail.com" );
        userList.addUser(director);
        userList.addUser(director2);
        userList.removeUser("Franklin", "Bob");
        ArrayList<Director> expected = new ArrayList<Director>();
        expected.add(director2);
        assertEquals(expected, userList.getDirectors());
    } 

    @Test
    public void testRemoveUserCounselorValid() {
        Counselor counselor1 = new Counselor("Billy", "Smith", "8031234567",
        "email@gmail.com", "11042009", "300 Main St.", "Jeff Smith",
        "Palmetto Pediatrics", "John Jones",
        "8031234567", new EmergencyContact("Jeff Smith", "8031234567"),
        new EmergencyContact("Debra Smith", "8031234569"), new ArrayList<String>(),
        new ArrayList<String>(), "bio");

        Counselor counselor2 = new Counselor("Bob", "Smith", "8031234567",
        "email@gmail.com", "11042009", "300 Main St.", "Jeff Smith",
        "Palmetto Pediatrics", "John Jones",
        "8031234567", new EmergencyContact("Jeff Smith", "8031234567"),
        new EmergencyContact("Debra Smith", "8031234569"), new ArrayList<String>(),
        new ArrayList<String>(), "bio");

        userList.addUser(counselor1);
        userList.addUser(counselor2);
        userList.removeUser("Billy", "Smith");
        ArrayList<Counselor> expected = new ArrayList<Counselor>();
        expected.add(counselor2);

        assertEquals(expected, userList.getCounselors());
    } 
    @Test
    public void testRemoveUserCounselorDuplicateName() {
        Counselor counselor1 = new Counselor("Billy", "Smith", "8031234567",
        "email@gmail.com", "11042009", "300 Main St.", "Jeff Smith",
        "Palmetto Pediatrics", "John Jones",
        "8031234567", new EmergencyContact("Jeff Smith", "8031234567"),
        new EmergencyContact("Debra Smith", "8031234569"), new ArrayList<String>(),
        new ArrayList<String>(), "bio");

        Counselor counselor2 = new Counselor("Billy", "Smith", "8031234567",
        "email@gmail.com", "11042009", "300 Main St.", "Jeff Smith",
        "Palmetto Pediatrics", "John Jones",
        "8031234567", new EmergencyContact("Jeff Smith", "8031234567"),
        new EmergencyContact("Debra Smith", "8031234569"), new ArrayList<String>(),
        new ArrayList<String>(), "bio");

        userList.addUser(counselor1);
        userList.addUser(counselor2);
        userList.removeUser("Billy", "Smith");
        ArrayList<Counselor> expected = new ArrayList<Counselor>();

        assertEquals(expected, userList.getCounselors());
    }
    @Test
    public void testRemoveUserCounselorNullFirstName() {
        Counselor counselor1 = new Counselor(null, "Smith", "8031234567",
        "email@gmail.com", "11042009", "300 Main St.", "Jeff Smith",
        "Palmetto Pediatrics", "John Jones",
        "8031234567", new EmergencyContact("Jeff Smith", "8031234567"),
        new EmergencyContact("Debra Smith", "8031234569"), new ArrayList<String>(),
        new ArrayList<String>(), "bio");

        Counselor counselor2 = new Counselor("Bob", "Smith", "8031234567",
        "email@gmail.com", "11042009", "300 Main St.", "Jeff Smith",
        "Palmetto Pediatrics", "John Jones",
        "8031234567", new EmergencyContact("Jeff Smith", "8031234567"),
        new EmergencyContact("Debra Smith", "8031234569"), new ArrayList<String>(),
        new ArrayList<String>(), "bio");

        userList.addUser(counselor1);
        userList.addUser(counselor2);
        userList.removeUser(null, "Smith");
        ArrayList<Counselor> expected = new ArrayList<Counselor>();
        expected.add(counselor2);

        assertEquals(expected, userList.getCounselors());
    }
    @Test
    public void testRemoveUserCounselorNullLastName() {
        Counselor counselor1 = new Counselor("Billy", null, "8031234567",
        "email@gmail.com", "11042009", "300 Main St.", "Jeff Smith",
        "Palmetto Pediatrics", "John Jones",
        "8031234567", new EmergencyContact("Jeff Smith", "8031234567"),
        new EmergencyContact("Debra Smith", "8031234569"), new ArrayList<String>(),
        new ArrayList<String>(), "bio");

        Counselor counselor2 = new Counselor("Bob", "Smith", "8031234567",
        "email@gmail.com", "11042009", "300 Main St.", "Jeff Smith",
        "Palmetto Pediatrics", "John Jones",
        "8031234567", new EmergencyContact("Jeff Smith", "8031234567"),
        new EmergencyContact("Debra Smith", "8031234569"), new ArrayList<String>(),
        new ArrayList<String>(), "bio");

        userList.addUser(counselor1);
        userList.addUser(counselor2);
        userList.removeUser("Billy", null);
        ArrayList<Counselor> expected = new ArrayList<Counselor>();
        expected.add(counselor2);

        assertEquals(expected, userList.getCounselors());
    }  
    @Test
    public void testRemoveUserCamperValid() {
        Camper camper = new Camper("Jim", "Bob", "8032345678",
        "email@gmail.com", "11042009", "300 Main St.", "Jeff Smith",
        "Palmetto Pediatrics", "John Jones",
        "8032345678", new EmergencyContact("Jeff Smith", "8032345678"),
        new EmergencyContact("Jeff Smith", "8032345679"), new ArrayList<String>(),
        new ArrayList<String>());

        Camper camper2 = new Camper("Frank", "bob", "8032345678",
        "email@gmail.com", "11042009", "300 Main St.", "Jeff Smith",
        "Palmetto Pediatrics", "John Jones",
        "8032345678", new EmergencyContact("Jeff Smith", "8032345678"),
        new EmergencyContact("Jeff Smith", "8032345679"), new ArrayList<String>(),
        new ArrayList<String>());

        userList.addUser(camper);
        userList.addUser(camper2);
        userList.removeUser("Jim", "Bob");
        ArrayList<Camper> expected = new ArrayList<Camper>();
        expected.add(camper2);

        assertEquals(expected, userList.getCampers());
    } 
    @Test
    public void testRemoveUserCamperDuplicateFirstName() {
        Camper camper = new Camper("Jim", "Bob", "8032345678",
        "email@gmail.com", "11042009", "300 Main St.", "Jeff Smith",
        "Palmetto Pediatrics", "John Jones",
        "8032345678", new EmergencyContact("Jeff Smith", "8032345678"),
        new EmergencyContact("Jeff Smith", "8032345679"), new ArrayList<String>(),
        new ArrayList<String>());

        Camper camper2 = new Camper("Jim", "Bob", "8032345678",
        "email@gmail.com", "11042009", "300 Main St.", "Jeff Smith",
        "Palmetto Pediatrics", "John Jones",
        "8032345678", new EmergencyContact("Jeff Smith", "8032345678"),
        new EmergencyContact("Jeff Smith", "8032345679"), new ArrayList<String>(),
        new ArrayList<String>());

        userList.addUser(camper);
        userList.addUser(camper2);
        userList.removeUser("Jim", "Bob");
        ArrayList<Camper> expected = new ArrayList<Camper>();

        assertEquals(expected, userList.getCampers());
    } 
}