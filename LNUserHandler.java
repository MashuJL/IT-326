import java.io.FileNotFoundException;
import java.util.ArrayList;

public class LNUserHandler 
{
    LNUserCRUDOps userCRUDOps = new LNUserOperations();
    // public LNAccount login(String username, String password)
    // {
        
    // }

    public ArrayList<LNAccount> createAccount(String username, String password, LNUser user)
    {
        user.getAccounts().add(new LNAccount(username, password));
        userCRUDOps.saveUser(user.getID(), user.getAccounts());
        return user.getAccounts();
    }
}
