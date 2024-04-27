public class OperationsFactory 
{
    private LNAccountOperations acctOpsObj = new LNAccountOperations();

    public LNAccountOperations getAcctOps()
    {
        return acctOpsObj;
    }
}
