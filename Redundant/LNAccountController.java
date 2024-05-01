public class LNAccountController 
{
    private LNAccountHandler acctHandler = new LNAccountHandler();
    
    public boolean loggout()
    {
        return acctHandler.loggout();
    }
}
