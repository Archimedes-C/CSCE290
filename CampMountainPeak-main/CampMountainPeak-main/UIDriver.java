import java.util.ArrayList;
import java.util.Scanner;

public class UIDriver {
    public static void main(String[] args) {
        UIDriver uDriver = new UIDriver();
        uDriver.runUIDriver();
    }
    /**
     * Runs the UI
     */
    
    /**
     * UI for each users to navigate through the system
     * This includes logging in, signing up, or quit
     */
    public void runUIDriver() {
        String command = null;
        int accounttype = 0;
        CampSystemFACADE facade = new CampSystemFACADE();
        Cabin cab = new Cabin(accounttype);
        Director Dir = new Director(command, command, command, command);
        SessionList Seslist = SessionList.getInstance();
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to Camp Mountain Peak");
        while(true) {  // login/sign up screen
            facade.current("Welcome!");
            System.out.println("1. Log in");
            System.out.println("2. Sign Up");
            System.out.println("3. Quit");
            command = getInputLine("Enter Command", in);
            if(command.contentEquals("1")) {  // log in
                while(true) {
                    facade.current("Log in");
                    System.out.println("Are you a...");
                    System.out.println("1. Parent\n2. Counselor\n3. Director");
                    command = getInputLine("Enter Command", in); // Logging in as specific user type
                    if(command.contentEquals("1")) {
                        accounttype = 1;
                        break;
                    } else if(command.contentEquals("2")) {
                        accounttype = 2;
                        break;
                    } else if(command.contentEquals("3")) {
                        accounttype = 3;
                        break;
                    } else {
                        System.out.println("I'm sorry, that command is not recognized."); // Invalid user type
                        System.out.println();
                    }
                }
                String username, password;
                int valLogin = 0;
                while(true) { //  sign in attempts
                    System.out.println("Username: ");
                    username = in.nextLine();
                    System.out.println("Password: ");
                    password = in.nextLine();
                    if(username.equals("quit") || password.equals("quit")) { // quit option ini log in
                        break;
                    }
                    if(!facade.findAccount(username)) {  // username not found
                        System.out.println("Username doesn't exist.");
                        continue;
                    }
                    if(!facade.checkPassword(username, password)) {  // wrong password
                        System.out.println("Incorrect password.");
                        continue;
                    }
                    valLogin = 1;// login successful
                    break;
                }
                if(valLogin == 1) {
                facade.login(username, password); // If successful, the user gains access
                break;
                }
            } else if(command.contentEquals("2")) {  // sign up
                facade.current("Sign Up");
                System.out.println("Username: ");
                String username = in.nextLine();
                System.out.println("Password: ");
                String password = in.nextLine();
                System.out.println(facade.signUp(username, password));
                
            } else if(command.contentEquals("3")) {  // quit
                System.exit(0);
            } else {
                System.out.println("I'm sorry, that command is not recognized.");
                System.out.println();
            }
        }
        while(true) {  // main menu
            if(accounttype == 1) {  // camper/parent
                while(true) {
                    facade.current("Main Menu");
                    System.out.println("Account: " + facade.getAccount().getUsername());
                    System.out.print("Children: ");
                    if(facade.getAccount().getUsers().size() == 0) {
                        System.out.print("N/A");
                    }
                    for(User user : facade.getAccount().getUsers()) {
                        System.out.print(user.getFullName() + " ");
                        ArrayList<Session> camperSessions = facade.getCamperSessions((Camper)user);
                        for(int i = 0; i < camperSessions.size(); i++) {
                            System.out.print("["+camperSessions.get(i)+"]");
                            if(i < camperSessions.size()-1) {
                                System.out.print(", ");
                            }
                        }
                    }
                    System.out.println();
                    System.out.println("1. Register Camper");
                    System.out.println("2. Show Schedule");
                    System.out.println("3. Payment");
                    System.out.println("4. Display Camper Information");
                    command = getInputLine("Enter Command", in);
                    if(command.contentEquals("1")){ // registeration for a camper
                        facade.current("Registration");
                        System.out.println("Would you like to..");
                        System.out.println("1. Register an existing camper");
                        System.out.println("2. Register a new camper");
                        command = getInputLine("Enter Command", in);
                        Camper camper = null;
                        if(command.contentEquals("1")) {  // register existing camper
                            if(facade.getAccount().getUsers().size() == 0) {  // no campers
                                System.out.println("There are no campers registered.");
                                command = "2";
                            } else {  // there are campers registered already
                                System.out.println("Select camper to register: ");
                                for (int i = 0; i < facade.getAccount().getUsers().size(); i++) {
                                    System.out.println((i+1) + ". " + facade.getAccount().getUsers().get(i).getFullName());
                                }
                                command = getInputLine("Enter Command", in);
                                camper = (Camper)facade.getAccount().getUsers().get(Integer.parseInt(command)-1);
                                command = "1";
                            }
                        }
                        if(command.contentEquals("2")) {  // register new camper
                            command = getInputLine("Enter First Name", in);
                            String first = command;
                            command = getInputLine("Enter Last Name", in);
                            String last = command;
                            command = getInputLine("Enter Phone Number", in);
                            String phone = command;
                            command = getInputLine("Email", in);
                            String email = command;
                            command = getInputLine("Enter Birthday", in);
                            String bday = command;
                            command = getInputLine("Address", in);
                            String address = command;
                            command = getInputLine("Guardian Name", in);
                            String Gname = command;
                            command = getInputLine("Emergency Contact Name", in);
                            String eContactName = command;
                            command = getInputLine("Emergency Contact Phone", in);
                            String eContactPhone = command;
                            command = getInputLine("Secondary Emergency Contact Name", in);
                            String eContactName2 = command;
                            command = getInputLine("Secondary Emergency Contact Phone", in);
                            String eContactPhone2 = command;
                            command = getInputLine("Pediatritic Care", in);
                            String Pcare = command;
                            command = getInputLine("Pediatritian Name", in);
                            String Pname = command;
                            command = getInputLine("Pediatritian Phone", in);
                            String Pphone = command;
                            System.out.println("Please enter all Allergies. Type 'done' when done.");
                            ArrayList<String> allergies = new ArrayList<String>();
                            while(true) {
                                command = getInputLine("Allergy", in);
                                if(command.contentEquals("done"))break;
                                allergies.add(command);
                            }
                            command = "";
                            System.out.println("Pleae enter all Dietary/Medication Information. Type 'done' when done.");
                            ArrayList<String> diets = new ArrayList<String>();
                            while(true) {
                                command = getInputLine("Diet/Medication", in);
                                if(command.contentEquals("done"))break;
                                diets.add(command);
                            }
                            camper = facade.registerCamper(first, last, phone, email, bday, address, Gname, Pcare, Pname, Pphone, new EmergencyContact(eContactName,eContactPhone), new EmergencyContact(eContactName2, eContactPhone2), allergies, diets);
                            break;
                        }
                        System.out.println("\nSelect which session you want to sign up for:");
                        ArrayList<Session> sesList = SessionList.getInstance().getSessions();
                        for(int i = 0; i < sesList.size(); i++) {
                            System.out.println((i+1)+ ". "+sesList.get(i).toString());
                        }
                        command = getInputLine("Command", in);
                        sesList.get(Integer.parseInt(command)-1).getCabins().get(0).addCamper(camper);
                        DataWriter.saveAllSessions();
                        System.out.println(camper.getFullName() + " was added to the session.");
                        command = "1";
                    }
                    if(command.contentEquals("2")){  // print schedule
                        command = getInputLine("Enter the week", in);
                        int week = Integer.parseInt(command);
                        command = getInputLine("Enter the day: ", in);
                        int day = Integer.parseInt(command);
                        command = getInputLine("Enter the cabin number: ", in);
                        int Cnum = Integer.parseInt(command);
                        System.out.println(cab.printScheduleDay(week, day, Cnum));
                        break;
                    }
                    if(command.contentEquals("quit"))break;
                    if(command.contentEquals("3")){
                        facade.current("Payment");
                        command = getInputLine("Name on Card: ", in);
                        if (command.equals("")) {
                            break;
                        }
                        command = getInputLine("Card number: ", in);
                        if (command.equals("")) {
                            break;
                        }
                        command = getInputLine("The three wacky numbers on the back: ", in);
                        if (command.equals("")) {
                            break;
                        }
                        command = getInputLine("Expiration Date: ", in);
                        if (command.equals("")) {
                            break;
                        }
                        System.out.println("Payment successfully entered.");
                        break;
                    }
                    if(command.contentEquals("4")){
                        System.out.println();
                        for (int i = 0; i < facade.getAccount().getUsers().size(); i++) {
                            System.out.println(facade.getAccount().getUsers().get(i).toString());
                        }
                    }
                    if(command.contentEquals("quit"))break;
                }
            }
            if(accounttype == 2) {  // counselor
                while(true) {
                    facade.current("Main Menu");
                    System.out.println("-Counselor " + facade.getAccount().getUsername());
                    System.out.println("1. Add Strikes");
                    System.out.println("2. Show Schedule");
                    command = getInputLine("Enter Command", in);
                    if(command.contentEquals("1")){ // strike system
                        command = getInputLine("Enter the First name of the Camper: ", in);
                        String firstname = command;
                        command = getInputLine("Enter the Last name of the Camper: ", in);
                        String lastname = command;
                        Camper curCamper = (Camper) UserList.getInstance().getUserByName(firstname, lastname);
                        //str.addStrike(curCamper);
                        System.out.println("Added a strike to " + firstname + lastname);
                        break;
                    }
                    if(command.contentEquals("2")){ // print the schedule of a cabin out
                        command = getInputLine("Enter the week: ", in);
                        int week = Integer.parseInt(command);
                        command = getInputLine("Enter the day: ", in);
                        int day = Integer.parseInt(command);
                        command = getInputLine("Enter the cabin number: ", in);
                        int Cnum = Integer.parseInt(command);
                        System.out.println(cab.printScheduleDay(week, day, Cnum));
                        System.out.println("Average Cabin Age: " + cab.cabinAge(Cnum));
                        System.out.println("------ Campers Information ------");
                        ArrayList<Cabin> cabin = SessionList.getInstance().getSession(week).getCabins();

                        for (int i = 0; i < cabin.size(); i++) {
                            if(cabin.get(i).getCabinNum() == Cnum) {
                                ArrayList<Camper> campers = cabin.get(i).getCampers();
                                for (Camper camper : campers) {
                                    System.out.println(camper.toString());
                                    System.out.println("-------------------------------");
                                }
                            }
                        }
                        break;
                    }
                    if(command.contentEquals("quit"))break;
                }
            }
            if(accounttype == 3) {  // director
                while(true) {
                    facade.current("Main Menu");
                    System.out.println("-Director " + facade.getAccount().getUsername());
                    System.out.println("1. Remove Camper");
                    System.out.println("2. Create a new Session");
                    System.out.println("3. Show Schedule");
                    command = getInputLine("Enter Command", in);
                    if(command.contentEquals("1")) {
                    facade.current("Remove Camper");
                    command = getInputLine("Enter the First name of the Camper: ", in);
                    String firstname = command;
                    command = getInputLine("Enter the Last name of the Camper: ", in);
                    String lastname = command;
                    UserList list = UserList.getInstance();
                    Dir.rmCamper(firstname, lastname, list);
                    break;
                    }
                    if(command.contentEquals("2")){
                        command = getInputLine("Enter the week of the new session: ", in);
                        int week = Integer.parseInt(command);
                        Session sess = new Session(week);
                        Seslist.addSession(sess);
                        command = getInputLine("Enter the Theme of the week: ", in);
                        sess.setTheme(command);
                        System.out.println("New Session Created!");
                        break;
                    }
                    if(command.contentEquals("3")){
                        command = getInputLine("Enter the week", in);
                        int week = Integer.parseInt(command);
                        command = getInputLine("Enter the day: ", in);
                        int day = Integer.parseInt(command);
                        command = getInputLine("Enter the cabin number: ", in);
                        int Cnum = Integer.parseInt(command);
                        System.out.println(cab.printScheduleDay(week, day, Cnum));
                        break;
                    }
                    command = getInputLine("Enter Command", in);
                    if(command.contentEquals("quit"))break;  // quit
                }
            }
            System.out.println("Press any key to continue or type 'quit' to exit the program.");
            command = getInputLine("Enter Command", in);
            if(command.contentEquals("quit")) {
                System.exit(0);
            };
        }
        
        
    }

    /**
     * Takes input from the user
     * @param prompt a string printed to the console prompting input
     * @param in input source
     * @return user input
     */
    private String getInputLine(String prompt, Scanner in) {
        System.out.print(prompt + ": ");
        return in.nextLine().toLowerCase().trim();
    }
}