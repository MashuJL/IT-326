package Handlers;

import java.io.IOException;

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
        if(getAcctOps().retrieveAcct(username, password) != null)
        {
            return true;
        }
        return false;
    }

    public boolean createAccount(String username, String password) throws IOException, ClassNotFoundException
    {
        return getAcctOps().saveAcct(new LNAccount(username, password));
    }

    public boolean loggout()
    {
        System.out.println("Goodbye");
        return true;
    }
}
