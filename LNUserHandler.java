import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

public class LNUserHandler 
{
    LNUserCRUDOps userCRUDOps = new LNUserOperations();

    public int getID(LNUser user)
    {
        return user.getID();
    }

    public ArrayList<LNAccount> getAccounts(LNUser user)
    {
        return user.getAccounts();
    }

    // public LNAccount login(String username, String password)
    // {
        
    // }

    public ArrayList<LNAccount> createAccount(String username, String password, LNUser user)
    {
        Random rand = new Random();
        int randID = -1;
        boolean alreadyID = true;
        while(alreadyID == true)
        {
            alreadyID = false;
            randID = rand.nextInt(1000);
            for(int i = 0; i < user.getAccounts().size(); i++)
            {
                if(randID == user.getAccounts().get(i).getAcctID())
                {
                    alreadyID = true;
                }
            }
        }
        user.getAccounts().add(new LNAccount(randID, username, password, user.getID(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
        userCRUDOps.saveUser(user.getID(), user.getAccounts());
        return user.getAccounts();
    }
}
