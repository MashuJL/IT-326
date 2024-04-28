import java.io.FileNotFoundException;
import java.util.ArrayList;

public class LNUserController 
{
    private LNUserHandler userHandler = new LNUserHandler();

    public int getID(LNUser user)
    {
        return userHandler.getID(user);
    }

    public ArrayList<LNAccount> getAccounts(LNUser user)
    {
        return userHandler.getAccounts(user);
    }

    public ArrayList<LNAccount> createAccount(String username, String password, LNUser user)
    {
        return userHandler.createAccount(username, password, user);
    }
}
