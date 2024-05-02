package Controllers;
import java.io.IOException;

import Handlers.LNAccountHandler;

public class LNAccountController 
{
    /*private static LNAccountHandler acctHandler = null;

    public static LNAccountHandler getLNAccountHandlerInstance(){ //Gets the account handler object
        if(acctHandler==null)
            acctHandler = new LNAccountHandler();
        return acctHandler;
    }*/

    private static LNAccountHandler acctHandler = new LNAccountHandler();
    
    public boolean login(String username, String password) throws IOException, ClassNotFoundException //Calls login implementation from account handler
    {
        //return getLNAccountHandlerInstance().login(username, password);
        return acctHandler.login(username, password);
    }

    public boolean createAccount(String username, String password) throws IOException, ClassNotFoundException //Calls create account implementation from account handler
    {
        //return getLNAccountHandlerInstance().createAccount(username, password);
        return acctHandler.createAccount(username, password);
    }

    public boolean loggout() //Calls loggout implementation from account handler
    {
        //return getLNAccountHandlerInstance().loggout();
        return acctHandler.loggout();
    }

    public boolean deleteAccount(String username, String password) throws ClassNotFoundException, IOException
    {
        //return getLNAccountHandlerInstance().deleteAccount(username, password);
        return acctHandler.deleteAccount(username, password);
    }

    public boolean updateAccount(String newName, String newPass, String oldName, String oldPass) throws ClassNotFoundException, IOException
    {
        //return getLNAccountHandlerInstance().updateAccount(newName, newPass, oldName, oldPass);
        return acctHandler.updateAccount(newName, newPass, oldName, oldPass);
    }

    public int printBlockedUsers(String currentUser) throws ClassNotFoundException, IOException
    {
        return acctHandler.printBlockedUsers(currentUser);
    }

    public boolean blockUser(String currentUser, int id) throws ClassNotFoundException, IOException
    {
        return acctHandler.blockUser(currentUser, id);
    }

    public boolean unblockUser(String currentUser, int id) throws ClassNotFoundException, IOException
    {
        return acctHandler.unblockUser(currentUser, id);
    }

    public int printComments(String currentUser) throws ClassNotFoundException, IOException
    {
        return acctHandler.printComments(currentUser);
    }

    public boolean pinComment(String currentUser, int selected) throws ClassNotFoundException, IOException
    {
        return acctHandler.pinComment(currentUser, selected);
    }

    public boolean removeComment(String currentUser, int removed) throws ClassNotFoundException, IOException
    {
        return acctHandler.removeComment(currentUser, removed);
    }

    public boolean editComment(String currentUser, int selected, String newText) throws ClassNotFoundException, IOException
    {
        return acctHandler.editComment(currentUser, selected, newText);
    }
}
