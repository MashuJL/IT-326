package Handlers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import CRUDOps.LNAccountCRUDOps;
import Models.LNAccount;
import Models.LNComment;
import OperationsFactory.OperationsFactory;

public class LNAccountHandler 
{
    private boolean verify(String verifyStr) //verifies that the parameter is a string
    {
        return verifyStr instanceof String;
    }

    private boolean verify(int verifyInt) //Verifies parameter is an integer
    {
        try
        {
            Integer temp = (Integer)verifyInt;
            return true; //Cast succeeded, we have an integer. (instanceof doesnt work on primitves)
        } 
        catch (Exception e)
        {
            return false; //Cast failed - not int
        }
    }

    public static LNAccountCRUDOps getAcctOps() //Get account operations object
    {
        return OperationsFactory.getAcctOps();
    }

    public boolean login(String username, String password) throws IOException, ClassNotFoundException //Login that checks user's inputted email and password with accounts.csv file
    {
        if(verify(username) && verify(password))
        {
            LNAccount tempAcct = getAcctOps().retrieveAcct(username);
            if(tempAcct != null)
            {
                if(tempAcct.getPassword().equals(password))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean createAccount(String username, String password) throws IOException, ClassNotFoundException //Creates and saves the account to the accounts.csv file
    {
        if(verify(username) && verify(password))
        {
            if(Pattern.matches("^[a-zA-Z0-9_!#$%&'*+=?`{|}~^.-]+@[a-zA-Z]+.[a-zA-Z]+$", username) == true)
            {
                return getAcctOps().saveAcct(new LNAccount(username, password));
            }
            System.out.print("Error: Not a valid email.");
        }
        return false;
    }

    public boolean updateAccount(String username, String password, String curUsername, String curPassword) throws IOException, ClassNotFoundException
    {
        if(verify(username) && verify(password) && verify(curUsername) && verify(curPassword))
        {
            return getAcctOps().updateAccount(username, password, curUsername, curPassword);
        }
        return false;
    }

    public boolean deleteAccount(String username, String password) throws IOException, ClassNotFoundException
    {
        if(verify(username) && verify(password))
        {
            return getAcctOps().deleteAccount(username, password);
        }
        return false;
    }

    public boolean loggout() //Simply returns true and which logs them out of the user experience in main
    {
        System.out.println("Goodbye");
        return true;
    }

    /*
    public boolean deleteAccount(String username, String password) throws ClassNotFoundException, IOException
    {
        return getAcctOps().deleteAccount(username, password);
    }

    public boolean updateAccount(String newName, String newPass, String oldName, String oldPass) throws ClassNotFoundException, IOException
    {
        return getAcctOps().updateAccount(newName, newPass, oldName, oldPass);
    }
    */

    public int printBlockedUsers(String currentUser) throws ClassNotFoundException, IOException
    {
        if(verify(currentUser))
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
        System.out.println("Error - Invalid input");
        return -1;
    }

    public boolean blockUser(String currentUser, int id) throws ClassNotFoundException, IOException
    {
        if(verify(currentUser) && verify(id))
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
        return false;
    }

    public boolean unblockUser(String currentUser, int id) throws ClassNotFoundException, IOException
    {
        if(verify(currentUser) && verify(id))
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
        return false;
    }

    public int printComments(String currentUser) throws ClassNotFoundException, IOException
    {
        if(verify(currentUser))
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
        System.out.println("Error - Invalid input");
        return -1;
    }

    public boolean pinComment(String currentUser, int selected) throws ClassNotFoundException, IOException
    {
        if(verify(currentUser) && verify(selected))
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
        return false;
    }

    public boolean removeComment(String currentUser, int removed) throws ClassNotFoundException, IOException
    {
        if(verify(currentUser) && verify(removed))
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
        return false;
    }

    public boolean editComment(String currentUser, int selected, String newText) throws ClassNotFoundException, IOException
    {
        if(verify(newText) && verify(selected))
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
        return false;
    }
}
