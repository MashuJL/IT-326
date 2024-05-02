package Redundant.IgnoreThis;
import java.io.Serializable;
import java.util.ArrayList;

import javax.management.Notification;

import LNComment;
import LNFile;
import LNFolder;

public class LNAccount implements Serializable 
{
    private int accountID;
    private String accountEmail;
    private String accountPassword;
    private int ownerID;
    private ArrayList<LNFile> ownedFiles;
    private ArrayList<LNFolder> ownedFolders;
    private ArrayList<LNNotification> notifications;
    private ArrayList<LNComment> comments;
    private ArrayList<Integer> blockedUserIDs;

    public LNAccount(int accountID, String accountEmail, String accountPassword, int ownerID, ArrayList<LNFile> ownedFiles, ArrayList<LNFolder> ownedFolders, ArrayList<LNNotification> notifications, ArrayList<LNComment> comments, ArrayList<Integer> blockedUserIDs)
    {
        this.accountID = accountID;
        this.accountEmail = accountEmail;
        this.accountPassword = accountPassword;
        this.ownerID = ownerID;
        this.ownedFiles = ownedFiles;
        this.ownedFolders = ownedFolders;
        this.notifications = notifications;
        this.comments = comments;
        this.blockedUserIDs = blockedUserIDs;
    }

    public int getAcctID()
    {
        return accountID;
    }

    public String getEmail()
    {
        return accountEmail;
    }

    public String getPassword()
    {
        return accountPassword;
    }

    public int getOwnerID()
    {
        return ownerID;
    }

    public ArrayList<LNFile> getFiles()
    {
        return ownedFiles;
    }

    public ArrayList<LNFolder> getFolders()
    {
        return ownedFolders;
    }

    public ArrayList<LNNotification> getNotifs()
    {
        return notifications;
    }

    public ArrayList<LNComment> getComments()
    {
        return comments;
    }

    public ArrayList<Integer> getBlockedUsers()
    {
        return blockedUserIDs;
    }
}
