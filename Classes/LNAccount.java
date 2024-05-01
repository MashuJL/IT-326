package Classes;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

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

    public LNAccount(String accountEmail, String accountPassword)
    {
        Random rand = new Random();
        this.accountID = rand.nextInt(1000);
        this.accountEmail = accountEmail;
        this.accountPassword = accountPassword;
        this.ownedFiles = new ArrayList<>();
        this.ownedFolders = new ArrayList<>();
        this.notifications = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.blockedUserIDs = new ArrayList<>();
    }

    public int getAcctID()
    {
        return accountID;
    }

    public String getEmail()
    {
        return accountEmail;
    }

    public String setEmail(String username)
    {
        accountEmail = username;
        return accountEmail;
    }

    public String getPassword()
    {
        return accountPassword;
    }

    public String setPassword(String password)
    {
        accountPassword = password;
        return accountPassword;
    }

    public int getOwnerID()
    {
        return ownerID;
    }

    public void setOwnerID(int id)
    {
        this.ownerID = id;
    }

    public ArrayList<LNFile> getFiles()
    {
        return ownedFiles;
    }

    public void setFiles(ArrayList<LNFile> files)
    {
        this.ownedFiles = files;
    }

    public ArrayList<LNFolder> getFolders()
    {
        return ownedFolders;
    }

    public void setFolders(ArrayList<LNFolder> folders)
    {
        this.ownedFolders = folders;
    }

    public ArrayList<LNNotification> getNotifs()
    {
        return notifications;
    }

    public void setNotifications(ArrayList<LNNotification> notifs)
    {
        this.notifications = notifs;
    }

    public ArrayList<LNComment> getComments()
    {
        return comments;
    }

    public void setComments(ArrayList<LNComment> cmts)
    {
        this.comments = cmts;
    }

    public ArrayList<Integer> getBlockedUsers()
    {
        return blockedUserIDs;
    }

    public void setBlockedUsers(ArrayList<Integer> ids)
    {
        this.blockedUserIDs = ids;
    }
}
