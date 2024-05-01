package Handlers;

import java.io.IOException;
import java.util.regex.Pattern;

import CRUDOps.LNAccountCRUDOps;
import Classes.LNAccount;
import OperationsFactory.OperationsFactory;

public class LNAccountHandler 
{
    //LNAccountCRUDOps acctCRUDOps = OperationsFactory.getAcctOps();

    public static LNAccountCRUDOps getAcctOps()
    {
        return OperationsFactory.getAcctOps();
    }

    public boolean login(String username, String password) throws IOException, ClassNotFoundException
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

    public boolean createAccount(String username, String password) throws IOException, ClassNotFoundException
    {
        if(Pattern.matches("^[a-zA-Z0-9_!#$%&'*+=?`{|}~^.-]+@[a-zA-Z]+.[a-zA-Z]+$", username) == true)
        {
            return getAcctOps().saveAcct(new LNAccount(username, password));
        }
        System.out.print("Error: Not a valid email.");
        return false;
    }

    public boolean loggout()
    {
        System.out.println("Goodbye");
        return true;
    }
}
