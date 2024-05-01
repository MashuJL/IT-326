package Handlers;

import java.io.IOException;
import java.util.ArrayList;

import CRUDOps.LNAccountCRUDOps;
import Classes.LNAccount;
import Classes.LNComment;
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

    public boolean deleteAccount(String username, String password) throws ClassNotFoundException, IOException
    {
        return getAcctOps().deleteAccount(username, password);
    }

    public boolean updateAccount(String newName, String newPass, String oldName, String oldPass) throws ClassNotFoundException, IOException
    {
        return getAcctOps().updateAccount(newName, newPass, oldName, oldPass);
    }

    public int printBlockedUsers(String currentUser, String currentPass) throws ClassNotFoundException, IOException
    {
        LNAccount temp = getAcctOps().retrieveAcct(currentUser, currentPass);
        if(temp == null)
        {
            System.out.println("Error - Account [Name = "+currentUser+"] is null");
        }
        ArrayList<Integer> blocked = temp.getBlockedUsers();

        if(blocked.size() == 0)
            return 0;
        
        System.out.println("All blocked IDs: ");
        for(Integer i : blocked)
        {
            System.out.println("["+i+"]");
        }
        return blocked.size();
    }

    public boolean blockUser(String currentUser, String currentPass, int id) throws ClassNotFoundException, IOException
    {
        LNAccount temp = getAcctOps().retrieveAcct(currentUser, currentPass);
        if(temp == null)
        {
            System.out.println("Error - Account [Name = "+currentUser+"] is null");
            return false;
        }
        ArrayList<Integer> newBlocked = temp.getBlockedUsers();

        if(newBlocked.contains((Integer) id))
            return false; //Already blocked
        newBlocked.add((Integer) id);
        return getAcctOps().updateAccount(newBlocked, currentUser, currentPass);
    }

    public boolean unblockUser(String currentUser, String currentPass, int id) throws ClassNotFoundException, IOException
    {
        LNAccount temp = getAcctOps().retrieveAcct(currentUser, currentPass);
        if(temp == null)
        {
            System.out.println("Error - Account [Name = "+currentUser+"] is null");
            return false;
        }
        ArrayList<Integer> newBlocked = temp.getBlockedUsers();
        if(newBlocked.contains((Integer) id))
        {
            newBlocked.remove((Integer) id);
            return getAcctOps().updateAccount(newBlocked, currentUser, currentPass);
        }
        return false; //Given ID is not blocked - can't unblock it
    }

    public int printComments(String currentUser, String currentPass) throws ClassNotFoundException, IOException
    {
        LNAccount temp = getAcctOps().retrieveAcct(currentUser, currentPass);
        if(temp == null)
        {
            System.out.println("Error - Account [Name = "+currentUser+"] is null");
        }
        ArrayList<LNComment> comments = temp.getComments();

        if(comments.size() == 0)
            return 0;
        
        System.out.println("All comments: ");
        for(LNComment i : comments)
        {
            System.out.println("------");
            System.out.println("Text: ["+i.getText()+"]");
            System.out.println("On File: "+i.getFile().getName());
            System.out.println("------");
        }
        return comments.size();
    }

}
