import java.io.IOException;

public class LNAccountHandler 
{
        private LNAccountCRUDOps ops = new LNAccountOperations();
        private LNAccount acct;

        public boolean blockUser(String username, String pass,  int id) throws ClassNotFoundException, IOException
        {
            acct = ops.retrieveAcct(username, pass);
            return true; //TODO: Implement logic
        }

        public boolean loggout()
        {
            System.out.println("Goodbye");
            return true;
        }
}
