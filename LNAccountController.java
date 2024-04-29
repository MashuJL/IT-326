import java.io.IOException;

public class LNAccountController 
{
    private LNAccountHandler acctHandler = new LNAccountHandler();

    public boolean blockUser(String username, String pass, int uid) throws ClassNotFoundException, IOException
    {
        return acctHandler.blockUser(username, pass, uid);
    }
    
    public boolean loggout()
    {
        return acctHandler.loggout();
    }
}
