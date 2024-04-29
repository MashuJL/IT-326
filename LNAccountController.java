import java.io.IOException;

public class LNAccountController 
{
    private LNAccountHandler handler = new LNAccountHandler();
    
    public boolean blockUser(String username, String pass, int id) throws ClassNotFoundException, IOException
    {
        return handler.blockUser(username, pass, id);
    }

}
