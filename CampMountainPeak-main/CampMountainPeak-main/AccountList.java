
import java.util.ArrayList;

/**
 * @author Andrew Chisolm, Bryan Munoz, Matt Olson, Daniel Ruiz, Jaden Arnold
 * List of all Accounts
 */
public class AccountList {

    private ArrayList<Account> accounts;
    private static AccountList accountList;
    /**
     * Sets accounts to get all accounts
     */
    private AccountList() {
        accounts = DataReader.getAllAccounts();
    }
    /**
     * Creates a new instance of accountlist
     * @return the new accountlist
     */
    public static AccountList getInstance() {
        if (accountList == null) {
            accountList = new AccountList();
        }
        return accountList;
    }

    /**
     * Accessor for list of Accounts
     * @return list of Accounts
     */
    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    /**
     * Adds a account to the list
     * @param account the account being added
     */
    public void addAccount(Account account) {
        accounts.add(account);
        DataWriter.saveAllAccounts();
    }

    /**
     * Searches for a account
     * @param username account username
     * @return the account; null if not found
     */
    public Account getAccount(String username) {
        for(Account account : accounts) {
            if(account.getUsername().equals(username)) {
                return account;
            }
        }
        return null;
    }
}
