public class LNAccountHandler 
{
    LNAccountCRUDOps acctCRUDOps = new LNAccountOperations();

    public boolean loggout()
    {
        System.out.println("Goodbye");
        return true;
    }
}
