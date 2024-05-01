package Classes;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.io.IOException;

import Operations.LNAccountOperations;
import CRUDOps.LNAccountCRUDOps;

public class LNAccount implements Serializable 
{
    private int accountID; //Account's ID
    private String accountEmail; //Account's email
    private String accountPassword; //Account's password
    private ArrayList<LNFile> ownedFiles; //Account's list of files
    private ArrayList<LNFolder> ownedFolders; //Account's list of folders
    private ArrayList<LNNotification> notifications; //Account's list of notifications
    private ArrayList<LNComment> comments; //Account's list of comments
    private ArrayList<Integer> blockedUserIDs; //Account's blocked list of users with their ID's specifying them

    public LNAccount(String accountEmail, String accountPassword) throws IOException, ClassNotFoundException
    {
        //Creating account ID/checking to see if the same ID already exists starting here
        Random rand = new Random();
        this.accountID = -1;
        boolean alreadyID = true;
        while(alreadyID == true)
        {
            alreadyID = false;
            this.accountID = rand.nextInt(1000);
            if(getAcctOps().readFromAccountCSV() != null)
            {
                for(int i = 0; i < getAcctOps().readFromAccountCSV().size(); i++)
                {
                    if(this.accountID == getAcctOps().readFromAccountCSV().get(i).getAcctID())
                    {
                        alreadyID = true;
                    }
                }
            }
        }
        //Creating account ID/checking to see if the same ID already exists ending here
        this.accountEmail = accountEmail;
        this.accountPassword = accountPassword;
        this.ownedFiles = new ArrayList<>();
        this.ownedFolders = new ArrayList<>();
        this.notifications = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.blockedUserIDs = new ArrayList<>();
    }

    public static LNAccountCRUDOps getAcctOps() //Gets CRUD operations
    {
        return LNAccountOperations.getLNAccountOperationsInstance();
    }

    public int getAcctID() //Gets the account's ID
    {
        return accountID;
    }

    public String getEmail() //Gets the account's email
    {
        return accountEmail;
    }

    public String setEmail(String username) //Sets the account's email
    {
        accountEmail = username;
        return accountEmail;
    }

    public String getPassword() //Gets the account's password
    {
        return accountPassword;
    }

    public String setPassword(String password) //Sets the account's password
    {
        accountPassword = password;
        return accountPassword;
    }

    public ArrayList<LNFile> getFiles() //Gets the account's list of files
    {
        return ownedFiles;
    }

    public ArrayList<LNFolder> getFolders() //Gets the account's list of folders
    {
        return ownedFolders;
    }

    public ArrayList<LNNotification> getNotifs() //Gets the account's list of notifications
    {
        return notifications;
    }

    public ArrayList<LNComment> getComments() //Gets the account's list of comments
    {
        return comments;
    }

    public ArrayList<Integer> getBlockedUsers() //Gets the account's list of blocked users
    {
        return blockedUserIDs;
    }
}
