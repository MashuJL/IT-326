package Handlers;

import java.io.IOException;
import java.util.regex.Pattern;
import java.util.ArrayList;

import CRUDOps.LNAccountCRUDOps;
import Classes.LNAccount;
import Classes.LNComment;
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

    public boolean loggout() //Simply returns true and which logs them out of the user experience in main
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

    public int printBlockedUsers(String currentUser) throws ClassNotFoundException, IOException
    {
        LNAccount temp = getAcctOps().retrieveAcct(currentUser);
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

    public boolean blockUser(String currentUser, int id) throws ClassNotFoundException, IOException
    {
        LNAccount temp = getAcctOps().retrieveAcct(currentUser);
        if(temp == null)
        {
            System.out.println("Error - Account [Name = "+currentUser+"] is null");
            return false;
        }
        ArrayList<Integer> newBlocked = temp.getBlockedUsers();

        if(newBlocked.contains((Integer) id))
            return false; //Already blocked
        newBlocked.add((Integer) id);
        return getAcctOps().updateAccountBlocked(newBlocked, currentUser);
    }

    public boolean unblockUser(String currentUser, int id) throws ClassNotFoundException, IOException
    {
        LNAccount temp = getAcctOps().retrieveAcct(currentUser);
        if(temp == null)
        {
            System.out.println("Error - Account [Name = "+currentUser+"] is null");
            return false;
        }
        ArrayList<Integer> newBlocked = temp.getBlockedUsers();
        if(newBlocked.contains((Integer) id))
        {
            newBlocked.remove((Integer) id);
            return getAcctOps().updateAccountBlocked(newBlocked, currentUser);
        }
        return false; //Given ID is not blocked - can't unblock it
    }

    public int printComments(String currentUser) throws ClassNotFoundException, IOException
    {
        LNAccount temp = getAcctOps().retrieveAcct(currentUser);
        if(temp == null)
        {
            System.out.println("Error - Account [Name = "+currentUser+"] is null");
        }
        ArrayList<LNComment> comments = temp.getComments();

        if(comments.size() == 0)
            return 0;
        
        int index = 1;
        System.out.println("All comments: ");
        for(LNComment i : comments)
        {
            System.out.println("-----------------");
            System.out.println("Comment "+index+":");
            System.out.println("    Text: ["+i.getText()+"]");
            System.out.println("    On File: "+i.getFile().getName());
            System.out.println("-----------------");
            index++;
        }
        return comments.size();
    }

    public boolean pinComment(String currentUser, int selected) throws ClassNotFoundException, IOException
    {
        LNAccount temp = getAcctOps().retrieveAcct(currentUser);
        if(temp == null)
        {
            System.out.println("Error - Account [Name = "+currentUser+"] is null");
            return false;
        }
        ArrayList<LNComment> comments = temp.getComments();
        if(selected > comments.size())
            return false; //Invalid selection
        ArrayList<LNComment> newPinned = new ArrayList<LNComment>();
        newPinned.add( comments.get(selected-1) ); //-1 because this is starting from 1 when presented to user
        return getAcctOps().updateAccountPinned(newPinned, currentUser);
    }

    public boolean removeComment(String currentUser, int removed) throws ClassNotFoundException, IOException
    {
        //TODO: Update the LNFile the comment is attached to as well
        //TODO: Actually, this may not be necessary if LNFile has the actual Comment object
        LNAccount temp = getAcctOps().retrieveAcct(currentUser);
        if(temp == null)
        {
            System.out.println("Error - Account [Name = "+currentUser+"] is null");
            return false;
        }
        ArrayList<LNComment> comments = temp.getComments();
        if(removed > comments.size())
            return false; //Invalid selection
        comments.remove(removed-1);
        return getAcctOps().updateAccountComments(comments, currentUser);
    }

    public boolean editComment(String currentUser, int selected, String newText) throws ClassNotFoundException, IOException
    {
        //TODO: Update the LNFile the comment is attached to as well
        //TODO: Actually, this may not be necessary if LNFile has the actual Comment object
        LNAccount temp = getAcctOps().retrieveAcct(currentUser);
        if(temp == null)
        {
            System.out.println("Error - Account [Name = "+currentUser+"] is null");
            return false;
        }
        ArrayList<LNComment> comments = temp.getComments();
        if(selected > comments.size())
            return false; //Invalid
        comments.get(selected-1).setText(newText);
        return getAcctOps().updateAccountComments(comments, currentUser);

    }

}
