package CRUDOps;
import java.io.IOException;

import Classes.LNAccount;

public abstract class LNAccountCRUDOps 
{
    public abstract boolean saveAcct(LNAccount acct) throws IOException, ClassNotFoundException;
    public abstract LNAccount retrieveAcct(String username, String password) throws IOException, ClassNotFoundException;
    public abstract boolean deleteAccount(String username, String password) throws IOException, ClassNotFoundException;
    public abstract boolean updateAccount(String username, String password, String curUsername, String curPassword) throws IOException, ClassNotFoundException;
};
