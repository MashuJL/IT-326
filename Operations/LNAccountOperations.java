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
import Classes.LNAccount;

public class LNAccountOperations extends LNAccountCRUDOps
{

    private static LNAccountCRUDOps acctOps = null;

    public static LNAccountCRUDOps getLNAccountOperationsInstance(){
        if(acctOps==null)
            acctOps = new LNAccountOperations();
        return acctOps;
    }

    private ArrayList<LNAccount> readFromAccountCSV() throws IOException, ClassNotFoundException
    {
        try(FileInputStream fis = new FileInputStream("accounts.csv"); ObjectInputStream ois = new ObjectInputStream(fis))
        {
            return (ArrayList<LNAccount>) ois.readObject();
        } catch (EOFException exc)
        {
            return null;
        }
    }

    private boolean writeToAccountCSV(ArrayList<LNAccount> accts) throws IOException, ClassNotFoundException
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

    public boolean saveAcct(LNAccount acct) throws IOException, ClassNotFoundException
    {
        ArrayList<LNAccount> accts = readFromAccountCSV();
        if(accts == null)
        {
            accts = new ArrayList<>();
        }
        accts.add(acct);
        if(writeToAccountCSV(accts) != false)
        {
            return true;
        }
        return false;
    }

    public LNAccount retrieveAcct(String username, String password) throws IOException, ClassNotFoundException
    {
        ArrayList<LNAccount> acctArr = readFromAccountCSV();
        if(acctArr != null)
        {
            for(int i = 0; i < acctArr.size(); i++)
            {
                if(acctArr.get(i).getEmail().toLowerCase().equals(username.toLowerCase()) && acctArr.get(i).getPassword().equals(password))
                {
                    return acctArr.get(i);
                }
            }
        }
        System.out.println("Error: No account has been made or could not find account. Returning null");
        return null;
    }

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
