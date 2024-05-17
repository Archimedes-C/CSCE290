import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
/**
 * @author Matthew Olson
 */
public class AccountListTest {
    private AccountList accountList = AccountList.getInstance();

    @BeforeEach
    public void setup() {
        AccountList.getInstance().getAccounts().clear();
    }

    @AfterEach
    public void tearDown() {
        AccountList.getInstance().getAccounts().clear();
    }

    @Test
    public void testaddaccountFound(){
        Account account = new Account("username", "password");
        accountList.addAccount(account);
        DataWriter.saveAllAccounts();
        assertEquals(account, accountList.getAccount("username"));
    }
    @Test
    public void testaddaccountnotFound(){
        Account account = new Account("username", "password");
        accountList.addAccount(account);
        DataWriter.saveAllAccounts();
        assertEquals(null, accountList.getAccount("NewUser"));
    }
    @Test
    public void testaddaccountnullPassword(){
        Account account = new Account("username", null);
        accountList.addAccount(account);
        DataWriter.saveAllAccounts();
        assertEquals(account, accountList.getAccount("username"));
    }
    @Test
    public void testaddaccountnullUsername(){
        Account account = new Account(null, "password");
        accountList.addAccount(account);
        DataWriter.saveAllAccounts();
        assertEquals(account, accountList.getAccount(null));
    }
    @Test
    public void testgetaccountDuplicate(){
        // Add a account to accountlist
        Account account = new Account("username", "password");
        Account account2 = new Account("username", "password");
        ArrayList<Account> expected = new ArrayList<Account>();
        expected.add(account);
        expected.add(account2);
        assertEquals(account, accountList.getAccount("username"));
    }
    @Test
    public void testgetaccountNullUsername(){
        Account account = new Account(null, "password");
        ArrayList<Account> expected = new ArrayList<Account>();
        expected.add(account);
        assertEquals(expected.equals(account), false);
    }
    @Test
    public void testgetaccountNullPassword(){
        Account account = new Account("Username", null);
        ArrayList<Account> expected = new ArrayList<Account>();
        expected.add(account);
        assertEquals(expected.equals(account), false);
    }
}

