import java.io.FileNotFoundException;
import java.util.ArrayList;

public class LNUserController 
{
    private LNUserHandler userHandler = new LNUserHandler();

    public ArrayList<LNAccount> createAccount(String username, String password, LNUser user)
    {
        return userHandler.createAccount(username, password, user);
    }
}
