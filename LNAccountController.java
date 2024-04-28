public class LNAccountController 
{
    private LNAccountHandler handler = new LNAccountHandler();
    
    public boolean blockUser(int id)
    {
        return handler.blockUser(id);
    }

}
