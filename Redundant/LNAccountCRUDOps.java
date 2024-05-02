import java.util.ArrayList;

import Redundant.IgnoreThis.LNAccount;

import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class LNAccountCRUDOps 
{
    // public abstract LNAccount retrieveAcct(String username, String password)
    // {
        
    // }
    public abstract boolean saveAcct(int ID, ArrayList<LNAccount> acct) throws IOException;
    public abstract LNAccount retrieveAcct(String username, String password) throws IOException, ClassNotFoundException;
    public abstract ArrayList<LNAccount> deleteAccount(String username, String password, LNUser user) throws IOException, ClassNotFoundException;
    public abstract ArrayList<LNAccount> updateAccount(String username, String password, String curUsername, String curPassword, LNUser user) throws IOException, ClassNotFoundException;
};
