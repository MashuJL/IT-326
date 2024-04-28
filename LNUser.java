import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.Random;
import java.util.ArrayList;

class LNUser implements Serializable 
{
    private int userID;
    private ArrayList<LNAccount> accounts;

    public LNUser (int userID, ArrayList<LNAccount> accounts)
    {
        this.userID = userID;
        this.accounts = accounts;
    }

    public int getID()
    {
        return userID;
    }

    public ArrayList<LNAccount> getAccounts()
    {
        return accounts;
    }
}