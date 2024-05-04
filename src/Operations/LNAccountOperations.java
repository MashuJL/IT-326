package Operations;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.EOFException;
import java.util.ArrayList;

import CRUDOps.LNAccountCRUDOps;
import Models.LNAccount;

public class LNAccountOperations extends LNAccountCRUDOps
{

    private static LNAccountCRUDOps acctOps = null;

    public static LNAccountCRUDOps getLNAccountOperationsInstance(){ //Gets the abstract account CRUDOps object
        if(acctOps==null)
            acctOps = new LNAccountOperations();
        return acctOps;
    }

    public ArrayList<LNAccount> readFromAccountCSV() throws IOException, ClassNotFoundException //Reads in the accounts.csv file into an array list of account objects
    {
        try(FileInputStream fis = new FileInputStream("accounts.csv"); ObjectInputStream ois = new ObjectInputStream(fis))
        {
            return (ArrayList<LNAccount>) ois.readObject();
        } catch (EOFException exc)
        {
            return null;
        }
    }

    public boolean writeToAccountCSV(ArrayList<LNAccount> accts) throws IOException, ClassNotFoundException //Writes into the accounts.csv file and reutrns a boolean based on if it worked or not
    {
        File csvFile = new File("accounts.csv");

        try(FileOutputStream fos = new FileOutputStream(csvFile); ObjectOutputStream oos = new ObjectOutputStream(fos))
        {
            oos.writeObject(accts);
            oos.flush();
            return true;
        } catch (Exception e)
        {
            return false;
        }
    }

    //Reads in the accounts from the accounts.csv file and adds the new account to the array list of accounts just read and finally writes 
    //the new array list with the new account to the accounts.csv file
    public boolean saveAcct(LNAccount acct) throws IOException, ClassNotFoundException 
    {
        ArrayList<LNAccount> accts = readFromAccountCSV();
        if(accts == null)
        {
            accts = new ArrayList<>();
        }

        if(retrieveAcct(acct.getEmail()) == null)
        {
            accts.add(acct);
        }
        else
        {
            System.out.print("Error: Account has already been made.");
            return false;
        }

        if(writeToAccountCSV(accts) != false)
        {
            return true;
        }
        return false;
    }

    //Reads in the accounts from the accounts.csv file and searches for the account based on email alone
    public LNAccount retrieveAcct(String username) throws IOException, ClassNotFoundException
    {
        ArrayList<LNAccount> acctArr = readFromAccountCSV();
        if(acctArr != null)
        {
            for(int i = 0; i < acctArr.size(); i++)
            {
                if(acctArr.get(i).getEmail().toLowerCase().equals(username.toLowerCase()))
                {
                    return acctArr.get(i);
                }
            }
        }
        return null;
    }

    //Reads in the accounts from the accounts.csv file and removes the specified account from the array list of accounts just read and finally writes 
    //the new array list with the account specified removed to the accounts.csv file
    public boolean deleteAccount(String username, String password) throws IOException, ClassNotFoundException
    {
        ArrayList<LNAccount> acctArr = readFromAccountCSV();
        if(acctArr != null)
        {
            for(int i = 0; i < acctArr.size(); i++)
            {
                if(acctArr.get(i).getEmail().toLowerCase().equals(username.toLowerCase()) && acctArr.get(i).getPassword().equals(password))
                {
                    acctArr.remove(i);
                    writeToAccountCSV(acctArr);
                    return true;
                }
            }
        }
        return false;
    }

    //Reads in the accounts from the accounts.csv file and updates the username and password of the specified account  
    //in the array list of accounts just read in and finally writes the new array list with the updated account to the accounts.csv file
    public boolean updateAccount(String username, String password, String curUsername, String curPassword) throws IOException, ClassNotFoundException
    {
        ArrayList<LNAccount> acctArr = readFromAccountCSV();
        if(acctArr != null)
        {
            for(int i = 0; i < acctArr.size(); i++)
            {
                if(acctArr.get(i).getEmail().toLowerCase().equals(curUsername.toLowerCase()) && acctArr.get(i).getPassword().equals(curPassword))
                {
                    acctArr.get(i).setEmail(username);
                    acctArr.get(i).setPassword(password);
                    writeToAccountCSV(acctArr);
                    return true;
                }
            }
        }
        return false;
    }
}
