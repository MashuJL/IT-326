package CRUDOps;
import java.io.IOException;
import java.util.ArrayList;

import Classes.LNAccount;

public abstract class LNAccountCRUDOps 
{
    public abstract ArrayList<LNAccount> readFromAccountCSV() throws IOException, ClassNotFoundException; //abstract method for reading in the accounts.csv file
    public abstract boolean writeToAccountCSV(ArrayList<LNAccount> accts) throws IOException, ClassNotFoundException; //abstract method for writing to the accounts.csv file
    public abstract boolean saveAcct(LNAccount acct) throws IOException, ClassNotFoundException; //abstract method for saving an account
    public abstract LNAccount retrieveAcct(String username) throws IOException, ClassNotFoundException; //abstract method for retrieving an account
    public abstract boolean deleteAccount(String username, String password) throws IOException, ClassNotFoundException; //abstract method for deleting an account
    public abstract boolean updateAccount(String username, String password, String curUsername, String curPassword) throws IOException, ClassNotFoundException; //abstract method for updating an account
};
