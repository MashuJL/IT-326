public class OperationsFactory 
{
    private LNAccountOperations acctOpsObj = new LNAccountOperations();
    private LNUserOperations userOpsObj = new LNUserOperations();

    public LNAccountOperations getAcctOps()
    {
        return acctOpsObj;
    }

    public LNUserOperations getUserOps()
    {
        return userOpsObj;
    }
}
