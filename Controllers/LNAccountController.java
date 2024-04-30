package Controllers;
import java.io.IOException;

import Handlers.LNAccountHandler;

public class LNAccountController 
{
    private static LNAccountHandler acctHandler = null;

    public static LNAccountHandler getLNAccountHandlerInstance(){
        if(acctHandler==null)
            acctHandler = new LNAccountHandler();
        return acctHandler;
    }
    
    public boolean login(String username, String password) throws IOException, ClassNotFoundException
    {
        return getLNAccountHandlerInstance().login(username, password);
    }

    public boolean createAccount(String username, String password) throws IOException, ClassNotFoundException
    {
        return getLNAccountHandlerInstance().createAccount(username, password);
    }

    public boolean loggout()
    {
        return getLNAccountHandlerInstance().loggout();
    }
}
