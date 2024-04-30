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
