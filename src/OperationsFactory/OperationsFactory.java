package OperationsFactory;
import CRUDOps.LNAccountCRUDOps;
import CRUDOps.LNFileCRUDOps;
import Operations.LNAccountOperations;
import Operations.LNFileOperations;

public class OperationsFactory 
{
    public static LNAccountCRUDOps getAcctOps()
    {
        return LNAccountOperations.getLNAccountOperationsInstance();
    }

    public static LNFileCRUDOps getFileOps() {
        return LNFileOperations.getLNFileOperationsInstance();
    }
}
