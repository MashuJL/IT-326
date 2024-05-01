import java.io.IOException;

public class LNAccountHandler 
{
        private LNAccountCRUDOps ops = new LNAccountOperations();
        private LNUserCRUDOps userOps = new LNUserOperations();
        private LNAccount acct;

        public boolean blockUser(String username, String pass, int userID, int blockID) throws ClassNotFoundException, IOException
        {
            acct = ops.retrieveAcct(username, pass);
            if(acct==null)
            {
                System.out.println("Account doesn't exist"); //Error finding blocking account
                return false;
            }
            acct.getBlockedUsers().add((Integer)blockID);
            ops.saveAcct(userID, userOps.retrieveUser(userID).getAccounts());
            System.out.println("Account ID = "+blockID+" successfully blocked.");
            return true;
        }

        public boolean loggout()
        {
            System.out.println("Goodbye");
            return true;
        }
}
