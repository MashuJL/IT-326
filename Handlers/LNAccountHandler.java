package Handlers;

import java.io.IOException;
import java.util.regex.Pattern;

import CRUDOps.LNAccountCRUDOps;
import Classes.LNAccount;
import OperationsFactory.OperationsFactory;

public class LNAccountHandler 
{
    //LNAccountCRUDOps acctCRUDOps = OperationsFactory.getAcctOps();

    public static LNAccountCRUDOps getAcctOps() //Get account operations object
    {
        return OperationsFactory.getAcctOps();
    }

    public boolean login(String username, String password) throws IOException, ClassNotFoundException //Login that checks user's inputted email and password with accounts.csv file
    {
        LNAccount tempAcct = getAcctOps().retrieveAcct(username);
        if(tempAcct != null)
        {
            if(tempAcct.getPassword().equals(password))
            {
                return true;
            }
        }
        return false;
    }

    public boolean createAccount(String username, String password) throws IOException, ClassNotFoundException //Creates and saves the account to the accounts.csv file
    {
        if(Pattern.matches("^[a-zA-Z0-9_!#$%&'*+=?`{|}~^.-]+@[a-zA-Z]+.[a-zA-Z]+$", username) == true)
        {
            return getAcctOps().saveAcct(new LNAccount(username, password));
        }
        System.out.print("Error: Not a valid email.");
        return false;
    }

    public boolean updateAccount(String username, String password, String curUsername, String curPassword) throws IOException, ClassNotFoundException
    {
        return getAcctOps().updateAccount(username, password, curUsername, curPassword);
    }

    public boolean deleteAccount(String username, String password) throws IOException, ClassNotFoundException
    {
        return getAcctOps().deleteAccount(username, password);
    }

    public boolean loggout() //Simply returns true and which logs them out of the user experience in main
    {
        System.out.println("Goodbye");
        return true;
    }
}
