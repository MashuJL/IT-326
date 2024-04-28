import java.io.IOException;
import java.util.ArrayList;

public abstract class LNUserCRUDOps 
{
    public abstract LNUser retrieveUser(int ID) throws IOException, ClassNotFoundException;
    public abstract boolean saveUser(int ID, ArrayList<LNAccount> accts);
    public abstract boolean deleteUser(int ID) throws IOException, ClassNotFoundException;
    public abstract boolean updateUser(int ID, int curID) throws IOException, ClassNotFoundException;
}
