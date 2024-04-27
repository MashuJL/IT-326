import java.io.FileNotFoundException;

public abstract class LNAccountCRUDOps 
{
    // public abstract LNAccount retrieveAcct(String username, String password)
    // {
        
    // }
    abstract LNAccount retrieveAcct(String username, String password) throws FileNotFoundException;
};
