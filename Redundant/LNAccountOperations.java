import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.SocketTimeoutException;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Scanner;

import Redundant.IgnoreThis.LNAccount;

public class LNAccountOperations extends LNAccountCRUDOps
{
    public boolean saveAcct(int ID, ArrayList<LNAccount> accts) throws IOException
    {
        File csvFile = new File("accounts.csv");
        // PrintWriter pout = new PrintWriter(csvFile);

        try (FileOutputStream fos = new FileOutputStream(csvFile); ObjectOutputStream oos = new ObjectOutputStream(fos))
        {
            for (int i = 0; i < accts.size(); i++)
            {
                oos.writeObject(accts.get(i));
            }
            oos.flush();
            return true;
        }
        catch (Exception e)
        {
            return false;
        }

        // for()
        // {
        // out.printf("%s %s\n", person.getEmail(), person.getPassword());
        // }

        // pout.close();
    }

    public LNAccount retrieveAcct(String username, String password) throws IOException, ClassNotFoundException
    {
        // File file = new File("people.csv");
        // Scanner scan = new Scanner(file);
        ArrayList<LNAccount> acctArr = new ArrayList<>();
        // while (scan.hasNextLine())
        // {
        // String[] readArr = scan.nextLine().split(" ");
        // for(int i = 0; i < readArr.length; i++)
        // {
        // strArr.add(readArr[i]);
        // }
        // }
        // scan.close();
        // for(int i = 0; i < strArr.size(); i+=2)
        // {
        // if(strArr.get(i).toLowerCase().equals(username.toLowerCase()) &&
        // strArr.get(i+1).equals(password))
        // {
        // scan.close();
        // return new LNAccount(username, password);
        // }
        // }
        FileInputStream fileStream = new FileInputStream("accounts.csv");
        ObjectInputStream objStream = new ObjectInputStream(fileStream);
        try
        {
            for (;;)
            {
                acctArr.add((LNAccount) objStream.readObject());
            }
        }
        catch (SocketTimeoutException exc)
        {

        }
        catch (EOFException exc)
        {

        }
        catch (IOException exc)
        {
            exc.printStackTrace();
        }
        // for(int i = 0; i < acctArr.size(); i++)
        // {
        // System.out.println("Email: " + acctArr.get(i).getEmail());
        // System.out.println("Password: " + acctArr.get(i).getPassword());
        // }
        if (acctArr != null)
        {
            for (int i = 0; i < acctArr.size(); i++)
            {
                if (acctArr.get(i).getEmail().toLowerCase().equals(username.toLowerCase())
                        && acctArr.get(i).getPassword().equals(password))
                {
                    objStream.close();
                    fileStream.close();
                    return acctArr.get(i);
                }
                // System.out.println("Email: " + acctArr.get(i).getEmail());
                // System.out.println("Password: " + acctArr.get(i).getPassword());
            }
        }
        System.out.println("Error: No accounts made or could not find account. Returning null");
        // scan.close();
        objStream.close();
        fileStream.close();
        return null;
    }

    public ArrayList<LNAccount> deleteAccount(String username, String password, LNUser user)
            throws IOException, ClassNotFoundException
    {
        // LNAccount tempAcct = retrieveAcct(username, password);
        for (int i = 0; i < user.getAccounts().size(); i++)
        {
            if (user.getAccounts().get(i).getEmail().toLowerCase().equals(username)
                    && user.getAccounts().get(i).getPassword().equals(password))
            {
                user.getAccounts().remove(i);
                saveAcct(user.getID(), user.getAccounts());
                System.out.println("Account successfully deleted");
                return user.getAccounts();
            }
        }
        System.out.println("Error: Account not deleted");
        return user.getAccounts();
    }

    public ArrayList<LNAccount> updateAccount(String username, String password, String curUsername, String curPassword,
            LNUser user) throws IOException, ClassNotFoundException
    {
        for (int i = 0; i < user.getAccounts().size(); i++)
        {
            if (user.getAccounts().get(i).getEmail().toLowerCase().equals(curUsername)
                    && user.getAccounts().get(i).getPassword().equals(curPassword))
            {
                user.getAccounts().set(i,
                        new LNAccount(user.getAccounts().get(i).getAcctID(), username, password,
                                user.getAccounts().get(i).getOwnerID(), user.getAccounts().get(i).getFiles(),
                                user.getAccounts().get(i).getFolders(), user.getAccounts().get(i).getNotifs(),
                                user.getAccounts().get(i).getComments(), user.getAccounts().get(i).getBlockedUsers()));
                saveAcct(user.getID(), user.getAccounts());
                System.out.println("Account successfully updated!");
                return user.getAccounts();
            }
        }
        System.out.println("Error: Account not updated");
        return user.getAccounts();
    }
}
