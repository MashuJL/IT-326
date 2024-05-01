package OperationsFactory;
import CRUDOps.LNAccountCRUDOps;
import Operations.LNAccountOperations;

public class OperationsFactory 
{
    public static LNAccountCRUDOps getAcctOps()
    {
        return LNAccountOperations.getLNAccountOperationsInstance();
    }
}
