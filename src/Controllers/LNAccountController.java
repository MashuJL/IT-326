package Controllers;

import java.io.IOException;

import Handlers.LNAccountHandler;

public class LNAccountController
{
    private static LNAccountHandler acctHandler = null;

    private static LNAccountHandler getLNAccountHandlerInstance()
    { // Gets the account handler object
        if (acctHandler == null)
            acctHandler = new LNAccountHandler();
        return acctHandler;
    }

    public static boolean login(String username, String password) throws IOException, ClassNotFoundException // Calls
                                                                                                             // login
                                                                                                             // implementation
                                                                                                             // from
                                                                                                             // account
                                                                                                             // handler
    {
        return getLNAccountHandlerInstance().login(username, password);
    }

    public static boolean createAccount(String username, String password) throws IOException, ClassNotFoundException // Calls
                                                                                                                     // create
                                                                                                                     // account
                                                                                                                     // implementation
                                                                                                                     // from
                                                                                                                     // account
                                                                                                                     // handler
    {
        return getLNAccountHandlerInstance().createAccount(username, password);
    }

    public static boolean updateAccount(String username, String password, String curUsername, String curPassword)
            throws IOException, ClassNotFoundException
    {
        return getLNAccountHandlerInstance().updateAccount(username, password, curUsername, curPassword);
    }

    public static boolean deleteAccount(String username, String password) throws IOException, ClassNotFoundException
    {
        return getLNAccountHandlerInstance().deleteAccount(username, password);
    }

    public static boolean loggout() // Calls loggout implementation from account handler
    {
        return getLNAccountHandlerInstance().loggout();
    }

    // calls the getNotifCount implementation from account handler -Nathan
    public static int getNotifCount(String username) throws IOException, ClassNotFoundException
    {
        return getLNAccountHandlerInstance().getNotifCount(username);
    }
}
