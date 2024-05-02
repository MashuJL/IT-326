package Controllers;

import java.io.IOException;

import Handlers.LNAccountHandler;

public class LNAccountController
{
    private static LNAccountHandler acctHandler = null;

    public static LNAccountHandler getLNAccountHandlerInstance()
    { // Gets the account handler object
        if (acctHandler == null)
            acctHandler = new LNAccountHandler();
        return acctHandler;
    }

    public boolean login(String username, String password) throws IOException, ClassNotFoundException // Calls login
                                                                                                      // implementation
                                                                                                      // from account
                                                                                                      // handler
    {
        return getLNAccountHandlerInstance().login(username, password);
    }

    public boolean createAccount(String username, String password) throws IOException, ClassNotFoundException // Calls
                                                                                                              // create
                                                                                                              // account
                                                                                                              // implementation
                                                                                                              // from
                                                                                                              // account
                                                                                                              // handler
    {
        return getLNAccountHandlerInstance().createAccount(username, password);
    }

    public boolean loggout() // Calls loggout implementation from account handler
    {
        return getLNAccountHandlerInstance().loggout();
    }
}
