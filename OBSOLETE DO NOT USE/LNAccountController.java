import java.io.IOException;

public class LNAccountController 
{
    private LNAccountHandler acctHandler = new LNAccountHandler();

    public boolean blockUser(String username, String pass, int uid, int blockID) throws ClassNotFoundException, IOException
    {
        return acctHandler.blockUser(username, pass, uid, blockID);
    }
    
    public boolean loggout()
    {
        return acctHandler.loggout();
    }
}
